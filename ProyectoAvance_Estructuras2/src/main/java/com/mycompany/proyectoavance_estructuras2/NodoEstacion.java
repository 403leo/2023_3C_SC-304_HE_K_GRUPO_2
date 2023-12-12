package com.mycompany.proyectoavance_estructuras2;


public class NodoEstacion {

    public Estacion elemento; // estacion de la provincia
    public NodoEstacion siguiente; // siguiente nodo en la lista
    public NodoEstacion anterior;  // anterior en la lista

    // inicializa un nodo 
    public NodoEstacion(Estacion p) {
        // Se asigna la estacion 
        this.elemento = p;
        // Se establecen los nodos siguiente y anterior como nulos
        this.siguiente = null;
        this.anterior = null;
    }

    // Metodos para acceder y modificar el elemento, el siguiente y el anterior

    // Metodo para obtener el elemento estacion del nodo.
    public Estacion getElemento() {
        return elemento;
    }

    // Metodo para establecer el elemento estación) del nodo.
    public void setElemento(Estacion elemento) {
        this.elemento = elemento;
    }

    // Metodo para obtener el siguiente nodo en la lista.
    public NodoEstacion getSiguiente() {
        return siguiente;
    }

    // Metodo para establecer el siguiente nodo en la lista.
    public void setSiguiente(NodoEstacion siguiente) {
        this.siguiente = siguiente;
    }

    // Metodo para obtener el nodo anterior en la lista.
    public NodoEstacion getAnterior() {
        return anterior;
    }

    // Metodo para establecer el nodo anterior en la lista.
    public void setAnterior(NodoEstacion anterior) {
        this.anterior = anterior;
    }

}
//Fin de la clase NodoEstacion