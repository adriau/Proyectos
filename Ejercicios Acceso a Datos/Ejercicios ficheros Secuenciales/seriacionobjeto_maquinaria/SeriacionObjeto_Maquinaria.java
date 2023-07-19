/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionobjeto_maquinaria;

import java.util.Scanner;

/**
 *
 * @author adrian
 */
public class SeriacionObjeto_Maquinaria {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte opcion = 0;
        boolean b = true;
        try {
            do {
                System.out.println("*************************");
                System.out.println("Menu");
                System.out.println("Opcion 1: Crear");
                System.out.println("Opcion 2: Nuevas Altas");
                System.out.println("Opcion 3: Bajas Fisicas");
                System.out.println("Opcion 4: Modificar");
                System.out.println("Opcion 5: Consultar por campo");
                System.out.println("Opcion 6: Visualizar todo");
                System.out.println("Opcion 7: Salir");
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
                        BajaFisica.Baja();
                        break;
                    case 4:
                        ModificarRegistros.Modificar();
                        break;
                    case 5:
                        VisualizarCampo.VisualizarC();
                        break;
                    case 6:
                        VisualizarRegistros.Visualizar();
                        break;
                    case 7:
                        System.out.println("Gracias por usar este programa");
                        break;
                }
            } while (opcion != 7);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
