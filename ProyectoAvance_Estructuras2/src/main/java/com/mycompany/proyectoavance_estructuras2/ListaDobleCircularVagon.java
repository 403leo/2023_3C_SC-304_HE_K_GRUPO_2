
package com.mycompany.proyectoavance_estructuras2;


public class ListaDobleCircularVagon {

    public NodoPilaPasajero cabeza; // Cabeza de la lista 
    private NodoPilaPasajero ultimo; // ultimo elemento de la lista

    public ListaDobleCircularVagon() { // Constructor con los datos vacios. 
        cabeza = null;
        ultimo = null;
    }

    public Boolean esVacio() { // Comprueba si la lista esta vacia. 
        if (cabeza == null) {
            return true;
        } else {
            return false;
        }
    }

    // Metodo que recibe la pila de los pasajeros ( es decir las colas de pasajeros ) y los inserta en los nodos de las listas
    // dobles circulares. Ademas, cuenta con otro parametro booleano de discapacidad para comprobar en que fila tendria que ir. 
    public void InsertarInicio(PilaPasajero e, boolean Discapacitado) {
        NodoPilaPasajero nuevoNodo = new NodoPilaPasajero(e, Discapacitado); // Crear el nodo a implementar

        if (esVacio()) {
            cabeza = nuevoNodo;
            nuevoNodo.anterior = nuevoNodo;
            nuevoNodo.siguiente = nuevoNodo;
        } else {
            ultimo = cabeza.anterior;
            nuevoNodo.anterior = ultimo;
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            ultimo.siguiente = nuevoNodo;
            cabeza = nuevoNodo;
        }
    }

} // Final de la clase Listas Dobles Circulares.
