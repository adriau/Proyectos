/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flujodedatos;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author a13adrianac
 */
public class LeerCampos {

    public static void Leer(String nombreFichero) throws IOException {
        DataInputStream dis = null;
        File fichero = null;

        try {
            fichero = new File(nombreFichero);

            if (fichero.exists()) {
                dis = new DataInputStream(new BufferedInputStream(new FileInputStream(fichero)));

                String nombre, direccion;
                long telefono;

                do {
                    nombre = dis.readUTF();
                    direccion = dis.readUTF();
                    telefono = dis.readLong();

                    System.out.println(nombre);
                    System.out.println(direccion);
                    System.out.println(telefono);
                    System.out.println();
                } while (true);
            } else {
                System.out.println("El fichero no existe");
            }
        } catch (EOFException e) {
            System.out.println("Fin del listado");
        } finally {
            if (dis != null) {
                dis.close();
            }
        }
    }
}
