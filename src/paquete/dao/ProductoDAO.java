package paquete.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import paquete.entity.Producto;

/**
 *
 * @author Junior
 */
public class ProductoDAO
{
    private String mensaje = "";
    
    public String agregarProducto(Connection con, Producto prod)
    {
        PreparedStatement pst = null;
        String sqlSentence = "INSERT INTO PRODUCTO(COD_PRODUCTO, NOMBRE, REGISTRO_SANITARIO, STOCK, PRECIO_UNITARIO)"
                + "VALUES(PRODUCTO_SEC.NEXTVAL, ?, ?, ?, ?)";
        
        try {
            pst = con.prepareStatement(sqlSentence);
            pst.setString(1, prod.getNombre());
            pst.setInt(2, prod.getRegistroSanitario());
            pst.setInt(3, prod.getStock());
            pst.setDouble(4, prod.getPrecioUnitario());
            
            mensaje = "Producto guardado exitosamente\n";
            pst.execute();
            pst.close();
            
        } catch (SQLException e) {
            mensaje = "No se ha podido guardarel producto\n" + e.getMessage();
        }
        return mensaje;
    }
    
    public String modificarProducto(Connection con, Producto prod)
    {
        PreparedStatement pst = null;
        String sqlSentence = "UPDATE PRODUCTO SET NOMBRE =?, REGISTRO_SANITARIO =?, STOCK =?, PRECIO_UNITARIO =? "
                + "WHERE COD_PRODUCTO = ?";
        
        try {
            pst = con.prepareStatement(sqlSentence);
            pst.setString(1, prod.getNombre());
            pst.setInt(2, prod.getRegistroSanitario());
            pst.setInt(3, prod.getStock());
            pst.setDouble(4, prod.getPrecioUnitario());
            pst.setInt(5, prod.getCodProducto());
            
            mensaje = "Modificado exitosamente\n";
            pst.execute();
            pst.close();
            
        } catch (SQLException e) {
            mensaje = "No se ha podido modificar\n" + e.getMessage();
        }
        return mensaje;
    }
    
    public String eliminarProducto(Connection con, int codigo)
    {
        PreparedStatement pst = null;
        String sqlSentence = "DELETE FROM PRODUCTO WHERE COD_PRODUCTO = ?";
        
        try {
            pst = con.prepareStatement(sqlSentence);
            pst.setInt(1, codigo);
            
            mensaje = "Solicitud de eliminación correcta\n";
            pst.execute();
            pst.close();
            
        } catch (SQLException e) {
            mensaje = "No se ha podido eliminar\n" + e.getMessage();
        }
        return mensaje;
    }
    
    public void mostrarProducto(Connection con, JTable tabla)
    {
        DefaultTableModel modelProducto;
        String[] columnas = {"CÓDIGO", "NOMBRE", "REG. SAN.", "STOCK", "PRECIO/U"};
        modelProducto = new DefaultTableModel(null, columnas);
        
        String sqlString = "SELECT * FROM PRODUCTO ORDER BY COD_PRODUCTO";
        
        String[] filas = new String[5];
        Statement st = null;
        ResultSet rs = null;
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlString);
            
            while(rs.next())
            {
                for (int i = 0; i<5;i++)
                {
                    filas[i] = rs.getString(i+1);
                    System.out.println(filas[i]);
                }
                modelProducto.addRow(filas);
            }
            tabla.setModel(modelProducto);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pueden mostrar los productos");
        }
        
    }
    
    public void listarTienda(Connection con, JTable tabla)
    {
        DefaultTableModel modelProducto;
        String[] columnas = {"CÓD", "NOM", "REG. SAN.", "STOCK", "PRECIO/U", "SELEC."};
        modelProducto = new DefaultTableModel(null, columnas);
        

        String sqlString = "SELECT * FROM PRODUCTO ORDER BY COD_PRODUCTO";
        
        String[] filas = new String[6];
        Statement st = null;
        ResultSet rs = null;
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlString);
            
            while(rs.next())
            {
                for (int i = 0; i<5;i++)
                {
                    filas[i] = rs.getString(i+1);
                    System.out.println(filas[i]);
                }
                modelProducto.addRow(filas);
            }
            tabla.setModel(modelProducto);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pueden mostrar los productos");
        }
        
    }
    
    
    public int getMaxID(Connection conn)
    {
        int id = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sqlSentence = "SELECT MAX(COD_PRODUCTO)+1 AS ID FROM PRODUCTO";
        try {
            pst = conn.prepareStatement(sqlSentence);
            rs = pst.executeQuery();
            if(rs.next())
            {
                id = rs.getInt(1);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            System.out.println("Error al mostrar ID" + e.getMessage());
        }
        return id;
    }
}
