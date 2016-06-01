package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

public class Word {
    
    private String word;
    private String meaning;
    private Timestamp insertionDate;

    public Word(String word) {
        this.word = word;
        this.meaning = "";
        this.insertionDate = 
                new Timestamp(Calendar.getInstance().getTime().getTime());
    }
    public Word(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
        this.insertionDate = 
                new Timestamp(Calendar.getInstance().getTime().getTime());
    }
    
    public int insert() throws SQLException{
        return H2DB.getInstance().getSt()
                .executeUpdate("INSERT INTO words values('"+this.word+"','"+this.meaning+"',CURRENT_TIMESTAMP)");
    }
    public int delete() throws SQLException{
        return H2DB.getInstance().getSt()
                .executeUpdate("DELETE FROM words where word='"+this.word+"'");
    }
    public int update() throws SQLException{
        return H2DB.getInstance().getSt
        ().executeUpdate("UPDATE words SET word='"+this.word+"' , meaning='"+this.meaning+"', date='CURRENT_TIMESTAMP' where word='"+this.word+"'");
    }
    public boolean exist() throws SQLException{
        ResultSet resultSet=H2DB.getInstance().getSt().
                executeQuery("select * from words where word='"+this.word+"'");
        return resultSet.next();
    }
    

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    public Timestamp getInsertionDate() {
        return insertionDate;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setInsertionDate(Timestamp insertionDate) {
        this.insertionDate = insertionDate;
    }
    
}
