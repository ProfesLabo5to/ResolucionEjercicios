package prestamos;
import java.time.LocalDate;

public abstract class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String direccion;
    private LocalDate fNacimiento;
    private String pais;
    private Long DNI;
    private Long telefono;
    private String mail;
    private String codPostal;

    public Persona(){
        this.nombre = "Pepito";
        this.apellido = "Sanchez";
        this.edad = 22;
        this.direccion = "El poli";
    }

    public Persona(String nombre, String apellido, int edad, String direccion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
    }

    public Persona(String nombre, String apellido, LocalDate fNacimiento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.fNacimiento = fNacimiento;
    }

    public Persona(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona(String nombre, String apellido, Long DNI, String pais, Long telefono){
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.pais = pais;
        this.telefono = telefono;
    }

    public Persona(String nombre, String apellido, Long DNI){
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
    }

    public Persona(String nombre, String apellido, String direccion, LocalDate fNacimiento, String codPostal){
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.fNacimiento = fNacimiento;
        this.codPostal = codPostal;
    }

    public Persona(Long DNI, String nombre, String apellido, String mail) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
    }

    public Persona(String nombre, LocalDate fNacimiento) {
        this.nombre = nombre;
        this.fNacimiento = fNacimiento;
    }

    public Persona(String nombre, LocalDate fNacimiento, Long DNI){
        this.nombre = nombre;
        this.fNacimiento = fNacimiento;
        this.DNI = DNI;
    }

    public Persona(String nombre, LocalDate fNacimiento, Long DNI, String mail) {
        this.nombre = nombre;
        this.fNacimiento = fNacimiento;
        this.DNI = DNI;
        this.mail = mail;
    }

    public Persona(String nombre, String apellido, Long DNI, LocalDate fNacimiento, String direccion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.fNacimiento = fNacimiento;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(LocalDate fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Long getDNI() {
        return DNI;
    }

    public void setDNI(Long DNI) {
        this.DNI = DNI;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public void mostrarTodo(){
        System.out.println("El nombre es: " + this.nombre);
        System.out.println("La edad es: " + this.edad);
        System.out.println("La direccion es: " + this.direccion);
    }

    public void mostrarNombreApellido(){
        System.out.println("El nombre es: " + this.nombre);
        System.out.println("El apellido es: " + this.apellido);
    }

    public boolean mayorEdad() {
        return this.edad > 18;
    }
}
