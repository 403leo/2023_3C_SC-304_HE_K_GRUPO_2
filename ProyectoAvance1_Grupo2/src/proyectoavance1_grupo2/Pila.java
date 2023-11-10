
package proyectoavance1_grupo2;

import javax.swing.JOptionPane;

public class Pila {
    private NodoPila cimaPila;
    private boolean discapacidad;
    private String maximosNodos;

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

    public String getMaximosNodos() {
        return maximosNodos;
    }

    public void setMaximosNodos(String maximosNodos) {
        this.maximosNodos = maximosNodos;
    }
    
    
    
    
    

    public Pila() {
        this.cimaPila = null;
    }
    
    public boolean esVacia() {
        if (cimaPila == null) {
            return true;

        } else {
            return false;

        }

    } //Final del esVacia

    public void apilar(String numero) {

        Pasajero d = new Pasajero();
        d.setEdad(Integer.parseInt(numero));

        d.setNombreCompleto(numero);
        

        NodoPila nuevo = new NodoPila();

        nuevo.setElemento(d);

        if (esVacia()) {

            cimaPila = nuevo;

        } else {

            nuevo.setSiguiente(cimaPila);
            cimaPila = nuevo;

        }

    } ///Final del metodo apilar

    public void desapilar() {
        if (!esVacia()) {
            cimaPila = cimaPila.getSiguiente();
            JOptionPane.showMessageDialog(null, "El elemento fue extraido. ");
        } else {
            JOptionPane.showMessageDialog(null, "No se puede extraer elementos de una pila vacia");

        }

    } //Final del metodo desapilar

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
    
    
    
} // Final de la clase Pila