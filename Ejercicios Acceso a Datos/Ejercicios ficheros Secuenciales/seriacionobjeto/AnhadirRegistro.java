/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionobjeto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

/**
 *
 * @author a13adrianac
 */
public class AnhadirRegistro {

    public static void Anhadir() throws IOException {
        String nombrep;
        String dni;
        String estudios;
        int sueldo;

        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        String nombreF;
        ObjectOutputStream os = null;
        char resp = 0;
        char resp2 = 0;
        boolean seguir = true;

        try {
            System.out.println("¿Desea añadir algun registro?");
            resp = leer.readLine().charAt(resp);
            if (resp == 's') {
                System.out.println("¿En que fichero quieres añadirlo?");
                nombreF = leer.readLine();
                File fichero = new File(nombreF);
                if (fichero.exists()) {
                    if (fichero.length() == 0) {
                        os = new ObjectOutputStream(new FileOutputStream(nombreF, true));
                    } else {
                        os = new ObjectOutputStreamSinCabecera(new FileOutputStream(nombreF, true));
                    }
                        System.out.println("Rellene los siguientes campos");
                        System.out.print("Nombre: ");
                        nombrep = leer.readLine();
                        System.out.print("DNI: ");
                        dni = leer.readLine();
                        System.out.print("Estudios: ");
                        estudios = leer.readLine();
                        System.out.print("Sueldo: ");
                        sueldo = Integer.parseInt(leer.readLine());

                        os.writeObject(new Persona(nombrep, dni, estudios, sueldo));

                } else {
                    System.out.println("El fichero no existe");
                }
            } else {
                System.out.println("Escoja otra opcion");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }
}
