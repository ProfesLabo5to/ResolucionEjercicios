public class Producto {
    private String nombreProducto;
    private String marca;
    private int codigoBarra;
    private int precio;

    public Producto(String nombreProducto, String marca, int codigoBarra, int precio) {
        this.nombreProducto = nombreProducto;
        this.marca = marca;
        this.codigoBarra = codigoBarra;
        this.precio = precio;
    }

    public Producto(int precio) {
        this.nombreProducto = "producto prueba";
        this.precio = precio;
    }

    public Producto(String nombreProducto, int precio) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(int codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombreProducto='" + nombreProducto + '\'' +
                ", precio original=" + precio +
                '}';
    }
}
