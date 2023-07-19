/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flujodedatos;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author a13adrianac
 */
public class GrabarCampos {

    public static void grabar() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        DataOutputStream ds = new DataOutputStream(new FileOutputStream("datos.dat", true));
        byte resp;

        try {
            String nombre, direccion;
            long telefono;

            do {
                System.out.println("nombre:   ");
                nombre = leer.readLine();
                System.out.println("direccion:   ");
                direccion = leer.readLine();
                System.out.println("telefono:    ");
                telefono = Long.parseLong(leer.readLine());

                ds.writeUTF(nombre);
                ds.writeUTF(direccion);
                ds.writeLong(telefono);

                System.out.println("¿desea escribir otro registro? (s(1)/n(0))");
                resp = sc.nextByte();
            } while (resp == 1);

        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }
}
