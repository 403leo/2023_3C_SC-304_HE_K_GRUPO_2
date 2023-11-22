package proyectoavance1_grupo2;

public class Estacion {

    private String nombre;
    private Cola colaDiscapacitada;
    private Cola colaNoDiscapacitada;
    
    private Pila p1;

    public Estacion() {
        this.p1 = new Pila();
    }

    public void agregarPasajero(Pasajero pasajero) {
        p1.apilar(pasajero);
    }

    public void eliminarPasajero(Pasajero pasajero) {
        p1.desapilarb();
    }

    public void imprimirPasajeros() {
        System.out.println(p1.imprimirPilaPasajero());
    }
    
    public void extrae(Pasajero p)
    {
        if(!p1.esVacia())
        {
            NodoPila actual = p1.getCimaPila(); // Este nodo auxiliar nos va a servir para recorrer la pila
            NodoPila anterior = null;

            //Empezamos a recorrer la pila 
            while(actual != null)
            {
                if(p.getNombreCompleto().equals(actual.getElemento().getNombreCompleto()))
                {
                    if(anterior != null)
                    {
                        //Actualizamos las conexiones entre los nodos
                        anterior.setSiguiente(actual.getSiguiente());
                        actual.setSiguiente(null);
                        actual = null;
                    }
                    else
                    {
                        //El elemento está en la cima, porque el anterior es null
                        p1.setCimaPila(actual.getSiguiente());
                        actual.setSiguiente(null);
                        actual = null;
                    }
                    System.out.println("El elemento fue extraído");
                    break;
                }
                else
                {
                    anterior = actual;
                    actual = actual.getSiguiente();
                }
            }
        }
        else
        {
            //La pila está vacía
            System.out.println("No se puede extraer el elemento, porque la Pila está vacía");
        }
    }


} // Final de la clase Estacion
