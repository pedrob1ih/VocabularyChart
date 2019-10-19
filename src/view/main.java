package view;

import Data.Conector.MysqlRemoteConector;
import Data.IgnoredWordInAListLoader;
import Data.WordLoader;
import Objects.Word;
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

    private static void insertarIgnoredWordInAList() {
        Word word = new Word();
        word.setWord("clara");
        word.setMeaning("psada");
        word.setDateInsert(new Timestamp(System.currentTimeMillis()));

        Word word1 = new Word();
        word1.setWord("AMONT");
        word1.setMeaning("rio arriba");
        word1.setDateInsert(new Timestamp(System.currentTimeMillis()));

        Word word2 = new Word();
        word2.setWord("affichage");
        word2.setMeaning("poner en pancarta");
        word2.setDateInsert(new Timestamp(System.currentTimeMillis()));

        try {
            insert_WordLoader(word);
            insert_WordLoader(word1);
            insert_WordLoader(word2);
            Insert_IgnoredWordInAListLoader();

            Insert_IgnoredWordInAListLoader();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /*REGION IgnoredWordInAListLoader*/
    //Create
    private static boolean Insert_IgnoredWordInAListLoader() throws SQLException {
        IgnoredWordInAList ignoredWordInAList = new IgnoredWordInAList();
        ignoredWordInAList.setIdUser(2);
        ignoredWordInAList.setIdWordsGroup(1);
        ignoredWordInAList.setWord("AMONT");
        ignoredWordInAList.setDateIsert(new Timestamp(System.currentTimeMillis()));
        return IgnoredWordInAListLoader.getInstance().create(ignoredWordInAList);
    }

    //read
    //update
    //delete
    /*END_REGION IgnoredWordInAListLoader*/
 /*REGION RelUserWordsGroupLoader */
    //Create
    //read
    //update
    //delete
    /*END_REGION RelUserWordsGroupLoader */
 /*REGION RelWordsGroupWordLoader */
    //Create
    //read
    //update
    //delete
    /*END_REGION RelWordsGroupWordLoader */
 /*REGION UserAccountLoader*/
    //Create
    //read
    //update
    //delete
    /*END_REGION UserAccountLoader*/
 /*REGION WordLoader */
    //Create
    private static boolean insert_WordLoader(Word word) throws SQLException {
        return WordLoader.getInstance().create(word);
    }

    //read
    private static void read_WordLoader(Word word) throws SQLException {
        WordLoader.getInstance().read(word);
    }

//update IMPLEMENTAR!!!!!!!!!!!!!!
//    private static void read_WordLoader(Word word) throws SQLException{
//        WordLoader.getInstance ().update(word);
//    }
    //delete
    
    private static boolean delete_WordLoader(Word word) throws SQLException {
        return WordLoader.getInstance().delete(word);
    }
    /*END_REGION WordLoader */
 /*REGION WordsGroupLoader */
    //Create
    //read
    //update
    //delete
    /*END_REGION WordsGroupLoader */
}
