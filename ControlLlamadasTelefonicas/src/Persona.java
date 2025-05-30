public class Persona {
    protected String nombre;
    protected String apellido;
    protected String dni;
    protected String pais;

    public Persona(String nombre, String apellido, String dni, String pais) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.pais = pais;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public String getPais() {
        return pais;
    }

    public String getDni() {
        return dni;
    }

}