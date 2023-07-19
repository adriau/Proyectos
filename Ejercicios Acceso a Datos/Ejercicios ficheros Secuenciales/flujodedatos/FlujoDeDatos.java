/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flujodedatos;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author a13adrianac
 */
public class FlujoDeDatos {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        byte op;

        do {

            System.out.println("Menu");
            System.out.println("Opcion 1:  Grabar Campos");
            System.out.println("Opcion 2:  Leer Campos");
            System.out.println("Opcion 3:  Borrado Fisico");
            System.out.println("Opcion 4:  Fin");
            System.out.println("Escoge una opion:");

            op = sc.nextByte();

            switch (op) {
                case 1:
                    GrabarCampos.grabar();
                    break;
                case 2:
                    LeerCampos.Leer("datos.dat");
                    break;
                case 3:
                    BorrarCampos.Borrar();
                    break;
                case 4:
                    System.out.println("Gracias por usar este programa");
                    break;
                default:
                    System.out.println("Esa opcion no existe");
            }
        } while (op != 4);
    }
}
