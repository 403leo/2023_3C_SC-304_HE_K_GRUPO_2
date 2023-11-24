package proyectoavance1_grupo2;

public class ListasDoblesCirculares {

    private NodoCircularesDobles cabeza;
    private NodoCircularesDobles ultimo;
    private int maximosNodos;

    public ListasDoblesCirculares(int maximosNodos) {
        this.maximosNodos = maximosNodos;
    }

    public ListasDoblesCirculares() {
    }

    public NodoCircularesDobles getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoCircularesDobles cabeza) {
        this.cabeza = cabeza;
    }

    public NodoCircularesDobles getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoCircularesDobles ultimo) {
        this.ultimo = ultimo;
    }

    public int getMaximosNodos() {
        return maximosNodos;
    }

    public void setMaximosNodos(int maximosNodos) {
        this.maximosNodos = maximosNodos;
    }

    // Insertar pilas en los nodos de las listas
    public void inserta(Pila p) {
        // Paso 1, de la presentación
        if (cabeza == null) {
            cabeza = new NodoCircularesDobles(p);
            ultimo = cabeza;
            cabeza.setAnterior(ultimo);
            cabeza.setSiguiente(ultimo);
            ultimo.setSiguiente(cabeza);
            ultimo.setAnterior(cabeza);
        } else {
            // Paso 2, de la presentación
            if (!cabeza.getPilaLista().esVacia() && cabeza.getPilaLista().getCimaPila().getElemento().getId() > p.getCimaPila().getElemento().getId()) {
                NodoCircularesDobles aux = new NodoCircularesDobles(p);
                aux.setSiguiente(cabeza);
                cabeza.setAnterior(aux);
                cabeza = aux;
                cabeza.setAnterior(ultimo);
                ultimo.setSiguiente(cabeza);
            } else {
                // Paso 3, de la presentación
                if (p.getCimaPila().getElemento().getId() > ultimo.getPilaLista().getCimaPila().getElemento().getId()) {
                    NodoCircularesDobles aux = new NodoCircularesDobles(p);
                    aux.setAnterior(ultimo);
                    ultimo.setSiguiente(aux);
                    ultimo = aux;
                    ultimo.setSiguiente(cabeza);
                    cabeza.setAnterior(ultimo);
                } else {
                    // Paso 4, de la presentación
                    NodoCircularesDobles aux = cabeza.getSiguiente();
                    while (aux != cabeza && !aux.getPilaLista().esVacia() && aux.getPilaLista().getCimaPila().getElemento().getId() < p.getCimaPila().getElemento().getId()) {
                        aux = aux.getSiguiente();
                    }

                    NodoCircularesDobles temp = new NodoCircularesDobles(p);
                    temp.setAnterior(aux.getAnterior());
                    temp.setSiguiente(aux);
                    aux.setAnterior(temp);
                    temp.getAnterior().setSiguiente(temp);
                }
            }
        }
    }

    // inserta para las colas en los nodos de la lista
//    public void insertaGPT(DataEstacion p) {
//        // Paso 1, de la presentación
//        if (cabeza == null) {
//            cabeza = new NodoCircularesDobles(p);
//            ultimo = cabeza;
//            cabeza.setAnterior(ultimo);
//            cabeza.setSiguiente(ultimo);
//            ultimo.setSiguiente(cabeza);
//            ultimo.setAnterior(cabeza);
//        } else {
//            // Paso 2, de la presentación
//            if (!cabeza.getPilaLista().esVacia() && cabeza.getPilaLista().getCimaPila().getElemento().getId() > p.getCimaPila().getElemento().getId()) {
//                NodoCircularesDobles aux = new NodoCircularesDobles(p);
//                aux.setSiguiente(cabeza);
//                cabeza.setAnterior(aux);
//                cabeza = aux;
//                cabeza.setAnterior(ultimo);
//                ultimo.setSiguiente(cabeza);
//            } else {
//                // Paso 3, de la presentación
//                if (p.getCimaPila().getElemento().getId() > ultimo.getPilaLista().getCimaPila().getElemento().getId()) {
//                    NodoCircularesDobles aux = new NodoCircularesDobles(p);
//                    aux.setAnterior(ultimo);
//                    ultimo.setSiguiente(aux);
//                    ultimo = aux;
//                    ultimo.setSiguiente(cabeza);
//                    cabeza.setAnterior(ultimo);
//                } else {
//                    // Paso 4, de la presentación
//                    NodoCircularesDobles aux = cabeza.getSiguiente();
//                    while (aux != cabeza && !aux.getPilaLista().esVacia() && aux.getPilaLista().getCimaPila().getElemento().getId() < p.getCimaPila().getElemento().getId()) {
//                        aux = aux.getSiguiente();
//                    }
//
//                    NodoCircularesDobles temp = new NodoCircularesDobles(p);
//                    temp.setAnterior(aux.getAnterior());
//                    temp.setSiguiente(aux);
//                    aux.setAnterior(temp);
//                    temp.getAnterior().setSiguiente(temp);
//                }
//            }
//        }
//    }
    public void agregarAlFinal(DataEstacion data) {
        NodoCircularesDobles nuevoNodo = new NodoCircularesDobles(data);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            NodoCircularesDobles ultimo = cabeza.getAnterior();
            ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            nuevoNodo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevoNodo);
        }
    }
    // Agrega este método a tu clase ListasDoblesCirculares

    // Imprime las pilas
    public void imprimirLista() {
        NodoCircularesDobles aux = cabeza;
        do {
            System.out.println("Contenido de la pila en el nodo: ");
            System.out.println(aux.getPilaLista().imprimirPila());
            aux = aux.getSiguiente();
        } while (aux != cabeza);
    }

    //Imprime las provincias
    public void imprimirLista1() {
        if (cabeza == null) {
            System.out.println("La lista esta vacia.");
        } else {
            NodoCircularesDobles actual = cabeza;
            do {
                System.out.println("Cantidad de pasajeros: " + actual.getDe().getCantidadPasajero()
                        + ", Estacion Actual: " + actual.getDe().getEstacionActual());
                actual = actual.getSiguiente();
            } while (actual != cabeza);
        }
    }

    @Override
    public String toString() {
        String respuesta = "Lista doble circular: \n";

        if (cabeza != null) {
            NodoCircularesDobles aux = cabeza;

            respuesta += aux.toString() + "\n";

            aux = aux.getSiguiente();

            while (aux != cabeza) {
                respuesta += aux.toString() + "\n";
                aux = aux.getSiguiente();
            }
        } else {
            respuesta += "Vacía";
        }

        return respuesta;
    }

} // Final de la clase Listas Dobles Circulares.
