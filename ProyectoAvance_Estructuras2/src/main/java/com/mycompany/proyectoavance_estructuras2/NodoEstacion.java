
package com.mycompany.proyectoavance_estructuras2;


public class NodoEstacion {

    Estacion elemento;
    NodoEstacion siguiente;
    NodoEstacion anterior;

    public NodoEstacion(Estacion p) {
        this.elemento = p;
        this.siguiente = null;
        this.anterior = null;
    }

    public Estacion getElemento() {
        return elemento;
    }

    public void setElemento(Estacion elemento) {
        this.elemento = elemento;
    }

    public NodoEstacion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEstacion siguiente) {
        this.siguiente = siguiente;
    }

    public NodoEstacion getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoEstacion anterior) {
        this.anterior = anterior;
    }

}
