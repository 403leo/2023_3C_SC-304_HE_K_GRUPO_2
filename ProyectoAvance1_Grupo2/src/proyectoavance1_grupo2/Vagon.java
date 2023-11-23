package proyectoavance1_grupo2;

public class Vagon {

    public ListasDoblesCirculares discapacitados;
    public ListasDoblesCirculares NoDiscapacitados;
    private String[][] jugadores = new String[2][4]; // Matriz

    private enum estacionActual {  // Hay que utilizarlo en los metodo mios?
        HEREDIA,
        ALAJUELA,
        LIMON,
        SAN_JOSE,
        PUNTARENAS,
        CARTAGO,
        GUANACASTE
    } // Final del enum estacion actual
    
    
     public void inicializarJuego() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                jugadores[i][j] = "-"; // Se le asigna a cada espacio de la matriz, 
                //llenando la matriz con valores por defecto "-".
            }
        }
    }
    public void mostrarTablero() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(jugadores[i][j]);

                if (j < 3) {
                    System.out.print(" | "); // divide los elementos de las filas. 
                }
            }
            System.out.println();
            if (i < 1) {
                System.out.println("---------"); // Divide los elementos de las columnas. 
            }
        }
    }

}