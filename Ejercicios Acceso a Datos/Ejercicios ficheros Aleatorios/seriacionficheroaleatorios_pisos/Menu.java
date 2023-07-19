/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionficheroaleatorios_pisos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author adrian
 */
public class Menu {
    public static byte menu() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        byte op;
        
        System.out.println("-------------------------");
        System.out.println("|      MENU             |");
        System.out.println("-------------------------");
        System.out.println("| Opcion 1: Crear       |");
        System.out.println("| Opcion 2: Altas       |");
        System.out.println("| Opcion 3: Bajas       |");
        System.out.println("| Opcion 4: listar      |");
        System.out.println("| Opcion 5: Modificar   |");
        System.out.println("| Opcion 6: Consulta    |");
        System.out.println("| Opcion 7: Cargar      |");
        System.out.println("| Opcion 8: Fin         |");
        System.out.println("-------------------------");
        System.out.print("Escoja un opcion: ");
        op = Byte.parseByte(leer.readLine());
        return op;
    }
}
