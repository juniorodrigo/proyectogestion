package paquete.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import paquete.entity.Empleado;

/**
 *
 * @author Junior
 */
public class EmpleadoDAO {
    
    private String mensaje = "";
    
    public String agregarEmpleado(Connection con, Empleado emp)
    {
        PreparedStatement pstx = null;
        String sqlSentence = "INSERT INTO EMPLEADO (DNI, NOMBRE, CELULAR, CORREO, BREVETE, CANAL_VENTA, PUESTO)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try {
            System.out.println("DAO/AGREGAREMPLEADO/TRY");
            pstx =  con.prepareStatement(sqlSentence);
            
            pstx.setInt(1, emp.getDni());
            pstx.setString(2, emp.getNombre());
            pstx.setInt(3, emp.getCelular());
            pstx.setString(4, emp.getCorreo());
            pstx.setInt(5, emp.getBrevete());
            pstx.setString(6, emp.getCanalVenta());
            pstx.setString(7, emp.getPuesto());
            mensaje = "Empleado guardado exitosamente\n";
            pstx.execute();
            System.out.println("DAO/AGREGAREMPLEADO/DESPUÉSA");
            pstx.close();
            
        } catch (SQLException e) {
            System.out.println("DAO/AGREGAREMPLEADO/CATCH");
            mensaje = "No se ha podido guardar\n" + e.getMessage();
        }
        return mensaje;
    }
    
    public String modificarEmpleado(Connection con, Empleado emp)
    {
        PreparedStatement pst = null;
        String sqlSentence = "UPDATE EMPLEADO SET  NOMBRE= ?, CELULAR = ?, CORREO= ?, BREVETE = ?, CANAL_VENTA= ?, PUESTO=?"
                + "WHERE DNI= ?";
        
        try {
            pst =  con.prepareStatement(sqlSentence);
            
            pst.setString(1, emp.getNombre());
            pst.setInt(2, emp.getCelular());
            pst.setString(3, emp.getCorreo());
            pst.setInt(4, emp.getBrevete());
            pst.setString(5, emp.getCanalVenta());
            pst.setString(6, emp.getPuesto());
            pst.setInt(7, emp.getDni());
            
            mensaje = "Empleado modificado exitosamente\n";
            pst.execute();
            pst.close();
            
        } catch (SQLException e) {
            mensaje = "No se ha podido modificar\n" + e.getMessage();
        }
        return mensaje;
    }
    
    public String eliminarEmpleado(Connection con, int dni)
    {
        PreparedStatement pst = null;
        String sqlSentence = "DELETE FROM EMPLEADO WHERE DNI=?";
        try {
            pst = con.prepareStatement(sqlSentence);
            pst.setInt(1, dni);
            
            mensaje = "Solicitud de eliminación procesada correctamente\n";
            pst.execute();
            pst.close();
            
        } catch (SQLException e) {
            mensaje = "No se ha podido procesar la solicitud\n" + e.getMessage();
        }
        return mensaje;
    }
    
    public void mostrarEmpleado(Connection con, JTable tabla)
    {
        DefaultTableModel modelEmpleado;
        String[] columnas = {"DNI", "NOMBRE", "CELULAR", "CORREO", "BREVETE", "CANALVENTA", "PUESTO"};
        
        modelEmpleado = new DefaultTableModel(null, columnas);
        
        String sqlString = "SELECT * FROM EMPLEADO ORDER BY PUESTO";
        
        String[] filas = new String[7];
        Statement st = null;
        ResultSet rs = null;
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlString);
            
            while (rs.next())
            {
                for (int i = 0; i<7; i++)
                {
                    filas[i] = rs.getString(i+1);
                    System.out.println(filas[i]);
                }
                modelEmpleado.addRow(filas);
            }
            tabla.setModel(modelEmpleado);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se pueden mostrar los empleados");
        }
    }
    
}
