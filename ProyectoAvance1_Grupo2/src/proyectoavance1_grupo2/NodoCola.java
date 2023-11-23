
package proyectoavance1_grupo2;

public class NodoCola {
    
    private String Pasajero;
    private NodoCola atras;

    public NodoCola() {
        this.atras = null;
    }

    public NodoCola(String Pasajero) {
        this.Pasajero = Pasajero;
    }

    
    
    public String getPasajero() {
        return Pasajero;
    }

    public void setPasajero(String Pasajero) {
        this.Pasajero = Pasajero;
    }

    public NodoCola getAtras() {
        return atras;
    }

    public void setAtras(NodoCola atras) {
        this.atras = atras;
    }
    
    @Override
    public String toString() {
        return this.Pasajero; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
} // Final de la clase NodoCola
