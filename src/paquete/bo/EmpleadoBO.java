package paquete.bo;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;
import paquete.dao.EmpleadoDAO;
import paquete.db.Conexion;
import paquete.entity.Empleado;

/**
 *
 * @author Junior
 */
public class EmpleadoBO {
    
    private String mensaje = "";
    private EmpleadoDAO edao = new EmpleadoDAO();
    
    public String agregarEmpleado(Empleado emp)
    {
        Connection conn1 = Conexion.getConnection();
        try {
            mensaje = edao.agregarEmpleado(conn1, emp);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        }finally
        {
            try {
                if(conn1!=null)
                {
                    conn1.close();
                }
            } catch (Exception e) {
                mensaje  = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    public String modificarEmpleado(Empleado emp)
    {
        Connection conn1 = Conexion.getConnection();
        try {
            mensaje = edao.modificarEmpleado(conn1, emp);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        }finally
        {
            try {
                if(conn1!=null)
                {
                    conn1.close();
                }
            } catch (Exception e) {
                mensaje  = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    
    public String eliminarEmpleado(int dni)
    {
        Connection conn1 = Conexion.getConnection();
        try {
            mensaje = edao.eliminarEmpleado(conn1, dni);
            
        } catch (Exception e) {
            mensaje  = mensaje + " " + e.getMessage();
        }finally {
            try {
                if(conn1!=null)
                {
                    conn1.close();
                }
            } catch (Exception e) {
                mensaje  = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    
    public String mostrarEmpleado(JTable tabla)
    {
        Connection con1 = Conexion.getConnection();
        edao.mostrarEmpleado(con1, tabla);
        try {
            con1.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return mensaje;
    }
    
}
