/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionobjeto_maquinaria;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author adrian
 */
public class AnhadirRegistro {

    public static void Anhadir() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        char resp = ' ';
        ObjectOutputStream oos = null;
        boolean b = true;
        byte opcion;
        Industrial industria = null;
        Agricola agricola = null;
        String nombreF;

        String marca;
        String modelo;
        float precio;
        String traccion;
        float impuestoEspecial;
        String potencia;
        float impuestoIndustrial;
        
        try {
            System.out.println("¿Desea escribir algun registro?");
            resp = leer.readLine().charAt(0);
            if (resp == 's') {
                System.out.println("Escriba el fichero en el que quiere añadir");
                nombreF = leer.readLine();
                File fichero = new File(nombreF);
                oos = new ObjectOutputStreamSinCabecera(new FileOutputStream(nombreF, true));
                if (fichero.exists()) {
                    System.out.println("¿Que tipo de maquinaria quiere registrar?");
                    System.out.println("opcion 1: Industrial");
                    System.out.println("opcion 2: Agricola");
                    opcion = sc.nextByte();

                    System.out.println("Escribe los siguientes campos: ");
                    System.out.print("Marca: ");
                    marca = leer.readLine();
                    System.out.print("Modelo: ");
                    modelo = leer.readLine();
                    System.out.print("Precio: ");
                    precio = Float.parseFloat(leer.readLine());

                    switch (opcion) {
                        case 1:
                            System.out.print("Potencia: ");
                            potencia = leer.readLine();
                            System.out.print("Impuesto Industrial: ");
                            impuestoIndustrial = Float.parseFloat(leer.readLine());

                            oos.writeObject(new Industrial(marca, modelo, precio, potencia, impuestoIndustrial));
                            break;
                        case 2:
                            System.out.print("Traccion: ");
                            traccion = leer.readLine();
                            System.out.print("Impuesto Especial: ");
                            impuestoEspecial = Float.parseFloat(leer.readLine());

                            oos.writeObject(new Agricola(marca, modelo, precio, traccion, impuestoEspecial));
                            break;
                    }
                }
            } else {
                System.out.println("Escoja otra opcion");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (oos != null) {
                oos.close();
            }
        }

    }
}
