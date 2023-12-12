package com.mycompany.proyectoavance_estructuras2;

import Comunes.EnumEstacion;

public class Estacion {

    // Colas de pasajeros de la estacion
    private ColaPasajero colaDiscapacitada;
    private ColaPasajero colaNoDiscapacitada;

    // Tipo de estacion.
    private EnumEstacion Estacion;

    
    public Estacion() {
    }

    // Constructor que inicia una estacion con colas de pasajeros 
    public Estacion(ColaPasajero colaDiscapacitada, ColaPasajero colaNoDiscapacitada, EnumEstacion Estacion) {
        this.colaDiscapacitada = colaDiscapacitada;
        this.colaNoDiscapacitada = colaNoDiscapacitada;
        this.Estacion = Estacion;
    }

    // Metodos para acceder y modificar las colas 

    // Metodo para obtener la cola de pasajeros discapacitados
    public ColaPasajero getColaDiscapacitada() {
        return colaDiscapacitada;
    }

    // Metodo para establecer la cola de pasajeros discapacitados
    public void setColaDiscapacitada(ColaPasajero colaDiscapacitada) {
        this.colaDiscapacitada = colaDiscapacitada;
    }

    // Metodo para obtener la cola de pasajeros no discapacitados
    public ColaPasajero getColaNoDiscapacitada() {
        return colaNoDiscapacitada;
    }

    // Metodo para establecer la cola de pasajeros no discapacitados
    public void setColaNoDiscapacitada(ColaPasajero colaNoDiscapacitada) {
        this.colaNoDiscapacitada = colaNoDiscapacitada;
    }

    // Metodo para obtener el tipo de estacion
    public EnumEstacion getEstacion() {
        return Estacion;
    }

    // Metodo para establecer el tipo de estacion
    public void setEstacion(EnumEstacion Estacion) {
        this.Estacion = Estacion;
    }

    // Metodo para obtener una representación en cadena de la estacion
    @Override
    public String toString() {
        return "Estacion: " + Estacion + "\n" + "Fila NO preferencial : \n"
                + colaNoDiscapacitada.imprimirColaPasajero() + "\n" + "Fila preferencial : \n"
                + colaDiscapacitada.imprimirColaPasajero() + "\n";
    }

}//Fin de la clase Estacion