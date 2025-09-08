package Campania;
import Dominio.Persona;
import Dominio.Mensajero;

import java.time.LocalDate;
import java.time.LocalTime;

public class Trabajador extends Persona implements Mensajero {
    private String cuil;
    private double sueldo;
    private String direccionResidencia;
    private LocalTime horaInicioLaboral; // horario laboral (ej: 09:00–17:00)
    private LocalTime horaFinLaboral;

    public Trabajador(String nombre, String apellido, String dni, LocalDate fechaNacimiento, String cuil, double sueldo, String direccionResidencia, LocalTime horaInicioLaboral, LocalTime horaFinLaboral) {
        super(nombre, apellido, dni, fechaNacimiento);
        this.cuil = cuil;
        this.sueldo = sueldo;
        this.direccionResidencia = direccionResidencia;
        this.horaInicioLaboral = horaInicioLaboral;
        this.horaFinLaboral = horaFinLaboral;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public LocalTime getHoraFinLaboral() {
        return horaFinLaboral;
    }

    public void setHoraFinLaboral(LocalTime horaFinLaboral) {
        this.horaFinLaboral = horaFinLaboral;
    }

    public LocalTime getHoraInicioLaboral() {
        return horaInicioLaboral;
    }

    public void setHoraInicioLaboral(LocalTime horaInicioLaboral) {
        this.horaInicioLaboral = horaInicioLaboral;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    private boolean enHorarioLaboral() {
        LocalTime ahora = LocalTime.now();
        return !ahora.isBefore(horaInicioLaboral) && !ahora.isAfter(horaFinLaboral);
    }

    @Override
    public String enviarMensajeCampania(String texto) {
        if (!enHorarioLaboral()) return "Se encuentra fuera de horario laboral.";
        return "Yo, " + getNombreCompleto() + " te invito a que… " + texto;
    }
}
