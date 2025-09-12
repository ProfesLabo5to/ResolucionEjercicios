import java.util.HashMap;
import java.util.HashSet;

public class Sistema {
    private HashSet<Bar> bares;
    private HashSet<Diana> dianas;
    private HashSet<Beneficio> beneficios;

    public Sistema(HashSet<Bar> bares, HashSet<Diana> dianas, HashSet<Beneficio> beneficios) {
        this.bares = bares;
        this.dianas = dianas;
        this.beneficios = beneficios;
    }

    public HashSet<Bar> getBares() {
        return bares;
    }

    public void setBares(HashSet<Bar> bares) {
        this.bares = bares;
    }

    public HashSet<Diana> getDianas() {
        return dianas;
    }

    public void setDianas(HashSet<Diana> dianas) {
        this.dianas = dianas;
    }

    public HashSet<Beneficio> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(HashSet<Beneficio> beneficios) {
        this.beneficios = beneficios;
    }

    // calculo area de diana en la clase diana
    // calculo cantidad beneficios trago en la clase bar

    public boolean mayorA(Diana mayor, Diana d){
        if(mayor == null || d.cantPuntajes() > mayor.cantPuntajes()) return true;
        return false;
    }

    public Diana cantPuntajesDistintos(){
        Diana mayor = null;
        for(Diana d : this.dianas){
            if(mayorA(mayor, d)){
                mayor = d;
            }
        }
        return mayor;
    }

    public static void main(String[] args) {
        // Crear creadores
        Creador creador1 = new Creador("Juan", "Pérez");
        Creador creador2 = new Creador("María", "Gómez");



        // Crear HashMap de puntajes para las dianas
        HashMap<Integer, FranjaColor> puntajesDiana1 = new HashMap<>();
        puntajesDiana1.put(10, FranjaColor.ROJO);
        puntajesDiana1.put(8, FranjaColor.AMARILLO);
        puntajesDiana1.put(5, FranjaColor.VERDE);

        HashMap<Integer, FranjaColor> puntajesDiana2 = new HashMap<>();
        puntajesDiana2.put(15, FranjaColor.ROJO);
        puntajesDiana2.put(12, FranjaColor.AMARILLO);
        puntajesDiana2.put(9, FranjaColor.VERDE);
        puntajesDiana2.put(6, FranjaColor.BLANCO);
        puntajesDiana2.put(3, FranjaColor.NEGRO);

        HashMap<Integer, FranjaColor> puntajesDiana3 = new HashMap<>();
        puntajesDiana3.put(20, FranjaColor.ROJO);
        puntajesDiana3.put(15, FranjaColor.AMARILLO);

        // Crear diferentes tipos de dianas
        Circular dianaCircular = new Circular("Diana Redonda", Dificultad.INTERMEDIO, puntajesDiana1, 5.0);
        Rectangular dianaRectangular = new Rectangular("Diana Rectangular", Dificultad.DIFICIL, puntajesDiana2, 8.0, 6.0);
        Cuadrada dianaCuadrada = new Cuadrada("Diana Cuadrada", Dificultad.FACIL, puntajesDiana3, 7.0);

        // Crear conjunto de dianas para el sistema
        HashSet<Diana> dianasSistema = new HashSet<>();
        dianasSistema.add(dianaCircular);
        dianasSistema.add(dianaRectangular);
        dianasSistema.add(dianaCuadrada);

        // Crear beneficios
        HashSet<Producto> tragos1 = new HashSet<>();
        tragos1.add(new Producto("Ron",10000));
        tragos1.add(new Producto("Smir",8700));
        BeneficioTrago beneficioTrago1 = new BeneficioTrago("Happy Hour", creador1, tragos1);

        HashSet<Producto> tragos2 = new HashSet<>();
        tragos2.add(new Producto("Whis",4560));
        tragos2.add(new Producto("Caipi",8890));
        BeneficioTrago beneficioTrago2 = new BeneficioTrago("Noche de Tragos", creador2, tragos2);

        HashSet<Producto> comidas = new HashSet<>();
        comidas.add(new Producto("Hamburguesa",16000));
        comidas.add(new Producto("Papas fritas",4000));
        BeneficioComida beneficioComida = new BeneficioComida("Menú Especial", creador1, comidas);

        HashSet<Producto> gaseosas = new HashSet<>();
        gaseosas.add(new Producto("Coca-Cola",4000));
        gaseosas.add(new Producto("Sprite",3800));
        BeneficioGaseosa beneficioGaseosa = new BeneficioGaseosa("Refresco Gratis", creador2, gaseosas);

        // Crear conjunto de beneficios para el bar
        HashSet<Beneficio> beneficiosBar = new HashSet<>();
        beneficiosBar.add(beneficioTrago1);
        beneficiosBar.add(beneficioTrago2);
        beneficiosBar.add(beneficioComida);
        beneficiosBar.add(beneficioGaseosa);

        // Crear conjunto de beneficios acumulables
        HashSet<BenefAcumulables> benefAcumulables = new HashSet<>();
        benefAcumulables.add(beneficioComida);
        benefAcumulables.add(beneficioGaseosa);

        // Crear clientes
        HashSet<Cliente> clientes = new HashSet<>();
        clientes.add(new Cliente("Carlos", "López"));
        clientes.add(new Cliente("Ana", "Martínez"));

        // Crear bar
        HashSet<Diana> dianasBar = new HashSet<>();
        dianasBar.add(dianaCircular);
        dianasBar.add(dianaCuadrada);

        HashSet<Producto> productos = new HashSet<>();
        productos.addAll(tragos1);
        productos.addAll(tragos2);
        productos.addAll(comidas);
        productos.addAll(gaseosas);

        Bar bar = new Bar(dianasBar, clientes, 50000.0, beneficiosBar, benefAcumulables, productos);

        // Crear conjunto de bares para el sistema
        HashSet<Bar> bares = new HashSet<>();
        bares.add(bar);

        // Crear sistema
        Sistema sistema = new Sistema(bares, dianasSistema, beneficiosBar);

        // Prueba 1: Calcular áreas de las dianas
        System.out.println("=== CÁLCULO DE ÁREAS DE DIANAS ===");
        System.out.println("Área Diana Circular '" + dianaCircular.getNombre() + "': " +
                String.format("%.2f", dianaCircular.calcularArea()) + " unidades cuadradas");
        System.out.println("Área Diana Rectangular '" + dianaRectangular.getNombre() + "': " +
                String.format("%.2f", dianaRectangular.calcularArea()) + " unidades cuadradas");
        System.out.println("Área Diana Cuadrada '" + dianaCuadrada.getNombre() + "': " +
                String.format("%.2f", dianaCuadrada.calcularArea()) + " unidades cuadradas");
        System.out.println();

        // Prueba 2: Contar beneficios de tragos en el bar
        System.out.println("=== BENEFICIOS DE TRAGOS EN EL BAR ===");
        int cantTragos = bar.cantBenefNoAcumulables();
        System.out.println("Cantidad de beneficios de tragos: " + cantTragos);
        System.out.println("Total de beneficios no acumulables (tragos): " + bar.cantBenefNoAcumulables());
        System.out.println();

        // Prueba 3: Encontrar la diana con más puntajes distintos
        System.out.println("=== DIANA CON MÁS PUNTAJES DISTINTOS ===");
        Diana dianaConMasPuntajes = sistema.cantPuntajesDistintos();
        if (dianaConMasPuntajes != null) {
            System.out.println("Diana con más puntajes: '" + dianaConMasPuntajes.getNombre() + "'");
            System.out.println("Cantidad de puntajes: " + dianaConMasPuntajes.cantPuntajes());
            System.out.println("Dificultad: " + dianaConMasPuntajes.getNivel());
        } else {
            System.out.println("No hay dianas en el sistema");
        }
        System.out.println();

        // Mostrar detalles de todas las dianas
        System.out.println("=== DETALLES DE TODAS LAS DIANAS ===");
        for (Diana diana : dianasSistema) {
            System.out.println(diana); // uso del método toString
        }

        //Prueba 4: mostrar precio con o sin el beneficio aplicado
        System.out.println("=== BENEFICIOS EN LOS PRODUCTOS ===");
        for (Beneficio b:bar.getBeneficios()){
            b.conocerPrecioConBeneficio();
        }
    }
}

