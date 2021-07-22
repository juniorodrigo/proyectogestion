package paquete.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Junior
 */
public class Conexion {
    private static Connection conn = null;
    private static String usuario = "system";
    private static String contraseña = "admin";
    private static String url = "jdbc:oracle:thin:@localhost:1521:XE";    
    
    public static Connection getConnection()
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, usuario, contraseña);
            conn.setAutoCommit(false);
            
            if(conn != null)
            {
                System.out.println("Conexión exitosa");
            }
            else
            {
                System.out.println("No se ha podido conectar a la base de datos");
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Conexión errónea - " + e.getMessage());
        }
        return conn;
    }
    
    public void disconnect()
    {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al desconectar" + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Conexion c = new Conexion();
        c.getConnection();
    }
    
}
