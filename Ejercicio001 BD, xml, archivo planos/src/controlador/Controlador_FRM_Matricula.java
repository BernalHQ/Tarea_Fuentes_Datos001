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
import modelo.MetodosEstudiantes;
import modelo.MetodosMatricula;
import modelo.Metodos_XML_Cursos;
import modelo.Metodos_XML_Estudiantes;
import modelo.Metodos_XML_Matricula;
import vista.FRM_Login;
import vista.FRM_MantenimientoCursos;
import vista.FRM_MantenimientoEstudiantes;
import vista.FRM_Matricula;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_Matricula implements ActionListener{
    FRM_MantenimientoEstudiantes frm_MantenimientoEstufiantes;
    FRM_MantenimientoCursos frm_MantenimientoCursos;
    ConexionBD conexion;
    FRM_Matricula frm_matricula;
    FRM_Login frm_Login;
    boolean encontroEstudiante=false;
    boolean encontroCurso=false;
    MetodosCursos metodosCursos;
    MetodosEstudiantes metodosEstudiantes;
    public  MetodosMatricula  metodosMatricula;
    Metodos_XML_Cursos metodos_XML_Cursos;
    Metodos_XML_Estudiantes metodos_XML_Estudiantes;
    public Metodos_XML_Matricula metodos_XML_Matricula;
    
    
    public Controlador_FRM_Matricula(FRM_MantenimientoEstudiantes frm_MantenimientoEstufiantes,FRM_MantenimientoCursos frm_MantenimientoCursos,FRM_Matricula frm_matricula,  ConexionBD conexion, FRM_Login frm_Login)
    {
        this.metodosCursos = frm_MantenimientoCursos.controlador.metodosCursos;
        this.metodosEstudiantes = frm_MantenimientoEstufiantes.controlador_FRM_MantenimientoEstudiantes.metodosEstudiantes;
        metodosMatricula = new  MetodosMatricula(metodosEstudiantes,metodosCursos,this,frm_matricula);
        this.conexion = conexion;
        this.frm_Login=frm_Login;
        this.frm_matricula=frm_matricula;
        this.metodos_XML_Cursos=frm_MantenimientoCursos.controlador.metodos_XML_Cursos;
        this.metodos_XML_Estudiantes=frm_MantenimientoEstufiantes.controlador_FRM_MantenimientoEstudiantes.metodos_XML;
        metodos_XML_Matricula =new Metodos_XML_Matricula(frm_matricula);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
            if(e.getActionCommand().equals("ConsultaRapidaCedula"))
            {
                if(frm_Login.devolverAlmacenamiento().equals("Base de datos"))
                {
                    if(conexion.consultarEstudiante(frm_matricula.devolverCedula()))
                    {
                        String arreglo[]=conexion.mostrarInformacionEstudiante();
                        frm_matricula.colocarNombreEstudiante(arreglo[0]);
                        encontroEstudiante=true;
                    }
                    else
                    {
                        frm_matricula.mostrarMensaje("El estudiante no se encuentra en la base de datos, favor dirigirse al módulo de Mantenimiento Estudiantes");
                    }
                }
                else if(frm_Login.devolverAlmacenamiento().equals("Archivos Planos"))
                {
                    if(metodosEstudiantes.consultarEstudiante(frm_matricula.devolverCedula()))
                    {
                        String arreglo[]=metodosEstudiantes.getArregloInformacion();
                        frm_matricula.colocarNombreEstudiante(arreglo[0]);
                        encontroEstudiante=true;
                    }
                    else
                    {
                        frm_matricula.mostrarMensaje("El estudiante no se encuentra en el archivo plano, favor dirigirse al módulo de Mantenimiento Estudiantes");
                    }
                }
                else
                {
                    if(metodos_XML_Estudiantes.consultarInformacionDelXml(frm_matricula.devolverCedula()))
                    {
                        String arreglo[]=metodos_XML_Estudiantes.getArregloInformacion();
                        frm_matricula.colocarNombreEstudiante(arreglo[1]);
                        encontroEstudiante=true;
                    }
                    else
                    {
                        frm_matricula.mostrarMensaje("El estudiante no se encuentra en el archivo XML, favor dirigirse al módulo de Mantenimiento Estudiantes");
                    }
                }
            }
        if(e.getActionCommand().equals("ConsultaRapidaSigla"))
        {
            if(frm_Login.devolverAlmacenamiento().equals("Base de datos"))
            {
                if(conexion.consultarCursos(frm_matricula.devolverSigla()))
                {
                    String arreglo[]=conexion.mostrarInformacionCursos();
                    frm_matricula.colocarNombreCurso(arreglo[0]);
                    encontroCurso=true;
                }
                else
                {
                    frm_matricula.mostrarMensaje("El curso no se encuentra en la base de datos, favor dirigirse al módulo de Mantenimiento Cursos");
                }
            }
            else if(frm_Login.devolverAlmacenamiento().equals("Archivos Planos"))
            {
               if(metodosCursos.consultarCurso(frm_matricula.devolverSigla()))
                {
                    String arreglo[]=metodosCursos.getArregloInformacion();
                    frm_matricula.colocarNombreCurso(arreglo[0]);
                    encontroCurso=true;
                }
                else
                {
                    frm_matricula.mostrarMensaje("El curso no se encuentra en el archivo plano, favor dirigirse al módulo de Mantenimiento Cursos");
                }         
            }
            else
            {
                if(metodos_XML_Cursos.consultarInformacionDelXml(frm_matricula.devolverSigla()))
                {
                    String arreglo[]=metodos_XML_Cursos.getArregloInformacion();
                    frm_matricula.colocarNombreCurso(arreglo[1]);
                    encontroCurso=true;
                }
                else
                {
                    frm_matricula.mostrarMensaje("El curso no se encuentra en el archivo XML, favor dirigirse al módulo de Mantenimiento Cursos");
                }
            }
        }
        if(e.getActionCommand().equals("Agregar"))
        {
            if(frm_Login.devolverAlmacenamiento().equals("Base de datos"))
            {
                frm_matricula.agregarInformacionTabla();
                frm_matricula.limpiarSigla();
            }
            else if(frm_Login.devolverAlmacenamiento().equals("Archivos Planos"))
            {
                frm_matricula.agregarInformacionTabla();
                frm_matricula.limpiarSigla();
            }
            else
            {
                frm_matricula.agregarInformacionTabla();
                frm_matricula.limpiarSigla();
            }
        }
        if(e.getActionCommand().equals("Finalizar"))
        {
            if(frm_Login.devolverAlmacenamiento().equals("Base de datos"))
            {
                String arreglo[] = new String[3];
            
                for(int i = 0; i < frm_matricula.getCantidadFilas();i++)
                {
                    arreglo[0] = frm_matricula.devolverCodigo();
                    arreglo[1] = frm_matricula.devolverDato(i, 1);
                    arreglo[2] = frm_matricula.devolverDato(i, 3);
                    conexion.agregarMatricula(arreglo);
                }
            
                frm_matricula.colocarCodigo();
                frm_matricula.resetearVentana();
                encontroEstudiante = false;
                encontroCurso = false;
            }
            else if(frm_Login.devolverAlmacenamiento().equals("Archivos Planos"))
            {
                String arreglo[] = new String[3];
            
                for(int i = 0; i < frm_matricula.getCantidadFilas();i++)
                {
                    arreglo[0] = frm_matricula.devolverCodigo();
                    arreglo[1] = frm_matricula.devolverDato(i, 1);
                    arreglo[2] = frm_matricula.devolverDato(i, 3);
                    metodosMatricula.agregarMatricula(arreglo);
                
                }
            
                frm_matricula.colocarCodigo();
                frm_matricula.resetearVentana();
                encontroEstudiante = false;
                encontroCurso = false;
            }
            else
            {
                String arreglo[] = new String [4];
                
                for(int i = 0; i < frm_matricula.getCantidadFilas();i++)
                {
                    arreglo[0] = frm_matricula.devolverCodigo();
                    arreglo[1] = frm_matricula.devolverDato(i, 1);
                    arreglo[2] = frm_matricula.devolverDato(i, 2);
                    arreglo[3] = frm_matricula.devolverDato(i, 3);
                    metodos_XML_Matricula.guardarEnXML(arreglo);
                
                }
                frm_matricula.colocarCodigo();
                frm_matricula.resetearVentana();
                encontroEstudiante = false;
                encontroCurso = false;
            }
        }
        if(e.getActionCommand().equals("Consultar"))
        {
            if(frm_Login.devolverAlmacenamiento().equals("Base de datos"))
            {
                if(conexion.consultarMatricula(frm_matricula))
                {
                    
                    frm_matricula.habilitarEliminar();
                }
                else
                {
                    frm_matricula.mostrarMensaje("La matricula no se encuentra almacenada en la base de datos");
                }
            }
            else if(frm_Login.devolverAlmacenamiento().equals("Archivos Planos"))
            {
                if(metodosMatricula.consultarMatricular(frm_matricula.devolverCodigo()))
                {
                    frm_matricula.habilitarEliminar();
                }
                else
                {
                    frm_matricula.mostrarMensaje("La matricula no se encuentra almacenada en archivos planos");
                }
            }
            else
            {
                if(metodos_XML_Matricula.consultarInformacionDelXml(frm_matricula.devolverCodigo()))
                {
                    frm_matricula.habilitarEliminar();
                }
                else
                {
                    frm_matricula.mostrarMensaje("La matricula no se encuentra almacenada en archivos XML");
                }
            }
        
        }
        
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(frm_Login.devolverAlmacenamiento().equals("Base de datos"))
            {
                conexion.eliminarMatricula(frm_matricula.devolverCodigoSelecionado(),frm_matricula.devolverSiglaSelecionda());
                frm_matricula.resetearVentanaConsultar();
            }
            else if(frm_Login.devolverAlmacenamiento().equals("Archivos Planos"))
            {
                metodosMatricula.eliminarMatricula(frm_matricula.devolverCodigoSelecionado(),frm_matricula.devolverSiglaSelecionda());
                frm_matricula.resetearVentanaConsultar();
            }
            else
            {
                metodos_XML_Matricula.eliminarInformacionDelXml(frm_matricula.devolverCodigoSelecionado(),frm_matricula.devolverSiglaSelecionda());
                frm_matricula.resetearVentanaConsultar();
                
                
            }
        }
        verificarConsultas();
    }
    public void verificarConsultas()
    {
        if(encontroEstudiante && encontroCurso)
        {
            this.frm_matricula.habilitarAgregar();
        }
    }
    
    public void guardarArchivo()
    {
        metodosMatricula.guardarArchivo();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
