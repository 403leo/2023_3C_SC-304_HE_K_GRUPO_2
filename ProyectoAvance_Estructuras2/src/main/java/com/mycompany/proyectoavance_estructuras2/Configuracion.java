package com.mycompany.proyectoavance_estructuras2;

//Imports de la clase
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Comunes.*;

public class Configuracion {

    // Atributos de la clase
    private Pasajero DatoPasajero;

    Pasajero p = new Pasajero();

    //Atributos datos de ejemplo de la clase
    private String nombreCompleto;
    private int edad;
    private EnumEstacion origen;
    private EnumEstacion destino;
    private EnumDiscapacidad discapacidad;
    private int id;
    private EnumEstadoViaje estadoViaje;

    //Constructor de la clase
    public Configuracion(String nombreCompleto, int edad, EnumEstacion origen, EnumEstacion destino, EnumDiscapacidad discapacidad, int id, EnumEstadoViaje estadoViaje) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.origen = origen;
        this.destino = destino;
        this.discapacidad = discapacidad;
        this.id = id;
        this.estadoViaje = estadoViaje;
    }

    //Este metodo se encargara de generar valores de ejemplo y ponerlos en el txt llamado Personas.txt
    public void DatosEjemplos() {

        try {
            //Nombre del archivo
            File archivo = new File("Personas.txt"); // Nombre del archivo
            Scanner scanner = new Scanner(archivo);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(", ");

                //Llenado del txt
                String nombreTxt = datos[0];
                int edadTxt = Integer.parseInt(datos[1]);
                EnumEstacion origenTxt = EnumEstacion.valueOf(datos[2]);
                EnumEstacion destinoTxt = EnumEstacion.valueOf(datos[3]);
                EnumDiscapacidad discapacidadTxt = EnumDiscapacidad.valueOf(datos[4]);
                int idTxt = Integer.parseInt(datos[5]);
                EnumEstadoViaje estadoViajeTxt = EnumEstadoViaje.valueOf(datos[6]);
                Configuracion config = new Configuracion(nombreTxt, edadTxt, origenTxt, destinoTxt, discapacidadTxt, idTxt, estadoViajeTxt);
                System.out.println(config);

            }
            scanner.close();

            //Si el archivo no se encontro sale este error
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }
    }

    // Sobrescribir el método toString() para imprimir detalles significativos del objeto
    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto + ", Edad: " + edad + ", Origen: " + origen.name()
                + ", Destino: " + destino.name() + ", Discapacidad: " + (discapacidad == EnumDiscapacidad.SI ? "SI" : "NO")
                + ", ID: " + id + ", Estado Viaje: " + estadoViaje.name();
    }

}