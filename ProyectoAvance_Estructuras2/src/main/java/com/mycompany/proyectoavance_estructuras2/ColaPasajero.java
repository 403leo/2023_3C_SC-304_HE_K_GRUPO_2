package com.mycompany.proyectoavance_estructuras2;


public class ColaPasajero {

    //Atributos de la clase 
    private NodoPasajero Frente;
    private NodoPasajero ultimo;
    private int tamano;//cuantos llevamos

    //Constructor que empieza vacio
    public ColaPasajero() { // todo empieza vacio
        Frente = null;
        ultimo = null;
        tamano = 0;
    }

    //Getters de la clase
    public NodoPasajero getFrente() {
        return Frente;
    }

    public NodoPasajero getUltimo() {
        return ultimo;
    }

    //Metodo que se encarga
public void encolar(Pasajero p) {
    // Se crea un nuevo nodo con el pasajero recibido como parámetro
    NodoPasajero nuevoNodo = new NodoPasajero(p);
    
    // Verifica si la cola está vacía
    if (esVacia()) {
        // Si la cola está vacía, el nuevo nodo se convierte en el frente de la cola
        Frente = nuevoNodo;
    } else {
        // Si la cola no está vacía, el nuevo nodo se coloca después del último nodo existente
        // El nodo "ultimo" apunta al último elemento de la cola y se enlaza con el nuevo nodo
        ultimo.setSiguiente(nuevoNodo);
    }

    // Incrementa el tamaño de la cola, ya que se ha agregado un nuevo elemento
    tamano++;
    
    // Actualiza el puntero "ultimo" para que apunte al nuevo nodo, ya que este es ahora el último elemento de la cola
    ultimo = nuevoNodo;
}

    /*Este metodo verifica si el frente de la cola apunta a null
    si es así significa que la cola está vacía*/
    public boolean esVacia() {
        return Frente == null;
    }

    public Pasajero desencolar() {
        if (esVacia()) { // Verifica si la cola está vacía
            return null;
        }
         // Guarda el pasajero del frente de la cola para devolverlo después
        Pasajero PasajeroDesencolado = Frente.getElemento();
        // Mueve el puntero "Frente" al siguiente nodo, eliminando así el primer elemento de la cola
        Frente = Frente.getSiguiente();
        // Si después de desencolar el elemento la cola queda vacía, actualiza el puntero "ultimo"
        if (Frente == null) {
            ultimo = null;
        }
        // Disminuye el tamaño de la cola, ya que se eliminó un elemento
        tamano--;
        // Devuelve el pasajero desencolado
        return PasajeroDesencolado;
    }

    //Este metodo se encargara de imprimir la cola de pasajeros
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
            respuesta = "La fila de la estacion esta vacia. ";
        } //Final del else 1
        return respuesta;

    } //Final del metodo imprimir pila

} // Final de la clase Cola