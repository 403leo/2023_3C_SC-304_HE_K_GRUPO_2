package proyectoavance1_grupo2;

public class NodoCircularesDobles {

    private Pila pasajero;
    
    private NodoCircularesDobles anterior;
    private NodoCircularesDobles siguiente;

    

    public NodoCircularesDobles(Pila pasajero) {
        this.pasajero = pasajero;
    }

    public Pila getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pila pasajero) {
        this.pasajero = pasajero;
    }

    public NodoCircularesDobles getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoCircularesDobles anterior) {
        this.anterior = anterior;
    }

    public NodoCircularesDobles getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCircularesDobles siguiente) {
        this.siguiente = siguiente;
    }

    

    @Override
    public String toString() {
        return pasajero.toString();
    }

} // Final de la clase Nodo circulares dobles
