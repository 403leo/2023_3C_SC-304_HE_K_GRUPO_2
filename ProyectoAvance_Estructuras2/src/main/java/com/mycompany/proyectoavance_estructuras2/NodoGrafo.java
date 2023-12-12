package com.mycompany.proyectoavance_estructuras2;

public class NodoGrafo {

    // Identificador del nodo
    public int id;

    // Nos dice si el nodo ha sido visitado en algun recorrido
    public boolean visitado;

    // Arreglos para almacenar informacion de las aristas salientes desde este nodo
    public int[] aristas;      
    public int[] distancias;   
    public int[] tiempos;      

    // Inicia un nodo con un identificador y la cantidad maxima de aristas permitidas
    public NodoGrafo(int id, int cantidadMaximaAristas) {
        this.id = id;
        visitado = false;
        aristas = new int[cantidadMaximaAristas];
        distancias = new int[cantidadMaximaAristas];
        tiempos = new int[cantidadMaximaAristas];
    }

    // Metodo para agregar una arista al nodo
    public void agregarArista(int nodoDestino, int peso, int tiempo) {
        // Encontrar el primer indice disponible en las aristas
        int indice = 0;
        while (aristas[indice] != 0) {
            indice++;
        }

        // Asigna el nodo destino, el peso y el tiempo a las aristas correspondientes
        aristas[indice] = nodoDestino;
        distancias[indice] = peso;
        tiempos[indice] = tiempo;
    }
}
//Fin de la clase NodoGrafo