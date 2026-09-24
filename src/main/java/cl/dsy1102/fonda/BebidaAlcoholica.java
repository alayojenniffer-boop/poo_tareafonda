package cl.dsy1102.fonda;

public class BebidaAlcoholica extends Bebida implements ConsumoResponsable{
    public static final int LIMITE_UNIDADES_POR_CLIENTE = 3;
    private double gradosAlcohol;
    private boolean certificada;
    private  boolean ventaRestringida;
    public  BebidaAlcoholica(String nombre, int volumenML, int stock,double gradosAlcohol, boolean certificada){
        super(nombre, volumenML, stock);
        setGradosAlcohol(gradosAlcohol);
        setCertificada(certificada);
    }
    public void setGradosAlcohol(double gradosAlcohol){
        if(gradosAlcohol < 0.5 || gradosAlcohol > 45){
            throw new IllegalArgumentException("Los grados de alcohol deben estar en el rango de 0.5 y 45 grados");
        }
        this.gradosAlcohol = gradosAlcohol;
    }
    public double getGradosAlcohol(){
        return gradosAlcohol;
    }
    public boolean isCertificada(){
        return certificada;
    }
    public void setCertificada(boolean certificada){
        this.certificada = certificada;

    }


    @Override
    public double calcularPrecio() {
        double precio = 3500;
        if(!certificada){
            precio = precio * 1.2;
        }
        return precio;
    }

    @Override
    public String obtenerDetalle() {
        return "Tipo:" + bebidaAlcoholica + "Nombre:" + getNombre() + "Volumen:" + getVolumenML() + "ml" + "Stock:" + getStock() + "Grados:" + gradosAlcohol + "Certificada" + certificada + "\n Venta restringida:" + ventaRestringida;

    }

    @Override
    public boolean tieneVentaRestringida() {
        return false;
    }

    @Override
    public boolean restringirVenta() {
        return this.certificada = certificada;

    }

    @Override
    public boolean superaLimite(int unidades) {
        return false;
    }
}
