package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqliteConector {
    
    private static SqliteConector instance=null;
    private Statement st;
    private Connection conn;
    
    private SqliteConector(){
        if(conn==null)
            abrirConexion();
    }
    public static SqliteConector getInstance(){
        if(instance==null)
            instance = new SqliteConector();
            
        return instance;
    }
    
    private boolean abrirConexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\mega\\GitHubProyects\\GitHubProyects\\VocabularyChartJSwing\\lib\\base_de_datos_sqlite.db");
            this.st=conn.createStatement();
            return true;
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(SqliteConector.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(SqliteConector.class.getName()).log(Level.SEVERE, null, ex);
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
