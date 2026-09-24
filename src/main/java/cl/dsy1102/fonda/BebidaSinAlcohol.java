package cl.dsy1102.fonda;

public abstract class BebidaSinAlcohol extends Bebida {
    private int azucarPorLitro;
    public  BebidaSinAlcohol(String nombre, int volumenML, int stock, int azucarPorLitro){
        super(nombre, volumenML, stock);
        setAzucarPorLitro(azucarPorLitro);
    }
    public void setAzucarPorLitro(int azucarPorLitro){
        this.azucarPorLitro = azucarPorLitro;

    }
    public int getAzucarPorLitro(){
        return azucarPorLitro;
    }
    @Override
    public double calcularPrecio(){
        double precio = 2000;
        if(azucarPorLitro > 80)
         precio = precio * 1.1;
        return precio;
    }
    @Override
    public String obtenerDetalle(){
        return "Tipo: Bebida sin alcohol" + " | Nombre: " + getNombre() + " | Volumen: " + getVolumenML() + " ml" + " | Stock: " + getStock() +  " | Precio: $" + (int) calcularPrecio() + " | Azucar: " + azucarPorLitro;

    }


}
