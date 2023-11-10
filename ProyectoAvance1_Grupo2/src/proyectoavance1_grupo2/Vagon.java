//package proyectoavance1_grupo2;
//
//public class Vagon {
//
//    
//    public ListasDoblesCirculares filas;
//
//    public Pila pila1 = new Pila(); // Fila 1 de vagones discapacitados
//    public Pila pila2 = new Pila(); // Fila 2 de vagones sin discapacidad
//    public Pila pila3 = new Pila(); // Fila 3 de vagones sin discapacidad
//    public Pila[] pilas = {pila1, pila2, pila3};
//
////    public ListasDoblesCirculares[] pilas = {pila1,pila2,pila3};
//    private enum estacionActual {  // Hay que utilizarlo en los metodo mios?
//        HEREDIA,
//        ALAJUELA,
//        LIMON,
//        SAN_JOSE,
//        PUNTARENAS,
//        CARTAGO,
//        GUANACASTE
//    } // Final del enum estacion actual
//
//    public boolean hayAsientosDisponibles(boolean discapacidad) {
//        boolean espacio = false; // En caso de que se encuentre el espacion se cambiara a true.
//        // Primero comprueba si la persona es discapacitada , en caso de que lo sea se recorrera 
//        // exclusivamente la fila 1
//
//        //En caso de que el parametro sea discapacitados, se recorrera solo la fila 2 y 3 buscando el espacio disponibles
//        if (discapacidad) {
//
//            if (!pila1.esVacia()) {
//                NodoPila aux1 = pila1.getCimaPila();
//
//                while (aux1 != null) { // Mientras el puntero no este vacio
//                    if (aux1.getElemento() == null) { // Si el elemento que se encontro hay espacio
//                        espacio = true; // se retorna verdad
//                        break;
//                    }
//                    aux1 = aux1.getSiguiente(); 
//                    // En caso de que no se cumpla el while, se sigue recorriendo la pila. 
//
//                } // Final del while 1
//
//            } // Final del if 2
//
//        } // Final del if 1 
//        else {
//            NodoPila aux2 = pila2.getCimaPila(); // dudad de recorrer ambas pilas
//            NodoPila aux3 = pila3.getCimaPila();
//            
//            if (!pila2.esVacia() && !pila3.esVacia()) {
//                 while (aux2 != null) { // Mientras el puntero no este vacio
//                    if (aux3.getElemento() == null) { // Si el elemento que se encontro hay espacio
//                        espacio = true; // se retorna verdad
//                        break;
//                    }
//                    aux2 = aux2.getSiguiente(); 
//                    // En caso de que no se cumpla el while, se sigue recorriendo la pila. 
//
//                } // Final del while 1
//                 
//                  while (aux3 != null) { // Mientras el puntero no este vacio
//                    if (aux3.getElemento() == null) { // Si el elemento que se encontro hay espacio
//                        espacio = true; // se retorna verdad
//                        break;
//                    }
//                    aux3 = aux3.getSiguiente(); 
//                    // En caso de que no se cumpla el while, se sigue recorriendo la pila. 
//
//                } // Final del while 1
//                
//                
//            } // Final del if 1
//
//        } // Final del else 1 
//
//        return espacio;
//
//    } // Final del hay asientos Dispibles
//
//    public void agregarPasajero(Pasajero pasajero) {
//
//        if (pasajero.isDiscapacidad() == true) { // En caso de que el pasajero sea discapacitado 
//
//            // en este se recorrera la pila 1 de discapacitados 
//            // y se buscara el espacio vacio para poder agregar al pasajero
//            // Esta pila deberia salir de la lista. 
//            if (!pila1.esVacia()) {
//                NodoPila aux1 = pila1.getCimaPila();
//
//                while (aux1 != null) { // Mientras la cola no este vacia. 
//                    if (aux1.getElemento() == null) {  // Mientras el espacio de la pila este vacia. 
//                        aux1.setElemento(pasajero); // Se asigna la informacion a dicha pila. 
//
//                    } //  Final del if 3 
//
//                    aux1 = aux1.getSiguiente(); // Se avanza en la pila hasta el final. 
//
//                } // Final del while 1 
//
//            } // Final del if 2 
//
//        } // Final del if 1 
//        else { // En caso de que el pasajero no sea discapacitado 
//            
//            NodoPila aux2 = pila2.getCimaPila();
//            NodoPila aux3 = pila3.getCimaPila();
//                
//            if (!pila2.esVacia() && !pila3.esVacia()) {
//
//                while (aux2 != null) {
//                    if (aux2.getElemento() == null) {
//                        aux2.setElemento(pasajero);
//                        break; // Salir del bucle cuando se asigna el pasajero
//                    } // Final del if 2 
//                    aux2 = aux2.getSiguiente();
//                } // Final del while 1 
//
//                while (aux3 != null) {
//                    if (aux3.getElemento() == null) {
//                        aux3.setElemento(pasajero);
//                        break; // Salir del bucle cuando se asigna el pasajero
//                    } // Final del if 3 
//                    aux3 = aux3.getSiguiente();
//                } // Final del while 2 
//
//            } // Final del if 1 
//            
//            
//            // en este se recorrera la pila 2 y 3 de no 2discapacitados 
//            // y se buscara el espacio vacio para poder agregar al pasajero    
//
//        } // Final del else 1
//
//    } // Final del metodp agregar pasajero. 
//    
//
//
//} // Final de la clase Vagon
//
//
//
//


package proyectoavance1_grupo2;

public class Vagon {

    
    public ListasDoblesCirculares filas;

    public Pila pila1 = new Pila(); // Fila 1 de vagones discapacitados
    public Pila pila2 = new Pila(); // Fila 2 de vagones sin discapacidad
    public Pila pila3 = new Pila(); // Fila 3 de vagones sin discapacidad
    
    

    
    
    

    public Pila getPila1() {
        return pila1;
    }

    public Pila getPila2() {
        return pila2;
    }

    public Pila getPila3() {
        return pila3;
    }
    
    
    

//    public ListasDoblesCirculares[] pilas = {pila1,pila2,pila3};
    private enum estacionActual {  // Hay que utilizarlo en los metodo mios?
        HEREDIA,
        ALAJUELA,
        LIMON,
        SAN_JOSE,
        PUNTARENAS,
        CARTAGO,
        GUANACASTE
    } // Final del enum estacion actual

    public boolean hayAsientosDisponibles(boolean discapacidad) {
        boolean espacio = false; // En caso de que se encuentre el espacion se cambiara a true.
        // Primero comprueba si la persona es discapacitada , en caso de que lo sea se recorrera 
        // exclusivamente la fila 1

        //En caso de que el parametro sea discapacitados, se recorrera solo la fila 2 y 3 buscando el espacio disponibles
        if (discapacidad) {

            if (!pila1.esVacia()) {
                NodoPila aux1 = pila1.getCimaPila();

                while (aux1 != null) { // Mientras el puntero no este vacio
                    if (aux1.getElemento() == null) { // Si el elemento que se encontro hay espacio
                        espacio = true; // se retorna verdad
                        break;
                    }
                    aux1 = aux1.getSiguiente(); 
                    // En caso de que no se cumpla el while, se sigue recorriendo la pila. 

                } // Final del while 1

            } // Final del if 2

        } // Final del if 1 
        else {
            NodoPila aux2 = pila2.getCimaPila(); // dudad de recorrer ambas pilas
            NodoPila aux3 = pila3.getCimaPila();
            
            if (!pila2.esVacia() && !pila3.esVacia()) {
                 while (aux2 != null) { // Mientras el puntero no este vacio
                    if (aux3.getElemento() == null) { // Si el elemento que se encontro hay espacio
                        espacio = true; // se retorna verdad
                        break;
                    }
                    aux2 = aux2.getSiguiente(); 
                    // En caso de que no se cumpla el while, se sigue recorriendo la pila. 

                } // Final del while 1
                 
                  while (aux3 != null) { // Mientras el puntero no este vacio
                    if (aux3.getElemento() == null) { // Si el elemento que se encontro hay espacio
                        espacio = true; // se retorna verdad
                        break;
                    }
                    aux3 = aux3.getSiguiente(); 
                    // En caso de que no se cumpla el while, se sigue recorriendo la pila. 

                } // Final del while 1
                
                
            } // Final del if 1

        } // Final del else 1 

        return espacio;

    } // Final del hay asientos Dispibles

    public void agregarPasajero(Pasajero pasajero) {

        if (pasajero.isDiscapacidad() == true) { // En caso de que el pasajero sea discapacitado 

            // en este se recorrera la pila 1 de discapacitados 
            // y se buscara el espacio vacio para poder agregar al pasajero
            // Esta pila deberia salir de la lista. 
            if (!pila1.esVacia()) {
                NodoPila aux1 = pila1.getCimaPila();

                while (aux1 != null) { // Mientras la cola no este vacia. 
                    if (aux1.getElemento() == null) {  // Mientras el espacio de la pila este vacia. 
                        aux1.setElemento(pasajero); // Se asigna la informacion a dicha pila. 

                    } //  Final del if 3 

                    aux1 = aux1.getSiguiente(); // Se avanza en la pila hasta el final. 

                } // Final del while 1 

            } // Final del if 2 

        } // Final del if 1 
        else { // En caso de que el pasajero no sea discapacitado 
            
            NodoPila aux2 = pila2.getCimaPila();
            NodoPila aux3 = pila3.getCimaPila();
                
            if (!pila2.esVacia() && !pila3.esVacia()) {

                while (aux2 != null) {
                    if (aux2.getElemento() == null) {
                        aux2.setElemento(pasajero);
                        break; // Salir del bucle cuando se asigna el pasajero
                    } // Final del if 2 
                    aux2 = aux2.getSiguiente();
                } // Final del while 1 

                while (aux3 != null) {
                    if (aux3.getElemento() == null) {
                        aux3.setElemento(pasajero);
                        break; // Salir del bucle cuando se asigna el pasajero
                    } // Final del if 3 
                    aux3 = aux3.getSiguiente();
                } // Final del while 2 

            } // Final del if 1 
            
            
            // en este se recorrera la pila 2 y 3 de no 2discapacitados 
            // y se buscara el espacio vacio para poder agregar al pasajero    

        } // Final del else 1

    } // Final del metodp agregar pasajero. 
    


} // Final de la clase Vagon




