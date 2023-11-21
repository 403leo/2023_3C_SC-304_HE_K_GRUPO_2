package proyectoavance1_grupo2;

import javax.swing.JOptionPane;

public class ProyectoAvance1_Grupo2 {

    public static void main(String[] args) {

        //MENU
        int opcion;

        do {
            opcion = mostrarMenu();

            switch (opcion) {
                //Opcion 1
                case 1:
                    JOptionPane.showMessageDialog(null, "Has elegido Vagon");
                    int subopcion1 = mostrarSubMenuOpcion1();

                    switch (subopcion1) {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Ver informacion de los pasajeros ");
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Consultar informacion de pasajeros");
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Subopción no válida. Por favor, elige nuevamente.");
                            break;
                    }
                    break;

                //Opcion 2
                case 2:
                    JOptionPane.showMessageDialog(null, "Has elegido Estaciones");
                    int subopcion2 = mostrarSubMenuOpcion2();

                    switch (subopcion2) {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Agregar pasajeros");

                            Pila p = new Pila();

                            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su numero de cedula: "));
                            String nombreCompleto = JOptionPane.showInputDialog("Ingrese su nombre completo: ");
                            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad: "));
                            boolean discapacidad = Boolean.parseBoolean(JOptionPane.showInputDialog("Ingrese (true | false ) su discapacidad: "));
                            String origen = JOptionPane.showInputDialog("Ingrese su ubicacion actual: ");
                            String destino = JOptionPane.showInputDialog("Ingrese su destino final: ");

                            Pasajero p1 = new Pasajero(nombreCompleto, edad, origen, destino, discapacidad, id);

                            p.apilar(p1);
                            System.out.println(p.imprimirPilaPasajero());
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Eliminar pasajeros");

                        default:
                            JOptionPane.showMessageDialog(null, "Subopción no válida. Por favor, elige nuevamente.");
                            break;
                    }
                    break;
                //Salir del MENU
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del Menu...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elige nuevamente.");
                    break;
            }

        } while (opcion != 3);
    }

    //Se muestran las opciones del MENU
    public static int mostrarMenu() {
        String[] opciones = {"Vagones", "Estaciones", "Salir"};
        int seleccion = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Menú",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

        // Ajustamos el índice de la opción seleccionada para que coincida con el valor del switch
        switch (seleccion) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            default:
                return -1; // En caso de error
        }
    }

    //Se muestran las opciones del SUBMENU1 (Vagones)
    public static int mostrarSubMenuOpcion1() {
        String[] opciones = {"Ver informacion de los pasajeros", "Consultar informacion de pasajeros", "Salir"};
        int seleccion = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Menú",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

        // Ajustamos el índice de la opción seleccionada para que coincida con el valor del switch
        switch (seleccion) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            default:
                return -1; // En caso de error
        }
    }
    //Se muestran las opciones del SUBMENU2 (Estaciones)

    public static int mostrarSubMenuOpcion2() {
        String[] opciones = {"Agregar pasajeros", "Eliminar pasajeros", "Salir"};
        int seleccion = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Menú",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

        // Ajustamos el índice de la opción seleccionada para que coincida con el valor del switch
        switch (seleccion) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            default:
                return -1; // En caso de error
        }
    }

} // Final de la clase proyecto avance 1
