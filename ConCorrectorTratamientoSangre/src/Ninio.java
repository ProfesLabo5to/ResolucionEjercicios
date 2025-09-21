import java.time.LocalDate;

public class Ninio extends Paciente implements Tratamiento{
    private ValorTolerancia tolerancia; // 1 a 10
    private boolean tieneMasDeTres;

    public Ninio(String nombre, String apellido, LocalDate fechaNacimiento, String genero, TipoSangre tipoSangre, ValorTolerancia tolerancia) {
        super(nombre, apellido, fechaNacimiento, genero, tipoSangre);
        this.tolerancia = tolerancia;
        this.tieneMasDeTres = super.getEdad() > 3;
    }

    public ValorTolerancia getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(ValorTolerancia tolerancia) {
        this.tolerancia = tolerancia;
    }

    @Override
    public boolean esCandidatoATratamiento(){
        return true;
    }

    @Override
    public int calcularCosto() {
        return tolerancia.getValor() * 450000;
    }

    @Override
    public boolean puedeRecibirTratamiento() {
        if (tieneMasDeTres) {
            System.out.println("Tu tratamiento tardará esta cantidad de días: " + (tolerancia.getValor() * 2));
            return true;
        } else {
            System.out.println("Aún es chico para probar el tratamiento");
            return false;
        }
    }
}
