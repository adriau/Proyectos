/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionobjeto;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author a13adrianac
 */
public class SeriacionObjeto {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        byte opcion = 0;
        boolean b = true;

        do {
            System.out.println("*************************");
            System.out.println("Menu");
            System.out.println("Opcion 1: Crear");
            System.out.println("Opcion 2: Añadir");
            System.out.println("Opcion 3: Modificar");
            System.out.println("Opcion 4: Borrar");
            System.out.println("Opcion 5: Recuperar");
            System.out.println("Opcion 6: Salir");
            System.out.println("*************************");
            System.out.println();
            System.out.print("Escoja una opcion: ");
            opcion = sc.nextByte();
            switch (opcion) {
                case 1:
                    CrearFichero.Crear();
                    break;
                            
                case 2:
                    AnhadirRegistro.Anhadir();
                    break;
                case 3:
                    ModificarDatos.Modificar();
                    break;
                case 4:
                    BorradoFisico.Borrar();
                    break;
                case 5:
                    RecuperarDatos.Recuperar();
                    break;
                case 6:
                    System.out.println("Gracias por usar este programa");
                    break;
            }
        } while (opcion != 6);
    }
}
