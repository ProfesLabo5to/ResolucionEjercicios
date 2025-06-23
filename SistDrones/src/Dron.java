import java.time.LocalDate;

public abstract class Dron {
    private static int contador = 0;
    private static double latitudOrigen = -34.573195;
    private static double longitudOrigen = -58.504111;
    private int id;
    private String modelo;
    private LocalDate fechaAdquisicion;
    private Bateria cargaBateria;
    private Estado estado;

    public Dron(String modelo, LocalDate fechaAdquisicion, Bateria cargaBateria, Estado estado) {
        this.id = contador;
        this.modelo = modelo;
        this.fechaAdquisicion = fechaAdquisicion;
        this.cargaBateria = cargaBateria;
        this.estado = estado;
        contador++;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Dron.contador = contador;
    }

    public static double getLatitudOrigen() {
        return latitudOrigen;
    }

    public static void setLatitudOrigen(double latitudOrigen) {
        Dron.latitudOrigen = latitudOrigen;
    }

    public static double getLongitudOrigen() {
        return longitudOrigen;
    }

    public static void setLongitudOrigen(double longitudOrigen) {
        Dron.longitudOrigen = longitudOrigen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public Bateria getCargaBateria() {
        return cargaBateria;
    }

    public void setCargaBateria(Bateria cargaBateria) {
        this.cargaBateria = cargaBateria;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean rastrearDron(){
        return estado.isRastreable();
    }

    public void recargarBateria(){
        Bateria[] valoresBateria = Bateria.values();
        if(cargaBateria.getValor()>=20 && cargaBateria.getValor()<100){
            cargaBateria = valoresBateria[
                    (cargaBateria.ordinal()+1)
                    ];
        } else{
            cargaBateria= Bateria.CIEN;
        }
    }

    public abstract boolean ejecutarMision(double latitudDestino,double longitudDestino );

}
