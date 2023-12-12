package com.mycompany.proyectoavance_estructuras2;

public class ListaDobleCircular {

    public NodoEstacion cabeza; // Cabeza de la lista doble que recibe estaciones. 
    private NodoEstacion ultimo; // Ultimo de la lista doble que recibe estaciones. 

    public ListaDobleCircular() { // Constructor con los datos vacios
        cabeza = null;
        ultimo = null;
    }

    public Boolean esVacio() { // Compruba si la lista esta vacia. 
        if (cabeza == null) {
            return true;
        } else {
            return false;
        }
    }
  
    public void InsertarFilnal(Estacion e) { // Metodo que recibe las estaciones de todas las provincias para poder crearlas. 
        NodoEstacion nuevoNodo = new NodoEstacion(e);
        if (esVacio()) { // si no existe se asignara como que no hay 
            nuevoNodo.anterior = nuevoNodo;
            nuevoNodo.siguiente = nuevoNodo;
            cabeza = nuevoNodo;
        } else { // En caso de que no hay la agregara.
            ultimo = cabeza.anterior;
            nuevoNodo.anterior = ultimo;
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            ultimo.siguiente = nuevoNodo;
        }
    }


} // Final de la clase Listas Dobles Circulares.
