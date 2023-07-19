/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionficheroaleatorios_libros;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

/**
 *
 * @author adrian
 */
public class Metodos {

    static Libros libro;

    public static void crear() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        RandomAccessFile raf = null;
        
        char resp = ' ';
        try {
            System.out.println("¿Quiere crear un nuevo fichero?");
            resp = leer.readLine().charAt(0);
            if (resp == 's' || resp == 'S') {
                System.out.println("Escribe el nombre del fichero");
                String nombreF = leer.readLine();
                File fichero = new File(nombreF);
                raf = new RandomAccessFile(fichero, "rw");

                System.out.println("Fichero creado");
                System.out.println("---------------------------------");

                raf.seek(0 * totalRegistros(fichero));
                System.out.println("Rellene los siguientes campos");
                System.out.print("Codigo: ");
                String codigoL = leer.readLine();
                System.out.print("Nombre: ");
                String nombreL = leer.readLine();
                System.out.print("Precio: ");
                float precioL = Float.valueOf(leer.readLine());

                libro = new Libros(codigoL, nombreL, precioL);

                if (libro.tamaño() + 4 > Libros.longitudMaxima) {
                    System.out.println("Tamaño excedido");
                } else {
                    raf.writeUTF(codigoL);
                    raf.writeUTF(nombreL);
                    raf.writeFloat(precioL);
                }
            }
        } catch (NullPointerException e) {
        } finally {
            if (raf != null) {
                raf.close();
            }
        }

    }

    public static void altas() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        char resp = ' ';
        byte num;
        RandomAccessFile raf = null;

        try {
            System.out.println("¿Quiere añadir un nuevo registro?");
            resp = leer.readLine().charAt(0);
            if (resp == 's' || resp == 'S') {
                System.out.println("Escoja el fichero");
                String nombreF = leer.readLine();
                File fichero = new File(nombreF);
                raf = new RandomAccessFile(fichero, "rw");

                System.out.println("¿Cuantos registros quiere añadir?");
                num = Byte.parseByte(leer.readLine());
                for (int i = 0; i < num; i++) {
                    if (i >= 0 && i <= totalRegistros(fichero)) {

                        raf.seek(totalRegistros(fichero) * libro.longitudMaxima);
                        System.out.println("Rellene los siguientes campos");
                        System.out.print("Codigo: ");
                        String codigoL = leer.readLine();
                        System.out.print("Nombre: ");
                        String nombreL = leer.readLine();
                        System.out.print("Precio: ");
                        float precioL = Float.valueOf(leer.readLine());

                        libro = new Libros(codigoL, nombreL, precioL);

                        if (libro.tamaño() + 4 > Libros.longitudMaxima) {
                            System.out.println("Tamaño excedido");
                        } else {
                            raf.writeUTF(codigoL);
                            raf.writeUTF(nombreL);
                            raf.writeFloat(precioL);
                        }
                    } else {
                    }
                }
            }
        } catch (NullPointerException e) {
        } finally {
            if (raf != null) {
                raf.close();
            }
        }
    }

    public static void listar() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        char resp = ' ';
        RandomAccessFile raf = null;

        System.out.println("¿Quiere listar los registros registro?");
        resp = leer.readLine().charAt(0);

        if (resp == 's' || resp == 'S') {
            System.out.println("Escoja el fichero");
            String nombreF = leer.readLine();
            File fichero = new File(nombreF);
            raf = new RandomAccessFile(fichero, "rw");

            for (int i = 0; i < totalRegistros(fichero); i++) {
                if (i >= 0 && i < totalRegistros(fichero)) {
                    raf.seek(i * libro.longitudMaxima);

                    String codigo, nombre;
                    float precio;

                    codigo = raf.readUTF();
                    nombre = raf.readUTF();
                    precio = raf.readFloat();

                    System.out.println("-------------------------------");
                    System.out.println("Codigo: " + codigo);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Precio: " + precio + " Euros");
                    System.out.println("-------------------------------");
                }
            }
        }
        if (raf != null) {
            raf.close();
        }
    }

    public static void baja() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        char resp = ' ';
        RandomAccessFile raf = null;

        System.out.println("¿Quieres dar de baja algun registro?");
        resp = leer.readLine().charAt(0);
        if (resp == 's' || resp == 'S') {
            System.out.println("Escoja el fichero");
            String nombreF = leer.readLine();
            File fichero = new File(nombreF);
            raf = new RandomAccessFile(fichero, "rw");

            for (int i = 0; i < totalRegistros(fichero); i++) {
                if (i >= 0 && i <= totalRegistros(fichero)) {
                    raf.seek(i * libro.longitudMaxima);

                    String codigo, nombre;
                    float precio;

                    codigo = raf.readUTF();
                    nombre = raf.readUTF();
                    precio = raf.readFloat();
                    System.out.println("-------------------------------");
                    System.out.println("Codigo: " + codigo);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Precio: " + precio + " Euros");
                    System.out.println("-------------------------------");

                    System.out.println("¿Dar de baja este registro?");
                    resp = leer.readLine().charAt(0);
                    if (resp == 's' || resp == 'S') {
                        raf.seek(i * libro.longitudMaxima);

                        float precioL = 0;

                        raf.writeUTF(codigo);
                        raf.writeUTF(nombre);
                        raf.writeFloat(precioL);
                    }
                } else {
                }
            }
        } else {
        }
        if (raf != null) {
            raf.close();
        }
    }

    public static void modificar() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        char resp = ' ';
        RandomAccessFile raf = null;
        String codigo;
        String nombre;
        float precio;

        System.out.println("¿Quieres modificar algun registro?");
        resp = leer.readLine().charAt(0);
        if (resp == 's' || resp == 'S') {
            System.out.println("Indica el fichero en el que modificar");
            String nombreF = leer.readLine();
            File fichero = new File(nombreF);
            raf = new RandomAccessFile(fichero, "rw");

            if (fichero.exists()) {
                System.out.println("Indica el registro a modificar");
                String campo = leer.readLine();
                for (int i = 0; i < totalRegistros(fichero); i++) {
                    raf.seek(i * libro.longitudMaxima);
                    codigo = raf.readUTF();
                    if (codigo.compareToIgnoreCase(campo) == 0) {
                        nombre = raf.readUTF();
                        precio = raf.readFloat();

                        System.out.println("-------------------------------");
                        System.out.println("Codigo: " + codigo);
                        System.out.println("Nombre: " + nombre);
                        System.out.println("Precio: " + precio + " Euros");
                        System.out.println("-------------------------------");
                        System.out.println("¿Quieres modificar este registro?");
                        resp = leer.readLine().charAt(0);

                        if (resp == 's' || resp == 'S') {
                            raf.seek(i * libro.longitudMaxima);
                            System.out.println("Modificar codigo");
                            resp = leer.readLine().charAt(0);
                            if (resp == 's' || resp == 'S') {
                                System.out.println("Indica el codigo nuevo");
                                codigo = leer.readLine();
                            }
                            System.out.println("Modificar nombre");
                            resp = leer.readLine().charAt(0);
                            if (resp == 's' || resp == 'S') {
                                System.out.println("Indica el nombre nuevo");
                                nombre = leer.readLine();
                            }
                            System.out.println("Modificar precio");
                            resp = leer.readLine().charAt(0);
                            if (resp == 's' || resp == 'S') {
                                System.out.println("Indica el precio nuevo");
                                precio = Float.parseFloat(leer.readLine());
                            }

                            libro = new Libros(codigo, nombre, precio);

                            if (libro.tamaño() + 4 > Libros.longitudMaxima) {
                                System.out.println("Tamaño excedido");
                            } else {
                                raf.writeUTF(codigo);
                                raf.writeUTF(nombre);
                                raf.writeFloat(precio);
                            }
                        }
                    }
                }
            } else {
            }
        } else {
        }
        if (raf != null) {
            raf.close();
        }
    }

    public static void bajaFisica() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        char resp = ' ';
        RandomAccessFile raf = null;
        RandomAccessFile raf2 = null;
        String codigo;
        String nombre;
        float precio;

        try {
            System.out.println("¿Quieres borrar algun registro?");
            resp = leer.readLine().charAt(0);

            if (resp == 's' || resp == 'S') {
                System.out.println("Indica el fichero en el que quieres borrar");
                String nombreF = leer.readLine();
                File fichero = new File(nombreF);
                File ficheroTemp = new File("nombreTemp");
                raf = new RandomAccessFile(fichero, "r");
                raf2 = new RandomAccessFile(ficheroTemp, "rw");

                if (fichero.exists()) {
                    System.out.println("Indica el registro a borrar");
                    String campo = leer.readLine();
                    for (int i = 0; i < totalRegistros(fichero); i++) {
                        raf.seek(i * libro.longitudMaxima);
                        codigo = raf.readUTF();
                        if (campo.compareToIgnoreCase(codigo) == 0) {
                            nombre = raf.readUTF();
                            precio = raf.readFloat();

                            System.out.println("-------------------------------");
                            System.out.println("Codigo: " + codigo);
                            System.out.println("Nombre: " + nombre);
                            System.out.println("Precio:  " + precio + " Euros");
                            System.out.println("-------------------------------");

                            System.out.println("¿Seguro que quiere borrar este registro?");
                            resp = leer.readLine().charAt(0);
                            if (resp == 's' || resp == 'S') {
                                for (int j = 0; j < totalRegistros(fichero); j++) {
                                    raf.seek(j * libro.longitudMaxima);

                                    String codigoC = raf.readUTF();
                                    String nombreC = raf.readUTF();
                                    float precioC = raf.readFloat();

                                    if (campo.compareToIgnoreCase(codigoC) != 0) {
                                        raf2.seek(j * libro.longitudMaxima);

                                        raf2.writeUTF(codigoC);
                                        raf2.writeUTF(nombreC);
                                        raf2.writeFloat(precioC);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (EOFException e) {
        } finally {
            if (raf != null) {
                raf.close();
            }
            if (raf2 != null) {
                raf2.close();           
            }
        }
    }

    public static int totalRegistros(File fichero) {
        int numeroRegistros = (int) Math.ceil((double) fichero.length() / (double) libro.longitudMaxima);

        return numeroRegistros;
    }
}
