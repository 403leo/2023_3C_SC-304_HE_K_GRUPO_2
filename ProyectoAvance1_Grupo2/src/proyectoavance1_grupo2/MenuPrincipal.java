
package proyectoavance1_grupo2;

import javax.swing.JOptionPane;


public class MenuPrincipal { 
    
    public void MenuPrincipal(){
        
        int opcion;
        boolean salir = false;
        
        while (!salir) {   
        opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                                                              
                                                              Bienvenido a 
                                                              Ingrese una opcion para empezar: 
                                                              1. Modulo de configuracion.
                                                              2. Administracion de pasajeros.
                                                              3. Visualizacion de estaciones y vagon.
                                                              4. Salir"""));
        
        if (opcion == 1) {
            
            
            
            
            } //Final del opcion 1
        else if (opcion == 2) {
            
            
            } //Final del opcion 2
        
        else if (opcion == 3) {
            
            
            
            
            } //Fin de la opcion 3
            
        else if (opcion == 4) {
            salir = true;
            } //Final del else if 4
            
        
        
        }//Final del while 





    } // Final del metodo Menu Principal
    
    
    
    
} // Final de la clase MenuPrincipal

