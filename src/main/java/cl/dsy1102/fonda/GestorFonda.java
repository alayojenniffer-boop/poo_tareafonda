package cl.dsy1102.fonda;

import java.util.ArrayList;
import java.util.List;

public class GestorFonda {
    private final List<Bebida> bebidas;

    public GestorFonda() {
        this.bebidas = new ArrayList<>();
    }

    public void registrar(Bebida bebida) {
        bebidas.add(bebida);
        System.out.println(bebida.getNombre() + " (" + bebida.getClass().getSimpleName() + ") registrada correctamente.");
    }

    public List<Bebida> buscarPorNombre(String nombre) {
        List<Bebida> resultado = new ArrayList<>();
        for (Bebida b : bebidas) {
            if (b.getNombre().equalsIgnoreCase(nombre)) {
                resultado.add(b);
            }
        }
        return resultado;
    }

    public List<Bebida> obtenerTodas() {
        return bebidas;
    }

    public void vender(String nombre, int unidades) {
        for (Bebida b : bebidas) {
            if (b.getNombre().equalsIgnoreCase(nombre)) {
                if (b instanceof ConsumoResponsable) {
                    ConsumoResponsable cr = (ConsumoResponsable) b;
                    if (cr.tieneVentaRestringida()) {
                        System.out.println("Venta rechazada: " + nombre + " tiene la venta restringida.");
                        return;
                    }
                    if (cr.superaLimite(unidades)) {
                        System.out.println("Venta rechazada: " + unidades + " unidades de " + nombre + " superan el limite de 3 por cliente.");
                        return;
                    }
                }
                double total = unidades * b.calcularPrecio();
                System.out.println("Venta autorizada: " + unidades + " x " + nombre + " | Total: $" + (int) total);
                return;
            }
        }
    }
}