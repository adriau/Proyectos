/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionficheroaleatorios_libros;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author adrian
 */
public class SeriacionFicheroAleatorios_Libros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        byte opcion;

        do {
            opcion = Menu.menu();

            switch (opcion) {
                case 1:
                    Metodos.crear();
                    break;
                case 2:
                    Metodos.altas();
                    break;
                case 3:
                    Metodos.baja();
                    break;
                case 4:
                    Metodos.listar();
                    break;
                case 5:
                    Metodos.modificar();
                    break;
                case 6:
                    Metodos.bajaFisica();
                    break;
                case 7:
                    System.out.println("Gracias por usar este programa");
                    break;
                default:
                    System.out.println("Esa opcion no es correcta. Prueba otra vez");
                    break;
            }
        } while (opcion != 7);

    }

}
