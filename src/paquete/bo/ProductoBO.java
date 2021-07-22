/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.bo;

import java.sql.Connection;
import java.sql.SQLException;
// import java.util.logging.Level;
// import java.util.logging.Logger;
import javax.swing.JTable;
import paquete.dao.ProductoDAO;
import paquete.db.Conexion;
import paquete.entity.Producto;

/**
 *
 * @author Junior
 */
public class ProductoBO {
    
    private String mensaje = "";
    private ProductoDAO ndao = new ProductoDAO();
    
    public String agregarProducto(Producto prod)
    {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = ndao.agregarProducto(conn, prod);
            
        } catch (Exception e) {
            mensaje  = mensaje + " " + e.getMessage();
        }finally {
            try {
                if(conn!=null)
                {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje  = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    
    public String modificarProducto(Producto prod)
    {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = ndao.modificarProducto(conn, prod);
            
        } catch (Exception e) {
            mensaje  = mensaje + " " + e.getMessage();
        }finally {
            try {
                if(conn!=null)
                {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje  = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    
    public String eliminarProducto(int codigo)
    {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = ndao.eliminarProducto(conn, codigo);
            
        } catch (Exception e) {
            mensaje  = mensaje + " " + e.getMessage();
        }finally {
            try {
                if(conn!=null)
                {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje  = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    
    public void mostrarProducto(JTable tabla)
    {
        Connection conn = Conexion.getConnection();
        ndao.mostrarProducto(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public void listarTienda(JTable tabla)
    {
        Connection conn = Conexion.getConnection();
        ndao.listarTienda(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public int getMaxID()
    {
        Connection conn = Conexion.getConnection();
        int id = ndao.getMaxID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
}