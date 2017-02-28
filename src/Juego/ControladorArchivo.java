/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author digital
 */
public class ControladorArchivo {
    private String Archivo;
    private FileWriter Fichero;
    private PrintWriter PW;    
    private File archivo;
    private FileReader fr;
    private BufferedReader br;

    public ControladorArchivo(String Archivo) {
        this.Archivo = Archivo;
    }
     
     
    public String[] LeerArchivo(){
      String[] Datos = new String[10000];
        try {
         archivo = new File (Archivo);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
         String linea;
         int i=1;
         while((linea=br.readLine())!=null)
            Datos[i]=linea;
            i++;
         }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
        return Datos;
    }
     
    public boolean BuscarArchivo(String Dato){
        boolean sw=false;
        try {
         archivo = new File (Archivo);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
         String linea;
         int i=1;
         
         while((linea=br.readLine())!=null && sw==false)
             if (linea.equals(Dato)) {
                 sw=true;
             }
         }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
      return sw;
    }
    
    public void EscribirArchivo(String Linea){
    try{
        Fichero = new FileWriter(Archivo,true);
        PW = new PrintWriter(Fichero);
        PW.println(Linea);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != Fichero)
              Fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }   
    }
   
    
}
