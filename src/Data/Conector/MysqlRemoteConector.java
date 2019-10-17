package Data.Conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MysqlRemoteConector {
    
    private static MysqlRemoteConector instance=null;
    private Connection conn;
    
    private MysqlRemoteConector(){
        if(conn==null)
            openConection();
    }
    public static MysqlRemoteConector getInstance(){
        if(instance==null)
            instance = new MysqlRemoteConector();
            
        return instance;
    }
    
    private boolean openConection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://37.59.55.185:3306/GRv0uSguq8?useSSL=false","GRv0uSguq8","BL0y8JnMPB");
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

    public Connection getConn() {
        return conn;
    }
}
