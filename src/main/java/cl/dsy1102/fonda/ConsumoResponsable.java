package cl.dsy1102.fonda;

public interface ConsumoResponsable {
    boolean tieneVentaRestringida();
    boolean restringirVenta();
    boolean superaLimite(int unidades);


}