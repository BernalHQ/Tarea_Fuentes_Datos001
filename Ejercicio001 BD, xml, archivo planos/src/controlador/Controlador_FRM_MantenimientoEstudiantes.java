/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
import modelo.MetodosEstudiantes;
import modelo.Metodos_XML_Estudiantes;
import vista.FRM_Login;

import vista.FRM_MantenimientoEstudiantes;


public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener{
    
    
    FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes;
    ConexionBD conexion;
    FRM_Login frm_Login;
    public MetodosEstudiantes metodosEstudiantes;
    Metodos_XML_Estudiantes metodos_XML;
    
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes, FRM_Login frm_Login,ConexionBD conexion)
    {
        metodosEstudiantes= new MetodosEstudiantes();
        this.conexion = conexion;
        this.frm_Login=frm_Login;
        this.frm_MantenimientoEstudiantes=frm_MantenimientoEstudiantes;
        metodos_XML=new Metodos_XML_Estudiantes(frm_MantenimientoEstudiantes);
    }
    
    public void actionPerformed(ActionEvent e)
    { 
        
        if(e.getActionCommand().equals("Agregar"))
        {
            
            if(frm_Login.devolverAlmacenamiento().equals("Base de datos"))
            {
                conexion.agregarEstudiantes(frm_MantenimientoEstudiantes.devolverInformacion());
                frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue registrado de forma correcta en la base de datos");
                frm_MantenimientoEstudiantes.resetearGUI();
            }
            else if(frm_Login.devolverAlmacenamiento().equals("Archivos Planos"))
            {
                metodosEstudiantes.agregarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
                frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue registrado de forma correcta en el archivo plano");
                frm_MantenimientoEstudiantes.resetearGUI();
            }
            else 
            {
                 metodos_XML.guardarEnXML(frm_MantenimientoEstudiantes.devolverInformacion());
                 frm_MantenimientoEstudiantes.mostrarMensaje("Información agregada al archivo XML de forma correcta.");
                 frm_MantenimientoEstudiantes.resetearGUI();
            }
            
        }
        if(e.getActionCommand().equals("Consultar") || e.getActionCommand().equals("Consulta_Rapida"))
        {     
            buscar();
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            if(frm_Login.devolverAlmacenamiento().equals("Base de datos"))
            {
                conexion.modificarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
                frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta de la base de datos.");
                frm_MantenimientoEstudiantes.resetearGUI();
            }
            else if(frm_Login.devolverAlmacenamiento().equals("Archivos Planos"))
            {
                metodosEstudiantes.modificarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
                frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta en el archivo plano.");
                frm_MantenimientoEstudiantes.resetearGUI();
            }
            else
            {
                metodos_XML.modificarInformacionDelXml(frm_MantenimientoEstudiantes.devolverInformacion());
                frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta en el archivo XML.");
                frm_MantenimientoEstudiantes.resetearGUI();
            }
            
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(frm_Login.devolverAlmacenamiento().equals("Base de datos"))
            {
                conexion.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverCedula());
                frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta de la base de datos.");
                frm_MantenimientoEstudiantes.resetearGUI();
            }
            else if(frm_Login.devolverAlmacenamiento().equals("Archivos Planos"))
            {
                metodosEstudiantes.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
                frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta en el archivo plano.");
                frm_MantenimientoEstudiantes.resetearGUI();
            }
            else
            {
                metodos_XML.eliminarInformacionDelXml(frm_MantenimientoEstudiantes.devolverCedula());
                frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta en el archivo XML.");
                frm_MantenimientoEstudiantes.resetearGUI();
            }
        }
    }
    public void buscar()
    {
        if(frm_Login.devolverAlmacenamiento().equals("Base de datos"))
        {
            if(conexion.consultarEstudiante(frm_MantenimientoEstudiantes.devolverCedula()))
            {
                    frm_MantenimientoEstudiantes.mostrarInformacion(conexion.mostrarInformacionEstudiante());
                    frm_MantenimientoEstudiantes.habilitarEdicion();
                
            }
            else
            {
                frm_MantenimientoEstudiantes.mostrarMensaje("La cédula buscada no se encuentra en la base de datos.");
                frm_MantenimientoEstudiantes.habilitarAgregar();
            }
        }
        else if(frm_Login.devolverAlmacenamiento().equals("Archivos Planos"))
        {
            if(metodosEstudiantes.consultarEstudiante(frm_MantenimientoEstudiantes.devolverCedula()))
            {
                    frm_MantenimientoEstudiantes.mostrarInformacion(metodosEstudiantes.getArregloInformacion());
                    frm_MantenimientoEstudiantes.habilitarEdicion();
                
            }
            else
            {
                frm_MantenimientoEstudiantes.mostrarMensaje("La cédula buscada no se encuentra en el archivo plano.");
                frm_MantenimientoEstudiantes.habilitarAgregar();
            }
        }
        else
        {
            if(metodos_XML.consultarInformacionDelXml(frm_MantenimientoEstudiantes.devolverCedula()))
            {
                frm_MantenimientoEstudiantes.mostrarInformacionXML(metodos_XML.getArregloInformacion());
                frm_MantenimientoEstudiantes.habilitarEdicion();
            
                frm_MantenimientoEstudiantes.mostrarMensaje("Información encontrada con la cédula : "+frm_MantenimientoEstudiantes.devolverCedula());
            }
            else
            {
                frm_MantenimientoEstudiantes.mostrarMensaje("No se encontró información con la cédula: "+frm_MantenimientoEstudiantes.devolverCedula());
                frm_MantenimientoEstudiantes.habilitarAgregar();
            }   
        }
    }
    
    public void guardarArchivo()
    {
        metodosEstudiantes.guardarArchivo();
    }   
    
    
    
    
    
    
    
    
    
}
