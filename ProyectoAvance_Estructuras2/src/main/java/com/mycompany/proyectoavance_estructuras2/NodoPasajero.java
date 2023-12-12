
package com.mycompany.proyectoavance_estructuras2;


public class NodoPasajero {
    private Pasajero elemento; // Atributo que contendra todos los elementos de la clase elemento 
    private NodoPasajero siguiente;

    public NodoPasajero(Pasajero p) { // Representa los nodos acumulados en las pilas de pasajeros. 
        this.elemento = p;
        this.siguiente = null;
    }
    // Encapsuladores
    public Pasajero getElemento() {
        return elemento;
    }

    public void setElemento(Pasajero elemento) {
        this.elemento = elemento;
    }

    public NodoPasajero getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPasajero siguiente) {
        this.siguiente = siguiente;
    }

}
