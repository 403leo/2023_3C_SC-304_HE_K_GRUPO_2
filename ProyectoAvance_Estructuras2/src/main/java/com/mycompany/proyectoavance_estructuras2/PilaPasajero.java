
package com.mycompany.proyectoavance_estructuras2;

import Comunes.EnumEstadoViaje;


public class PilaPasajero {

    private NodoPasajero cima;
    private int cantidad;//maximo permitido
    private int tamano;//cuantos llevamos

    public PilaPasajero(int cantidad) {
        cima = null;
        this.cantidad = cantidad;
        tamano = 0;
    }

    public Pasajero getCima() {
        return cima.elemento;
    }

    public boolean esVacia() {
        if (cima == null) {
            return true;
        } else {
            return false;
        }
    } //Final del esVacia

    public boolean apilar(Pasajero p) {
        if (tamano >= cantidad) {
            return false;
        } else {
            p.setEstadoViaje(EnumEstadoViaje.En_Camino);
            NodoPasajero nuevo = new NodoPasajero(p);
            nuevo.setSiguiente(cima);
            cima = nuevo;
            tamano++;

            return true;
        }
    }

    public Pasajero desapilar() {

        if (!esVacia()) {
            
            Pasajero desapilado = cima.getElemento();
            desapilado.setEstadoViaje(EnumEstadoViaje.Completado);
            cima = cima.getSiguiente();
            tamano--;
            return desapilado;

        } else {
            return null;

        }

    } //Final del metodo desapilar 

    //Ahora se hara un metodo para desapilar pero tomando en cuenta la clase Dato
    public String imprimirPila() {
        String respuesta = "";
        if (!esVacia()) {
            NodoPasajero temp = cima;
            while (temp != null) {//Esto quiere decir que si la cima no es nula, hay elemento y por lo tanto los va a imprimir.

                respuesta += temp.getElemento().getNombreCompleto() + "\n";

                temp = temp.getSiguiente();

            } //Final del while 

        } //Final del if 1 
        else {
            respuesta = "La pila esta vacia. ";
        } //Final del else 1
        return respuesta;

    } //Final del metodo imprimir pila

    public String imprimirPilaPasajero() {
        String respuesta = "";
        if (!esVacia()) {
            NodoPasajero temp = cima;
            while (temp != null) {//Esto quiere decir que si la cima no es nula, hay elemento y por lo tanto los va a imprimir.

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
            respuesta = "La pila esta vacia. ";
        } //Final del else 1
        return respuesta;

    } //Final del metodo imprimir pila

}
