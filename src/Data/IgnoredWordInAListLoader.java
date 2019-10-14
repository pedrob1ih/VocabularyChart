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
import objects.IgnoredWordInAList;

/**
 *
 * @author pedro
 */
public class IgnoredWordInAListLoader {

    private static IgnoredWordInAListLoader instance = null;

    private MysqlRemoteConector mysqlRemoteConector;
    private PreparedStatement pStCreate;
    private final String create = "INSERT INTO ignored_word_in_a_list (id_user, id_words_group, word, date_insert) VALUES (?, ?, ?, ?)";
    private PreparedStatement pStReadAll;
    private final String readAll = "Select id_user, id_words_group, word, date_insert from ignored_word_in_a_list";
    private PreparedStatement pStReadIndividual;
    private final String readIndividual = "Select id_user, id_words_group, word, date_insert from ignored_word_in_a_list "
            + "where id_user=?, id_words_group=?, word=?, date_insert=?";
    private PreparedStatement pStDelete;
    private final String delete = "DELETE FROM ignored_word_in_a_list WHERE id_user=? and id_words_group=? and word=?";

    public static IgnoredWordInAListLoader getInstance() throws SQLException {
        if (instance == null) {
            instance = new IgnoredWordInAListLoader();
        }
        return instance;
    }

    private IgnoredWordInAListLoader() {
        if (pStCreate == null) {
            try {
                createInstance();
            } catch (SQLException ex) {
                Logger.getLogger(IgnoredWordInAListLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void createInstance() throws SQLException {
        if (this.mysqlRemoteConector == null) {
            this.mysqlRemoteConector = MysqlRemoteConector.getInstance();
        }
//        this.instance = new IgnoredWordInAListLoader();
        Connection connection = mysqlRemoteConector.getConn();
        pStCreate = connection.prepareStatement(create);
        pStReadAll = connection.prepareStatement(readAll);
        pStReadIndividual = connection.prepareStatement(readIndividual);
        pStDelete = connection.prepareStatement(delete);
    }

//Create
    public boolean create(IgnoredWordInAList ignoredWordInAList) throws SQLException {
        pStCreate.setInt(1, ignoredWordInAList.getIdUser());
        pStCreate.setInt(2, ignoredWordInAList.getIdWordsGroup());
        pStCreate.setString(3, ignoredWordInAList.getWord());
        pStCreate.setTimestamp(4, ignoredWordInAList.getDateIsert());
        return pStCreate.execute();
    }
//Read

    public ArrayList<IgnoredWordInAList> readAll() throws SQLException {
        ResultSet resultSet = pStReadAll.executeQuery();
        ArrayList<IgnoredWordInAList> lIgnoredWordInAList = new ArrayList<>();
        while (resultSet.next()) {
            IgnoredWordInAList ignoredWordInAList = new IgnoredWordInAList();
            ignoredWordInAList.setIdUser(resultSet.getInt("id_user"));
            ignoredWordInAList.setIdWordsGroup(resultSet.getInt("id_words_group"));
            ignoredWordInAList.setWord(resultSet.getString("word"));
            ignoredWordInAList.setDateIsert(resultSet.getTimestamp("date_insert"));
            lIgnoredWordInAList.add(ignoredWordInAList);
        }
        return lIgnoredWordInAList;
    }

    public void read(IgnoredWordInAList ignoredWordInAList) throws SQLException {
        //comprobar si se le pueden poner nulos
        pStReadIndividual.setInt(1, ignoredWordInAList.getIdUser());
        pStReadIndividual.setInt(2, ignoredWordInAList.getIdWordsGroup());
        pStReadIndividual.setString(3, ignoredWordInAList.getWord());
        pStReadIndividual.setTimestamp(4, ignoredWordInAList.getDateIsert());
        ResultSet resultSet = pStReadIndividual.executeQuery();
        while (resultSet.next()) {
            ignoredWordInAList.setIdUser(resultSet.getInt("id_user"));
            ignoredWordInAList.setIdWordsGroup(resultSet.getInt("id_words_group"));
            ignoredWordInAList.setWord(resultSet.getString("word"));
            ignoredWordInAList.setDateIsert(resultSet.getTimestamp("date_insert"));
        }
    }
//Update
//Delete

    public boolean delete(IgnoredWordInAList ignoredWordInAList) throws SQLException {
        //comprobar si se le pueden poner nulos
        pStDelete.setInt(1, ignoredWordInAList.getIdUser());
        pStDelete.setInt(2, ignoredWordInAList.getIdWordsGroup());
        pStDelete.setString(3, ignoredWordInAList.getWord());
        return pStDelete.execute();
    }
}
