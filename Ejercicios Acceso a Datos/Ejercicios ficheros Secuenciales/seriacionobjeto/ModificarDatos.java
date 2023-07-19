/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionobjeto;

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
public class ModificarDatos {

    public static void Modificar() throws IOException, ClassNotFoundException {
        String nombreF;
        String nombre;
        String nombreC = null;
        String dni;
        String estudios;
        int sueldo;
        char resp = 0;
        boolean b = true;
        byte opcion = 0;

        Persona persona;
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        Scanner sc = new Scanner(System.in);
        File ficheroTemp = new File("nombreTemp");

        System.out.println("¿Desea modificar algun campo?");
        resp = leer.readLine().charAt(resp);
        try {
            System.out.println("Escriba el fichero en el que quiere modificar");
            nombreF = leer.readLine();
            
            if (resp == 's') {
                System.out.println("¿De quien quiere cambiar algun campo?");
                nombre = leer.readLine();
                File fichero = new File(nombreF);
                ois = new ObjectInputStream(new FileInputStream(nombreF));
                oos = new ObjectOutputStream(new FileOutputStream(ficheroTemp, true));
                
               do {
                    persona = (Persona) ois.readObject();
                    if (nombre.equalsIgnoreCase(persona.getNombre())) {
                        System.out.println("Escoja el campo a modificar");
                        System.out.println("Opcion 1: Nombre");
                        System.out.println("Opcion 2: DNI");
                        System.out.println("Opcion 3: Estudios");
                        System.out.println("Opcion 4: Sueldo");
                        System.out.println("Opcion 5: grabar");
                        opcion = sc.nextByte();
                        switch (opcion) {
                            case 1:
                                System.out.println("Escriba el nuevo nombre");
                                nombreC = leer.readLine();
                                persona.setNombre(nombreC);
                                break;
                            case 2:
                                System.out.println("Escriba el dni nuevo");
                                dni = leer.readLine();
                                persona.setDni(dni);
                                break;
                            case 3:
                                System.out.println("Escriba los estudios nuevos");
                                estudios = leer.readLine();
                                persona.setEstudio(estudios);
                                break;
                            case 4:
                                System.out.println("Escriba el nuevo sueldo");
                                sueldo = Integer.parseInt(leer.readLine());
                                persona.setSueldo(sueldo);
                                break;
                        }
                        oos.writeObject(persona);
                    } else {
                        oos.writeObject(persona);
                    }
               } while (true);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (ois != null) {
                ois.close();
            }
            if (oos != null) {
                oos.close();
            }
        }
    }
}
