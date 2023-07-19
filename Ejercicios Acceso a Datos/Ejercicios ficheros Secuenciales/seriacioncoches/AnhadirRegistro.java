/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacioncoches;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

/**
 *
 * @author a13adrianac
 */
public class AnhadirRegistro {

    public static void Anhadir() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        ObjectOutputStream oos = null;
        String nombreF;
        char resp = ' ';
        boolean b=true;

        String marca;
        String modelo;
        String marcaRueda;
        String dimension;

        try {
            System.out.println("Escoja el fichero");
            nombreF = leer.readLine();
            File fichero = new File(nombreF);
            if (fichero.exists()) {
                System.out.println("¿Desea añadir algun registro?");
                resp = leer.readLine().charAt(0);
                if (resp == 's') {
                    oos = new ObjectOutputStreamSinCabecera(new FileOutputStream(fichero, true));
                    do {                        
                        
                    
                    System.out.println("Cubra los siguientes campos");
                    System.out.print("Marca: ");
                    marca = leer.readLine();
                    System.out.print("Modelo: ");
                    modelo = leer.readLine();
                    System.out.print("Marca Rueda: ");
                    marcaRueda = leer.readLine();
                    System.out.print("Dimension: ");
                    dimension = leer.readLine();

                    oos.writeObject(new Coche(marca, modelo, new Rueda(marcaRueda, dimension)));
                    
                        System.out.println("¿Desea escribir otro registro?");
                        resp=leer.readLine().charAt(0);
                        if (resp == 'n') {                            
                            b=false;
                        }
                    
                    } while (b);
                } else {
                    System.out.println("Escoja otra opcion");
                }
            } else {
                System.out.println("El fichero no existe");
            }
        } catch (Exception e) {
        } finally {
            if (oos != null) {
                oos.close();
            }
        }
    }
}
