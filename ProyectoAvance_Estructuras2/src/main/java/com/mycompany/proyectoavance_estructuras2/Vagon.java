
package com.mycompany.proyectoavance_estructuras2;


public class Vagon {

    public PilaPasajero Fila1;
    public PilaPasajero Fila2;
    public PilaPasajero Discapacitados;
    public Estacion estacionActual;

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

    public Vagon() {
        this.Fila1 = new PilaPasajero(3);
        this.Fila2 = new PilaPasajero(3);
        this.Discapacitados = new PilaPasajero(2);
    }

    public Vagon(PilaPasajero Fila1, PilaPasajero Fila2, PilaPasajero Discapacitados) {
        this.Fila1 = Fila1;
        this.Fila2 = Fila2;
        this.Discapacitados = Discapacitados;
    }

    @Override
    public String toString() {
        return "Fila1 : \n"
                + Fila1.imprimirPilaPasajero() + "\n"
                + "Fila2 : \n"
                + Fila2.imprimirPilaPasajero() + "\n"
                + "Fila preferencial : \n"
                + Discapacitados.imprimirPilaPasajero() + "\n";
    }

}
