package modelo;


public class Auto extends Vehiculo {
    private int numeroPuertas;
    public Auto(String marca, String modelo, int anio, int Puertas) {
        super(marca, modelo, anio);
        this.numeroPuertas = Puertas;
    }

    @Override
    public void acelerar() {
        System.out.println("El auto " + getInfo() + " está acelerando.");
    }

    public int numeroPuertas() {
        return numeroPuertas;
    }
}
