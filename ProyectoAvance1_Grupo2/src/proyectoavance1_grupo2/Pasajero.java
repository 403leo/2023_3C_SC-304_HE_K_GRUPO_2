package proyectoavance1_grupo2;

public class Pasajero {

    private String nombreCompleto;
    private int edad;
    private String origen;
    private String destino;
    private boolean discapacidad;
    private enum Estado {
        En_Cola,
        En_Camino,
        Completado
    } // Final del enum

    public Pasajero(String nombreCompleto, int edad, boolean discapacidad) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.discapacidad = discapacidad;
    }

    public Pasajero() {
        this.nombreCompleto = "";
        this.edad = 0;
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

    @Override
    public String toString() {
        return "Pasajero{" + '}';
    }
    
    

} // Final de la clase Pasajero
