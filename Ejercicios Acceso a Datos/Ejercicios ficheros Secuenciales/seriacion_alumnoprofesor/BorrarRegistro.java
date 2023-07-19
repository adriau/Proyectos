/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacion_alumnoprofesor;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author adrian
 */
public class BorrarRegistro {

    public static void Borrar() throws IOException, ClassNotFoundException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        //ArrayList<AsignaturasNotas> Asnotas = null;
        File ficheroTemp = new File("nombreTemp");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        Persona objTemp;
        String nombreF;
        String dniC;
        char resp = ' ';
        byte op;
        boolean b = true;

        try {
            System.out.println("Escoja el fichero");
            nombreF = leer.readLine();
            File fichero = new File(nombreF);
            ois = new ObjectInputStream(new FileInputStream(fichero));
            oos = new ObjectOutputStream(new FileOutputStream(ficheroTemp));
            if (fichero.exists()) {
                System.out.println("¿Desea borrar algun registro?");
                resp = leer.readLine().charAt(0);
                if (resp == 's' || resp == 'S') {
                    do {
                        System.out.println("¿Que tipo de registro quiere borrar?");
                        System.out.println("Opcion 1: Alumno");
                        System.out.println("Opcion 2: Profesor");
                        System.out.println("Opcion 3: Fin");
                        op = Byte.parseByte(leer.readLine());
                        switch (op) {
                            case 1:
                                System.out.println("Indique el dni del alumno que quiere borrar");
                                dniC = leer.readLine();
                                do {
                                    objTemp = (Persona) ois.readObject();
                                    if (!dniC.equalsIgnoreCase(objTemp.getDni())) {
                                        oos.writeObject(objTemp);

                                    }
                                } while (b);

                                break;
                            case 2:
                                System.out.println("Indique el dni del profesor que quiere borrar");
                                dniC = leer.readLine();
                                objTemp = (Persona) ois.readObject();
                                do {
                                    objTemp = (Persona) ois.readObject();
                                    if (!dniC.equalsIgnoreCase(objTemp.getDni())) {
                                        oos.writeObject(objTemp);

                                    }
                                } while (b);
                                break;
                            case 3:
                                System.out.println("Fin de borrado");
                                break;
                            default:
                                System.out.println("Esa opcion no es valida");
                                break;
                        }

                    } while (op != 3);
                } else {
                    System.out.println("Escoja otra opcion");
                }
            } else {
                System.out.println("El fichero no existe");
            }
        } catch (EOFException e) {
            System.out.println("El registro se ha eliminado.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (ois != null && oos != null) {
                    ois.close();
                    oos.close();
                }
//                fichero.delete();
//                ficheroTemp.renameTo(fichero);
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
