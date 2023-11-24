package proyectoavance1_grupo2;

import javax.swing.JOptionPane;

public class ProyectoAvance1_Grupo2 {

    public static void main(String[] args) {
//                Pila p1 = new Pila();
//        p1.apilarPasajero(new Pasajero("Ale", 12, "Alajuela", "Heredia", true, 12));
//        p1.apilarPasajero(new Pasajero("leo", 21, "Alajuela", "Heredia", false, 1));
//        p1.apilarPasajero(new Pasajero("Sebas", 32, "Alajuela", "Heredia", true, 8));
//        System.out.println(p1.imprimirPilaPasajero());
//
//        Pila p2 = new Pila();
//// Agrega elementos a la pila2 si es necesario
//        p2.apilarPasajero(new Pasajero("juan", 192, "Alajuela", "Heredia", true, 100));
//        p2.apilarPasajero(new Pasajero("jose", 211, "Alajuela", "Heredia", false, 13));
//        p2.apilarPasajero(new Pasajero("gregorio", 352, "Alajuela", "Heredia", true, 87));
//        System.out.println(p2.imprimirPilaPasajero());
//        ListasDoblesCirculares l = new ListasDoblesCirculares();
//        l.insertaGPT(p1);
//        l.insertaGPT(p2);
//        l.imprimirLista();

        DataEstacion data = new DataEstacion();
        
        data.recorrerEstacionInfinitamente();
        
        
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su numero de cedula: "));
        String nombreCompleto = JOptionPane.showInputDialog("Ingrese su nombre completo: ");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad: "));
        boolean discapacidad = Boolean.parseBoolean(JOptionPane.showInputDialog("Ingrese (true | false ) su discapacidad: "));
        String origen = JOptionPane.showInputDialog("Ingrese su ubicacion actual: ");
        String destino = JOptionPane.showInputDialog("Ingrese su destino final: ");

        
        
        }
    }

//        //MENU
//        int opcion;
//
//        Cola C = new Cola();
//        Vagon vagon = new Vagon();
//        Estacion estacion = new Estacion();
//
//        do {
//            opcion = mostrarMenu();
//
//            switch (opcion) {
//                //Opcion 1
//
//                case 1:
//                    int subopcion1;
//                    do {
//                        JOptionPane.showMessageDialog(null, "Has elegido Vagon");
//                        subopcion1 = mostrarSubMenuOpcion1();
//
//                        switch (subopcion1) {
//                            case 1:
//                                JOptionPane.showMessageDialog(null, "Ver informacion de los pasajeros ");
//                                vagon.inicializarJuego();
//                                vagon.mostrarTablero();
//                                break;
//                            case 2:
//                                JOptionPane.showMessageDialog(null, "Consultar informacion de pasajeros");
//                                break;
//                            default:
//                                JOptionPane.showMessageDialog(null, "Subopción no válida. Por favor, elige nuevamente.");
//                                break;
//                        }
//                    } while (subopcion1 != 3);
//                    break;
//
//                //Opcion 2
//                case 2:
//                    int subopcion2;
//                    do {
//                        JOptionPane.showMessageDialog(null, "Has elegido Estaciones");
//                        subopcion2 = mostrarSubMenuOpcion2();
//
//                        switch (subopcion2) {
//                            case 1:
//                                JOptionPane.showMessageDialog(null, "Agregar pasajeros");
//
//                                int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su numero de cedula: "));
//                                String nombreCompleto = JOptionPane.showInputDialog("Ingrese su nombre completo: ");
//                                int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad: "));
//                                boolean discapacidad = Boolean.parseBoolean(JOptionPane.showInputDialog("Ingrese (true | false ) su discapacidad: "));
//                                String origen = JOptionPane.showInputDialog("Ingrese su ubicacion actual: ");
//                                String destino = JOptionPane.showInputDialog("Ingrese su destino final: ");
//
////                                Pasajero p1 = new Pasajero(nombreCompleto, edad, origen, destino, discapacidad, id);
//                                estacion.accederCola(new Pasajero(nombreCompleto, edad, origen, destino, discapacidad, id));
//
//                                estacion.imprimirCola();
//
//                                break;
//                            case 2:
//                                JOptionPane.showMessageDialog(null, "Eliminar pasajeros");
//                                break;
//                            case 3:
//                                JOptionPane.showMessageDialog(null, "Estacion actual: \n");
//                                estacion.imprimirColas();
//                                break;
//                            default:
//                                JOptionPane.showMessageDialog(null, "Subopción no válida. Por favor, elige nuevamente.");
//                                break;
//                        }
//                    } while (subopcion2 != 4);
//                    break;
//                //Salir del MENU
//                case 3:
//                    JOptionPane.showMessageDialog(null, "Saliendo del Menu...");
//                    break;
//                default:
//                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elige nuevamente.");
//                    break;
//            }
//
//        } while (opcion != 3);
//    }
//
//    //Se muestran las opciones del MENU
//    public static int mostrarMenu() {
//        String[] opciones = {"Vagones", "Estaciones", "Salir"};
//        int seleccion = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Menú",
//                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
//
//        // Ajustamos el índice de la opción seleccionada para que coincida con el valor del switch
//        switch (seleccion) {
//            case 0:
//                return 1;
//            case 1:
//                return 2;
//            case 2:
//                return 3;
//            default:
//                return -1; // En caso de error
//        }
//    }
//
//    //Se muestran las opciones del SUBMENU1 (Vagones)
//    public static int mostrarSubMenuOpcion1() {
//        String[] opciones = {"Ver informacion de los pasajeros", "Consultar informacion de pasajeros", "Salir"};
//        int seleccion = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Menú",
//                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
//
//        // Ajustamos el índice de la opción seleccionada para que coincida con el valor del switch
//        switch (seleccion) {
//            case 0:
//                return 1;
//            case 1:
//                return 2;
//            case 2:
//                return 3;
//            default:
//                return -1; // En caso de error
//        }
//    }
//    //Se muestran las opciones del SUBMENU2 (Estaciones)
//
//    public static int mostrarSubMenuOpcion2() {
//        String[] opciones = {" Agregar pasajeros ", " Eliminar pasajeros ", " Visualizar estacion ", " Visualizacion de los trenes "," Salir "};
//        int seleccion = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Menú",
//                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
//
//        // Ajustamos el índice de la opción seleccionada para que coincida con el valor del switch
//        switch (seleccion) {
//            case 0:
//                return 1;
//            case 1:
//                return 2;
//            case 2:
//                return 3;
//            case 3:
//                return 4;
//            case 4:
//                return 5;
//            default:
//                return -1; // En caso de error
//        }
//    }

//}// Final de la clase proyecto avance 1
