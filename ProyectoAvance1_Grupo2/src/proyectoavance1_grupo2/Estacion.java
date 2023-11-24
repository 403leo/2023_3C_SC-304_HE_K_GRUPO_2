package proyectoavance1_grupo2;

import javax.swing.JOptionPane;

public class Estacion {

    private Cola colaDiscapacitada;
    private Cola colaNoDiscapacitada;
    

    public Cola getColaDiscapacitada() {
        return colaDiscapacitada;
    }

    public void setColaDiscapacitada(Cola colaDiscapacitada) {
        this.colaDiscapacitada = colaDiscapacitada;
    }

    public Cola getColaNoDiscapacitada() {
        return colaNoDiscapacitada;
    }

    public void setColaNoDiscapacitada(Cola colaNoDiscapacitada) {
        this.colaNoDiscapacitada = colaNoDiscapacitada;
    }

    private NodoCola Frente;
    private NodoCola ultimo;

    public NodoCola getFrente() {
        return Frente;
    }

    public void setFrente(NodoCola Frente) {
        this.Frente = Frente;
    }

    public NodoCola getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoCola ultimo) {
        this.ultimo = ultimo;
    }

    public void hacerFila(Pasajero p) {
        NodoCola nuevo = new NodoCola(p);
        if (Frente == null) // La fila está vacía
        {
            Frente = nuevo; //Se asigna al nuevo dato ( el del usuario ).
            ultimo = nuevo;
        } else {
            //12        ->          13
            ultimo.setAtras(nuevo); // Si la cola es de tres, el que se agrega se vuelve 4 (osea ahora seria el ultimo)
            //y el siguiente que este es nulo
            ultimo = nuevo;

        }
    }

    public NodoCola atender() { // Cambiarlo a tipo pasajero. 
        NodoCola actual = Frente;

        if (Frente != null) {
            Frente = Frente.getAtras(); // El elemento se va a atras de la cabeza
            actual.setAtras(null); // El elemento sacado se convertiria en nulo 
        }

        return actual;
    }

    public String imprimirCola() {
        String respuesta = ""; // En esta respuesta vamos a ir concatenando los nodos, para poder imprimirlos juntos
        NodoCola actual = Frente;

        while (actual != null) {
            //Podemos hacer el recorrido
            respuesta += actual.getPasajero() + " - ";
            actual = actual.getAtras();
        }

        return respuesta;
    }

    public String imprimirColaNombre() {
        String respuesta = ""; // En esta respuesta vamos a ir concatenando los nodos, para poder imprimirlos juntos
        NodoCola actual = Frente;

        while (actual != null) {
            //Podemos hacer el recorrido
            respuesta += actual.getPasajero().getNombreCompleto() + " - ";
            actual = actual.getAtras();
        }

        return respuesta;
    }

    public void imprimirColas() {
        
        JOptionPane.showMessageDialog(null,"Cola de pasajeros con discapacidad: \n" + (colaDiscapacitada != null ? colaDiscapacitada.imprimirCola() : "Vacia"));
        JOptionPane.showMessageDialog(null,"Cola de pasajeros sin discapacidad: \n" + (colaNoDiscapacitada != null ? colaNoDiscapacitada.imprimirCola() : "Vacia"));
        
    }

    public Cola accederCola(Pasajero p) {
        Cola colaActual;
        if (p.isDiscapacidad() == true) {
            if (colaDiscapacitada == null) {
                colaDiscapacitada = new Cola();
            }
            colaActual = colaDiscapacitada;

            
        } // Final del if 1 
        else {

            if (colaNoDiscapacitada == null) {
                colaNoDiscapacitada = new Cola();

            }
            colaActual = colaNoDiscapacitada;
        } // Final del else 1
        
        hacerFila(p, colaActual);
        return colaActual;

    } // Final del acceder Cola
    
    public void hacerFila(Pasajero p, Cola cola) {
        NodoCola nuevo = new NodoCola(p);
        if (cola.getFrente() == null) {
            cola.setFrente(nuevo);
            cola.setUltimo(nuevo);
        } else {
            cola.getUltimo().setAtras(nuevo);
            cola.setUltimo(nuevo);
        }
    }
    
    

} // Final de la clase Estacion
