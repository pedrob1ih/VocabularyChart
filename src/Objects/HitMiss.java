package Objects;

import Model.H2DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;


public class HitMiss {
    
    private String word;
    private boolean hit;
    private Timestamp insertionDate;

    public HitMiss(String word, boolean hit) {
        this.word = word;
        this.hit = hit;
        this.insertionDate = 
                new Timestamp(Calendar.getInstance().getTime().getTime());
    }
        
    public int insert() throws SQLException{
        return H2DB.getInstance().getSt()
                .executeUpdate("insert into hit_miss values ('"+this.word+"',"+this.hit+",CURRENT_TIMESTAMP)");
    }
    public int delete() throws SQLException{
        return H2DB.getInstance().getSt()
                .executeUpdate("DELETE FROM hit_miss where word='"+this.word+"'");
    }
    public boolean exist() throws SQLException{
        ResultSet resultSet=H2DB.getInstance().getSt().
                executeQuery("select * from hit_miss where word='"+this.word+"'");
        return resultSet.next();
    }

    public static ArrayList<HitMiss> selectWhere(String select) throws SQLException{
        ArrayList<HitMiss> l= new ArrayList<>();
        ResultSet resultSet;
        if(select==null){
            resultSet=H2DB.getInstance().getSt().
                executeQuery("select * from hit_miss");
        }
        else
            resultSet=H2DB.getInstance().getSt().
                executeQuery(select);
        
        while (resultSet.next()) {
            HitMiss w= new HitMiss(resultSet.getString(1),resultSet.getBoolean(2));
            l.add(w);
        }
        return l;
    }
    
    public String getWord() {
        return word;
    }

    public boolean isHit() {
        return hit;
    }

    public Timestamp getHitDate() {
        return insertionDate;
    }
    
}
