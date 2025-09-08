package Dominio;

public abstract class Ave {
    private String color;
    private String nombre;
    private String especie; // Tambien puede ser un Enum

    public Ave(String color, String nombre, String especie) {
        this.color = color;
        this.nombre = nombre;
        this.especie = especie;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}