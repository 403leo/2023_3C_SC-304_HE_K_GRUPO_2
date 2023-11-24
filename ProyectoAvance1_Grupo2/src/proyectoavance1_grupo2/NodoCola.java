package proyectoavance1_grupo2;

public class NodoCola {

    private Pasajero pasajero;
    private NodoCola atras;

    public NodoCola() {
        this.atras = null;
    }

    public NodoCola(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public NodoCola getAtras() {
        return atras;
    }

    public void setAtras(NodoCola atras) {
        this.atras = atras;
    }

    @Override
    public String toString() {
        return "Pasajero: " + pasajero;
    }
} // Final de la clase NodoCola
