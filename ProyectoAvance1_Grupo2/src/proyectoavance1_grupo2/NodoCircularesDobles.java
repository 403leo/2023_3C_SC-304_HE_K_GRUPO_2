package proyectoavance1_grupo2;

public class NodoCircularesDobles {
    
    private Pasajero pasajero;
    private Pila pilaLista;
    private NodoCircularesDobles anterior;
    private NodoCircularesDobles siguiente;
    private DataEstacion De;
    
    
    public NodoCircularesDobles(DataEstacion De) {
        this.De = De;
    }

    // Constructor para las pilas 
    public NodoCircularesDobles(Pila pilaLista) {
        this.pilaLista = pilaLista;
    }
    
    // Contructor para las colas.

    
    
    

    public Pila getPilaLista() {
        return pilaLista;
    }

    public void setPilaLista(Pila pilaLista) {
        this.pilaLista = pilaLista;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
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

    public DataEstacion getDe() {
        return De;
    }

    public void setDe(DataEstacion De) {
        this.De = De;
    }
    
    

    @Override
    public String toString() {
        return pasajero.toString();
    }

} // Final de la clase Nodo circulares dobles
