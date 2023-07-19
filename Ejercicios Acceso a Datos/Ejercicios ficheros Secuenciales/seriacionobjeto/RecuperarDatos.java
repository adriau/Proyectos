/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionobjeto;

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
public class RecuperarDatos {

    public static void Recuperar() throws IOException, ClassNotFoundException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        char resp = 0;
        String nombreF;
        ObjectInputStream os = null;

        System.out.println("¿Desea recuperar algun dato?");
        resp = leer.readLine().charAt(resp);
        try {
            if (resp == 's') {
                System.out.println("Escoja el fichero del que quiere recuperar");
                nombreF = leer.readLine();
                File fichero = new File(nombreF);
                if (fichero.exists()) {
                    os = new ObjectInputStream(new FileInputStream(fichero));
                    Persona persona;
                    do {
                        persona = (Persona) os.readObject();
                        System.out.println("Nombre: " + persona.getNombre());
                        System.out.println("dni: " + persona.getDni());
                        System.out.println("Estudios: " + persona.getEstudio());
                        System.out.println("Sueldo: " + persona.getSueldo());
                        System.out.println();
                    } while (true);
                } else {
                    System.out.println("El fichero no existe");
                }
            } else {
                System.out.println("Escoja otra opcion");
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }
}
