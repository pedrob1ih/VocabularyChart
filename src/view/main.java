package view;

import Model.HitMiss;
import Model.Word;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

    public static void main(String[] args) {
        try {
            HitMiss word= new HitMiss("thing", false);
            System.out.println(word.exist());
            System.out.println(word.insert());
            System.out.println(word.exist());
            System.out.println(word.delete());
            System.out.println(word.exist());
            
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
