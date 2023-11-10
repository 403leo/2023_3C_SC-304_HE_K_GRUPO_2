package proyectoavance1_grupo2;

public class PasajeroDoble {

    private String nombreCompleto;
    private int id;

    public PasajeroDoble() {
    }

    public PasajeroDoble(String nombreCompleto, int id) {
        this.nombreCompleto = nombreCompleto;
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.nombreCompleto + " - ";
    }

} // Final de la clase Pasajero Doble
