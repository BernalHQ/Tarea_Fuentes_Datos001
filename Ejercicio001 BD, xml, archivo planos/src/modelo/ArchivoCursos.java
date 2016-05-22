/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author acerpc
 */
public class ArchivoCursos {
    
     ObjectInputStream archivoEntrada;
    ObjectOutputStream archivoSalida;
    
    public ArchivoCursos()
    {
        
    }
    
    public void crearArchivo()
    {
        try
        {
            archivoSalida = new ObjectOutputStream(new FileOutputStream("curso.dat"));
            System.out.println("Se creo el archivo curso");
        }
        catch(Exception e)
        {
            System.out.println("Error al crear el archivo");
        }
    }
    
    public void escribirInformacionEnElArchivo(Cursos curso)
    {
        try
        {
            archivoSalida.writeObject(curso);
            System.out.println("Se ha escrito el archivo");
        }
        catch(Exception e)
        {
            System.out.println("Error al escribir el archivo");
        }
    }
    
    public ArrayList<Cursos> leerInformacionCompleta()
    {
        ArrayList<Cursos> arrayCursos = new ArrayList<Cursos>();
        
        try
        {
            archivoEntrada = new ObjectInputStream(new FileInputStream("curso.dat"));
            while(true)
            {
                arrayCursos.add((Cursos)archivoEntrada.readObject());
            }
        }
        catch(Exception e)
        {
            System.out.println("Fin del archivo cursos" + e);
        }
        
        return arrayCursos;
    }
}
