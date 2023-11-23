
package proyectoavance1_grupo2;


public class Cola {
    private NodoCola Frente;
    private NodoCola ultimo;

    public Cola() {
    }

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
    
    public void hacerFila(NodoCola elemento) {
        if (Frente == null) // La fila está vacía
        {
            Frente = elemento; //Se asigna al nuevo dato ( el del usuario ).
            Frente = elemento;
        } else {
            //12        ->          13
            ultimo.setAtras(elemento); // Si la cola es de tres, el que se agrega se vuelve 4 (osea ahora seria el ultimo)
            //y el siguiente que este es nulo
            ultimo = elemento;

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
    
} // Final de la clase Cola
