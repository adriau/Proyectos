/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacion_alumnoprofesor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author a13adrianac
 */
public class CrearFichero {

    public static void Crear() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        ObjectOutputStream oos = null;
        char resp = ' ';
        String nombreF = null;
        byte op;
        boolean b = true;
        
        try {
            System.out.println("¿Desea crear un nuevo fichero?");
            resp = leer.readLine().charAt(0);
            if (resp == 's') {
                System.out.println("Escriba un nombre para el fichero");
                nombreF = leer.readLine();
                File fichero = new File(nombreF);
                if (!fichero.exists()) {
                    fichero.createNewFile();
                    System.out.println("El fichero ha sido creado correctamente");
                } else {
                    System.out.print("El fichero ya existe. ");
                    System.out.print("¿Desea sobreescribirlo?");
                    resp = leer.readLine().charAt(0);
                    if (resp == 's') {
                        fichero.delete();
                        fichero.createNewFile();
                        System.out.println("El fichero se ha sobreescrito");

                    } else {
                        System.out.println("Escoja otra opcion");
                    }
                }
                if (resp == 's' || !fichero.exists()) {
                    oos = new ObjectOutputStream(new FileOutputStream(fichero));
                    do {
                        System.out.println("Escoja tipo de persona ha crear:");
                        System.out.println("Opcion 1: Alumno");
                        System.out.println("Opcion 2: Profesor");
                        op = Byte.parseByte(leer.readLine());
                        switch (op) {
                            case 1:
                                String nombreA;
                                String dniA;
                                String moduloA;
                                String cursoA;
                                float nota;
                                ArrayList<AsignaturasNotas> Asnotas = new ArrayList();

                                System.out.println("Escribe los siguientes campos");
                                System.out.print("Nombre del alumno: ");
                                nombreA = leer.readLine();
                                System.out.print("Dni del alumno: ");
                                dniA = leer.readLine();
                                do {
                                    System.out.print("Modulo en el que esta matriculado: ");
                                    moduloA = leer.readLine();
                                    System.out.print("Curso en el que esta matriculado: ");
                                    cursoA = leer.readLine();
                                    System.out.print("Nota del alumno en el modulo: ");
                                    nota = Float.parseFloat(leer.readLine());
                                    Asnotas.add(new AsignaturasNotas(moduloA, cursoA, nota));
                                    System.out.println("----------------------------------------");
                                    System.out.println("¿Desea añadir otra Asignatura?");
                                    resp = leer.readLine().charAt(0);
                                } while (resp == 's' || resp == 'S');

                                oos.writeObject(new Alumnos(dniA, nombreA, Asnotas));
                                System.out.println("Fin de la creacion");
                                b = false;
                                break;
                            case 2:
                                String nombreP;
                                String dniP;
                                String titulacion;
                                String cursoP;
                                String moduloP;
                                float salario_base;
                                byte trienio;
                                ArrayList<Asignaturas> modulos = new ArrayList();

                                System.out.println("Escribe los siguientes campos");
                                System.out.print("Nombre del profesor: ");
                                nombreP = leer.readLine();
                                System.out.print("Dni del profesor: ");
                                dniP = leer.readLine();
                                System.out.print("Titulacion del profesor: ");
                                titulacion = leer.readLine();
                                System.out.print("Salario del Profesor: ");
                                salario_base=Float.parseFloat(leer.readLine());
                                System.out.print("Numero de trienios: ");
                                trienio=Byte.parseByte(leer.readLine());
                                do {
                                    System.out.print("Curso en el que imparte: ");
                                    cursoP = leer.readLine();
                                    System.out.print("Modulo en el que imparte: ");
                                    moduloP = leer.readLine();
                                    modulos.add(new Asignaturas(moduloP, cursoP));
                                    System.out.println("----------------------------------------");
                                    System.out.println("¿Desea añadir otra Asignatura?");
                                    resp = leer.readLine().charAt(0);
                                } while (resp == 's' || resp == 'S');

                                oos.writeObject(new Profesores(dniP, nombreP, titulacion, modulos, salario_base, trienio));
                                System.out.println("Fin de la creacion");
                                b = false;
                                break;
                            default:
                                System.out.println("Esa opcion no es valida");
                                break;
                        }
                    } while (b);
                    
                }
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
