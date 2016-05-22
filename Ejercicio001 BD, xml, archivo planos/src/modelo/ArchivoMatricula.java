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
public class ArchivoMatricula {
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;
    
    
    public ArchivoMatricula()
    {
        
    }
    
    public void crearArchivo()
    {
        try
        {
            archivoSalida = new ObjectOutputStream(new FileOutputStream("matricula.dat"));
            System.out.println("Se creo el archivo matricula");
        }
        catch(Exception e)
        {
            System.out.println("Error al crear archivo");
        }
    }
    
    public void escribirInformacionEnElArchivo(Matricula matricula)
    {
        try
        {
            archivoSalida.writeObject(matricula);
            System.out.println("Se ha escrito correctamente la informacion ");
        }
        catch(Exception e)
        {
            System.out.println("Error al escribir el archivo");
        }
    }
    
    public ArrayList<Matricula> leerInformacionCompleta()
    {
        ArrayList<Matricula> arrayMatricula = new ArrayList<Matricula>();
        
        try
        {
            archivoEntrada = new ObjectInputStream(new FileInputStream("matricula.dat"));
            while(true)
            {
                arrayMatricula.add((Matricula)archivoEntrada.readObject());
            }
        }
        catch(Exception e)
        {
            System.out.println("Fin del archivo matricula " + e);
        }
        return arrayMatricula;
    
    }
}
