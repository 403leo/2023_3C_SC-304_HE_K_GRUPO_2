
package proyectoavance1_grupo2;

public class NodoPila {
    private Pasajero elemento;
    private NodoPila siguiente;

    public NodoPila() {
        this.siguiente = null;
    }

    public Pasajero getElemento() {
        return elemento;
    }

    public void setElemento(Pasajero elemento) {
        this.elemento = elemento;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
    
} // Final de la clase NodoPila
