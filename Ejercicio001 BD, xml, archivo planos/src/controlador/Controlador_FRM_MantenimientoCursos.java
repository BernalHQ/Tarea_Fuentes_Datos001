/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
import modelo.MetodosCursos;
import modelo.Metodos_XML_Cursos;
import vista.FRM_Login;
import vista.FRM_MantenimientoCursos;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_MantenimientoCursos implements ActionListener{

    FRM_MantenimientoCursos frm_mantenimientoCursos;
    ConexionBD conexion;
    FRM_Login frm_Login;
    public MetodosCursos metodosCursos;
    Metodos_XML_Cursos metodos_XML_Cursos;
    
    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos frm_mantenimientoCursos, ConexionBD conexion, FRM_Login frm_Login)
    {
        this.conexion = conexion;
        this.frm_mantenimientoCursos=frm_mantenimientoCursos;
        this.frm_Login=frm_Login;
        metodosCursos = new MetodosCursos();
        metodos_XML_Cursos = new Metodos_XML_Cursos(frm_mantenimientoCursos);
        
    }
    
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getActionCommand().equals("Agregar"))
        {
            if(frm_Login.devolverAlmacenamiento().equals("Base de datos"))
            {
                conexion.agregarCursos(frm_mantenimientoCursos.devolverInformacion());
                frm_mantenimientoCursos.mostrarMensaje("El estudiante fue registrado de forma correcta en la base de datos");
                frm_mantenimientoCursos.resetearGUI();
            }
            else if(frm_Login.devolverAlmacenamiento().equals("Archivos Planos"))
            {
                metodosCursos.agregarCurso(frm_mantenimientoCursos.devolverInformacion());
                frm_mantenimientoCursos.mostrarMensaje("El estudiante fue registrado de forma correcta en el archivo plano");
                frm_mantenimientoCursos.resetearGUI();
            }
            else
            {
                metodos_XML_Cursos.guardarEnXML(frm_mantenimientoCursos.devolverInformacion());
                 frm_mantenimientoCursos.mostrarMensaje("Información agregada al archivo XML de forma correcta.");
                 frm_mantenimientoCursos.resetearGUI();
            }
        }
        if(evento.getActionCommand().equals("Consultar") || evento.getActionCommand().equals("ConsultaRapida"))
        {
            buscar();
        }
        if(evento.getActionCommand().equals("Modificar"))
        {
            if(frm_Login.devolverAlmacenamiento().equals("Base de datos"))
            {
                conexion.modificarCursos(frm_mantenimientoCursos.devolverInformacion());
                frm_mantenimientoCursos.mostrarMensaje("El estudiante fue modificado de forma correcta en la base de datos.");
                frm_mantenimientoCursos.resetearGUI();  
            }
            else if(frm_Login.devolverAlmacenamiento().equals("Archivos Planos"))
            {
                metodosCursos.modificarCurso(frm_mantenimientoCursos.devolverInformacion());
                frm_mantenimientoCursos.mostrarMensaje("El estudiante fue modificado de forma correcta en el archivo plano.");
                frm_mantenimientoCursos.resetearGUI();  
            }
            else
            {
                metodos_XML_Cursos.modificarInformacionDelXml(frm_mantenimientoCursos.devolverInformacion());
                frm_mantenimientoCursos.mostrarMensaje("El estudiante fue modificado de forma correcta en el archivo XML.");
                frm_mantenimientoCursos.resetearGUI();
            }
        }
        if(evento.getActionCommand().equals("Eliminar"))
        {
            if(frm_Login.devolverAlmacenamiento().equals("Base de datos"))
            {
                conexion.eliminarCurso(frm_mantenimientoCursos.devolverSigla());
                frm_mantenimientoCursos.mostrarMensaje("El estudiante fue eliminado de forma correcta en la base de datos.");
                frm_mantenimientoCursos.resetearGUI();
            }
            else if(frm_Login.devolverAlmacenamiento().equals("Base de datos"))
            {
                metodosCursos.eliminarCurso(frm_mantenimientoCursos.devolverInformacion());
                frm_mantenimientoCursos.mostrarMensaje("El estudiante fue eliminado de forma correcta en el archivo plano.");
                frm_mantenimientoCursos.resetearGUI();
            }
            else
            {
                metodos_XML_Cursos.eliminarInformacionDelXml(frm_mantenimientoCursos.devolverSigla());
                frm_mantenimientoCursos.mostrarMensaje("El estudiante fue eliminado de forma correcta en el archivo XML.");
                frm_mantenimientoCursos.resetearGUI();
            }
        }
    
    }
    public void buscar()
    {
        if(frm_Login.devolverAlmacenamiento().equals("Base de datos"))
        {
            if(conexion.consultarCursos(frm_mantenimientoCursos.devolverSigla()))
                {
                    frm_mantenimientoCursos.mostrarInformacion(conexion.mostrarInformacionCursos());
                    frm_mantenimientoCursos.habilitarEdicion();
                }
                else
                {
                    frm_mantenimientoCursos.mostrarMensaje("La sigla buscada no se encuentra en la base de datos.");
                    frm_mantenimientoCursos.habilitarAgregar();
                }
        }
        
        else if(frm_Login.devolverAlmacenamiento().equals("Archivos Planos"))
        {
            if(metodosCursos.consultarCurso(frm_mantenimientoCursos.devolverSigla()))
                {
                    frm_mantenimientoCursos.mostrarInformacion(metodosCursos.getArregloInformacion());
                    frm_mantenimientoCursos.habilitarEdicion();
                }
                else
                {
                    frm_mantenimientoCursos.mostrarMensaje("La sigla buscada no se encuentra en el archivo plano");
                    frm_mantenimientoCursos.habilitarAgregar();
                }
        }
        else
        {
            if(metodos_XML_Cursos.consultarInformacionDelXml(frm_mantenimientoCursos.devolverSigla()))
            {
                frm_mantenimientoCursos.mostrarInformacionXML(metodos_XML_Cursos.getArregloInformacion());
                frm_mantenimientoCursos.habilitarEdicion();
            
                frm_mantenimientoCursos.mostrarMensaje("Información encontrada con la siglas : "+frm_mantenimientoCursos.devolverSigla());
            }
            else
            {
                frm_mantenimientoCursos.mostrarMensaje("No se encontró información con la siglas: "+frm_mantenimientoCursos.devolverSigla());
                frm_mantenimientoCursos.habilitarAgregar();
            }   
        }
    }
public void guardarArchivo()
{
    metodosCursos.guardarArchivo();
}
    

    
}
