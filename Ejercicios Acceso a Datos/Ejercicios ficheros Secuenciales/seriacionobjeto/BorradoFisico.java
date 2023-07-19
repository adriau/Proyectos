/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionobjeto;

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
public class BorradoFisico {

    public static void Borrar() throws IOException, ClassNotFoundException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        Persona persona;

        ObjectInputStream ois;
        ObjectOutputStream oos;
        File ficheroTemp = new File("nombreTemp");

        char resp = 0;
        String nombreF;
        String nombreC;
        String nombre;
        String dni;
        String estudios;
        int sueldo;
        String nombreTemp;

        System.out.println("¿Desea borrar algun registro?");
        resp = leer.readLine().charAt(resp);
        if (resp == 's') {
            System.out.println("Escoja el fichero del que quiere borrar");
            nombreF = leer.readLine();
            File fichero = new File(nombreF);

            ois = new ObjectInputStream(new FileInputStream(fichero));
            oos = new ObjectOutputStream(new FileOutputStream(ficheroTemp));
            try {
                if (fichero.exists()) {
                    System.out.println("Escoja el registro a borrar");
                    nombreF = leer.readLine();
                    do {
                        persona = (Persona) ois.readObject();
                        if (!nombreF.equalsIgnoreCase(persona.getNombre())) {
                            oos.writeObject(persona);
                        }
                    } while (true);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
        }
    }
}
