/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionobjeto;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author a13adrianac
 */
public class CrearFichero {

    public static void Crear() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        String nombre;
        char resp = 0;
        boolean seguir = true;
        
        System.out.println("****************************************");
        System.out.println("¿Desea crear un fichero nuevo?");
        resp = leer.readLine().charAt(resp);
        if (resp == 's') {
            do {
                System.out.println("Escriba un nombre: ");
                nombre = leer.readLine();
                File fichero = new File(nombre);
                if (fichero.exists()) {
                    System.out.println("El fichero ya existe. Prueba otra vez");
                    System.out.println("****************************************");
                } else {
                    fichero.createNewFile();
                    System.out.println("El fichero " + nombre + " se ha creado");
                    seguir=false;
                }
            } while (seguir == true);
        } else {
            System.out.println("Escoja otra opcion");
        }
    }
}
