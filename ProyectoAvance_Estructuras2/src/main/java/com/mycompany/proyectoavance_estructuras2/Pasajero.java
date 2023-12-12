package com.mycompany.proyectoavance_estructuras2;

import Comunes.*;

public class Pasajero {

    
    // Se definen todos los atributos necesarios del pasajero
    private String nombreCompleto;
    private int edad;
    private EnumEstacion origen;
    private EnumEstacion destino;
    private EnumDiscapacidad discapacidad;
    private int id;
    private EnumEstadoViaje estadoViaje;

    
    // Se crea un constructor vacio. 
    public Pasajero() {
    }
    //  Se crea un constructor con todos los datos del usuario a ingresar
    public Pasajero(String nombreCompleto, int edad, EnumEstacion origen, EnumEstacion destino, EnumDiscapacidad discapacidad, EnumEstadoViaje estadoViaje, int id) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.origen = origen;
        this.destino = destino;
        this.discapacidad = discapacidad;
        this.id = id;
        this.estadoViaje = estadoViaje;
    }
    // Encapsuladores
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public EnumEstacion getOrigen() {
        return origen;
    }

    public void setOrigen(EnumEstacion origen) {
        this.origen = origen;
    }

    public EnumEstacion getDestino() {
        return destino;
    }

    public void setDestino(EnumEstacion destino) {
        this.destino = destino;
    }

    public EnumDiscapacidad getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(EnumDiscapacidad discapacidad) {
        this.discapacidad = discapacidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EnumEstadoViaje getEstadoViaje() {
        return estadoViaje;
    }

    public void setEstadoViaje(EnumEstadoViaje estadoViaje) {
        this.estadoViaje = estadoViaje;
    }



}
