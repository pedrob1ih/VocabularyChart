/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Data.Conector.MysqlRemoteConector;
import Objects.Word;
import Objects.WordsGroup;
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
public class WordsGroupLoader {

    private static WordsGroupLoader instance = null;

    private MysqlRemoteConector mysqlRemoteConector;
    private PreparedStatement pStCreate;
    private final String create = "INSERT INTO wordsGroup (id, name, date_insert) VALUES (?, ?, ?)";
    private PreparedStatement pStReadAll;
    private final String readAll = "Select id, name, date_insert from wordsGroup";
    private PreparedStatement pStReadIndividual;
    private final String readIndividual = "Select id, name, date_insert from wordsGroup where id=?";
    private PreparedStatement pStDelete;
    private final String delete = "DELETE FROM wordsGroup where id=?";

    public static WordsGroupLoader getInstance() throws SQLException {
        if (instance == null) {
            instance = new WordsGroupLoader();
        }
        return instance;
    }

    private WordsGroupLoader() {
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
    public boolean create(WordsGroup wordsGroup) throws SQLException {
        pStCreate.setInt(1, wordsGroup.getId());
        pStCreate.setString(2, wordsGroup.getName());
        pStCreate.setTimestamp(3, wordsGroup.getDate());
        return pStCreate.execute();
    }
//Read

    public ArrayList<WordsGroup> readAll() throws SQLException {
        ResultSet resultSet = pStReadAll.executeQuery();
        ArrayList<WordsGroup> lWordsGroup = new ArrayList<>();
        while (resultSet.next()) {
            WordsGroup wordsGroup = new WordsGroup();
            wordsGroup.setId(resultSet.getInt("id"));
            wordsGroup.setName(resultSet.getString("name"));
            wordsGroup.setDate(resultSet.getTimestamp("date_insert"));
            lWordsGroup.add(wordsGroup);
        }
        return lWordsGroup;
    }

    public void read(WordsGroup wordsGroup) throws SQLException {
        //comprobar si se le pueden poner nulos
        pStReadIndividual.setInt(1, wordsGroup.getId());
//        pStReadIndividual.setString(2, wordsGroup.getName());
//        pStReadIndividual.setTimestamp(3, wordsGroup.getDate());
        ResultSet resultSet = pStReadIndividual.executeQuery();
        while (resultSet.next()) {
            wordsGroup.setId(resultSet.getInt("id"));
            wordsGroup.setName(resultSet.getString("name"));
            wordsGroup.setDate(resultSet.getTimestamp("date_insert"));
        }
    }
//Update
//Delete

    public boolean delete(WordsGroup wordsGroup) throws SQLException {
        //comprobar si se le pueden poner nulos
        pStDelete.setInt(1, wordsGroup.getId());
        return pStDelete.execute();
    }

    //exist
    public boolean exist(WordsGroup wordsGroup) throws SQLException {
        //comprobar si se le pueden poner nulos
        pStReadIndividual.setInt(1, wordsGroup.getId());
//        pStReadIndividual.setString(2, wordsGroup.getName());
//        pStReadIndividual.setTimestamp(3, wordsGroup.getDate());
        ResultSet resultSet = pStReadIndividual.executeQuery();
        return resultSet.next();
    }
}
