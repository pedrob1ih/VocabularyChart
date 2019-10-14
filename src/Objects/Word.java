package Objects;

import Data.Conector.MysqlRemoteConector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Word {

    private String word;
    private String meaning;
    private Timestamp dateInsert;

    public Word() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public Timestamp getDateInsert() {
        return dateInsert;
    }

    public void setDateInsert(Timestamp dateInsert) {
        this.dateInsert = dateInsert;
    }

//    public int insert() throws SQLException {
//        return MysqlRemoteConector.getInstance().getSt()
//                .executeUpdate("INSERT INTO words values(" + this.idWordGoup + ",'" + this.word + "','" + this.meaning + "',CURRENT_TIMESTAMP," + this.ignoredWord + ")");
//    }
//
//    public int delete() throws SQLException {
//        return MysqlRemoteConector.getInstance().getSt()
//                .executeUpdate("DELETE FROM words where word='" + this.word + "'");
//    }

//    public int update() throws SQLException {
//        String slq = "UPDATE words SET meaning='" + this.meaning + "', ignoredWord=" + this.ignoredWord + " where word='" + this.word + "'";
////        System.out.println(slq);
//        return MysqlRemoteConector.getInstance().getSt().executeUpdate(slq);
//    }

//    public boolean exist() throws SQLException {
//        ResultSet resultSet = MysqlRemoteConector.getInstance().getSt().
//                executeQuery("select * from words where word='" + this.word + "'");
//        return resultSet.next();
//    }

//    public static ArrayList<Word> selectWhere(String select) throws SQLException {
//        ArrayList<Word> l = new ArrayList<>();
//        ResultSet resultSet;
//        if (select == null) {
//            resultSet = MysqlRemoteConector.getInstance().getSt().
//                    executeQuery("select * from words order by word");
//        } else {
//            resultSet = MysqlRemoteConector.getInstance().getSt().
//                    executeQuery(select);
//
//        }
//
//        while (resultSet.next()) {
//            Word w = new Word(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getTimestamp(4), resultSet.getBoolean(5));
//            w.set
//            l.add(w);
//        }
//        return l;
//    }
}
