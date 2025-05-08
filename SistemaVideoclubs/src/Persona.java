import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String apellido;
    private int dni;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngresoAlBanco;

    public Persona() {
        this.nombre = "";
        this.apellido = "";
        this.dni = 00;
        this.fechaNacimiento = LocalDate.now();
        this.fechaIngresoAlBanco = LocalDate.now();
    }
    public Persona(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngresoAlBanco) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngresoAlBanco = fechaIngresoAlBanco;
    }
    //Se usa para dar de alta con la fecha de hoy a empleados.
    public Persona(String nombre, String apellido, int dni, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngresoAlBanco = LocalDate.now();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaIngresoAlBanco() {
        return fechaIngresoAlBanco;
    }

    public void setFechaIngresoAlBanco(LocalDate fechaIngresoAlBanco) {
        this.fechaIngresoAlBanco = fechaIngresoAlBanco;
    }

    public int antiguedad(){
        return LocalDate.now().getYear() - fechaIngresoAlBanco.getYear();
    }

    public boolean esMayorDeEdad(){
        return (LocalDate.now().getYear()-fechaNacimiento.getYear()) > 18;
    }
}
