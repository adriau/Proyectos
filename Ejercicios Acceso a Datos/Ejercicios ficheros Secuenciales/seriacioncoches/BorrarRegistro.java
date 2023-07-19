/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacioncoches;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author adrian
 */
public class BorrarRegistro {

    public static void Borrar() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        String nombreF;
        char resp = ' ';
        String modelo;
        File ficheroTemp = new File("nombreTemp");
        
        try {
            System.out.println("Escoja el fichero");
            nombreF = leer.readLine();
            File fichero = new File(nombreF);
            ois = new ObjectInputStream(new FileInputStream(fichero));
            oos = new ObjectOutputStream(new FileOutputStream(ficheroTemp));
            if (fichero.exists()) {
                System.out.println("¿Desea borrar algun registro?");
                resp = leer.readLine().charAt(0);
                if (resp == 's') {
                    System.out.print("Escoja el registro a borrar: ");
                    modelo = leer.readLine();
                    System.out.println();
                    
                    Coche objTemp = (Coche) ois.readObject();
                    if (modelo.equalsIgnoreCase(objTemp.getModelo())) {
                        System.out.println("Marca: " + objTemp.getMarca());
                        System.out.println("Modelo: " + objTemp.getModelo());
                        System.out.println("Marca: " + objTemp.getRueda().marcaRueda);
                        System.out.println("Marca: " + objTemp.getRueda().dimension);
                        System.out.println();
                    }
                    
                    System.out.println("¿Desea borrar el registro seleccionado?");
                    resp = leer.readLine().charAt(0);
                    if (resp == 's') {
                        do {   
                            Coche objTemp2 = (Coche) ois.readObject();
                            if (!modelo.equalsIgnoreCase(objTemp2.getModelo())) {
                                oos.writeObject(objTemp2);
                            }
                        } while (true);
                    } else {
                    }
                } else {
                }
            } else {
            }
        } catch (Exception e) {
        } finally {
            if (ois != null) {
                ois.close();
            }
            if (oos != null) {
                oos.close();
            }
        }
    }
}
