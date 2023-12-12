package com.mycompany.proyectoavance_estructuras2;

public class Vagon {

    // Se definen las tres filas del vagon 
    public PilaPasajero Fila1; // Fila 1 
    public PilaPasajero Fila2; // Fila 2 
    public PilaPasajero Discapacitados; // Fila 3 de discapacitados
    public Estacion estacionActual; // Estacion actual. 

    // Encapsuladores
    public PilaPasajero getFila1() {
        return Fila1;
    }

    public void setFila1(PilaPasajero Fila1) {
        this.Fila1 = Fila1;
    }

    public PilaPasajero getFila2() {
        return Fila2;
    }

    public void setFila2(PilaPasajero Fila2) {
        this.Fila2 = Fila2;
    }

    public PilaPasajero getDiscapacitados() {
        return Discapacitados;
    }

    public void setDiscapacitados(PilaPasajero Discapacitados) {
        this.Discapacitados = Discapacitados;
    }

    // Constructor vacio que recibe la cantidad maxima de pasajeros por pilas
    public Vagon() {
        this.Fila1 = new PilaPasajero(3);
        this.Fila2 = new PilaPasajero(3);
        this.Discapacitados = new PilaPasajero(2);
    }

    // Constructor que recibe las filas. 
    public Vagon(PilaPasajero Fila1, PilaPasajero Fila2, PilaPasajero Discapacitados) {
        this.Fila1 = Fila1;
        this.Fila2 = Fila2;
        this.Discapacitados = Discapacitados;
    }

}
