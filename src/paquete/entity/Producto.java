package paquete.entity;

/**
 *
 * @author Junior
 */
public class Producto {
    
    private int codProducto;
    private String nombre;
    private int registroSanitario;
    private int stock;
    private double precioUnitario;
            
    /*
    COD_PRODUCTO NUMBER(4) NOT NULL,
    NOMBRE VARCHAR2(30) NOT NULL,
    REGISTRO_SANITARIO NUMBER(5) NOT NULL,
    STOCK NUMBER,
    PRECIO_UNITARIO NUMBER(6,2)
    */

    public Producto(int codProducto, String nombre, int registroSanitario, int stock, double precioUnitario) {
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.registroSanitario = registroSanitario;
        this.stock = stock;
        this.precioUnitario = precioUnitario;
    }

    public Producto() {
    }
    

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRegistroSanitario() {
        return registroSanitario;
    }

    public void setRegistroSanitario(int registroSanitario) {
        this.registroSanitario = registroSanitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "Producto{" + "codProducto=" + codProducto + ", nombre=" + nombre + ", registroSanitario=" + registroSanitario + ", stock=" + stock + ", precioUnitario=" + precioUnitario + '}';
    }
}
