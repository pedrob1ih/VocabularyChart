package Objects;

import Data.Conector.MysqlRemoteConector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class WordsGroup {

    private int id;
    private String name;
    private Timestamp date;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getDate() {
        return date;
    }
//
//    public int insert() throws SQLException {
//        String sql = "";
//        if (this.date == null) {
//            sql = "insert into wordsGroup values(" + this.id + ",'" + this.name + "',CURRENT_TIMESTAMP)";
//        } else {
//            sql = "insert into wordsGroup values(" + this.id + ",'" + this.name + "'," + this.date + ")";
//        }
//        return MysqlRemoteConector.getInstance().getSt().executeUpdate(sql);
//    }

//    public int update() throws SQLException {
//        String sql = "UPDATE wordsGroup SET name='" + this.name + "'where id=" + this.id;
//        return MysqlRemoteConector.getInstance().getSt().executeUpdate(sql);
//    }

//    public int delete() throws SQLException {
//        String sql = "DELETE FROM wordsGroup where id=" + this.id;
//        return MysqlRemoteConector.getInstance().getSt().executeUpdate(sql);
//    }

//    public boolean exist() throws SQLException {
//        String sql = "select * FROM wordsGroup where id=" + this.id;
//        return MysqlRemoteConector.getInstance().getSt().executeQuery(sql).next();
//    }

//    public static ArrayList<WordsGroup> select(String select) throws SQLException {
//        ArrayList<WordsGroup> l = new ArrayList<>();
//        ResultSet resultSet;
//        if (select == null) {
//            resultSet = MysqlRemoteConector.getInstance().getSt().
//                    executeQuery("select * from wordsGroup order by id");
//        } else {
////            System.out.println(select);
//            resultSet = MysqlRemoteConector.getInstance().getSt().
//                    executeQuery(select);
//        }
//
//        while (resultSet.next()) {
//            WordsGroup wG = new WordsGroup();
//            wG.setId(resultSet.getInt("id"));
//            wG.setName(resultSet.getString("name"));
//            wG.setDate(resultSet.getTimestamp("DATE"));
////            WordsGroup wG = new WordsGroup(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getTimestamp("DATE"));
//            l.add(wG);
//        }
//        return l;
//    }

    @Override
    public String toString() {
        return name;
    }

}
