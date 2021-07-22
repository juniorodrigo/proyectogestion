package paquete.test;

import paquete.bo.EmpleadoBO;
import paquete.bo.ProductoBO;
import paquete.entity.Empleado;
import paquete.entity.Producto;

public class Test {
    
    ProductoBO pbo = new ProductoBO();
    Producto producto = new Producto();
    
    EmpleadoBO ebo = new EmpleadoBO();
    Empleado empleado = new Empleado();
    
    String mensaje = "";
    
    public void insertarEmpleado()
    {
        empleado.setDni(1111);
        empleado.setNombre("XXXXDDDDD");
        empleado.setCelular(999);
        empleado.setCorreo("XD");
        empleado.setBrevete(123);
        empleado.setCanalVenta("XD");
        empleado.setPuesto("XD");
        empleado.toString();
        mensaje = ebo.agregarEmpleado(empleado);
        System.out.println(mensaje);
        
        empleado.toString();
                
    }
    
    public void modificar()
    {
        producto.setCodProducto(100);
        producto.setNombre("LEGUMBRES");
        producto.setRegistroSanitario(12345);
        producto.setStock(12);
        producto.setPrecioUnitario(5);
        mensaje = pbo.modificarProducto(producto);
        System.out.println(mensaje);

    }
    
    public void eliminar()
    {
        mensaje = pbo.eliminarProducto(100);
        System.out.println(mensaje);
    }
    
    public void insertarProducto()
    {
        producto.setNombre("PRUEBAAAAXD");
        producto.setRegistroSanitario(3333);
        producto.setStock(12);
        producto.setPrecioUnitario(5);
        producto.toString();
        mensaje = pbo.agregarProducto(producto);
        System.out.println(mensaje);

    }
    
    public void modificarProducto()
    {
        producto.setCodProducto(100);
        producto.setNombre("LEGUMBRES");
        producto.setRegistroSanitario(12345);
        producto.setStock(12);
        producto.setPrecioUnitario(5);
        mensaje = pbo.modificarProducto(producto);
        System.out.println(mensaje);

    }
    
    public void eliminarProducto()
    {
        mensaje = pbo.eliminarProducto(100);
        System.out.println(mensaje);
    }
    
    
    public static void main(String[] args) {
        Test test = new Test();
        test.insertarProducto();
        System.out.println("PRODUCTRO INSERTADO");
        test.insertarEmpleado(); 
        System.out.println("EMPLEADO INSERTADO");
        
        
        
        // test.eliminar();
        
    }
}
