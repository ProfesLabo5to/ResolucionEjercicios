import java.util.HashSet;

public class Bar {
    private HashSet<Diana> dianas;
    private HashSet<Cliente> clientes;
    private Double recaudado;
    private HashSet<Producto> productos;
    private HashSet<Beneficio> beneficios;
    private HashSet<BenefAcumulables> benefAcumulables;

    public Bar(HashSet<Diana> dianas, HashSet<Cliente> clientes, Double recaudado, HashSet<Beneficio> beneficios, HashSet<BenefAcumulables> benefAcumulables, HashSet<Producto>productos) {
        this.dianas = dianas;
        this.clientes = clientes;
        this.recaudado = recaudado;
        this.beneficios = beneficios;
        this.benefAcumulables = benefAcumulables;
        this.productos = productos;
    }

    public HashSet<Diana> getDianas() {
        return dianas;
    }

    public void setDianas(HashSet<Diana> dianas) {
        this.dianas = dianas;
    }

    public HashSet<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashSet<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Double getRecaudado() {
        return recaudado;
    }

    public void setRecaudado(Double recaudado) {
        this.recaudado = recaudado;
    }

    public HashSet<Beneficio> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(HashSet<Beneficio> beneficios) {
        this.beneficios = beneficios;
    }

    public HashSet<BenefAcumulables> getBenefAcumulables() {
        return benefAcumulables;
    }

    public HashSet<Producto> getProductos() {
        return productos;
    }

    public void setProductos(HashSet<Producto> productos) {
        this.productos = productos;
    }

    public void setBenefAcumulables(HashSet<BenefAcumulables> benefAcumulables) {
        this.benefAcumulables = benefAcumulables;
    }

    public int cantBenefNoAcumulables(){
        return this.beneficios.size() - this.benefAcumulables.size();
    }
}
