package com.mycompany.proyectoavance_estructuras2;
import org.ini4j.Ini;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Administracion1 {


    private int filasConDiscapacidad;
    private int filasSinDiscapacidad;
    private int asientosConDiscapacidad;
    private int asientosSinDiscapacidad;
    private String nombreEmpresa;
    private int tiempoEntreParadas;
    private int costoPorKilometro;
    
    public int getFilasConDiscapacidad() {
        return filasConDiscapacidad;
    }

    public int getFilasSinDiscapacidad() {
        return filasSinDiscapacidad;
    }

    public int getAsientosConDiscapacidad() {
        return asientosConDiscapacidad;
    }

    public int getAsientosSinDiscapacidad() {
        return asientosSinDiscapacidad;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public int getTiempoEntreParadas() {
        return tiempoEntreParadas;
    }

    public int getCostoPorKilometro() {
        return costoPorKilometro;
    }
    
    public Administracion1() {
        try {
            
             File configFile = new File("config.ini");
            Ini ini = new Ini(configFile);
            Ini.Section config = ini.get("Config");

            filasConDiscapacidad = Integer.parseInt(config.getOrDefault("filas_con_discapacidad", "1"));
            filasSinDiscapacidad = Integer.parseInt(config.getOrDefault("filas_sin_discapacidad", "2"));
            asientosConDiscapacidad = Integer.parseInt(config.getOrDefault("asientos_con_discapacidad", "1"));
            asientosSinDiscapacidad = Integer.parseInt(config.getOrDefault("asientos_sin_discapacidad", "3"));
            nombreEmpresa = config.getOrDefault("nombre_empresa", "Nombre por defecto");
            tiempoEntreParadas = Integer.parseInt(config.getOrDefault("tiempo_entre_paradas", "1"));
            costoPorKilometro = Integer.parseInt(config.getOrDefault("costo_por_kilometro", "100"));
            
        } catch (FileNotFoundException e) {
            System.out.println("El archivo config.ini no se ha encontrado.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error de entrada/salida al leer el archivo.");
            e.printStackTrace();
        }
    }

//    public void Kilometraje(double costoKilometraje) {
//
//    } // Final del metodo kilometraje

} // Final de la clase Administracion