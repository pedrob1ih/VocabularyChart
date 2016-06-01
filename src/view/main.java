package view;

import Model.Word;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

    public static void main(String[] args) {
        try {
            Word word= new Word("thing", "cosa");
            System.out.println(word.exist());
            System.out.println(word.insert());
            System.out.println(word.exist());
            word.setWord("tetera");
            word.setMeaning("titira");
            System.out.println(word.update());
            System.out.println(word.delete());
            System.out.println(word.exist());
            
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
