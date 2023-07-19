/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacion_alumnoprofesor;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adrian
 */
public class Seriacion_AlumnoProfesor {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        byte opcion = 0;
        boolean b = true;
        do {
            try {
                System.out.println("*************************");
                System.out.println("Menu");
                System.out.println("Opcion 1: Crear fichero");
                System.out.println("Opcion 2: Nuevas Altas");
                System.out.println("Opcion 3: Bajas Fisicas");
                System.out.println("Opcion 4: Modificar");
                System.out.println("Opcion 5: Visualizar");
                System.out.println("Opcion 6: Salir");
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
                        ModificarRegistro.Modificar();
                        break;
                    case 5:
                        VisualizarRegistro.Visualizar();
                        break;
                    case 6:
                        System.out.println("Gracias por usar este programa");
                        break;
                    default:
                        System.out.println("Esa opcion no es correcta. Prueba otra vez");
                        break;
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Seriacion_AlumnoProfesor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (opcion != 6);
    }
}
