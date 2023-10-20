
package proyectoavance1_grupo2;

import javax.swing.JOptionPane;


public class Login {
    
    private String usuario;
    private String Clave;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }
    
    public void registrarClaveyUsuario(){
        
        
        setUsuario(JOptionPane.showInputDialog("Ingrese el usuario a crear: "));
        setClave(JOptionPane.showInputDialog("Ingrese la clave a crear: "));
        
        String usuarioo = JOptionPane.showInputDialog("Ingrese el usuario de ingreso: ");
        String clavee = JOptionPane.showInputDialog("Ingrese la clave de ingreso: ");
        
        
        if (usuario.equals(usuarioo) && Clave.equals(clavee)) {
            
            JOptionPane.showMessageDialog(null, "Usted ha ingreado al menu de la peluqueria mi Rey correctamente.");
            MenuPrincipal menu = new MenuPrincipal();
            menu.MenuPrincipal();
            
        }else{
            JOptionPane.showMessageDialog(null, "Las claves y usuarios no coinciden. ");
            
        
        } //Final else
    
    
    }//Fin del metodo 
    
    
    
} // Final de la clase Login. 
