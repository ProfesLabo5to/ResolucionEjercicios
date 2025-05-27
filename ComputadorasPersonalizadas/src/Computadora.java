import java.util.ArrayList;

public class Computadora {
    private CPU cpu;
    private ArrayList<Periferico> perifericos;

    public Computadora(CPU cpu, ArrayList<Periferico> perifericos) {
        if (cpu == null) throw new IllegalArgumentException("Debe incluir una CPU");
        boolean tienePuertosEntrada = false;
        boolean tienePuertosSalida = false;
        for(Periferico p: perifericos){
            if (p instanceof Entrada){
                tienePuertosEntrada = true;
            } else if (p instanceof Salida){
                tienePuertosSalida = true;
            }
        }
        if (tienePuertosEntrada && tienePuertosSalida && cpu !=null){
            this.cpu = cpu;
            this.perifericos = perifericos;
        }
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public ArrayList<Periferico> getPerifericos() {
        return perifericos;
    }

    public void setPerifericos(ArrayList<Periferico> perifericos) {
        this.perifericos = perifericos;
    }

    public double calcularPrecioNeto() {
        double suma = cpu.getPrecio();
        for (Periferico p : perifericos) {
            suma += p.getPrecio();
        }
        return suma;
    }

    public void actualizarStock() {
        cpu.reducirStock(1);
        for (Periferico p : perifericos) p.reducirStock(1);
    }

    public int cantidadDispositivosEntrada(){
        int contador =0;
        for(Periferico p: perifericos){
            if (p instanceof Entrada){
                contador++;
           }
        }
        return contador;
    }
    public int cantidadDispositivosSalida(){
        int contador =0;
        for(Periferico p: perifericos){
            if (p instanceof Salida){
                contador++;
            }
        }
        return contador;
    }

    public int cantidadDispositivos (String tipoDispositivo){
        int contador =0;
        for(Periferico p: perifericos){
            if (p.getClass().getCanonicalName().equals(tipoDispositivo)){
                contador++;
            }
        }
        return contador;
    }
}
