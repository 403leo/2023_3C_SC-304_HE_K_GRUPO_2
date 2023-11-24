package proyectoavance1_grupo2;

public class DataEstacion {

    private int cantidadPasajero = 10;
    private EstacionActual estacionActual;  // Corrección aquí
    private ListasDoblesCirculares CostaRica;
    private NodoCircularesDobles posicionActual;

    // Enum para representar las estaciones
    public enum EstacionActual {
        HEREDIA,
        ALAJUELA,
        LIMON,
        SAN_JOSE,
        PUNTARENAS,
        CARTAGO,
        GUANACASTE
    }

    // Constructor vacio
    public DataEstacion() {
    }

    // Constructor corregido con los parametros 
    public DataEstacion(int cantidadPasajero, EstacionActual estacionActual) {
        this.cantidadPasajero = cantidadPasajero;
        this.estacionActual = estacionActual;
    }

    public int getCantidadPasajero() {
        return cantidadPasajero;
    }

    public void setCantidadPasajero(int cantidadPasajero) {
        this.cantidadPasajero = cantidadPasajero;
    }

    public EstacionActual getEstacionActual() {
        return estacionActual;
    }

    public void setEstacionActual(EstacionActual estacionActual) {
        this.estacionActual = estacionActual;
    }

    public void anadirData() {
        CostaRica = new ListasDoblesCirculares();

        DataEstacion SanJose = new DataEstacion(12, DataEstacion.EstacionActual.SAN_JOSE);
        DataEstacion Puntarenas = new DataEstacion(12, DataEstacion.EstacionActual.PUNTARENAS);
        DataEstacion Guanacaste = new DataEstacion(12, DataEstacion.EstacionActual.GUANACASTE);
        DataEstacion Alajuela = new DataEstacion(12, DataEstacion.EstacionActual.ALAJUELA);
        DataEstacion Limon = new DataEstacion(12, DataEstacion.EstacionActual.LIMON);
        DataEstacion Cartago = new DataEstacion(12, DataEstacion.EstacionActual.CARTAGO);
        DataEstacion Heredia = new DataEstacion(12, DataEstacion.EstacionActual.HEREDIA);

        CostaRica.agregarAlFinal(SanJose);
        CostaRica.agregarAlFinal(Puntarenas);
        CostaRica.agregarAlFinal(Guanacaste);
        CostaRica.agregarAlFinal(Alajuela);
        CostaRica.agregarAlFinal(Limon);
        CostaRica.agregarAlFinal(Cartago);
        CostaRica.agregarAlFinal(Heredia);

        CostaRica.imprimirLista1();

    } // Final del metodo recorrer estacion

//    public void recorrerEstacion() {
//        CostaRica = new ListasDoblesCirculares();
//        anadirData();
//        // ... (tu código existente para agregar estaciones)
//        // Inicializamos la posición actual en la primera estación
//        posicionActual = CostaRica.getCabeza();
//
//        // Simulamos el recorrido de estación en estación
//        for (int i = 0; i < CostaRica.getTamanio(); i++) {
//            System.out.println("Estación Actual: " + posicionActual.getData().getEstacionActual());
//            System.out.println("Pasajeros en la Estación: " + posicionActual.getData().getCantidadPasajero());
//            System.out.println("------------------------------------");
//
//            // Movemos a la siguiente estación
//            posicionActual = posicionActual.getSiguiente();
//        }
//    }
    public void recorrerEstacionInfinitamente() {
        CostaRica = new ListasDoblesCirculares();
        anadirData();

        // ... (tu código existente para agregar estaciones)
        // Inicializamos la posición actual en la primera estación
        posicionActual = CostaRica.getCabeza();

        // Recorremos la lista circular doble infinitamente
        while (true) {
            System.out.println("Estacion Actual: " + posicionActual.getDe().getEstacionActual());
            System.out.println("Pasajeros en la Estacion: " + posicionActual.getDe().getCantidadPasajero());
            System.out.println("------------------------------------");

            // Movemos a la siguiente estación
            posicionActual = posicionActual.getSiguiente();
        }
    }

    
    public String[] obtenerProvinciasDisponibles() {
        EstacionActual[] estaciones = EstacionActual.values();
        String[] provincias = new String[estaciones.length];

        for (int i = 0; i < estaciones.length; i++) {
            provincias[i] = estaciones[i].toString();
        }

        return provincias;
    }
} // Final del la clase dataestacion