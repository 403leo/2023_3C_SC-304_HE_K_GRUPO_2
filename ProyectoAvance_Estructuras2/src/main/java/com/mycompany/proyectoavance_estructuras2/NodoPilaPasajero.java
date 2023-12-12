
package com.mycompany.proyectoavance_estructuras2;


public class NodoPilaPasajero {

    public PilaPasajero FilaAsientos; // Almacenara la fila de los asientos
    public boolean Discapacitado; // Comprobara su discapacidad
    public NodoPilaPasajero siguiente;
    public NodoPilaPasajero anterior;

    // Constructor que almacena las pila de los pasajeros 
    // en los nodos de las listas dobles circulares del vagon. 
    public NodoPilaPasajero(PilaPasajero p, boolean d) {
        this.FilaAsientos = p;
        this.Discapacitado = d;
        this.siguiente = null;
        this.anterior = null;
    }
    // Encapsuladores 
    public PilaPasajero getElemento() {
        return FilaAsientos;
    }

    public void setElemento(PilaPasajero elemento) {
        this.FilaAsientos = elemento;
    }

    public NodoPilaPasajero getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPilaPasajero siguiente) {
        this.siguiente = siguiente;
    }

    public NodoPilaPasajero getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoPilaPasajero anterior) {
        this.anterior = anterior;
    }

}
