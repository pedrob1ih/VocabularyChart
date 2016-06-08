package Objects;

import Model.H2DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

public class Word {
    
    private int idWordGoup;
    private String word;
    private String meaning;
    private Timestamp insertionDate;
    private boolean ignoredWord;

    public Word(int idWordGoup,String word, String meaning, Timestamp insertionDate, boolean ignoredWord) {
        this.idWordGoup=idWordGoup;
        this.word = word;
        this.meaning = meaning;
        this.insertionDate = insertionDate;
        this.ignoredWord = ignoredWord;
    }

    
    public Word(int idWordGoup,String word,boolean ignoredWord) {
        this.idWordGoup=idWordGoup;
        this.word = word;
        this.meaning = "";
        this.insertionDate = 
                new Timestamp(Calendar.getInstance().getTime().getTime());
        this.ignoredWord=ignoredWord;
    }
    public Word(int idWordGoup,String word, String meaning,boolean ignoredWord) {
        this.idWordGoup=idWordGoup;
        this.word = word;
        this.meaning = meaning;
        this.insertionDate = 
                new Timestamp(Calendar.getInstance().getTime().getTime());
        this.ignoredWord=ignoredWord;
    }
    public Word(int idWordGoup,String word) {
        this.idWordGoup=idWordGoup;
        this.word = word;
        this.meaning = "";
        this.insertionDate = 
                new Timestamp(Calendar.getInstance().getTime().getTime());
        this.ignoredWord=false;
    }
    public Word(int idWordGoup,String word, String meaning) {
        this.idWordGoup=idWordGoup;
        this.word = word;
        this.meaning = meaning;
        this.insertionDate = 
                new Timestamp(Calendar.getInstance().getTime().getTime());
        this.ignoredWord=false;
    }

    public int getIdWordGoup() {
        return idWordGoup;
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
    
    public int insert() throws SQLException{
        return H2DB.getInstance().getSt()
                .executeUpdate("INSERT INTO words values("+this.idWordGoup+",'"+this.word+"','"+this.meaning+"',CURRENT_TIMESTAMP,"+this.ignoredWord+")");
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
            Word w= new Word(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getTimestamp(4),resultSet.getBoolean(5));
            l.add(w);
        }
        return l;
    }
}
