package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MysqlRemoteConector {
    
    private static MysqlRemoteConector instance=null;
    private Statement st;
    private Connection conn;
    
    private MysqlRemoteConector(){
        if(conn==null)
            abrirConexion();
    }
    public static MysqlRemoteConector getInstance(){
        if(instance==null)
            instance = new MysqlRemoteConector();
            
        return instance;
    }
    
    private boolean abrirConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://185.224.137.11:3306/u935890934_VocChart","def","defdef");
            this.st=conn.createStatement();
            return true;
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(MysqlRemoteConector.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(MysqlRemoteConector.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Statement getSt() {
        return st;
    }

    public Connection getConn() {
        return conn;
    }
}
