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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author adrian
 */
public class VisualizarRegistro {

    public static void Visualizar() throws IOException, ClassNotFoundException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        ObjectInputStream ois = null;
        String nombreF;
        char resp = ' ';
        byte op;
        boolean b = true;
        Persona objTemp;
        try {
            System.out.println("Escoja el fichero");
            nombreF = leer.readLine();
            File fichero = new File(nombreF);
            if (fichero.exists()) {
                ois = new ObjectInputStream(new FileInputStream(fichero));
                do {
                    System.out.println();
                    System.out.println("Escoja tipo de persona que quiere visualizar");
                    System.out.println("Opcion 1: Alumno");
                    System.out.println("Opcion 2: Profesor");
                    System.out.println("Opcion 3: Fin");
                    op = Byte.parseByte(leer.readLine());
                    System.out.println();

                    switch (op) {
                        case 1:
                            do {
                                objTemp = (Persona) ois.readObject();
                                if (objTemp instanceof Alumnos) {

                                    System.out.println("--------------------------------------------------");
                                    System.out.println("Nombre del alumno: " + objTemp.getNombre());
                                    System.out.println("DNI del alumno: " + objTemp.getDni());

                                    ArrayList<AsignaturasNotas> Asnotas = ((Alumnos) objTemp).getAsnotas();
                                    for (int i = 0; i < Asnotas.size(); i++) {
                                        System.out.println("Curso: " + Asnotas.get(i).getCurso());
                                        System.out.println("Modulo: " + Asnotas.get(i).getNombre());
                                        System.out.println("Nota: " + Asnotas.get(i).getNota());
                                    }
                                    System.out.println("Nota media: " + ((Alumnos) objTemp).calculo());
                                    System.out.println("--------------------------------------------------");
                                }
                            } while (b);
                            break;
                        case 2:
                            do {
                                objTemp = (Persona) ois.readObject();
                                if (objTemp instanceof Profesores) {
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("Nombre del profesor: " + objTemp.getNombre());
                                    System.out.println("DNI del profesor: " + objTemp.getDni());
                                    System.out.println("Titulacion: " + ((Profesores) objTemp).getTitulacion());
                                    System.out.println("Salario del Profesor: " + ((Profesores) objTemp).getSueldo_base());
                                    System.out.println("Numero de trienios: " + ((Profesores) objTemp).getTrienio());
                                    System.out.println("Sueldo: " + ((Profesores) objTemp).calculo());

                                    ArrayList<Asignaturas> modulos = ((Profesores) objTemp).getModulos();
                                    for (int i = 0; i < modulos.size(); i++) {
                                        System.out.println("Curso: " + modulos.get(i).getCurso());
                                        System.out.println("Modulo: " + modulos.get(i).getNombre());
                                    }
                                    System.out.println("--------------------------------------------------");
                                }
                            } while (b);
                            break;
                        case 3:
                            System.out.println("Visualizacion terminada");
                            break;
                    }
                } while (op != 3);
            } else {
            }
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
