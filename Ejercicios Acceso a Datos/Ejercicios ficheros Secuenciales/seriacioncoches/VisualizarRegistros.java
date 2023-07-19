/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacioncoches;

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
public class VisualizarRegistros {

    public static void Visualizar() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        ObjectInputStream ois = null;
        String nombreF;
        char resp = ' ';

        try {
            System.out.println("Escoja el fichero");
            nombreF = leer.readLine();
            File fichero = new File(nombreF);
            ois = new ObjectInputStream(new FileInputStream(fichero));
            if (fichero.exists()) {
                System.out.println("¿Desea visualizar los registros?");
                resp = leer.readLine().charAt(0);
                if (resp == 's') {
                    do {
                        Coche objTemp = (Coche) ois.readObject();
                        
                        System.out.println("Marca: " + objTemp.getMarca());
                        System.out.println("Modelo: " + objTemp.getModelo());
                        System.out.println("Marca: " + objTemp.getRueda().marcaRueda);
                        System.out.println("Marca: " + objTemp.getRueda().dimension);
                        System.out.println();
                    } while (true);
                } else {
                    System.out.println("Escoja otra opcion");
                }
            } else {
                System.out.println("El fichero no existe");
            }
        } catch (Exception e) {
        } finally {
            if (ois != null) {
                ois.close();
            }
        }
    }
}
