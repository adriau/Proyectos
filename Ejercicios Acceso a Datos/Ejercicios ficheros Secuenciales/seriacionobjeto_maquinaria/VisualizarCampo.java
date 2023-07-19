/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seriacionobjeto_maquinaria;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

/**
 *
 * @author a13adrianac
 */
public class VisualizarCampo {
    public static void VisualizarC() throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        ObjectInputStream ois=null;
        String nombreF;
        char resp=' ';
        String marcaC;
        
        try {
            System.out.println("Escoja el fichero");
            nombreF=leer.readLine();
            File fichero=new File(nombreF);
            
            if (fichero.exists()) {
                System.out.println("¿Desea visualizar algun registro?");
                resp = leer.readLine().charAt(0);
                
                if (resp == 's') {
                    System.out.println("Escribe la marca del coche");
                    marcaC=leer.readLine();
                    ois = new ObjectInputStream (new FileInputStream(fichero));
                    
                    do {                            
                    Maquinaria objTemp = (Maquinaria) ois.readObject();
                    if (marcaC.equalsIgnoreCase(objTemp.getMarca())) {
                       System.out.println("Marca: " + objTemp.getMarca());
                        System.out.println("Modelo: " + objTemp.getModelo());
                        System.out.println("Precio: " + objTemp.getPrecio());
                        
                        if (objTemp instanceof Industrial) {
                            System.out.println("Potencia: " + ((Industrial) objTemp).getPotencia());
                            System.out.println("Impuesto Industrial: " + ((Industrial) objTemp).getImpuestoIndustrial());
                            System.out.println();
                        } else {
                            System.out.println("Traccion: " + ((Agricola) objTemp).getTraccion());
                            System.out.println("Impuesto Especial: " + ((Agricola) objTemp).getImpuestoEspecial());
                            System.out.println();
                        } 
                    }
                    } while (true);
                } else {
                    System.out.println("Escoja otra opcion");
                }
            } else {
                System.out.println("El fichero no existe");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (ois != null) {
                ois.close();
            }
        }
    }
}
