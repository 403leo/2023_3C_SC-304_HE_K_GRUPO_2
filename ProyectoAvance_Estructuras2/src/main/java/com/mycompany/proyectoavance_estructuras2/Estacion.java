
package com.mycompany.proyectoavance_estructuras2;

import Comunes.EnumEstacion;


public class Estacion {

    private ColaPasajero colaDiscapacitada;
    private ColaPasajero colaNoDiscapacitada;
    private EnumEstacion Estacion;

    public Estacion() {
    }

    public Estacion(ColaPasajero colaDiscapacitada, ColaPasajero colaNoDiscapacitada, EnumEstacion Estacion) {
        this.colaDiscapacitada = colaDiscapacitada;
        this.colaNoDiscapacitada = colaNoDiscapacitada;
        this.Estacion = Estacion;
    }

    public ColaPasajero getColaDiscapacitada() {
        return colaDiscapacitada;
    }

    public void setColaDiscapacitada(ColaPasajero colaDiscapacitada) {
        this.colaDiscapacitada = colaDiscapacitada;
    }

    public ColaPasajero getColaNoDiscapacitada() {
        return colaNoDiscapacitada;
    }

    public void setColaNoDiscapacitada(ColaPasajero colaNoDiscapacitada) {
        this.colaNoDiscapacitada = colaNoDiscapacitada;
    }

    public EnumEstacion getEstacion() {
        return Estacion;
    }

    public void setEstacion(EnumEstacion Estacion) {
        this.Estacion = Estacion;
    }

    @Override
    public String toString() {
        return "Estacion: " + Estacion + "\n" + "Fila NO preferencial : \n"
                + colaNoDiscapacitada.imprimirColaPasajero() + "\n" + "Fila preferencial : \n"
                + colaDiscapacitada.imprimirColaPasajero() + "\n";
    }

}
