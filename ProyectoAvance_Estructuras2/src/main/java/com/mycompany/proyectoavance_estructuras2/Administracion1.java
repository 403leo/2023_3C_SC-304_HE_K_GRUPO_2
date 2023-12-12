package com.mycompany.proyectoavance_estructuras2;

//Imports de la clase
import org.ini4j.Ini;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class Administracion1 {

    //Atributos de la clase
    //El valor se inizializa en el archivo config.ini
    private int filasConDiscapacidad; // numeroFilasConDiscapacidad
    private int filasSinDiscapacidad; // numerofilasSinDiscapacidad
    private int asientosConDiscapacidad; // numeroAsientosFilaConDiscapacidad
    private int asientosSinDiscapacidad; // numeroAsientosFilaSinDiscapacidad
    private String nombreEmpresa;//Se almacena el nombre de la empresa
    private int tiempoEntreParadas;//Se establece el tiempo entre paradas
    private int costoPorKilometro;//Se establece el costo por kilometro

    //Getters de la clase
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
        
    /*En este metodo se hace el llamado del archivo config.ini
    dende van a estar todos los datos necesirios para llenar los atributos de esta clase*/
    public Administracion1() {
        try {

            //Ruta del archivo.ini
            File configFile = new File("C:\\Users\\leona\\Downloads\\Codigo grafos\\ProyectoAvance_Estructuras2 (3)\\ProyectoAvance_Estructuras2\\ProyectoAvance_Estructuras2\\ProyectoAvance_Estructuras2\\src\\main\\java\\Config.ini");
            Ini ini = new Ini(configFile);
            Ini.Section config = ini.get("Config");//Nombre con el que encuntra el archivo

            //Se agrega en valor default para luego cambierlo por el valor del archivo.ini
            this.filasConDiscapacidad = Integer.parseInt(config.getOrDefault("filasConDiscapacidad", "1"));
            filasSinDiscapacidad = Integer.parseInt(config.getOrDefault("filasSinDiscapacidad", "2"));
            asientosConDiscapacidad = Integer.parseInt(config.getOrDefault("asientosConDiscapacidad", "1"));
            asientosSinDiscapacidad = Integer.parseInt(config.getOrDefault("asientosSinDiscapacidad", "3"));
            nombreEmpresa = config.getOrDefault("nombreEmpresa", "Nombre por defecto");
            tiempoEntreParadas = Integer.parseInt(config.getOrDefault("tiempoEntreParadas", "1000"));
            costoPorKilometro = Integer.parseInt(config.getOrDefault("costoPorKilometro", "100"));

            //Por si el archivo no se encuentra sale este error y no se cae el programa
        } catch (FileNotFoundException e) {
            System.out.println("El archivo config.ini no se ha encontrado.");
            e.printStackTrace();
            //No puede leer el archivo, generalmente es por errores de escritura
        } catch (IOException e) {
            System.out.println("Error de entrada/salida al leer el archivo."); // es que esta pero no puede hacer escritura
            e.printStackTrace();
        }
    }//Fin del metodo administracion

} // Final de la clase Administracion