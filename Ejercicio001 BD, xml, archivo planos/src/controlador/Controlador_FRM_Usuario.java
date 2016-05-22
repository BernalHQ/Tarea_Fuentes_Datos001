/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the 
template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConexionBD;
import vista.FRM_Login;
import vista.FRM_Usuario;


public class Controlador_FRM_Usuario implements ActionListener{
    
    FRM_Usuario frm_Usuario; 
    FRM_Login frm_Login; 
    ConexionBD conexion;
    
    public Controlador_FRM_Usuario(FRM_Usuario frm_Usuario, FRM_Login frm_Login, ConexionBD conexion )
    {
        this.conexion=conexion;      
        this.frm_Login=frm_Login; 
        this.frm_Usuario=frm_Usuario;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Aceptar"))
        {
            if(frm_Login.devolverAlmacenamiento().equals(""))
            {
                JOptionPane.showMessageDialog(null, "No ha escogido niguna de las opciones fuentes de datos,\nPor favor marcar una de la opciones ");
            }
            else
            {
                if(conexion.verificarLogin(frm_Login.devolverInformacion()))
                {
                    frm_Login.abrirPrincipal();
                    frm_Login.setVisible(false);
                
                }
                else
                {
                    frm_Login.mostrarMensaje("El usuario o contraseña no existe");
                }
            }
        }
        
        if(e.getActionCommand().equals("Consultar"))
        {
            if(frm_Usuario.devolverContraseña().equals(frm_Usuario.devolverContraseñaRepetida()))
            {
                conexion.agregarUsuario(frm_Usuario.devolverInformacion());
                frm_Usuario.resetearGUI();
                frm_Usuario.setVisible(false);
            }
            else
            {
                frm_Usuario.mostrarMensaje("La contraseñas no son las mismas");
                frm_Usuario.resetearContraseñas();
                
            }
            
        }
    }
    
}
