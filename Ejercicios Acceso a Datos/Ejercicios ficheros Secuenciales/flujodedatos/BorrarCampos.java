/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flujodedatos;

import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author adrian
 */
public class BorrarCampos {

    public static void Borrar() throws FileNotFoundException {
        File fichero = new File("datos.dat");
        if (fichero.exists()) {
            fichero.delete();
            System.out.println("El fichero ha sido eliminado");
        } else {
            System.out.println("El fichero no existe");
        }

    }
}
