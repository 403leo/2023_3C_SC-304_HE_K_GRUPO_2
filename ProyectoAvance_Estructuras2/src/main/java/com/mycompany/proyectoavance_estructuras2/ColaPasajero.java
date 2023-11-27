

package com.mycompany.proyectoavance_estructuras2;


public class ColaPasajero {

    private NodoPasajero Frente;
    private NodoPasajero ultimo;
    private int tamano;//cuantos llevamos

    public ColaPasajero() {
        Frente = null;
        ultimo = null;
        tamano = 0;
    }

    public NodoPasajero getFrente() {
        return Frente;
    }

    public NodoPasajero getUltimo() {
        return ultimo;
    }

    public void encolar(Pasajero p) {
        NodoPasajero nuevoNodo = new NodoPasajero(p);
        if (esVacia()) {
            Frente = nuevoNodo;
        } else {
            ultimo.setSiguiente(nuevoNodo);
        }

        tamano++;
        ultimo = nuevoNodo;

    }

    public boolean esVacia() {
        return Frente == null;
    }

    public Pasajero desencolar() {
        if (esVacia()) {
            return null;
        }

        Pasajero PasajeroDesencolado = Frente.getElemento();
        Frente = Frente.getSiguiente();
        if (Frente == null) {
            ultimo = null;
        }
        tamano--;
        return PasajeroDesencolado;
    }

    public String imprimirCola() {
        String respuesta = ""; // En esta respuesta vamos a ir concatenando los nodos, para poder imprimirlos juntos
        NodoPasajero actual = Frente;

        while (actual != null) {
            //Podemos hacer el recorrido
            respuesta += actual.getElemento();
            actual = actual.getSiguiente();
        }
        return respuesta;
    }

    public String imprimirColaNombre() {
        String respuesta = ""; // En esta respuesta vamos a ir concatenando los nodos, para poder imprimirlos juntos
        NodoPasajero actual = Frente;

        while (actual != null) {
            //Podemos hacer el recorrido
            respuesta += actual.getElemento().getNombreCompleto() + " - ";
            actual = actual.getSiguiente();
        }

        return respuesta;
    }

    public String imprimirColaPasajero() {
        String respuesta = "";
        if (!esVacia()) {
            NodoPasajero temp = Frente;
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

} // Final de la clase Cola
