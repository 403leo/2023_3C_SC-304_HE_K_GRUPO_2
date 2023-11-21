package proyectoavance1_grupo2;

import javax.swing.JOptionPane;

public class Pasajero {

    private String nombreCompleto;
    private int edad;
    private String origen;
    private String destino;
    private boolean discapacidad;
    private int id;

    private enum Estado {
        En_Cola,
        En_Camino,
        Completado
    } // Final del enum

    public Pasajero(String nombreCompleto, int edad, String origen, String destino,boolean discapacidad, int id) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.origen = origen;
        this.destino = destino;
        this.discapacidad = discapacidad;
        this.id = id;
    }

    public Pasajero() {
        this.nombreCompleto= "";
        this.id = 0;
        this.origen = "";
        this.destino = "";
        this.discapacidad = false;

    }
    

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

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public boolean isDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pasajero{" + '}';
    }

} // Final de la clase Pasajero
