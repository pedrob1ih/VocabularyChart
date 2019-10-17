package view;

import Data.Conector.MysqlRemoteConector;
import Data.IgnoredWordInAListLoader;
import com.mysql.jdbc.MySQLConnection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.IgnoredWordInAList;

public class main {

    public static void main(String[] args) throws SQLException {
        
        insertarIgnoredWordInAList();
    }
    
    private static void insertarIgnoredWordInAList(){
        try {
            IgnoredWordInAList ignoredWordInAList = new IgnoredWordInAList();
            ignoredWordInAList.setIdUser(1);
            ignoredWordInAList.setIdWordsGroup(1);
            ignoredWordInAList.setWord("epojé");
            ignoredWordInAList.setDateIsert(new Timestamp(System.currentTimeMillis()));
            IgnoredWordInAListLoader.getInstance().delete(ignoredWordInAList);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
