
package com.mycompany.proyectoavance_estructuras2;

import org.ini4j.Ini;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Configuracion {
    
    // Atributos
    
    
    private Pasajero DatoPasajero;
    
    Pasajero p = new Pasajero();
    
    //Atributos datos de ejemplo
    private String nombre;
    private int edad;
    private String origen;
    private String destino;
    private boolean discapacidad;
    private int id;

    //Constructor datos de ejemplo
    public Configuracion(String nombre, int edad, String origen, String destino, boolean discapacidad, int id) {
        this.nombre = nombre;
        this.edad = edad;
        this.origen = origen;
        this.destino = destino;
        this.discapacidad = discapacidad;
        this.id = id;
    }
    
    public void DatosEjemplos(){
        
        try {
            File archivo = new File("Personas.txt"); // Nombre del archivo
            Scanner scanner = new Scanner(archivo);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(", ");
                
                String nombreTxt = datos[0];
                int edadTxt = Integer.parseInt(datos[1]);
                String origenTxt = datos[2];
                String destinoTxt = datos[3];
                boolean discapacidadTxt = datos[4].equals("SI");
                int idTxt = Integer.parseInt(datos[5]);
                
                Configuracion config = new Configuracion(nombreTxt, edadTxt, origenTxt, destinoTxt, discapacidadTxt, idTxt);
                System.out.println(config);
                
            }
            scanner.close();
                
        }catch(FileNotFoundException e){
             System.out.println("Archivo no encontrado.");
             e.printStackTrace();  
        }
    }
    
    // Sobrescribir el método toString() para imprimir detalles significativos del objeto
    @Override
    public String toString() {

        return "Nombre: " + nombre + ", Edad: " + edad + ", Origen: " + origen + ", Destino: " + destino + ", Discapacidad: " + (discapacidad ? "SI" : "NO") + ", ID: " + id;

    }//Fin de override
    
}
