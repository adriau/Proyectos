/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionobjeto_maquinaria;

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
 * @author a13adrianac
 */
public class BajaFisica {

    public static void Baja() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        char resp = ' ';
        String nombreF;
        String MarcaC;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        File ficheroTemp = new File("nombreTemp");

        try {
            System.out.println("¿Desea dar de baja algun registro?");
            resp = leer.readLine().charAt(0);
            if (resp == 's') {
                System.out.println("Escoja el fichero en el que quiere dar de baja");
                nombreF = leer.readLine();
                File fichero = new File(nombreF);
                ois = new ObjectInputStream(new FileInputStream(fichero));
                oos = new ObjectOutputStream(new FileOutputStream(ficheroTemp));
                if (fichero.exists()) {
                    System.out.println("Escoje el registro a dar de baja");
                    MarcaC = leer.readLine();
                    do {
                        Maquinaria objTemp = (Maquinaria) ois.readObject();
                        if (!MarcaC.equalsIgnoreCase(objTemp.getMarca())) {
                            oos.writeObject(objTemp);
                        }
                    } while (true);
                } 
            } else {
                System.out.println("Escoja otra opcion");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
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
