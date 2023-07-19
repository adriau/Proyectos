/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacion_personalmedicoadmin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author a13adrianac
 */
public class Seriacion_PersonalMedicoAdmin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        byte op;

        do {
            System.out.println("*************************");
            System.out.println("Menu");
            System.out.println("Opcion 1: Crear fichero");
            System.out.println("Opcion 2: Nuevas Altas");
            System.out.println("Opcion 3: Bajas Fisicas");
            System.out.println("Opcion 4: Busqueda dicotomica");
            System.out.println("Opcion 5: Visualizar");
            System.out.println("Opcion 6: Salir");
            System.out.println("*************************");
            System.out.print("Escoja una opcion: ");
            op = Byte.parseByte(leer.readLine());

            switch (op) {
                case 1:
                    Metodos.Crear();
                    break;
                case 2:
                    Metodos.Altas();
                    break;
                case 3:
                    Metodos.Borrar();
                    break;
                case 4:
                    Metodos.Buscar();
                    break;
                case 5:
                    Metodos.Visualizar();
                    break;
                case 6:
                    System.out.println("Gracias por usar este programa");
                    break;
                default:
                    System.out.println("Esa opcion no es correcta. Prueba otra vez");
                    break;
            }
        } while (op != 6);
    }
}
