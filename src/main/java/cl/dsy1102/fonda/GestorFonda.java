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
        System.out.println(bebida.getNombre() + " fue registrada correctamente.");
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
}