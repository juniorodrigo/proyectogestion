package paquete.entity;

/**
 *
 * @author Junior
 */
public class Empleado {
    private int dni;
    private String nombre;
    private int celular;
    private String correo;
    private int brevete;
    private String canalVenta;
    private String puesto;
    

    public Empleado(int dni, String nombre, int celular, String correo, int brevete, String canalVenta, String puesto) {
        this.dni = dni;
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
        this.brevete = brevete;
        this.canalVenta = canalVenta;
        this.puesto = puesto;
    }
    public Empleado()
    {}

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getBrevete() {
        return brevete;
    }

    public void setBrevete(int brevete) {
        this.brevete = brevete;
    }

    public String getCanalVenta() {
        return canalVenta;
    }

    public void setCanalVenta(String canalVenta) {
        this.canalVenta = canalVenta;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Empleado{" + "dni=" + dni + ", nombre=" + nombre + ", celular=" + celular + ", correo=" + correo + ", brevete=" + brevete + ", canalVenta=" + canalVenta + ", puesto=" + puesto + '}';
    }
    
}
