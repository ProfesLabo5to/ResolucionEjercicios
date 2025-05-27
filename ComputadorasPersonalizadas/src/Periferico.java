import java.util.ArrayList;

public class Periferico extends Componente{
   private ArrayList<String> puertos;
   public Periferico(String fabricante, String modelo, double precioBase, int stock
                      ,ArrayList<String> puertos) {
      super(fabricante, modelo, precioBase, stock);
      this.puertos = puertos;
   }
   public Periferico() {
      super();
      this.puertos = new ArrayList<>();
   }

   public ArrayList<String> getPuertos() {
      return puertos;
   }

   public void setPuertos(ArrayList<String> puertos) {
      this.puertos = puertos;
   }
}
