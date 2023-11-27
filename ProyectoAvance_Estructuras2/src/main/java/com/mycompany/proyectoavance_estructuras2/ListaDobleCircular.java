
package com.mycompany.proyectoavance_estructuras2;


public class ListaDobleCircular {

    NodoEstacion cabeza;
    private NodoEstacion ultimo;

    public ListaDobleCircular() {
        cabeza = null;
        ultimo = null;
    }

    
    
    public Boolean esVacio() {
        if (cabeza == null) {
            return true;
        } else {
            return false;
        }
    }

    public void InsertarInicio(Estacion e) {
        NodoEstacion nuevoNodo = new NodoEstacion(e);
        if (esVacio()) {
            nuevoNodo.anterior = nuevoNodo;
            nuevoNodo.siguiente = nuevoNodo;
            cabeza = nuevoNodo;
        } else {
            ultimo = cabeza.anterior;
            nuevoNodo.anterior = ultimo;
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            ultimo.siguiente = nuevoNodo;
            cabeza = nuevoNodo;
        }
    }

    public void InsertarFilnal(Estacion e) {
        NodoEstacion nuevoNodo = new NodoEstacion(e);
        if (esVacio()) {
            nuevoNodo.anterior = nuevoNodo;
            nuevoNodo.siguiente = nuevoNodo;
            cabeza = nuevoNodo;
        } else {
            ultimo = cabeza.anterior;
            nuevoNodo.anterior = ultimo;
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            ultimo.siguiente = nuevoNodo;
        }
    }

    public void EliminarInicio() {
        if (esVacio()) {
            if (cabeza == ultimo) {
                cabeza = null;
            } else {
                cabeza = cabeza.siguiente;
                cabeza.anterior = ultimo;
                ultimo.siguiente = cabeza;
            }
        }
    }

    public void EliminarUltimo() {
        if (esVacio()) {
            if (cabeza == ultimo) {
                cabeza = null;
            } else {
                NodoEstacion nuevoUltimo= ultimo.anterior;
                nuevoUltimo.siguiente=cabeza;
                cabeza.anterior=nuevoUltimo;
            }
        }
    }

} // Final de la clase Listas Dobles Circulares.
