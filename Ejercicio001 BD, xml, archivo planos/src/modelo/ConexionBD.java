/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import vista.FRM_Matricula;

/**
 *
 * @author acerpc
 */
public class ConexionBD {
   
     Connection con = null;
     String arregloInformacionConsultadaEstudiante[] = new String [2];
     String arregloInformacionConsultadaCursos[] = new String [3];
     String arregloInformacionConsultadaMatricula[]= new String [4];
     
     FRM_Matricula frm_Matricula;
    public ConexionBD()
    {   
       
        realizarConexion();
    }
    public void realizarConexion()
    {
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/matricula";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión Realizada");
            
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
    }
    
    
    public void agregarEstudiantes(String arreglo[])
    {
        
        ResultSet rs = null;
        Statement cmd = null;
        
        try {
                cmd = con.createStatement();
                cmd.execute("INSERT INTO estudiantes(cedula, nombre, direccion) VALUES ('"+arreglo[0]+"','"+arreglo[1]+"','"+arreglo[2]+"')");
                
               
               //rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            
        }
        
    }
    public boolean consultarEstudiante(String cedulaEstudiante)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean existe = false;
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT cedula, nombre, direccion FROM estudiantes WHERE cedula = "+cedulaEstudiante+" " );
                
                
                while (rs.next()) 
                {
                   
                    arregloInformacionConsultadaEstudiante [0] = rs.getString("nombre");
                    arregloInformacionConsultadaEstudiante [1] =rs.getString("direccion");
                    
                    existe = true;
                }
                rs.close();
                
                
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            
        }
        return existe;
    }
    
    public void modificarEstudiante(String arreglo[])
    {
        int rs = -1;
        Statement cmd = null;
        
        try
        {
            cmd = con.createStatement();
            rs = cmd.executeUpdate("UPDATE estudiantes SET nombre = '"+arreglo[1]+"', direccion = '"+arreglo[2]+"' WHERE cedula = '"+arreglo[0]+"' ");
            
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
        
    }
    
    public void eliminarEstudiante(String cedula)
    {
        int eliminar;
        Statement cmd = null;
        try
        {
            cmd = con.createStatement();
            eliminar = cmd.executeUpdate("DELETE FROM estudiantes WHERE cedula = '"+cedula+"' ");
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
    }
    
    public String[] mostrarInformacionEstudiante()
    {
        return arregloInformacionConsultadaEstudiante;
    }
    
    
    
    
    public void agregarCursos(String arreglo[])
    {
        
        ResultSet rs = null;
        Statement cmd = null;
        
        try {
                cmd = con.createStatement();
                cmd.execute("INSERT INTO cursos(siglas, nombre, creditos, horario) VALUES ('"+arreglo[0]+"','"+arreglo[1]+"','"+arreglo[2]+"', '"+arreglo[3]+"')");
                
             
               //rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
           
        }
        
    }
    
    public boolean consultarCursos(String siglas)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean existe = false;
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT siglas, nombre, creditos, horario FROM cursos WHERE siglas = '"+siglas+"' " );
                
                
                while (rs.next()) 
                {
                   
                    arregloInformacionConsultadaCursos [0] = rs.getString("nombre");
                    arregloInformacionConsultadaCursos [1] =rs.getString("creditos");
                    arregloInformacionConsultadaCursos [2] = rs.getString("horario");
                    
                    existe = true;
                }
                rs.close();
                
                
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            
        }
        return existe;
    }
    
    public void modificarCursos(String arreglo[])
    {
        int rs = -1;
        Statement cmd = null;
       
        try
        {
            cmd = con.createStatement();
            rs = cmd.executeUpdate("UPDATE cursos SET nombre = '"+arreglo[1]+"', creditos = '"+arreglo[2]+"', horario = '"+arreglo[3]+"' WHERE siglas = '"+arreglo[0]+"' ");
           
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
        
    }
    
    public void eliminarCurso(String siglas)
    {
        int eliminar;
        Statement cmd = null;
        try
        {
            cmd = con.createStatement();
            eliminar = cmd.executeUpdate("DELETE FROM cursos WHERE siglas = '"+siglas+"' ");
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
    }
    
    public String[] mostrarInformacionCursos()
    {
        return arregloInformacionConsultadaCursos;
    }
    
    
    
    public void agregarMatricula(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
       
        try {
                cmd = con.createStatement();
                cmd.execute("INSERT INTO matricula(codigo, cedula, siglas) VALUES ('"+arreglo[0]+"','"+arreglo[1]+"','"+arreglo[2]+"')");
                
              
               //rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            
        }
    }
    
    public boolean consultarMatricula(FRM_Matricula frm_Ventana)
    {
        boolean existe = false;
        ResultSet rs = null;
        Statement cmd = null;
        frm_Ventana.resetearVentana();
        try
        {
            cmd = con.createStatement();
            rs = cmd.executeQuery("SELECT * FROM  matricula" );
           while(rs.next())
           {
               if(rs.getString("codigo").equals(frm_Ventana.devolverCodigo()))
               {
                   arregloInformacionConsultadaMatricula[0] = frm_Ventana.devolverCodigo();
                   arregloInformacionConsultadaMatricula[1] = rs.getString("cedula");
                   consultarEstudiante(arregloInformacionConsultadaMatricula[1]);
                   arregloInformacionConsultadaMatricula[2] = arregloInformacionConsultadaEstudiante[0];
                   arregloInformacionConsultadaMatricula[3] = rs.getString("siglas");
               
                   frm_Ventana.agregarInformacionTablaConsulta(arregloInformacionConsultadaMatricula);
               }           
            }
            
            existe = true;
            rs.close();
            
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
                
        return existe;
                
    }
    
    public void eliminarMatricula(String codigo, String siglas)
    {
        int eliminar;
        Statement cmd = null;
        try
        {
            cmd = con.createStatement();
            eliminar = cmd.executeUpdate("DELETE FROM matricula WHERE codigo = '"+codigo+"' AND siglas = '"+siglas+"' ");
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
    }
    
    public String [] mostrarInformacionMatricula()
    {
        return arregloInformacionConsultadaMatricula;
    }
    public String generarCodigoMatricula()
    {
        ResultSet rs = null;
        Statement cmd =null;
        String codigo = ""; 
        int numero = -1;
        try
        {
            cmd = con.createStatement();
            rs=cmd.executeQuery("SELECT * FROM matricula"); 
            
            while(rs.next())
            {
                numero = Integer.parseInt(rs.getString("codigo"));
            }
            
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        int suma = numero+1;
        codigo = "0000"+suma;
        
        return codigo;
    }
    
    public int verificarexistenciaUsuarios()
    {
        ResultSet rs=null;
        Statement cmd=null;
        ArrayList lista = new ArrayList();
        int cantidadUsuarios=0;
        try
        {
            cmd=con.createStatement();
            rs=cmd.executeQuery("SELECT cedula FROM usuario");
            
            while(rs.next())
            {
                lista.add(rs.getString("cedula"));        
            }
            
            cantidadUsuarios=lista.size();
        }
        catch(Exception e)
        {
            System.out.printf("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
        return cantidadUsuarios;
    }
    
    public boolean verificarLogin(String arreglo [])
    {
        boolean existe = false;
        ResultSet rs = null;
        Statement cmd = null;
        try
        {
            cmd=con.createStatement();
            rs=cmd.executeQuery("SELECT * FROM usuario");
            
            while(rs.next())
            {
                if((rs.getString("nombreUsuario").equals(arreglo[0]))&&(rs.getString("contraseña").equals(arreglo[1])))
                {
                    existe=true;
                }
            }
        }
        catch(Exception e)
        {
            System.out.printf("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return existe;
    }
    
    public void agregarUsuario(String arreglo[])
    {
        
        ResultSet rs = null;
        Statement cmd = null;
        
        try {
                cmd = con.createStatement();
                cmd.execute("INSERT INTO usuario (cedula, nombre, nombreUsuario, contraseña) VALUES ('"+arreglo[0]+"','"+arreglo[1]+"','"+arreglo[2]+"', '"+arreglo[3]+"')");
                
               
               //rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            
        }
        
    }
  
}
