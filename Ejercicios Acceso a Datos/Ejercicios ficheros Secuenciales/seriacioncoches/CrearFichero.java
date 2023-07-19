/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacioncoches;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

/**
 *
 * @author a13adrianac
 */
public class CrearFichero {

    public static void Crear() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        ObjectOutputStream oos = null;
        String nombreF = null;
        char resp = ' ';
        boolean b = true;

        String marca;
        String modelo;
        String marcaRueda;
        String dimension;

        try {
            System.out.println("¿Desea crear un fichero?");
            resp = leer.readLine().charAt(0);

            if (resp == 's') {
                do {
                    System.out.println("Escriba un nombre para el fichero");
                    nombreF = leer.readLine();
                    File fichero = new File(nombreF);
                    if (!fichero.exists()) {
                        fichero.createNewFile();
                        System.out.println("El fichero " + nombreF + " Se ha creado correctamente");

                    } else {
                        System.out.println("El fichero ya existe. ¿Desea Sobreescribirlo?");
                        resp = leer.readLine().charAt(0);
                        if (resp == 's') {
                            fichero.delete();
                            fichero.createNewFile();
                        } else {
                            b = false;
                        }
                    }
                    System.out.println();
                    System.out.println("¿Desea añadir algun registro");
                    resp = leer.readLine().charAt(0);
                    oos = new ObjectOutputStream(new FileOutputStream(nombreF));
                    if (resp == 's') {
                        System.out.println("Cubra los siguientes campos");
                        System.out.print("Marca: ");
                        marca = leer.readLine();
                        System.out.print("Modelo: ");
                        modelo = leer.readLine();
                        System.out.print("Marca Rueda: ");
                        marcaRueda = leer.readLine();
                        System.out.print("Dimension: ");
                        dimension = leer.readLine();

                        oos.writeObject(new Coche(marca, modelo, new Rueda(marcaRueda, dimension)));
                        b = false;
                    } else {
                        System.out.println("Escoja otra opcion");
                    }

                } while (b);
            } else {
                System.out.println("Escoja otra opcion");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (oos != null) {
                oos.close();
            }
        }
    }
}
