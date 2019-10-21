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
import objects.UserAccount;
import objects.UserAccount;

/**
 *
 * @author pedro
 */
public class UserAccountLoader {

    private static UserAccountLoader instance = null;

    private MysqlRemoteConector mysqlRemoteConector;
    private PreparedStatement pStCreate;
    private final String create = "INSERT INTO user_account (name, pass, date_insert) VALUES (?, ?, ?)";
    private PreparedStatement pStReadAll;
    private final String readAll = "Select id, name, pass, date_insert from user_account";
    private PreparedStatement pStReadIndividual;
    private final String readIndividual = "Select id, name, pass, date_insert from user_account where id=?";
    private PreparedStatement pStDelete;
    private final String delete = "DELETE FROM user_account where id=?";
    private PreparedStatement pStCorrectLogin;
    private final String correctLogin = "Select id, name, pass, date_insert from user_account where name=? and pass=?";

    public static UserAccountLoader getInstance() throws SQLException {
        if (instance == null) {
            instance = new UserAccountLoader();
        }
        return instance;
    }

    private UserAccountLoader() {
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
        pStCorrectLogin = connection.prepareStatement(correctLogin);
    }

//Create
    public boolean create(UserAccount userAccount) throws SQLException {
        pStCreate.setString(1, userAccount.getName());
        pStCreate.setString(2, userAccount.getPass());
        pStCreate.setTimestamp(3, userAccount.getDateIsert());
        return pStCreate.execute();
    }
//Read

    public ArrayList<UserAccount> readAll() throws SQLException {
        ResultSet resultSet = pStReadAll.executeQuery();
        ArrayList<UserAccount> lUserAccount = new ArrayList<>();
        while (resultSet.next()) {
            UserAccount userAccount = new UserAccount();
            userAccount.setName(resultSet.getString("name"));
            userAccount.setPass(resultSet.getString("pass"));
            userAccount.setDateIsert(resultSet.getTimestamp("date_insert"));
            lUserAccount.add(userAccount);
        }
        return lUserAccount;
    }

    public void read(UserAccount userAccount) throws SQLException {
        //comprobar si se le pueden poner nulos
        pStReadIndividual.setInt(1, userAccount.getId());
        ResultSet resultSet = pStReadIndividual.executeQuery();
        while (resultSet.next()) {
            userAccount.setId(resultSet.getInt("id"));
            userAccount.setName(resultSet.getString("name"));
            userAccount.setPass(resultSet.getString("pass"));
            userAccount.setDateIsert(resultSet.getTimestamp("date_insert"));
        }
    }
//Update
//Delete

    public boolean delete(UserAccount userAccount) throws SQLException {
        //comprobar si se le pueden poner nulos
        pStDelete.setInt(1, userAccount.getId());
        return pStDelete.execute();
    }

    //exist
    public boolean exists(UserAccount userAccount) throws SQLException {
        //comprobar si se le pueden poner nulos
        pStReadIndividual.setInt(1, userAccount.getId());
        ResultSet resultSet = pStReadIndividual.executeQuery();
        return resultSet.next();
    }

    //correct login
    public boolean correctLogIn(UserAccount userAccount) throws SQLException {
        boolean isFound = false;
        //comprobar si se le pueden poner nulos
        pStCorrectLogin.setString(1, userAccount.getName());
        pStCorrectLogin.setString(2, userAccount.getPass());
        ResultSet resultSet = pStCorrectLogin.executeQuery();
        while (resultSet.next()) {
            isFound = true;
            userAccount.setId(resultSet.getInt("id"));
            userAccount.setName(resultSet.getString("name"));
            userAccount.setPass(resultSet.getString("pass"));
            userAccount.setDateIsert(resultSet.getTimestamp("date_insert"));
        }
        return isFound;
    }

}
