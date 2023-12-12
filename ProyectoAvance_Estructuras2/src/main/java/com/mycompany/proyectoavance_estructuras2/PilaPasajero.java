package com.mycompany.proyectoavance_estructuras2;

import Comunes.EnumEstadoViaje;

public class PilaPasajero {

    private NodoPasajero cima;
    private int cantidad;//maximo permitido
    private int tamano;//cuantos nodos se llevan

    // Encapsuladores
    public int getTamano() {
        return tamano;
    }

    public int getCantidad() {
        return cantidad;
    }

    // Constructor que reciba la cantidad maxima de 
    // Nodos de las pilas ( es decir la cantidad maxima de pasajeros ). 
    public PilaPasajero(int cantidad) {
        cima = null;
        this.cantidad = cantidad;
        tamano = 0;
    }

    public Pasajero getCima() {
        return cima.getElemento();
    }

// Comprube si la pila esta vacia
    public boolean esVacia() {
        if (cima == null) {
            return true;
        } else {
            return false;
        }
    } //Final del esVacia

    public boolean apilar(Pasajero p) { // Se apilan los pasjeros en las pilas
        if (tamano >= cantidad) {
            return false;
        } else {
            p.setEstadoViaje(EnumEstadoViaje.En_Camino);
            // ingresa y por lo tanto esta en camino
            NodoPasajero nuevo = new NodoPasajero(p);
            nuevo.setSiguiente(cima);
            cima = nuevo;
            // Se va contando la cantidad de pasajeros 
            //para compararlos con la cantidad maxima del constructor
            tamano++;

            return true;
        }
    }

    public Pasajero desapilar() {

        if (!esVacia()) { // Se desapila

            Pasajero desapilado = cima.getElemento();
            desapilado.setEstadoViaje(EnumEstadoViaje.Completado);
            // Completo el viaje
            cima = cima.getSiguiente();
            tamano--; // Se quita de la cuenta. 
            return desapilado;

        } else {
            return null;

        }

    } //Final del metodo desapilar 

    // Se imprimira lo que contiene las filas del metodo imprimirPilaPasajero.
    public String imprimirPilaPasajero() {
        String respuesta = "";
        if (!esVacia()) {
            NodoPasajero temp = cima;
            while (temp != null) {
//Esto quiere decir que si la cima no es nula, hay elemento y por lo tanto los va a imprimir.

                respuesta += Integer.toString(temp.getElemento().getId())
                        + " - " + temp.getElemento().getNombreCompleto()
                        + " - " + Integer.toString(temp.getElemento().getEdad())
                        + " - " + temp.getElemento().getDiscapacidad()
                        + " - " + temp.getElemento().getOrigen()
                        + " - " + temp.getElemento().getDestino() + "\n";

                temp = temp.getSiguiente();

            } //Final del while 

        } //Final del if 1 
        else {
            respuesta = "La fila esta vacia. ";
        } //Final del else 1
        return respuesta;

    } //Final del metodo imprimir pila

}
