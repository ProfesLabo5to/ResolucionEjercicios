public class Empleado extends Persona {
    private String telefono;

    public Empleado(String nombre, String apellido, String dni, String pais, String telefono) {
        super(nombre, apellido, dni, pais);
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }
}