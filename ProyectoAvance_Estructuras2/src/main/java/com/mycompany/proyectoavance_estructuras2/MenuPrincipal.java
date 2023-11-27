package com.mycompany.proyectoavance_estructuras2;

import javax.swing.JOptionPane;
import Comunes.EnumDiscapacidad;
import static Comunes.EnumDiscapacidad.NO;
import static Comunes.EnumDiscapacidad.SI;
import Comunes.EnumEstacion;
import Comunes.EnumEstadoViaje;

public class MenuPrincipal {

    static ListaDobleCircular Estaciones = new ListaDobleCircular();
    static Vagon vagon = new Vagon();

    public void MenuPrincipal() throws InterruptedException {

        Estaciones.InsertarFilnal(new Estacion(new ColaPasajero(), new ColaPasajero(), EnumEstacion.ALAJUELA));
        Estaciones.InsertarFilnal(new Estacion(new ColaPasajero(), new ColaPasajero(), EnumEstacion.CARTAGO));
        Estaciones.InsertarFilnal(new Estacion(new ColaPasajero(), new ColaPasajero(), EnumEstacion.HEREDIA));
        Estaciones.InsertarFilnal(new Estacion(new ColaPasajero(), new ColaPasajero(), EnumEstacion.SAN_JOSE));
        Estaciones.InsertarFilnal(new Estacion(new ColaPasajero(), new ColaPasajero(), EnumEstacion.GUANACASTE));
        Estaciones.InsertarFilnal(new Estacion(new ColaPasajero(), new ColaPasajero(), EnumEstacion.LIMON));
        Estaciones.InsertarFilnal(new Estacion(new ColaPasajero(), new ColaPasajero(), EnumEstacion.PUNTARENAS));

        NodoEstacion estacionActual = Estaciones.cabeza;
        while (true) {
            System.out.println("Estacion Actual");
            System.out.println(estacionActual.elemento);
            //JOptionPane.showMessageDialog(null, "Vagon En la estacion \"" + estacionActual.elemento.getEstacion() + "\"");
            agregarpasajeroEnEstacion(estacionActual.elemento);
            System.out.println("personas entrando a la estacion");
            System.out.println(vagon.toString());

            //JOptionPane.showMessageDialog(null, estacionActual.elemento);
            vagon.estacionActual = estacionActual.elemento;
            Thread.sleep(2000);//
            vaciarVagon(estacionActual.elemento);
            Pasajero pasajero = estacionActual.elemento.getColaNoDiscapacitada().desencolar();
            while (true) {
                if (pasajero == null) {
                    break;
                }
                if (!llenarVagon(pasajero)) {
                    estacionActual.elemento.getColaNoDiscapacitada().encolar(pasajero);
                    break;
                }
                pasajero = estacionActual.elemento.getColaNoDiscapacitada().desencolar();
            }
            pasajero = estacionActual.elemento.getColaDiscapacitada().desencolar();
            while (true) {
                if (pasajero == null) {
                    break;
                }
                if (!llenarFilaDiscapacitado(pasajero)) {
                    estacionActual.elemento.getColaDiscapacitada().encolar(pasajero);
                    break;
                }
                pasajero = estacionActual.elemento.getColaDiscapacitada().desencolar();
            }
            estacionActual = estacionActual.siguiente;

            System.out.println("personas Saliendo a la estacion");
            System.out.println(vagon.toString());

           
        }
    }

    static void vaciarVagon(Estacion destino) {
        // se bajan en la estacion correspondiente
        PilaPasajero pilaAux = new PilaPasajero(3);
        while (!vagon.getFila1().esVacia()) {
            Pasajero p = vagon.getFila1().desapilar();
            if (p.getDestino() != destino.getEstacion()) {
                pilaAux.apilar(p);
            } else {
                System.out.println("pasajero: " + p.getEstadoViaje());
            }
        }
        while (!pilaAux.esVacia()) {
            vagon.getFila1().apilar(pilaAux.desapilar());
        }
        pilaAux = new PilaPasajero(3);
        while (!vagon.getFila2().esVacia()) {
            Pasajero p = vagon.getFila2().desapilar();
            if (p.getDestino() != destino.getEstacion()) {
                pilaAux.apilar(p);
            } else {
                System.out.println("pasajero: " + p.getEstadoViaje());
            }
        }
        while (!pilaAux.esVacia()) {
            vagon.getFila2().apilar(pilaAux.desapilar());
        }
        pilaAux = new PilaPasajero(2);
        while (!vagon.getDiscapacitados().esVacia()) {
            Pasajero p = vagon.getDiscapacitados().desapilar();
            if (p.getDestino() != destino.getEstacion()) {
                pilaAux.apilar(p);
            } else {
                System.out.println("pasajero: " + p.getEstadoViaje());
            }
        }
        while (!pilaAux.esVacia()) {
            vagon.getDiscapacitados().apilar(pilaAux.desapilar());
        }
    }

    static boolean llenarVagon(Pasajero p) {
        Boolean bandera = true;
        if (vagon.getFila1().apilar(p)) {
            bandera = false;
        }
        if (bandera) {
            if (vagon.getFila2().apilar(p)) {
                bandera = false;
            }
        }
        return !bandera;
    }

    static boolean llenarFilaDiscapacitado(Pasajero p) {

        Boolean bandera = true;
        if (bandera) {
            if (vagon.getDiscapacitados().apilar(p)) {
                bandera = false;
            }
        }

        return !bandera;
    }

    static void agregarpasajeroEnEstacion(Estacion e) {
        // Ciclo para agregar pasajeros a la estación actual
        do {
            int opcionAgregarPasajero = JOptionPane.showConfirmDialog(
                    null, "¿Desea agregar un pasajero a esta estación?",
                    "Agregar Pasajero", JOptionPane.YES_NO_OPTION);

            if (opcionAgregarPasajero == JOptionPane.YES_OPTION) {
                // Capturar detalles del pasajero desde el usuario
                String nombreCompleto = JOptionPane.showInputDialog("Ingrese su nombre completo: ");
                int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad: "));

                EnumDiscapacidad[] discapacidades = EnumDiscapacidad.values();
                EnumDiscapacidad discapacidad = (EnumDiscapacidad) JOptionPane.showInputDialog(
                        null,
                        "Seleccione la discapacidad:",
                        "Seleccionar Discapacidad",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        discapacidades,
                        discapacidades[0] // Discapacidad por defecto
                );

                EnumEstacion[] estacionesDestino = EnumEstacion.values();
                EnumEstacion destino = (EnumEstacion) JOptionPane.showInputDialog(
                        null,
                        "Seleccione su estación de destino:",
                        "Seleccionar Estación",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        estacionesDestino,
                        estacionesDestino[0] // Estación por defecto
                );

                Pasajero nuevoPasajero = new Pasajero(nombreCompleto, edad, e.getEstacion(), destino, discapacidad, 1, EnumEstadoViaje.En_Cola);

                switch (discapacidad) {
                    case NO:
                        e.getColaNoDiscapacitada().encolar(nuevoPasajero);
                        break;
                    case SI:
                        e.getColaDiscapacitada().encolar(nuevoPasajero);
                        break;
                    default:
                        throw new AssertionError();
                }

                System.out.println("Pasajero agregado a la cola en la estación actual: " + e.getEstacion());
            } else {
                // Si el usuario decide no agregar más pasajeros, salir del bucle interno
                break;
            }
        } while (true);
    }

    static Estacion llenarCartago() {

        ColaPasajero cola1 = new ColaPasajero();

        cola1.encolar(new Pasajero(EnumEstacion.CARTAGO, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.CARTAGO, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.CARTAGO, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.CARTAGO, EnumEstacion.GUANACASTE, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.CARTAGO, EnumEstacion.HEREDIA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.CARTAGO, EnumEstacion.LIMON, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.CARTAGO, EnumEstacion.LIMON, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.CARTAGO, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.CARTAGO, EnumEstacion.HEREDIA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        ColaPasajero cola2 = new ColaPasajero();

        cola2.encolar(new Pasajero(EnumEstacion.CARTAGO, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.CARTAGO, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.CARTAGO, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.CARTAGO, EnumEstacion.GUANACASTE, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.CARTAGO, EnumEstacion.HEREDIA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        return new Estacion(cola2, cola1, EnumEstacion.CARTAGO);
    }

    static Estacion llenarlIMON() {

        ColaPasajero cola1 = new ColaPasajero();
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.LIMON, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO, 23, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.LIMON, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.LIMON, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.LIMON, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.LIMON, EnumEstacion.GUANACASTE, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.LIMON, EnumEstacion.HEREDIA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.LIMON, EnumEstacion.CARTAGO, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.LIMON, EnumEstacion.CARTAGO, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.LIMON, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.LIMON, EnumEstacion.HEREDIA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        ColaPasajero cola2 = new ColaPasajero();

        cola2.encolar(new Pasajero(EnumEstacion.LIMON, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.LIMON, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.LIMON, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.LIMON, EnumEstacion.GUANACASTE, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.LIMON, EnumEstacion.HEREDIA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        return new Estacion(cola2, cola1, EnumEstacion.LIMON);
    }

    static Estacion llenarAlajuela() {

        ColaPasajero cola1 = new ColaPasajero();
        cola1.encolar(new Pasajero(EnumEstacion.ALAJUELA, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.ALAJUELA, EnumEstacion.CARTAGO, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.ALAJUELA, EnumEstacion.CARTAGO, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.ALAJUELA, EnumEstacion.GUANACASTE, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.ALAJUELA, EnumEstacion.HEREDIA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.ALAJUELA, EnumEstacion.LIMON, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.ALAJUELA, EnumEstacion.LIMON, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.ALAJUELA, EnumEstacion.CARTAGO, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.ALAJUELA, EnumEstacion.HEREDIA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        ColaPasajero cola2 = new ColaPasajero();

        cola2.encolar(new Pasajero(EnumEstacion.ALAJUELA, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.ALAJUELA, EnumEstacion.CARTAGO, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.ALAJUELA, EnumEstacion.CARTAGO, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.ALAJUELA, EnumEstacion.GUANACASTE, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.ALAJUELA, EnumEstacion.HEREDIA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        return new Estacion(cola2, cola1, EnumEstacion.ALAJUELA);
    }

    static Estacion llenarHeredia() {

        ColaPasajero cola1 = new ColaPasajero();
        cola1.encolar(new Pasajero(EnumEstacion.HEREDIA, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.HEREDIA, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.HEREDIA, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.HEREDIA, EnumEstacion.GUANACASTE, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.HEREDIA, EnumEstacion.CARTAGO, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.HEREDIA, EnumEstacion.LIMON, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.HEREDIA, EnumEstacion.LIMON, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.HEREDIA, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.HEREDIA, EnumEstacion.CARTAGO, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        ColaPasajero cola2 = new ColaPasajero();

        cola2.encolar(new Pasajero(EnumEstacion.HEREDIA, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.HEREDIA, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.HEREDIA, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.HEREDIA, EnumEstacion.GUANACASTE, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.HEREDIA, EnumEstacion.CARTAGO, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        return new Estacion(cola2, cola1, EnumEstacion.HEREDIA);
    }

    static Estacion llenarSanJose() {

        ColaPasajero cola1 = new ColaPasajero();
        cola1.encolar(new Pasajero(EnumEstacion.SAN_JOSE, EnumEstacion.CARTAGO, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.SAN_JOSE, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.SAN_JOSE, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.SAN_JOSE, EnumEstacion.GUANACASTE, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.SAN_JOSE, EnumEstacion.HEREDIA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.SAN_JOSE, EnumEstacion.LIMON, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.SAN_JOSE, EnumEstacion.LIMON, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.SAN_JOSE, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.SAN_JOSE, EnumEstacion.HEREDIA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        ColaPasajero cola2 = new ColaPasajero();

        cola2.encolar(new Pasajero(EnumEstacion.SAN_JOSE, EnumEstacion.CARTAGO, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.SAN_JOSE, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.SAN_JOSE, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.SAN_JOSE, EnumEstacion.GUANACASTE, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.SAN_JOSE, EnumEstacion.HEREDIA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        return new Estacion(cola2, cola1, EnumEstacion.SAN_JOSE);
    }

    static Estacion llenarGuanacaste() {

        ColaPasajero cola1 = new ColaPasajero();
        cola1.encolar(new Pasajero(EnumEstacion.GUANACASTE, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.GUANACASTE, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.GUANACASTE, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.GUANACASTE, EnumEstacion.CARTAGO, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.GUANACASTE, EnumEstacion.HEREDIA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.GUANACASTE, EnumEstacion.LIMON, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.GUANACASTE, EnumEstacion.LIMON, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.GUANACASTE, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.GUANACASTE, EnumEstacion.HEREDIA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        ColaPasajero cola2 = new ColaPasajero();

        cola2.encolar(new Pasajero(EnumEstacion.GUANACASTE, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.GUANACASTE, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.GUANACASTE, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.GUANACASTE, EnumEstacion.CARTAGO, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.GUANACASTE, EnumEstacion.HEREDIA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        return new Estacion(cola2, cola1, EnumEstacion.GUANACASTE);
    }

    static Estacion llenarPuntarenas() {

        ColaPasajero cola1 = new ColaPasajero();
        cola1.encolar(new Pasajero(EnumEstacion.PUNTARENAS, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.PUNTARENAS, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.PUNTARENAS, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.PUNTARENAS, EnumEstacion.GUANACASTE, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.PUNTARENAS, EnumEstacion.HEREDIA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.PUNTARENAS, EnumEstacion.LIMON, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.PUNTARENAS, EnumEstacion.LIMON, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.PUNTARENAS, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        cola1.encolar(new Pasajero(EnumEstacion.PUNTARENAS, EnumEstacion.HEREDIA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola));
        ColaPasajero cola2 = new ColaPasajero();

        cola2.encolar(new Pasajero(EnumEstacion.PUNTARENAS, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.PUNTARENAS, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.PUNTARENAS, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.PUNTARENAS, EnumEstacion.GUANACASTE, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        cola2.encolar(new Pasajero(EnumEstacion.PUNTARENAS, EnumEstacion.HEREDIA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola));
        return new Estacion(cola2, cola1, EnumEstacion.PUNTARENAS);
    }

} // Final del menu principal

