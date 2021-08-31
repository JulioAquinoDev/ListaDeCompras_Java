package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author julio
 */

public class ConexaoBD {
       
    String user = "root";
    String password = "#Ap.29081970";
    String nameDB = "lista_de_compras";
    String host = "localhost:3306";
        
    public Connection getConnection(){
        
        Connection conn = null;
                
        try {
            String url = "jdbc:mysql://"+ host +"/"+ nameDB +"?user="+ user +"&password="+ password;
            conn = DriverManager.getConnection(url);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ConexaoBD" + erro.getMessage());
        }
        return conn;        
    }
    
}