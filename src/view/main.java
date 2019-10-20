package view;


import Data.IgnoredWordInAListLoader;
import Data.WordLoader;
import Objects.Word;
import java.sql.SQLException;
import java.sql.Timestamp;
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

//        Word word1 = new Word();
//        word1.setWord("AMONT");
//        word1.setMeaning("rio arriba");
//        word1.setDateInsert(new Timestamp(System.currentTimeMillis()));
//
//        Word word2 = new Word();
//        word2.setWord("affichage");
//        word2.setMeaning("poner en pancarta");
//        word2.setDateInsert(new Timestamp(System.currentTimeMillis()));
        try {
            if (!insert_WordLoader(word)) {
                read_WordLoader(word);
                System.out.println("Palabra insertada read: " + word.getWord() +" "+ word.getMeaning() +" "+ word.getDateInsert());
            }

            word.setMeaning("bbbb");
            word.setDateInsert(new Timestamp(System.currentTimeMillis()));
            
            if (!update_WordLoader(word)) {
                read_WordLoader(word);
                System.out.println("Palabra actualizada read: " + word.getWord() +" "+ word.getMeaning() +" "+ word.getDateInsert());
            }

            if (!delete_WordLoader(word)) {
                System.out.println("Palabra borrada no hay registro");
            } else {
                read_WordLoader(word);
                System.out.println("Palabra actualizada read: " + word.getWord() +" "+ word.getMeaning() +" "+ word.getDateInsert());
            }


//            Insert_IgnoredWordInAListLoader();
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

    private static boolean update_WordLoader(Word word) throws SQLException {
        return WordLoader.getInstance().update(word);
    }
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
