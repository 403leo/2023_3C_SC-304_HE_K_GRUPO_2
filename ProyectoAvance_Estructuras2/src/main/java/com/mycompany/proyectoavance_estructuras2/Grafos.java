package com.mycompany.proyectoavance_estructuras2;

import Comunes.*;

public class Grafos {

    // Nodos del grafo
    private NodoGrafo[] nodos;

    // Cantidad de nodos en el grafo
    private int cantidadNodos;

    // Constructor que inicializa el grafo con la cantidad de nodos especificos
    public Grafos(int cantidadNodos) {
        this.cantidadNodos = cantidadNodos;
        nodos = new NodoGrafo[cantidadNodos];

        // Inicia cada nodo con la capacidad maxima de aristas
        for (int i = 0; i < cantidadNodos; i++) {
            nodos[i] = new NodoGrafo(i, cantidadNodos);
        }
    }

    // Metodo para agregar una arista entre dos nodos con peso y tiempo
    public void agregarArista(int origen, int destino, int peso, int tiempo) {
        nodos[origen].agregarArista(destino, peso, tiempo);
    }

    // Metodo que implementa el algoritmo de Dijkstra 
    // para encontrar las distancias minimas desde un nodo origen
    public int[][] dijkstra(int origen) {
        int[] distancias = new int[cantidadNodos];
        int[] tiempos = new int[cantidadNodos];
        boolean[] visitados = new boolean[cantidadNodos];

        // Inicia distancias y tiempos como infinito y visitados como falso
        for (int i = 0; i < cantidadNodos; i++) {
            distancias[i] = Integer.MAX_VALUE;
            visitados[i] = false;
        }

        // La distancia desde el nodo origen a si mismo es 0!
        distancias[origen] = 0;
        tiempos[origen] = 0;

        for (int i = 0; i < cantidadNodos - 1; i++) {
            // Obtener el nodo con la menor distancia no visitado
            int nodoActual = obtenerNodoMinimaDistancia(distancias, visitados);
            visitados[nodoActual] = true;

            // Actualiza distancias y tiempos de los nodos vecinos
            for (int j = 0; j < nodos[nodoActual].aristas.length; j++) {
                int nodoVecino = nodos[nodoActual].aristas[j];
                int pesoArista = nodos[nodoActual].distancias[j];
                int tiempoArista = nodos[nodoActual].tiempos[j];

                if (nodoVecino != 0 && !visitados[nodoVecino]
                        && distancias[nodoActual] != Integer.MAX_VALUE
                        && distancias[nodoActual] + pesoArista < distancias[nodoVecino]) {
                    distancias[nodoVecino] = distancias[nodoActual] + pesoArista;
                    tiempos[nodoVecino] = tiempos[nodoActual] + tiempoArista;
                }
            }
        }

        // Devolver las distancias y tiempos minimos
        return new int[][]{distancias, tiempos};
    }

    // Metodo privado para obtener el nodo con la minima distancia no visitado
    private int obtenerNodoMinimaDistancia(int[] distancias, boolean[] visitados) {
        int minimo = Integer.MAX_VALUE;
        int indiceMinimo = -1;

        for (int i = 0; i < cantidadNodos; i++) {
            if (!visitados[i] && distancias[i] <= minimo) {
                minimo = distancias[i];
                indiceMinimo = i;
            }
        }

        // Devolver el indice del nodo con la minima distancia
        return indiceMinimo;
    }
}
//Fin de la clase Grafos