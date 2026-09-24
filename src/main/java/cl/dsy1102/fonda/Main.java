package cl.dsy1102.fonda;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestorFonda gestor = getGestor();

        System.out.println(); // Separador visual

        gestor.vender("Pisco Sour", 2);
        gestor.vender("Pisco Sour", 5);
        gestor.vender("Chicha", 1);
        gestor.vender("Mote con Huesillo", 6);

        System.out.println();

        System.out.println("=== BUSQUEDA POR NOMBRE: \"Chicha\" ===");
        List<Bebida> bebidasEncontradas = gestor.buscarPorNombre("Chicha");
        for (Bebida b : bebidasEncontradas) {
            System.out.println(b.obtenerDetalle());
            System.out.println("---");
        }

        System.out.println();

        System.out.println("=== LISTADO COMPLETO ===");
        for (Bebida b : gestor.obtenerTodas()) {
            System.out.println(b.toString());
        }
    }

    private static GestorFonda getGestor() {
        BebidaAlcoholica chichaAlc = new BebidaAlcoholica("Chicha", 1000, 40, 12.0, false);
        BebidaAlcoholica piscoSour = new BebidaAlcoholica("Pisco Sour", 500, 25, 18.0, true);
        BebidaSinAlcohol chichaSinAlc = new BebidaSinAlcohol("Chicha", 1000, 60, 95);
        BebidaSinAlcohol moteConHuesillo = new BebidaSinAlcohol("Mote con Huesillo", 400, 50, 70);

        chichaAlc.restringirVenta();

        GestorFonda gestor = new GestorFonda();
        gestor.registrar(chichaAlc);
        gestor.registrar(piscoSour);
        gestor.registrar(chichaSinAlc);
        gestor.registrar(moteConHuesillo);
        return gestor;
    }
}