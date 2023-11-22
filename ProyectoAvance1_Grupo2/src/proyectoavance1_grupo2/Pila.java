package proyectoavance1_grupo2;

import javax.swing.JOptionPane;

public class Pila {

    private NodoPila cimaPila;
    private boolean discapacidad;// DUDA
    private int maximosPasajeros;
    private Pila p1;
    
    public Pila(Pila p1) {
        this.p1 = new Pila();
    }
    
    // Constructor vacio. 
    
//    public Pila() {
//        this.cimaPila = null;
//    }
    
    public Pila() {
        
    }
    
    

    public Pila(int maximosPasajeros) {
        this.maximosPasajeros = maximosPasajeros;
    }

    public NodoPila getCimaPila() {
        return cimaPila;
    }

    public void setCimaPila(NodoPila cimaPila) {
        this.cimaPila = cimaPila;
    }

    public boolean isDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    public int getMaximosPasajeros() {
        return maximosPasajeros;
    }

    public void setMaximosPasajeros(int maximosPasajeros) {
        this.maximosPasajeros = maximosPasajeros;
    }

    

    public boolean esVacia() {
        if (cimaPila == null) {
            return true;

        } else {
            return false;

        }

    } //Final del esVacia

    public void apilar(String nombreCompleto) {

        Pasajero d = new Pasajero();
        d.setEdad(Integer.parseInt(nombreCompleto));

        d.setNombreCompleto(nombreCompleto);

        NodoPila nuevo = new NodoPila();

        nuevo.setElemento(d);

        if (esVacia()) {

            cimaPila = nuevo;

        } else {

            nuevo.setSiguiente(cimaPila);
            cimaPila = nuevo;

        }

    } ///Final del metodo apilar

    public void apilar(Pasajero p) {
        NodoPila nuevo = new NodoPila(p);
        if (esVacia()) {
            cimaPila = nuevo;
        } else {
            nuevo.setSiguiente(cimaPila);
            cimaPila = nuevo;
        }
    }

    public void desapilar() {
        if (!esVacia()) {
            cimaPila = cimaPila.getSiguiente();
            JOptionPane.showMessageDialog(null, "El elemento fue extraido. ");
        } else {
            JOptionPane.showMessageDialog(null, "No se puede extraer elementos de una pila vacia");

        }

    } //Final del metodo desapilar
    
     public Pasajero desapilarb() {

        if (!esVacia()) {
            Pasajero desapilado = cimaPila.getElemento();
            cimaPila = cimaPila.getSiguiente();
            return desapilado;

        } else {
            return null;

        }

    } //Final del metodo desapilar B

    //Ahora se hara un metodo para desapilar pero tomando en cuenta la clase Dato
    public String imprimirPila() {
        String respuesta = "";
        if (!esVacia()) {
            NodoPila temp = cimaPila;
            while (temp != null) {//Esto quiere decir que si la cima no es nula, hay elemento y por lo tanto los va a imprimir.

                respuesta += temp.getElemento().getNombreCompleto() + "\n";

                temp = temp.getSiguiente();

            } //Final del while 

        } //Final del if 1 
        else {
            respuesta = "La pila esta vacia. ";
        } //Final del else 1
        return respuesta;

    } //Final del metodo imprimir pila

    public String imprimirPilaPasajero() {
        String respuesta = "";
        if (!esVacia()) {
            NodoPila temp = cimaPila;
            while (temp != null) {//Esto quiere decir que si la cima no es nula, hay elemento y por lo tanto los va a imprimir.

                respuesta += Integer.toString(temp.getElemento().getId())
                        + " - " + temp.getElemento().getNombreCompleto()
                        + " - " + Integer.toString(temp.getElemento().getEdad())
                        + " - " + temp.getElemento().isDiscapacidad()
                        + " - " + temp.getElemento().getOrigen()
                        + " - " + temp.getElemento().getDestino() + "\n";

                temp = temp.getSiguiente();

            } //Final del while 

        } //Final del if 1 
        else {
            respuesta = "La pila esta vacia. ";
        } //Final del else 1
        return respuesta;

    } //Final del metodo imprimir pila
 

    
    
    

    
    
    
    public void extrae(Pasajero pasajero)
    {
        if(!p1.esVacia())
        {
            NodoPila actual = p1.getCimaPila(); // Este nodo auxiliar nos va a servir para recorrer la pila
            NodoPila anterior = null;

            //Empezamos a recorrer la pila 
            while(actual != null)
            {
                if(pasajero.getNombreCompleto().equals(actual.getElemento().getNombreCompleto()))
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
    
    
    


} // Final de la clase Pila
