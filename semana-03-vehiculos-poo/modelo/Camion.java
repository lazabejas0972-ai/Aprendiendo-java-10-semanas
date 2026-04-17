package semana-03-vehiculos-poo.modelo;

public class Camion extends Vehiculo {
    private double capacidadCarga;

    public Camion(String marca, String modelo, int anio, double ton) {
        super(marca, modelo, anio);
        this.capacidadCarga = ton;
    }

    @Override
    public void acelerar() {
        System.out.println(marca+" (camion, "+ capacidadCarga+ "t) acelera despacio.");
    }

    public double gitCapacidadCarga() {
        return capacidadCarga;
    }
}
