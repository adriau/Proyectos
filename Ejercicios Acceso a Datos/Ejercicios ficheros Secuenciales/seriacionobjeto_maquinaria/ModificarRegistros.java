/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionobjeto_maquinaria;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author a13adrianac
 */
public class ModificarRegistros {

    public static void Modificar() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        char resp = ' ';
        String nombreF;
        String ModeloC;
        File ficheroTemp = new File("modificar");
        byte op;
        boolean b = true;

        String marcaC;
        String modelo;
        float precio;
        String traccion;
        float impuestoEspecial;
        float impuestoIndustrial;
        String potencia;

        try {
            System.out.println("¿Desea modificar algun campo?");
            resp = leer.readLine().charAt(0);

            if (resp == 's') {
                System.out.println("Escoja el fichero a modificar");
                nombreF = leer.readLine();
                File fichero = new File(nombreF);
                ois = new ObjectInputStream(new FileInputStream(fichero));
                oos = new ObjectOutputStream(new FileOutputStream(ficheroTemp));

                if (fichero.exists()) {
                    System.out.println("Escoja el registro a modificar");
                    ModeloC = leer.readLine();

                    do {
                        Maquinaria objTemp = (Maquinaria) ois.readObject();
                        if (ModeloC.equalsIgnoreCase(objTemp.getModelo())) {
                            do {
                                System.out.println("Marca: " + objTemp.getMarca());
                                System.out.println("Modelo: " + objTemp.getModelo());
                                System.out.println("Precio: " + objTemp.getPrecio());

                                if (objTemp instanceof Industrial) {
                                    System.out.println("Potencia: " + ((Industrial) objTemp).getPotencia());
                                    System.out.println("Impuesto Industrial: " + ((Industrial) objTemp).getImpuestoIndustrial());
                                    System.out.println();
                                    System.out.println("Opcion 1: Marca");
                                    System.out.println("Opcion 2: Modelo");
                                    System.out.println("Opcion 3: Precio");
                                    System.out.println("Opcion 4: Potencia");
                                    System.out.println("Opcion 5: Impuesto Industrial");
                                    op = Byte.parseByte(leer.readLine());

                                    switch (op) {
                                        case 1:
                                            System.out.println("Escriba la nueva marca");
                                            marcaC = leer.readLine();
                                            objTemp.setMarca(marcaC);
                                            break;
                                        case 2:
                                            System.out.println("Escriba el nuevo modelo");
                                            modelo = leer.readLine();
                                            objTemp.setModelo(modelo);
                                            break;
                                        case 3:
                                            System.out.println("Escriba el precio nuevo");
                                            precio = Float.parseFloat(leer.readLine());
                                            objTemp.setPrecio(precio);
                                            break;
                                        case 4:
                                            System.out.println("Escriba el nuevo modelo");
                                            potencia = leer.readLine();
                                            ((Industrial) objTemp).setPotencia(potencia);
                                            break;
                                        case 5:
                                            System.out.println("Escriba el nuevo modelo");
                                            impuestoIndustrial = Float.parseFloat(leer.readLine());
                                            ((Industrial) objTemp).setImpuestoIndustrial(impuestoIndustrial);
                                            break;
                                        case 6:
                                            oos.writeObject(objTemp);
                                            b = false;
                                            break;
                                    }
                                } else {
                                    System.out.println("Traccion: " + ((Agricola) objTemp).getTraccion());
                                    System.out.println("Impuesto Especial: " + ((Agricola) objTemp).getImpuestoEspecial());
                                    System.out.println();
                                    System.out.println("Opcion 1: Marca");
                                    System.out.println("Opcion 2: Modelo");
                                    System.out.println("Opcion 3: Precio");
                                    System.out.println("Opcion 4: Traccion");
                                    System.out.println("Opcion 5: Impuesto Especial");
                                    op = Byte.parseByte(leer.readLine());

                                    switch (op) {
                                        case 1:
                                            System.out.println("Escriba la nueva marca");
                                            marcaC = leer.readLine();
                                            objTemp.setMarca(marcaC);
                                            break;
                                        case 2:
                                            System.out.println("Escriba el nuevo modelo");
                                            modelo = leer.readLine();
                                            objTemp.setMarca(modelo);
                                            break;
                                        case 3:
                                            System.out.println("Escriba el precio nuevo");
                                            precio = Float.parseFloat(leer.readLine());
                                            objTemp.setPrecio(precio);
                                            break;
                                        case 4:
                                            System.out.println("Escriba el nuevo modelo");
                                            traccion = leer.readLine();
                                            ((Agricola) objTemp).setTraccion(traccion);
                                            break;
                                        case 5:
                                            System.out.println("Escriba el nuevo modelo");
                                            impuestoEspecial = Float.parseFloat(leer.readLine());
                                            ((Agricola) objTemp).setImpuestoEspecial(impuestoEspecial);
                                            break;
                                        case 6:
                                            oos.writeObject(objTemp);
                                            b = false;
                                            break;
                                    }
                                }
                            } while (b == true);
                        }
                    } while (true);
                } else {
                    System.out.println("El fichero no existe");
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
            if (ois != null) {
                ois.close();
            }
        }
    }
}
