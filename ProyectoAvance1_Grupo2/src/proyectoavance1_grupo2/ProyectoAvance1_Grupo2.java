package proyectoavance1_grupo2;

import javax.swing.JOptionPane;

public class ProyectoAvance1_Grupo2 {

    public static void main(String[] args) {

//        Pila p = new Pila();
//
//        p.apilar(new Pasajero("Juan", 25, "San José", "San José", true, 1));
//        p.apilar(new Pasajero("Maria", 30, "Heredia", "Cartago", false, 2));
//
//        
//        p.extrae(p);
//        
//        System.out.println(p.imprimirPilaPasajero());
//        
//        
//        
//        
////        Pasajero pasajeroEliminado = p.desapilarb();
////
////        System.out.println("Pasajero eliminado: " + pasajeroEliminado);
        //MENU
        int opcion;

        Pila p = new Pila();

        do {
            opcion = mostrarMenu();

            switch (opcion) {
                //Opcion 1

                case 1:
                    int subopcion1;
                    do {
                        JOptionPane.showMessageDialog(null, "Has elegido Vagon");
                        subopcion1 = mostrarSubMenuOpcion1();

                        switch (subopcion1) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Ver informacion de los pasajeros ");
                                System.out.println(p.imprimirPilaPasajero());
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "Consultar informacion de pasajeros");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Subopción no válida. Por favor, elige nuevamente.");
                                break;
                        }
                    } while (subopcion1 != 3);
                    break;

                //Opcion 2
                case 2:
                    int subopcion2;
                    do {
                        JOptionPane.showMessageDialog(null, "Has elegido Estaciones");
                        subopcion2 = mostrarSubMenuOpcion2();

                        switch (subopcion2) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Agregar pasajeros");

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

                                if (p.extrae("Maria")) {
                                    System.out.println("El pasajero ha sido eliminado.");

                                } else {
                                    System.out.println("El pasajjero no se ha encontrado. ");

                                }

                            default:
                                JOptionPane.showMessageDialog(null, "Subopción no válida. Por favor, elige nuevamente.");
                                break;
                        }
                    } while (subopcion2 != 3);
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
