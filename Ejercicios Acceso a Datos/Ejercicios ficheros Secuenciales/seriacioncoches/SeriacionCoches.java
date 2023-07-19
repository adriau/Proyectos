/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seriacioncoches;

import java.util.Scanner;

/**
 *
 * @author a13adrianac
 */
public class SeriacionCoches {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte opcion = 0;
        boolean b = true;
        try {
            do {
                System.out.println("*************************");
                System.out.println("Menu");
                System.out.println("Opcion 1: Crear fichero Coches");
                System.out.println("Opcion 2: Nuevas Altas");
                System.out.println("Opcion 3: Bajas Fisicas");
                System.out.println("Opcion 4: Visualizar");
                System.out.println("Opcion 5: Salir");
                System.out.println("*************************");
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
                        BorrarRegistro.Borrar();
                        break;
                    case 4:
                        VisualizarRegistros.Visualizar();
                        break;
                    case 5:
                        System.out.println("Gracias por usar este programa");
                        break;
                    default:
                        System.out.println("Esa opcion no es correcta. Prueba otra vez");
                        break;
                }
            } while (opcion != 5);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
