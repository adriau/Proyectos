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
 * @author a13adrianac
 */
public class ModificarRegistro {

    public static void Modificar() throws IOException, ClassNotFoundException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        String nombreF;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        File ficheroTemp = new File("modificado");
        char resp = ' ';
        String dniC;
        byte op;
        Persona objTemp;
        boolean b = true;

        try {
            System.out.println("Escoja el fichero");
            nombreF = leer.readLine();
            File fichero = new File(nombreF);
            ois = new ObjectInputStream(new FileInputStream(fichero));
            oos = new ObjectOutputStream(new FileOutputStream(ficheroTemp));
            if (fichero.exists()) {
                System.out.println("¿Desea modificar algun registro?");
                resp = leer.readLine().charAt(0);
                if (resp == 's' || resp == 'S') {
                    do {
                        System.out.println("Escoja tipo de persona ha modificar");
                        System.out.println("Opcion 1: Alumno");
                        System.out.println("Opcion 2: Profesor");
                        System.out.println("Opcion 3: Fin");
                        op = Byte.parseByte(leer.readLine());

                        switch (op) {
                            case 1:
                                System.out.println("Escoja el registro a modificar");
                                dniC = leer.readLine();
                                do {
                                    objTemp = (Persona) ois.readObject();
                                    if (dniC.equalsIgnoreCase(objTemp.getDni())) {
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
                                            System.out.println("--------------------------------------------------");

                                            do {
                                                System.out.println("Escoja el campo a modificar");
                                                System.out.println("Opcion 1: Nombre");
                                                System.out.println("Opcion 2: DNI");
                                                System.out.println("Opcion 3: Curso");
                                                System.out.println("Opcion 4: Modulo");
                                                System.out.println("Opcion 5: Nota");
                                                System.out.println("Opcion 6: Fin y guardado");
                                                op = Byte.parseByte(leer.readLine());
                                                switch (op) {
                                                    case 1:
                                                        System.out.println("Escriba el nombre nuevo");
                                                        String nombreNuevo = leer.readLine();
                                                        objTemp.setNombre(nombreNuevo);
                                                        break;
                                                    case 2:
                                                        System.out.println("Escriba el dni nuevo");
                                                        String dniNuevo = leer.readLine();
                                                        objTemp.setDni(dniNuevo);
                                                        break;
                                                    case 3:
                                                        for (int i = 0; i < Asnotas.size(); i++) {
                                                            System.out.println("Curso: " + Asnotas.get(i).getCurso());
                                                            System.out.println("¿Desea modificar este curso?");
                                                            resp = leer.readLine().charAt(0);
                                                            if (resp == 's' || resp == 'S') {
                                                                System.out.println("Escribe el nuevo curso");
                                                                String cursoNuevo = leer.readLine();
                                                                Asnotas.get(i).setCurso(cursoNuevo);
                                                            } else {
                                                            }
                                                        }
                                                        break;
                                                    case 4:
                                                        for (int i = 0; i < Asnotas.size(); i++) {
                                                            System.out.println("Modulo: " + Asnotas.get(i).getNombre());
                                                            System.out.println("¿Desea modificar este Modulo?");
                                                            resp = leer.readLine().charAt(0);
                                                            if (resp == 's' || resp == 'S') {
                                                                System.out.println("Escribe el nuevo Modulo");
                                                                String moduloNuevo = leer.readLine();
                                                                Asnotas.get(i).setNombre(moduloNuevo);
                                                            } else {
                                                            }
                                                        }
                                                        break;
                                                    case 5:
                                                        for (int i = 0; i < Asnotas.size(); i++) {
                                                            System.out.println("La nota de " + Asnotas.get(i).getNombre() + " es " + Asnotas.get(i).getNota());
                                                            System.out.println("¿Desea modificar esta Nota?");
                                                            resp = leer.readLine().charAt(0);
                                                            if (resp == 's' || resp == 'S') {
                                                                System.out.println("Escribe la nota nueva");
                                                                float notaNuevo = Float.parseFloat(leer.readLine());
                                                                Asnotas.get(i).setNota(notaNuevo);
                                                            }
                                                        }
                                                        break;
                                                    case 6:
                                                        System.out.println("Fin y guardado de la modificacion");

                                                        break;
                                                    default:
                                                        System.out.println("Esa opcion no es valida");
                                                        break;
                                                }
                                            } while (op != 6);
                                        }
                                    }
                                    oos.writeObject(objTemp);
                                } while (b);
                                break;
                            case 2:
                                System.out.println("Escoja el registro a modificar");
                                dniC = leer.readLine();
                                do {
                                    objTemp = (Persona) ois.readObject();
                                    if (dniC.equalsIgnoreCase(objTemp.getDni())) {
                                        if (objTemp instanceof Profesores) {
                                            System.out.println("--------------------------------------------------");
                                            System.out.println("Nombre del profesor: " + objTemp.getNombre());
                                            System.out.println("DNI del profesor: " + objTemp.getDni());
                                            System.out.println("Titulacion del profesor: " + ((Profesores) objTemp).getTitulacion());
                                            ArrayList<Asignaturas> modulos = ((Profesores) objTemp).getModulos();
                                            for (int i = 0; i < modulos.size(); i++) {
                                                System.out.println("Curso: " + modulos.get(i).getCurso());
                                                System.out.println("Modulo: " + modulos.get(i).getNombre());
                                            }
                                            System.out.println("--------------------------------------------------");

                                            do {
                                                System.out.println("Escoja el campo a modificar");
                                                System.out.println("Opcion 1: Nombre");
                                                System.out.println("Opcion 2: DNI");
                                                System.out.println("Opcion 3: Titulacion");
                                                System.out.println("Opcion 4: Sueldo");
                                                System.out.println("Opcion 5: Trienios");
                                                System.out.println("Opcion 6: Curso");
                                                System.out.println("Opcion 7: Modulo");
                                                System.out.println("Opcion 8: Fin y guardado");
                                                op = Byte.parseByte(leer.readLine());
                                                switch (op) {
                                                    case 1:
                                                        System.out.println("Escriba el nombre nuevo");
                                                        String nombreNuevo = leer.readLine();
                                                        objTemp.setNombre(nombreNuevo);
                                                        break;
                                                    case 2:
                                                        System.out.println("Escriba el dni nuevo");
                                                        String dniNuevo = leer.readLine();
                                                        objTemp.setDni(dniNuevo);
                                                        break;
                                                    case 3:
                                                        System.out.println("Escriba la nueva titulacion");
                                                        String titulacionNueva = leer.readLine();
                                                        ((Profesores) objTemp).setTitulacion(titulacionNueva);
                                                        break;
                                                    case 4:
                                                        System.out.println("Escribe el sueldo nuevo");
                                                        float salarioNuevo = Float.parseFloat(leer.readLine());
                                                        ((Profesores) objTemp).setSueldo_base(salarioNuevo);
                                                        break;
                                                    case 5:
                                                        System.out.println("Escriba la nueva titulacion");
                                                        byte trienioNuevo = Byte.parseByte(leer.readLine());
                                                        ((Profesores) objTemp).setTrienio(trienioNuevo);
                                                        break;
                                                    case 6:
                                                        for (int i = 0; i < modulos.size(); i++) {
                                                            System.out.println("Curso: " + modulos.get(i).getCurso());
                                                            System.out.println("¿Desea modificar este curso?");
                                                            resp = leer.readLine().charAt(0);
                                                            if (resp == 's' || resp == 'S') {
                                                                System.out.println("Escribe el nuevo curso");
                                                                String cursoNuevo = leer.readLine();
                                                                modulos.get(i).setCurso(cursoNuevo);
                                                            } else {
                                                            }
                                                        }
                                                        break;
                                                    case 7:
                                                        for (int i = 0; i < modulos.size(); i++) {
                                                            System.out.println("Modulo: " + modulos.get(i).getNombre());
                                                            System.out.println("¿Desea modificar este Modulo?");
                                                            resp = leer.readLine().charAt(0);
                                                            if (resp == 's' || resp == 'S') {
                                                                System.out.println("Escribe el nuevo Modulo");
                                                                String moduloNuevo = leer.readLine();
                                                                modulos.get(i).setNombre(moduloNuevo);
                                                            } else {
                                                            }
                                                        }
                                                        break;
                                                    case 8:
                                                        System.out.println("Fin y guardado de la modificacion");
                                                        break;
                                                    default:
                                                        System.out.println("Esa opcion no es valida");
                                                        break;
                                                }
                                            } while (op != 8);
                                        }
                                    }
                                    oos.writeObject(objTemp);
                                } while (b);
                                break;
                            case 3:
                                System.out.println("Fin de modificacion");
                                break;
                            default:
                                System.out.println("Esa opcion no es valida");
                                break;
                        }
                    } while (op != 3);
                } else {
                }
            } else {
            }
        } catch (EOFException e) {
            System.out.println("Tarea realizada");
        } catch (ClassNotFoundException e) {
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
