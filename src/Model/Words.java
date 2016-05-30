package Model;

import java.util.Calendar;

public class Words {
    
    private String word;
    private String meaning;
    private Calendar insertionDate;

    public Words(String word, String meaning, Calendar insertionDate) {
        this.word = word;
        this.meaning = meaning;
        this.insertionDate = insertionDate;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    public Calendar getInsertionDate() {
        return insertionDate;
    }
}
