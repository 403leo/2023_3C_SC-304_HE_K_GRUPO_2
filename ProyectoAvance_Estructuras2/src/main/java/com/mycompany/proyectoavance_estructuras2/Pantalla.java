package com.mycompany.proyectoavance_estructuras2;

import Comunes.EnumDiscapacidad;
import static Comunes.EnumDiscapacidad.NO;
import static Comunes.EnumDiscapacidad.SI;
import Comunes.EnumEstacion;
import Comunes.EnumEstadoViaje;
//import static com.mycompany.proyectoavance_estructuras2.MenuPrincipal.Estaciones;
//import static com.mycompany.proyectoavance_estructuras2.MenuPrincipal.vagon;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Pantalla extends javax.swing.JFrame {

    static ListaDobleCircular Estaciones = new ListaDobleCircular();
    static ListaDobleCircularVagon VagonLDC = new ListaDobleCircularVagon();
    public Thread t;
    NodoEstacion estacionActual;
    boolean Estacion = false;
    Administracion1 administracion1;
    Grafos grafo = new Grafos(7);

    public Pantalla() {
        administracion1 = new Administracion1(); // Se sacan los datos necesarios de la clase Administracion. 
        initComponents(); // inicializa los componentes de la interfaza grafica. 
        jLabel3.setText(administracion1.getNombreEmpresa());// Se establece el nnombre de le empresa. 
        Estaciones.InsertarFilnal(llenarAlajuela());//0
        Estaciones.InsertarFilnal(llenarlIMON());//1
        Estaciones.InsertarFilnal(llenarCartago());//2
        Estaciones.InsertarFilnal(llenarHeredia());//3
        Estaciones.InsertarFilnal(llenarSanJose());//4
        Estaciones.InsertarFilnal(llenarPuntarenas());//5
        Estaciones.InsertarFilnal(llenarGuanacaste());//6

        // Se crea el grafo para representar las conexiones entre las estcaiones. 
        grafo.agregarArista(0, 1, 10, 20);
        grafo.agregarArista(1, 2, 50, 60);
        grafo.agregarArista(2, 3, 30, 30);
        grafo.agregarArista(3, 4, 25, 35);
        grafo.agregarArista(4, 5, 40, 40);
        grafo.agregarArista(5, 6, 100, 120);
        grafo.agregarArista(6, 0, 40, 25);

        // Se crea vagones y se pueblan con pilas de los pasajeros
        //  El numero de vagones y pasajeros se basa en los detalles de administracion1
        // el bucle inicializa vagones para pasajeros con y sin discapacidad
        for (int i = 0; i < administracion1.getFilasConDiscapacidad(); i++) {
            VagonLDC.InsertarInicio(new PilaPasajero(administracion1.getAsientosConDiscapacidad()), true);
        }
        for (int i = 0; i < administracion1.getFilasSinDiscapacidad(); i++) {
            VagonLDC.InsertarInicio(new PilaPasajero(administracion1.getAsientosSinDiscapacidad()), false);
        }

        // Inicializa el hilo para manejar el movimiento del tren
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    movimientoVagon();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            // Maneja el movimiento del tren entre estaciones. 

            public void movimientoVagon() throws InterruptedException {
                // Saca la estacion actual. 
                estacionActual = Estaciones.cabeza;
                while (true) {

                    // Imprime la estacion actual. 
                    System.out.println("Estacion Actual");
                    System.out.println(estacionActual.elemento);
                    // Actualiza la estacion que esta actual. 
                    lblEstacion.setText(estacionActual.elemento.getEstacion().toString());
                    // Imprime en la consola que las personas están entrando a la estación.
                    System.out.println("Personas entrando a la estacion");
                    System.out.println(ImprimirVagon());

                    jTextArea1.setText(ImprimirEstaciones()); // Llama al metodo para imprimir las estaciones. 

                    // este metodo vacia al vagon en caso de que tenga pasajeros. 
                    vaciarVagon(estacionActual.elemento);

                    // Desencola y procesa pasajeros de la cola de pasajeros no discapccitados. 
                    Pasajero pasajero = estacionActual.elemento.getColaNoDiscapacitada().desencolar();
                    while (true) {
                        if (pasajero == null) {
                            break;
                        }
                        // Llena el vagon con el pasajero no discapacitado, si es posible. 
                        if (llenarVagon(pasajero, false)) {
                            estacionActual.elemento.getColaNoDiscapacitada().encolar(pasajero);
                            break;
                        }
                        pasajero = estacionActual.elemento.getColaNoDiscapacitada().desencolar();
                    }
                    // Desencola y procesa pasajeros de la cola de pasajeros discapacitados.

                    pasajero = estacionActual.elemento.getColaDiscapacitada().desencolar();
                    while (true) {
                        if (pasajero == null) {
                            break;
                        }
                        // Llena el vagon con el pasajero discapacitado, si es posible. 
                        if (llenarVagon(pasajero, true)) {
                            estacionActual.elemento.getColaDiscapacitada().encolar(pasajero);
                            break;
                        }
                        pasajero = estacionActual.elemento.getColaDiscapacitada().desencolar();
                    }

                    // Avanza a la siguiente estacion en la lista circular de estaciones
                    estacionActual = estacionActual.siguiente;
                    System.out.println("personas Saliendo a la estacion");
                    // Imprime en la consola la represetnacion del estado actual del vagon. 

                    System.out.println(ImprimirVagon());
                    // Imprime en el panel derecho inferior la represetnacion del estado actual del vagon. 

                    jTextArea2.setText(ImprimirVagon());

                    // Puasa el hilo actual durante el tiempo especifico entre paradas. 
                    Thread.sleep(administracion1.getTiempoEntreParadas());//
                }
            }
        });
        t.start(); // Inicia el hilo. 

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblEstacion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        DatosFijos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Estacion Actual: ");

        lblEstacion.setText("jLabel2");

        jScrollPane1.setEnabled(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("Vagon");

        jScrollPane2.setEnabled(false);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton1.setText("Agregar pasajero");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("jLabel3");

        jLabel4.setText("Empresa");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        DatosFijos.setText("DatosFijos");
        DatosFijos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatosFijosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DatosFijos)
                        .addGap(37, 37, 37)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblEstacion)
                                .addGap(141, 141, 141)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane3))))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblEstacion)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(DatosFijos))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Estacion = true;
        // Estas seran las preguntas que se les debe hacer al usuario para poder agregarlos a los vagones. 
        int opcionAgregarPasajero = JOptionPane.showConfirmDialog( // Sera una pregunta al ususario para confirmar si quiere agregar el usuario o no. 
                null, "¿Desea agregar un pasajero a una estación?",
                "Agregar Pasajero", JOptionPane.YES_NO_OPTION);

        if (opcionAgregarPasajero == JOptionPane.YES_OPTION) { // En caso de que el usuario diga que si, se le haran las siguientes pregunttas. 
            // Capturar detalles del pasajero desde el usuario
            String nombreCompleto = JOptionPane.showInputDialog("Ingrese su nombre completo: ");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad: "));
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su id"));
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

            EnumEstacion[] estacionesOrigen = EnumEstacion.values();
            EnumEstacion Origen = (EnumEstacion) JOptionPane.showInputDialog(
                    null,
                    "Seleccione su estación de Origen:",
                    "Seleccionar Estación",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    estacionesOrigen,
                    estacionesOrigen[0] // Estación por defecto
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

            Pasajero nuevoPasajero = new Pasajero(nombreCompleto, edad, Origen, destino, discapacidad, EnumEstadoViaje.En_Cola, id);
            // Tomara en cuenta la discapacidad y origen escritos por el usuario y los mete como parametros en la clase insertarEstacion, para poder insertarlos.
            InsertarEnEstacion(discapacidad, Origen, nuevoPasajero);
        } else {

        }

        Estacion = true;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void DatosFijosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatosFijosActionPerformed
        //Cartago
        // Agrega los datos fijos de Cartago
        ColaPasajero cola1Cartago = new ColaPasajero();
        cola1Cartago.encolar(new Pasajero("Leo", 1, EnumEstacion.CARTAGO, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
        cola1Cartago.encolar(new Pasajero("Leo", 1, EnumEstacion.CARTAGO, EnumEstacion.HEREDIA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
        ColaPasajero cola2Cartago = new ColaPasajero();
        cola2Cartago.encolar(new Pasajero("Leo", 1, EnumEstacion.CARTAGO, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
        cola2Cartago.encolar(new Pasajero("Leo", 1, EnumEstacion.CARTAGO, EnumEstacion.HEREDIA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
        Estaciones.InsertarFilnal(llenarCartago(cola1Cartago, cola2Cartago));
        //limon
        // Agrega los datos fijos de Limon

        ColaPasajero cola1limon = new ColaPasajero();
        cola1limon.encolar(new Pasajero("Leo", 1, EnumEstacion.LIMON, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
        cola1limon.encolar(new Pasajero("Leo", 1, EnumEstacion.LIMON, EnumEstacion.HEREDIA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
        ColaPasajero cola2limon = new ColaPasajero();
        cola2limon.encolar(new Pasajero("Leo", 1, EnumEstacion.LIMON, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
        cola2limon.encolar(new Pasajero("Leo", 1, EnumEstacion.LIMON, EnumEstacion.HEREDIA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
        Estaciones.InsertarFilnal(llenarLimon(cola1limon, cola2limon));
        //Alajuela
       // Agrega los datos fijos de Alajuela

        ColaPasajero cola1Alajuela = new ColaPasajero();
        cola1Alajuela.encolar(new Pasajero("Leo", 1, EnumEstacion.ALAJUELA, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
        cola1Alajuela.encolar(new Pasajero("Leo", 1, EnumEstacion.ALAJUELA, EnumEstacion.HEREDIA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
        ColaPasajero cola2Alajuela = new ColaPasajero();
        cola2Alajuela.encolar(new Pasajero("Leo", 1, EnumEstacion.ALAJUELA, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
        cola2Alajuela.encolar(new Pasajero("Leo", 1, EnumEstacion.ALAJUELA, EnumEstacion.HEREDIA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
        Estaciones.InsertarFilnal(llenarAlajuela(cola1Alajuela, cola2Alajuela));
        //San Jose
        // Agrega los datos fijos de San Jose

        ColaPasajero cola1SAN_JOSE = new ColaPasajero();
        cola1SAN_JOSE.encolar(new Pasajero("Leo", 1, EnumEstacion.SAN_JOSE, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
        cola1SAN_JOSE.encolar(new Pasajero("Leo", 1, EnumEstacion.SAN_JOSE, EnumEstacion.HEREDIA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
        ColaPasajero cola2SAN_JOSE = new ColaPasajero();
        cola2SAN_JOSE.encolar(new Pasajero("Leo", 1, EnumEstacion.SAN_JOSE, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
        cola2SAN_JOSE.encolar(new Pasajero("Leo", 1, EnumEstacion.SAN_JOSE, EnumEstacion.HEREDIA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
        Estaciones.InsertarFilnal(llenarSanJose(cola1SAN_JOSE, cola2SAN_JOSE));
        //HEREDIA
         // Agrega los datos fijos de Heredia

        ColaPasajero cola1HEREDIA = new ColaPasajero();
        cola1HEREDIA.encolar(new Pasajero("Leo", 1, EnumEstacion.HEREDIA, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
        cola1HEREDIA.encolar(new Pasajero("Leo", 1, EnumEstacion.HEREDIA, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
        ColaPasajero cola2HEREDIA = new ColaPasajero();
        cola2HEREDIA.encolar(new Pasajero("Leo", 1, EnumEstacion.HEREDIA, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
        cola2HEREDIA.encolar(new Pasajero("Leo", 1, EnumEstacion.HEREDIA, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
        Estaciones.InsertarFilnal(llenarHeredia(cola1HEREDIA, cola2HEREDIA));
        //Puntarenas
        
        // Agrega los datos fijos de Puntarenas

        ColaPasajero cola1Puntarenas = new ColaPasajero();
        cola1Puntarenas.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
        cola1Puntarenas.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
        ColaPasajero cola2Puntarenas = new ColaPasajero();
        cola2Puntarenas.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
        cola2Puntarenas.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
        Estaciones.InsertarFilnal(llenarPuntarenas(cola1Puntarenas, cola2Puntarenas));
        //Guanacaste
        // Agrega los datos fijos de Guanacaste

        ColaPasajero cola1Guana = new ColaPasajero();
        cola1Guana.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
        cola1Guana.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
        ColaPasajero cola2Guana = new ColaPasajero();
        cola2Guana.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
        cola2Guana.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
        Estaciones.InsertarFilnal(llenarGuanacaste(cola1Guana, cola2Guana));
    }//GEN-LAST:event_DatosFijosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla().setVisible(true);
            }
        });
    }

    // Metodo que vaciara el vagon en cuando se reciba el destino final. 
    void vaciarVagon(Estacion destino) {
        // se bajan los pasajeros en la estacion correspondiente
        Boolean fila = true;
        // Verifica que el vagon tenga pasajeros. 
        if (VagonLDC.cabeza != null) {

            // Inicia un bucle para recorrer los nodos del vagon
            NodoPilaPasajero temp = VagonLDC.cabeza;

            do {
                // Se crea una pila auxiliar para reorganizar los pasajeros
                PilaPasajero pilaAux = new PilaPasajero(temp.FilaAsientos.getTamano());

                /// procesa cada pasajero en la fila del vagon
                while (!temp.FilaAsientos.esVacia()) {
                    Pasajero p = temp.FilaAsientos.desapilar();
                    //  Verifca si el destino del pasajero es diferente a la estacion actual. 
                    if (p.getDestino() != destino.getEstacion()) {
                        // Si es diferente, se guarda en la pila auxiliar para permanecer en el vagón
                        pilaAux.apilar(p);
                    } else {
                        // Si es el destino que el usuario elijio , se imprimira la informacion del mismo.
                        int[][] Valores = grafo.dijkstra(p.getOrigen().ordinal());
                        System.out.println("pasajero: " + p.getNombreCompleto() + " Estado de Viaje: " + p.getEstadoViaje());
                        System.out.println("distancia: " + Valores[0][p.getDestino().ordinal()] + " kilometros.");
                        System.out.println("Origen: " + p.getOrigen());
                        System.out.println("Destino: " + p.getDestino());
                        System.out.println("Tiempo: " + Valores[1][p.getDestino().ordinal()] + " minutos.");
                        System.out.println("Monto pagar: " + Valores[0][p.getDestino().ordinal()] * administracion1.getCostoPorKilometro());
                        // Se muestra la informacion en el panel derecho inferior. 
                        jTextArea3.setText(jTextArea3.getText().trim() + "\nPasajero : " + p.getNombreCompleto()
                                + "\nEstado de Viaje : " + p.getEstadoViaje()
                                + "\ndistancia : " + Valores[0][p.getDestino().ordinal()] + " kilometros."
                                + "\nOrigen : " + p.getOrigen()
                                + "\nDestino : " + p.getDestino()
                                + "\nTiempo : " + Valores[1][p.getDestino().ordinal()] + " minutos."
                                + "\nMonto pagar : " + Valores[0][p.getDestino().ordinal()] * administracion1.getCostoPorKilometro());
                    }
                }
                // Devuelve los pasajeros que no se bajaron a la fila original. 
                while (!pilaAux.esVacia()) {
                    temp.FilaAsientos.apilar(pilaAux.desapilar());
                }
                // Se mueve el siguiente nodo del vagon si no es el que se estaba buscando. 
                temp = temp.siguiente;
            } while (temp != VagonLDC.cabeza); // Repite hasta volver al inicio del vagón

        }
    }

    static boolean llenarVagon(Pasajero p, Boolean discapacitado) {
        Boolean fila = true;

        // Verifica si el vagon tiene nodos
        if (VagonLDC.cabeza != null) {
            // Inicia desde el primer nodo del vagon
            NodoPilaPasajero temp = VagonLDC.cabeza;

            // Recorre circularmente los nodos del vagon
            do {
                // Verifica si el pasajero es discapacitado y si la fila del nodo actual es adecuada
                if (discapacitado == temp.Discapacitado) {
                    // Intenta apilar el pasajero en la fila de asientos del nodo actual
                    fila = temp.FilaAsientos.apilar(p);

                    if (fila) {
                        break;
                    }
                }
                // Moverse al siguiente nodo en el vagon
                temp = temp.siguiente;
            } while (temp != VagonLDC.cabeza);
        }

        // Devolver true si la fila está llena false si se pudo añadir el pasajero
        return !fila;
    }

    static String ImprimirEstaciones() {
        // Construye la cadena de texto
        StringBuilder sb = new StringBuilder();

        // Verifica si la lista de estaciones tiene nodos
        if (Estaciones.cabeza != null) {
            // Inicia desde el primer nodo de la lista de estaciones
            NodoEstacion temp = Estaciones.cabeza;

            // Recorre circularmente los nodos de la lista de estaciones
            do {
                // Agrega la representacion en cadena de la estacion al StringBuilder
                sb.append(temp.elemento.toString()).append("\n");

                // Mover al siguiente nodo 
                temp = temp.siguiente;
            } while (temp != Estaciones.cabeza);
        }

        // Devolver la cadena de texto resultante
        return sb.toString();
    }

    //Metodo InsertarEnEstacion
    static String InsertarEnEstacion(EnumDiscapacidad discapacidad, EnumEstacion Origen, Pasajero nuevoPasajero) {
        StringBuilder sb = new StringBuilder();
        // Verifica si hay alguna estación en la lista de estaciones
        if (Estaciones.cabeza != null) {
            NodoEstacion temp = Estaciones.cabeza;

            // Recorre la lista de estaciones en un ciclo do-while
            do {
                // Comprueba si la estación actual coincide con la estación de origen recibida como parámetro
                if (Origen == temp.elemento.getEstacion()) {
                    // Dependiendo del tipo de discapacidad del pasajero, se encola en la cola correspondiente en la estación actual
                    switch (discapacidad) {
                        case NO:
                            temp.elemento.getColaNoDiscapacitada().encolar(nuevoPasajero);
                            break;
                        case SI:
                            temp.elemento.getColaDiscapacitada().encolar(nuevoPasajero);
                            break;
                        default:
                            throw new AssertionError();
                    }
                    // Mensaje indicando que se agregó al pasajero a la cola en la estación actual
                    System.out.println("Pasajero agregado a la cola en la estación actual: " + temp.elemento.getEstacion());
                    break;
                }
                temp = temp.siguiente;
            } while (temp != Estaciones.cabeza); // Continúa el ciclo hasta que se vuelve a la cabeza de la lista

        }
        return sb.toString();// Retorna una cadena vacía ya que no se está usando el StringBuilder
    }//Fin de InsertarEnEstacion

    //Metodo ImprimirVagon
    static String ImprimirVagon() {
        StringBuilder sb = new StringBuilder();

        // Verifica si hay algún nodo en la lista de vagones
        if (VagonLDC.cabeza != null) {
            NodoPilaPasajero temp = VagonLDC.cabeza;

            // Recorre la lista de vagones en un ciclo do-while
            do {
                // Agrega información sobre el tipo de asiento (preferencial o normal)
                sb.append(temp.Discapacitado ? "Preferencial: " : "Normal: ");
                // Agrega la representación de la pila de pasajeros en el asiento actual al StringBuilder
                sb.append(temp.FilaAsientos.imprimirPilaPasajero() + "\n");
                // Avanza al siguiente nodo que representa el siguiente asiento en el vagón
                temp = temp.siguiente;
            } while (temp != VagonLDC.cabeza);// Continúa el ciclo hasta que se vuelve al inicio de la lista

        }
        return sb.toString();// Retorna la cadena construida que representa el contenido del vagón
    }//Fin de ImprimirVagon
    static int count = 1;

    static Estacion llenarCartago() {

        ColaPasajero cola1 = new ColaPasajero();

//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.CARTAGO, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.CARTAGO, EnumEstacion.HEREDIA, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.CARTAGO, EnumEstacion.CARTAGO, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.CARTAGO, EnumEstacion.PUNTARENAS, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.CARTAGO, EnumEstacion.GUANACASTE, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.CARTAGO, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.CARTAGO, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        
        ColaPasajero cola2 = new ColaPasajero();

//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.CARTAGO, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.CARTAGO, EnumEstacion.HEREDIA, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.CARTAGO, EnumEstacion.CARTAGO, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.CARTAGO, EnumEstacion.PUNTARENAS, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.CARTAGO, EnumEstacion.GUANACASTE, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.CARTAGO, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.CARTAGO, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        
        return new Estacion(cola2, cola1, EnumEstacion.CARTAGO);
    }

    private Estacion llenarCartago(ColaPasajero colaNoDiscapacitados, ColaPasajero colaDiscapacitados) {
        // Crea y devuelve una nueva instancia de Estacion con las colas proporcionadas
        return new Estacion(colaDiscapacitados, colaNoDiscapacitados, EnumEstacion.CARTAGO);
    }

    static Estacion llenarlIMON() {

        ColaPasajero cola1 = new ColaPasajero();

//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.LIMON, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.LIMON, EnumEstacion.HEREDIA, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.LIMON, EnumEstacion.CARTAGO, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.LIMON, EnumEstacion.PUNTARENAS, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.LIMON, EnumEstacion.GUANACASTE, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.LIMON, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.LIMON, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        
        ColaPasajero cola2 = new ColaPasajero();
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.LIMON, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.LIMON, EnumEstacion.HEREDIA, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.LIMON, EnumEstacion.CARTAGO, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.LIMON, EnumEstacion.PUNTARENAS, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.LIMON, EnumEstacion.GUANACASTE, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.LIMON, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.LIMON, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        
        return new Estacion(cola2, cola1, EnumEstacion.LIMON);
    }

    private Estacion llenarLimon(ColaPasajero colaNoDiscapacitados, ColaPasajero colaDiscapacitados) {
        // Crea y devuelve una nueva instancia de Estacion con las colas proporcionadas
        return new Estacion(colaDiscapacitados, colaNoDiscapacitados, EnumEstacion.LIMON);
    }

    static Estacion llenarAlajuela() {

        ColaPasajero cola1 = new ColaPasajero();
//        cola1.encolar(new Pasajero("Leo", 3, EnumEstacion.ALAJUELA, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.ALAJUELA, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.ALAJUELA, EnumEstacion.HEREDIA, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.ALAJUELA, EnumEstacion.CARTAGO, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.ALAJUELA, EnumEstacion.PUNTARENAS, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.ALAJUELA, EnumEstacion.GUANACASTE, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.ALAJUELA, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.ALAJUELA, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        
        ColaPasajero cola2 = new ColaPasajero();

//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.ALAJUELA, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.ALAJUELA, EnumEstacion.HEREDIA, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.ALAJUELA, EnumEstacion.CARTAGO, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.ALAJUELA, EnumEstacion.PUNTARENAS, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.ALAJUELA, EnumEstacion.GUANACASTE, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.ALAJUELA, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.ALAJUELA, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        
        return new Estacion(cola2, cola1, EnumEstacion.ALAJUELA);
    }

    private Estacion llenarAlajuela(ColaPasajero colaNoDiscapacitados, ColaPasajero colaDiscapacitados) {
        // Crea y devuelve una nueva instancia de Estacion con las colas proporcionadas
        return new Estacion(colaDiscapacitados, colaNoDiscapacitados, EnumEstacion.ALAJUELA);
    }

    static Estacion llenarHeredia() {

        ColaPasajero cola1 = new ColaPasajero();

//        cola1.encolar(new Pasajero("Ale", 1, EnumEstacion.HEREDIA, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
//        cola1.encolar(new Pasajero("Ale", 1, EnumEstacion.HEREDIA, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
//        cola1.encolar(new Pasajero("Ale", 1, EnumEstacion.HEREDIA, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
//        cola1.encolar(new Pasajero("Ale", 1, EnumEstacion.HEREDIA, EnumEstacion.GUANACASTE, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
//        cola1.encolar(new Pasajero("Ale", 1, EnumEstacion.HEREDIA, EnumEstacion.CARTAGO, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
//        cola1.encolar(new Pasajero("Ale", 1,EnumEstacion.HEREDIA, EnumEstacion.LIMON, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
//        cola1.encolar(new Pasajero("Ale", 1,EnumEstacion.HEREDIA, EnumEstacion.LIMON, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
//        cola1.encolar(new Pasajero("Ale", 1,EnumEstacion.HEREDIA, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
//        cola1.encolar(new Pasajero("Ale", 1,EnumEstacion.HEREDIA, EnumEstacion.CARTAGO, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
        ColaPasajero cola2 = new ColaPasajero();

//        cola2.encolar(new Pasajero("Ale", 1,EnumEstacion.HEREDIA, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
//        cola2.encolar(new Pasajero("Ale", 1,EnumEstacion.HEREDIA, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
//        cola2.encolar(new Pasajero("Ale", 1,EnumEstacion.HEREDIA, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
//        cola2.encolar(new Pasajero("Ale", 1,EnumEstacion.HEREDIA, EnumEstacion.GUANACASTE, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
//        cola2.encolar(new Pasajero("Ale", 1,EnumEstacion.HEREDIA, EnumEstacion.CARTAGO, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
        return new Estacion(cola2, cola1, EnumEstacion.HEREDIA);
    }

    private Estacion llenarHeredia(ColaPasajero colaNoDiscapacitados, ColaPasajero colaDiscapacitados) {
        // Crea y devuelve una nueva instancia de Estacion con las colas proporcionadas
        return new Estacion(colaDiscapacitados, colaNoDiscapacitados, EnumEstacion.HEREDIA);
    }

    static Estacion llenarSanJose() {

        ColaPasajero cola1 = new ColaPasajero();
//        cola1.encolar(new Pasajero("Ale", 1,EnumEstacion.SAN_JOSE, EnumEstacion.CARTAGO, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
//        cola1.encolar(new Pasajero("Ale", 1,EnumEstacion.SAN_JOSE, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
//        cola1.encolar(new Pasajero("Ale", 1,EnumEstacion.SAN_JOSE, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
//        cola1.encolar(new Pasajero("Ale", 1,EnumEstacion.SAN_JOSE, EnumEstacion.GUANACASTE, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
//        cola1.encolar(new Pasajero("Ale", 1,EnumEstacion.SAN_JOSE, EnumEstacion.HEREDIA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
//        cola1.encolar(new Pasajero("Ale", 1,EnumEstacion.SAN_JOSE, EnumEstacion.LIMON, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
//        cola1.encolar(new Pasajero("Ale", 1,EnumEstacion.SAN_JOSE, EnumEstacion.LIMON, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
//        cola1.encolar(new Pasajero("Ale", 1,EnumEstacion.SAN_JOSE, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
//        cola1.encolar(new Pasajero("Ale", 1,EnumEstacion.SAN_JOSE, EnumEstacion.HEREDIA, EnumDiscapacidad.NO, EnumEstadoViaje.En_Cola, count++));
        ColaPasajero cola2 = new ColaPasajero();

//        cola2.encolar(new Pasajero("Ale", 1,EnumEstacion.SAN_JOSE, EnumEstacion.CARTAGO, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
//        cola2.encolar(new Pasajero("Ale", 1,EnumEstacion.SAN_JOSE, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
//        cola2.encolar(new Pasajero("Ale", 1,EnumEstacion.SAN_JOSE, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
//        cola2.encolar(new Pasajero("Ale", 1,EnumEstacion.SAN_JOSE, EnumEstacion.GUANACASTE, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
//        cola2.encolar(new Pasajero("Ale", 1,EnumEstacion.SAN_JOSE, EnumEstacion.HEREDIA, EnumDiscapacidad.SI, EnumEstadoViaje.En_Cola, count++));
        return new Estacion(cola2, cola1, EnumEstacion.SAN_JOSE);
    }

    private Estacion llenarSanJose(ColaPasajero colaNoDiscapacitados, ColaPasajero colaDiscapacitados) {
        // Crea y devuelve una nueva instancia de Estacion con las colas proporcionadas
        return new Estacion(colaDiscapacitados, colaNoDiscapacitados, EnumEstacion.SAN_JOSE);
    }

    static Estacion llenarGuanacaste() {

        ColaPasajero cola1 = new ColaPasajero();

//        cola1.encolar(new Pasajero("Leo", 3, EnumEstacion.GUANACASTE, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.GUANACASTE, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.GUANACASTE, EnumEstacion.HEREDIA, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.GUANACASTE, EnumEstacion.CARTAGO, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.GUANACASTE, EnumEstacion.PUNTARENAS, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.GUANACASTE, EnumEstacion.GUANACASTE, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.GUANACASTE, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.GUANACASTE, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
        ColaPasajero cola2 = new ColaPasajero();

//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.GUANACASTE, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.GUANACASTE, EnumEstacion.HEREDIA, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.GUANACASTE, EnumEstacion.CARTAGO, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.GUANACASTE, EnumEstacion.PUNTARENAS, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.GUANACASTE, EnumEstacion.GUANACASTE, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.GUANACASTE, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.GUANACASTE, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        
        return new Estacion(cola2, cola1, EnumEstacion.GUANACASTE);
    }

    private Estacion llenarGuanacaste(ColaPasajero colaNoDiscapacitados, ColaPasajero colaDiscapacitados) {
        // Crea y devuelve una nueva instancia de Estacion con las colas proporcionadas
        return new Estacion(colaDiscapacitados, colaNoDiscapacitados, EnumEstacion.GUANACASTE);
    }

    static Estacion llenarPuntarenas() {

        ColaPasajero cola1 = new ColaPasajero();

//        cola1.encolar(new Pasajero("Leo", 3, EnumEstacion.PUNTARENAS, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.HEREDIA, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.CARTAGO, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.CARTAGO, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.GUANACASTE, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.ALAJUELA, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
//        cola1.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.SAN_JOSE, EnumDiscapacidad.NO,EnumEstadoViaje.En_Cola,count++));
        ColaPasajero cola2 = new ColaPasajero();

//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.HEREDIA, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.CARTAGO, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.HEREDIA, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.GUANACASTE, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.ALAJUELA, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        cola2.encolar(new Pasajero("Leo", 1, EnumEstacion.PUNTARENAS, EnumEstacion.SAN_JOSE, EnumDiscapacidad.SI,EnumEstadoViaje.En_Cola,count++));
//        
        return new Estacion(cola2, cola1, EnumEstacion.PUNTARENAS);
    }

    private Estacion llenarPuntarenas(ColaPasajero colaNoDiscapacitados, ColaPasajero colaDiscapacitados) {
        // Crea y devuelve una nueva instancia de Estacion con las colas proporcionadas
        return new Estacion(colaDiscapacitados, colaNoDiscapacitados, EnumEstacion.PUNTARENAS);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DatosFijos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JLabel lblEstacion;
    // End of variables declaration//GEN-END:variables
}
