/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
import vista.FRM_Login;
import vista.FRM_MantenimientoCursos;
import vista.FRM_MantenimientoEstudiantes;
import vista.FRM_Matricula;
import vista.FRM_Usuario;
import vista.FRM_VentanaPrincipal;

/**
 *
 * @author tecnologiamultimedia
 */


    
public class Controlador_FRM_VentanaPrincipal implements ActionListener{

    FRM_MantenimientoEstudiantes frm_MantenimientoEstufiantes;
    FRM_MantenimientoCursos frm_MantenimientoCursos;
    FRM_Matricula frm_Matricula;
    FRM_Usuario frm_Usuario;
    public FRM_Login frm_Login;
    ConexionBD conexion;
    
    
    public Controlador_FRM_VentanaPrincipal(FRM_VentanaPrincipal frm_VentanaPrincipal)
    {
        conexion = new ConexionBD();
        frm_Login = new FRM_Login(frm_VentanaPrincipal,frm_Usuario, conexion);
        frm_MantenimientoEstufiantes= new FRM_MantenimientoEstudiantes(conexion, frm_Login);
        frm_MantenimientoCursos= new FRM_MantenimientoCursos(conexion, frm_Login);
        frm_Matricula =new FRM_Matricula(frm_MantenimientoEstufiantes,frm_MantenimientoCursos,conexion, frm_Login);
        frm_Usuario = new FRM_Usuario(frm_VentanaPrincipal, frm_Login, conexion);
        
        verificarBD();
        
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Salir"))
        {
            System.exit(0);
        }
        if(e.getActionCommand().equals("Estudiantes"))
        {
            frm_MantenimientoEstufiantes.setVisible(true);    
        }
        if(e.getActionCommand().equals("Cursos"))
        {
            frm_MantenimientoCursos.setVisible(true);
        }
        if(e.getActionCommand().equals("Matricula"))
        {
            frm_Matricula.setVisible(true);
            frm_Matricula.colocarCodigo();
        }
    
    }
    
    public void verificarBD()
    {
       
        if(conexion.verificarexistenciaUsuarios() == 0)
        {
            frm_Usuario.setVisible(true);
        }
        else
        {
            frm_Login.setVisible(true);
        }
      
    }
    
    
    
}












