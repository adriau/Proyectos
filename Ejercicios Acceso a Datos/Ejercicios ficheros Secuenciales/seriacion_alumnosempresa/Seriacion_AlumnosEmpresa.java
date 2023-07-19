/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacion_alumnosempresa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;


/**
 *
 * @author a13adrianac
 */
public class Seriacion_AlumnosEmpresa {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        ObjectInputStream ois = null;
        byte opcion = 0;
        boolean b = true;
        
        do {
            System.out.println("*************************");
            System.out.println("Menu");
            System.out.println("Opcion 1: Crear fichero");
            System.out.println("Opcion 2: Cargar datos");
            System.out.println("Opcion 3: Altas");
            System.out.println("Opcion 4: Bajas");
            System.out.println("Opcion 5: Modificar");
            System.out.println("Opcion 6: Busqueda dicotomica");
            System.out.println("Opcion 7: Consultar");
            System.out.println("Opcion 8: Grabar");
            System.out.println("Opcion 9: Fin");
            System.out.println("*************************");
            System.out.print("Escoja una opcion: ");
            opcion = Byte.parseByte(leer.readLine());
            switch (opcion) {
                case 1:
                    Metodos.Crear();
                    break;
                case 2:
                    Metodos.Cargar();
                    break;
                case 3:
                    Metodos.Altas();
                    break;
                case 4:
                    Metodos.Borrar();
                    break;
                case 5:
                    Metodos.Modificar();
                    break;
                case 6:
                    Metodos.busqueda();
                    break;
                case 7:
                    Metodos.Consultar();
                    break;
                case 8:
                    Metodos.grabar();
                    break;
                case 9:
                    System.out.println("Gracias por usar este programa");
                    break;
                default:
                    System.out.println("Esa opcion no es correcta. Prueba otra vez");
                    break;
            }
        } while (opcion != 9);
    }
}
