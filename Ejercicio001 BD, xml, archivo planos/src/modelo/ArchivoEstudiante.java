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
public class ArchivoEstudiante {
    
   ObjectInputStream archivoEntrada;
    ObjectOutputStream archivoSalida;
    
    public void crearArchivo()
    {
        try
        {
            archivoSalida = new ObjectOutputStream(new FileOutputStream("estudiante.dat"));
            System.out.println("Se creo el archivo estudiante");
        }
        catch(Exception e)
        {
            System.out.println("Error al crear el archivo");
        }
    }
    
    public void escribirInformacionEnElArchivo(Estudiante estudiante)
    {
        try
        {
            archivoSalida.writeObject(estudiante);
            System.out.println("Se ha escrito el archivo");
        }
        catch(Exception e)
        {
            System.out.println("Error al escribir el archivo");
        }
    }
    
    public ArrayList<Estudiante> leerInformacionCompleta()
    {
        ArrayList<Estudiante> arrayCursos = new ArrayList<Estudiante>();
        
        try
        {
            archivoEntrada = new ObjectInputStream(new FileInputStream("estudiante.dat"));
            while(true)
            {
                arrayCursos.add((Estudiante)archivoEntrada.readObject());
            }
        }
        catch(Exception e)
        {
            System.out.println("Fin del archivo estudiante " + e);
        }
        
        return arrayCursos;
    }
}
