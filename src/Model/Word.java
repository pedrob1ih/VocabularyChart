package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

public class Word {
    
    private String word;
    private String meaning;
    private Timestamp insertionDate;
    private boolean ignoredWord;

    public Word(String word, String meaning, Timestamp insertionDate, boolean ignoredWord) {
        this.word = word;
        this.meaning = meaning;
        this.insertionDate = insertionDate;
        this.ignoredWord = ignoredWord;
    }

    
    public Word(String word,boolean ignoredWord) {
        this.word = word;
        this.meaning = "";
        this.insertionDate = 
                new Timestamp(Calendar.getInstance().getTime().getTime());
        this.ignoredWord=ignoredWord;
    }
    public Word(String word, String meaning,boolean ignoredWord) {
        this.word = word;
        this.meaning = meaning;
        this.insertionDate = 
                new Timestamp(Calendar.getInstance().getTime().getTime());
        this.ignoredWord=ignoredWord;
    }
    public Word(String word) {
        this.word = word;
        this.meaning = "";
        this.insertionDate = 
                new Timestamp(Calendar.getInstance().getTime().getTime());
        this.ignoredWord=false;
    }
    public Word(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
        this.insertionDate = 
                new Timestamp(Calendar.getInstance().getTime().getTime());
        this.ignoredWord=false;
    }
    
    public int insert() throws SQLException{
        return H2DB.getInstance().getSt()
                .executeUpdate("INSERT INTO words values('"+this.word+"','"+this.meaning+"',CURRENT_TIMESTAMP,"+this.ignoredWord+")");
    }
    public int delete() throws SQLException{
        return H2DB.getInstance().getSt()
                .executeUpdate("DELETE FROM words where word='"+this.word+"'");
    }
    public int update() throws SQLException{
        String slq="UPDATE words SET meaning='"+this.meaning+"', ignoredWord="+this.ignoredWord+" where word='"+this.word+"'";
//        System.out.println(slq);
        return H2DB.getInstance().getSt().executeUpdate(slq);
    }
    public boolean exist() throws SQLException{
        ResultSet resultSet=H2DB.getInstance().getSt().
                executeQuery("select * from words where word='"+this.word+"'");
        return resultSet.next();
    }
    
    public static ArrayList<Word> selectWhere(String where) throws SQLException{
        ArrayList<Word> l= new ArrayList<>();
        ResultSet resultSet;
        String select="select * from words ";
        String select2=" order by word";
        if(where==null){
            resultSet=H2DB.getInstance().getSt().
                executeQuery(select+select2);
        }
        else{
            resultSet=H2DB.getInstance().getSt().
                executeQuery(select+where+select2);
        }
        
        while (resultSet.next()) {
            Word w= new Word(resultSet.getString(1),resultSet.getString(2),resultSet.getTimestamp(3),resultSet.getBoolean(4));
            l.add(w);
        }
        return l;
    }

    public boolean isIgnoredWord() {
        return ignoredWord;
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
