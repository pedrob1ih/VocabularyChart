/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Data.Conector.MysqlRemoteConector;
import Objects.Word;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class WordLoader {

    private static WordLoader instance = null;

    private MysqlRemoteConector mysqlRemoteConector;
    private PreparedStatement pStCreate;
    private final String create = "INSERT INTO words (word, meaning, date_insert) VALUES (?, ?, ?)";
    private PreparedStatement pStReadAll;
    private final String readAll = "Select word, meaning, date_insert from words";
    private PreparedStatement pStReadIndividual;
    private final String readIndividual = "Select word, meaning, date_insert from words where word=?";
    private PreparedStatement pStUpdate;
    private final String update = "UPDATE words SET meaning = ?, date_insert = ? where word=?";
    private PreparedStatement pStDelete;
    private final String delete = "DELETE FROM words where word=?";

    public static WordLoader getInstance() throws SQLException {
        if (instance == null) {
            instance = new WordLoader();
        }
        return instance;
    }

    private WordLoader() {
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
        pStUpdate = connection.prepareStatement(update);
        pStDelete = connection.prepareStatement(delete);
    }

//Create
    public boolean create(Word word) throws SQLException {
        pStCreate.setString(1, word.getWord());
        pStCreate.setString(2, word.getMeaning());
        pStCreate.setTimestamp(3, word.getDateInsert());;
        return pStCreate.execute();
    }
//Read

    public ArrayList<Word> readAll() throws SQLException {
        ResultSet resultSet = pStReadAll.executeQuery();
        ArrayList<Word> lWord = new ArrayList<>();
        while (resultSet.next()) {
            Word word = new Word();
            word.setWord(resultSet.getString("word"));
            word.setMeaning(resultSet.getString("meaning"));
            word.setDateInsert(resultSet.getTimestamp("date_insert"));
            lWord.add(word);
        }
        return lWord;
    }

    public void read(Word word) throws SQLException {
        //comprobar si se le pueden poner nulos
        pStReadIndividual.setString(1, word.getWord());
        ResultSet resultSet = pStReadIndividual.executeQuery();
        while (resultSet.next()) {
            word.setWord(resultSet.getString("word"));
            word.setMeaning(resultSet.getString("meaning"));
            word.setDateInsert(resultSet.getTimestamp("date_insert"));
        }
    }
//Update

    public boolean update(Word word) throws SQLException {
        //comprobar si se le pueden poner nulos
        pStUpdate.setString(1, word.getMeaning());
        pStUpdate.setTimestamp(2, word.getDateInsert());
        pStUpdate.setString(3, word.getWord());
        return pStUpdate.execute();
    }

//Delete
    public boolean delete(Word word) throws SQLException {
        //comprobar si se le pueden poner nulos
        pStDelete.setString(1, word.getWord());
        return pStDelete.execute();
    }

    //exist
    public boolean exist(Word word) throws SQLException {
        //comprobar si se le pueden poner nulos
        pStReadIndividual.setString(1, word.getWord());
        ResultSet resultSet = pStReadIndividual.executeQuery();
        return resultSet.next();
    }
}
