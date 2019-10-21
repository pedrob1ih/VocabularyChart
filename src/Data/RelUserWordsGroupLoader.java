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
import objects.RelUserWordsGroup;

/**
 *
 * @author pedro
 */
public class RelUserWordsGroupLoader {

    private static RelUserWordsGroupLoader instance = null;

    private MysqlRemoteConector mysqlRemoteConector;
    private PreparedStatement pStCreate;
    private final String create = "INSERT INTO rel_user_wordsgroup (id_user, id_words_group,date_insert) VALUES (?, ?, ?)";
    private PreparedStatement pStReadAll;
    private final String readAll = "Select id_user, id_words_group, date_insert from rel_user_wordsgroup";
    private PreparedStatement pStReadIndividual;
    private final String readIndividual = "Select id_user, id_words_group, date_insert from rel_user_wordsgroup"
            + "where id_user=?, id_words_group=?";
    private PreparedStatement pStDelete;
    private final String delete = "DELETE FROM rel_user_wordsgroup WHERE id_user=?, id_words_group=?";
    private PreparedStatement pStListPerUser;
    private final String listPerUser = "SELECT * FROM `rel_user_wordsgroup` WHERE id_user=?";

    public static RelUserWordsGroupLoader getInstance() throws SQLException {
        if (instance == null) {
            instance = new RelUserWordsGroupLoader();
        }
        return instance;
    }

    private RelUserWordsGroupLoader() {
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
        pStListPerUser = connection.prepareStatement(listPerUser);
    }

//Create
    public boolean create(RelUserWordsGroup relUserWordsGroup) throws SQLException {
        pStCreate.setInt(1, relUserWordsGroup.getIdUser());
        pStCreate.setInt(2, relUserWordsGroup.getIdWordsGroup());
        pStCreate.setTimestamp(3, relUserWordsGroup.getDateIsert());
        return pStCreate.execute();
    }
//Read

    public ArrayList<RelUserWordsGroup> readAll() throws SQLException {
        ResultSet resultSet = pStReadAll.executeQuery();
        ArrayList<RelUserWordsGroup> lRelUserWordsGroup = new ArrayList<>();
        while (resultSet.next()) {
            RelUserWordsGroup relUserWordsGroup = new RelUserWordsGroup();
            relUserWordsGroup.setIdWordsGroup(resultSet.getInt("id_user"));
            relUserWordsGroup.setIdWordsGroup(resultSet.getInt("id_words_group"));
            relUserWordsGroup.setDateIsert(resultSet.getTimestamp("date_insert"));
            lRelUserWordsGroup.add(relUserWordsGroup);
        }
        return lRelUserWordsGroup;
    }

    public void read(RelUserWordsGroup relUserWordsGroup) throws SQLException {
        //comprobar si se le pueden poner nulos
        pStReadIndividual.setInt(1, relUserWordsGroup.getIdUser());
        pStReadIndividual.setInt(2, relUserWordsGroup.getIdWordsGroup());
        pStReadIndividual.setTimestamp(3, relUserWordsGroup.getDateIsert());
        ResultSet resultSet = pStReadIndividual.executeQuery();
        while (resultSet.next()) {
            relUserWordsGroup.setIdUser(resultSet.getInt("id_user"));
            relUserWordsGroup.setIdWordsGroup(resultSet.getInt("id_words_group"));
            relUserWordsGroup.setDateIsert(resultSet.getTimestamp("date_insert"));
        }
    }
//Update
//Delete

    public boolean delete(RelUserWordsGroup relUserWordsGroup) throws SQLException {
        //comprobar si se le pueden poner nulos
        pStDelete.setInt(1, relUserWordsGroup.getIdUser());
        pStDelete.setInt(2, relUserWordsGroup.getIdWordsGroup());
        pStDelete.setTimestamp(3, relUserWordsGroup.getDateIsert());
        return pStDelete.execute();
    }

    //listar las listas de palabras que tiene un usuario

    public ArrayList<RelUserWordsGroup> listPerUser(RelUserWordsGroup in) throws SQLException {
        ArrayList<RelUserWordsGroup> lRelUserWordsGroup = new ArrayList<>();
        pStListPerUser.setInt(1, in.getIdUser());
        ResultSet resultSet = pStListPerUser.executeQuery();
        while (resultSet.next()) {
            RelUserWordsGroup relUserWordsGroup = new RelUserWordsGroup();
            relUserWordsGroup.setIdWordsGroup(resultSet.getInt("id_user"));
            relUserWordsGroup.setIdWordsGroup(resultSet.getInt("id_words_group"));
            relUserWordsGroup.setDateIsert(resultSet.getTimestamp("date_insert"));
            lRelUserWordsGroup.add(relUserWordsGroup);
        }
        return lRelUserWordsGroup;
    }
}
