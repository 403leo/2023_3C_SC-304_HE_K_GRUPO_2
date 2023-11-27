
package com.mycompany.proyectoavance_estructuras2;


public class NodoPasajero {
    Pasajero elemento;
    NodoPasajero siguiente;

    public NodoPasajero(Pasajero p) {
        this.elemento = p;
        this.siguiente = null;
    }

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
