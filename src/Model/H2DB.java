package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class H2DB {
    
    private static H2DB instance=null;
    private Statement st;
    private Connection conn;
    
    private H2DB(){
        if(conn==null)
            abrirConexion();
    }
    public static H2DB getInstance(){
        if(instance==null)
            instance = new H2DB();
            
        return instance;
    }
    
    private boolean abrirConexion(){
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            this.st=conn.createStatement();
            return true;
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(H2DB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(H2DB.class.getName()).log(Level.SEVERE, null, ex);
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
