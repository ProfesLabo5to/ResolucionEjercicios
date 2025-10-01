package prestamos;

import java.time.LocalDate;

public class Autor extends Persona{
    public Autor() {
    }

    public Autor(String nombre, String apellido, int edad, String direccion) {
        super(nombre, apellido, edad, direccion);
    }

    public Autor(String nombre, String apellido, LocalDate fNacimiento) {
        super(nombre, apellido, fNacimiento);
    }

    public Autor(String nombre, String apellido) {
        super(nombre, apellido);
    }
}
