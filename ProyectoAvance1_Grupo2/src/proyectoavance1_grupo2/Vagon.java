package proyectoavance1_grupo2;

import javax.swing.JOptionPane;

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
    
//     public boolean hacerJugada(int fila, int columna, String jugador) {
//        // Verificar que la posición especificada esté dentro de los límites de la matriz y que la celda esté vacía ("-").
//        if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && jugadores[fila][columna].equals("-")) {
//            // Si la posición es válida, actualizar la matriz con el símbolo del jugador.
//            jugadores[fila][columna] = jugador;
//            return true; // Indicar que la jugada fue exitosa.
//        } else {
//            // Si la posición no es válida, mostrar un mensaje de error y devolver false.
//            JOptionPane.showMessageDialog(null, "Movimiento inválido, intenta de nuevo.");
//            return false; // Indicar que la jugada fue inválida.
//        }
//    }

}