/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Data.Conector.MysqlRemoteConector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.RelWordsGroupWord;

/**
 *
 * @author pedro
 */
public class RelWordsGroupWordLoader {

    private static RelWordsGroupWordLoader instance = null;

    private MysqlRemoteConector mysqlRemoteConector;
    private PreparedStatement pStCreate;
    private final String create = "INSERT INTO rel_wordsgroup_word (id_words_group, word) VALUES (?, ?)";
    private PreparedStatement pStReadAll;
    private final String readAll = "Select id_words_group, word from rel_wordsgroup_word";
    private PreparedStatement pStReadIndividual;
    private final String readIndividual = "Select id_words_group, word from rel_wordsgroup_word "
            + "where id_words_group=?, word=?";
    private PreparedStatement pStDelete;
    private final String delete = "DELETE FROM rel_wordsgroup_word WHERE id_words_group=?, word=?";

    public static RelWordsGroupWordLoader getInstance() throws SQLException {
        if (instance == null) {
            instance = new RelWordsGroupWordLoader();
        }
        return instance;
    }

    private RelWordsGroupWordLoader() {
        if (pStCreate == null) {
            try {
                createInstance();
            } catch (SQLException ex) {
                Logger.getLogger(RelUserWordsGroupLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void createInstance() throws SQLException {
        if (this.mysqlRemoteConector == null) {
            this.mysqlRemoteConector = MysqlRemoteConector.getInstance();
        }
        Connection connection = mysqlRemoteConector.getConn();
        pStCreate = connection.prepareStatement(create);
        pStReadAll = connection.prepareStatement(readAll);
        pStReadIndividual = connection.prepareStatement(readIndividual);
        pStDelete = connection.prepareStatement(delete);
    }

//Create
    public boolean create(RelWordsGroupWord relWordsGroupWord) throws SQLException {
        pStCreate.setInt(1, relWordsGroupWord.getIdWordsGroup());
        pStCreate.setString(2, relWordsGroupWord.getWord());
        return pStCreate.execute();
    }
//Read

    public ArrayList<RelWordsGroupWord> readAll() throws SQLException {
        ResultSet resultSet = pStReadAll.executeQuery();
        ArrayList<RelWordsGroupWord> lRelWordsGroupWord = new ArrayList<>();
        while (resultSet.next()) {
            RelWordsGroupWord relWordsGroupWord = new RelWordsGroupWord();
            relWordsGroupWord.setIdWordsGroup(resultSet.getInt("id_words_group"));
            relWordsGroupWord.setWord(resultSet.getString("word"));
            lRelWordsGroupWord.add(relWordsGroupWord);
        }
        return lRelWordsGroupWord;
    }

    public void read(RelWordsGroupWord relWordsGroupWord) throws SQLException {
        //comprobar si se le pueden poner nulos
        pStReadIndividual.setInt(1, relWordsGroupWord.getIdWordsGroup());
        pStReadIndividual.setString(3, relWordsGroupWord.getWord());
        ResultSet resultSet = pStReadIndividual.executeQuery();
        while (resultSet.next()) {
            relWordsGroupWord.setIdWordsGroup(resultSet.getInt("id_words_group"));
            relWordsGroupWord.setWord(resultSet.getString("word"));
        }
    }
//Update
//Delete

    public boolean delete(RelWordsGroupWord relWordsGroupWord) throws SQLException {
        //comprobar si se le pueden poner nulos
        pStDelete.setInt(1, relWordsGroupWord.getIdWordsGroup());
        pStDelete.setString(2, relWordsGroupWord.getWord());
        return pStDelete.execute();
    }
}
