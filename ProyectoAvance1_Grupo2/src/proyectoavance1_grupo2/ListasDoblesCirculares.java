package proyectoavance1_grupo2;

public class ListasDoblesCirculares {

    private NodoCircularesDobles cabeza;
    private NodoCircularesDobles ultimo;
    private int maximosNodos;

    public ListasDoblesCirculares(int maximosNodos) {
        this.maximosNodos = maximosNodos;
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

    public void inserta(PasajeroDoble p) {
        //Paso 1, de la presentación
        if (cabeza == null) {
            cabeza = new NodoCircularesDobles(p);
            ultimo = cabeza;
            cabeza.setAnterior(ultimo);
            cabeza.setSiguiente(ultimo);
            ultimo.setSiguiente(cabeza);
            ultimo.setAnterior(cabeza);
        } else {
            //Paso 2, de la presentación
            if (cabeza.getPasajero1().getId() > p.getId()) {
                NodoCircularesDobles aux = new NodoCircularesDobles(p);
                aux.setSiguiente(cabeza);
                cabeza.setAnterior(aux);
                cabeza = aux;
                cabeza.setAnterior(ultimo);
                ultimo.setSiguiente(cabeza);
            } else {
                //Paso 3, de la presentación
                if (p.getId() > ultimo.getPasajero1().getId()) {
                    NodoCircularesDobles aux = new NodoCircularesDobles(p);
                    aux.setAnterior(ultimo);
                    ultimo.setSiguiente(aux);
                    ultimo = aux;
                    ultimo.setSiguiente(cabeza);
                    cabeza.setAnterior(ultimo);
                } else {
                    //Paso 4, de la presentación
                    NodoCircularesDobles aux = cabeza.getSiguiente();
                    while (aux.getPasajero1().getId() < p.getId()) {
                        aux = aux.getSiguiente();
                    }

                    NodoCircularesDobles temp = new NodoCircularesDobles(p);
                    temp.setAnterior(aux.getAnterior());
                    temp.setSiguiente(aux); //Acá aux.getAnterior está apuntando (en su siguiente) a aux
                    aux.setAnterior(temp);
                    temp.getAnterior().setSiguiente(temp);
                }
            }
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
