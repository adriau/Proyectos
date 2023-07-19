/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacion_personalmedicoadmin;

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a13adrianac
 */
public class Metodos {

    private static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<Medico> arrayMedico = new ArrayList();

    public static void Crear() throws IOException {
        char resp = ' ';
        String nombreF;
        byte op;
        boolean b = true;
        ArrayList<Enfermos> arrayEnfer = new ArrayList();

        ObjectOutputStream oos = null;
        System.out.println("¿Quiere crear un fichero?");
        resp = leer.readLine().charAt(0);
        if (resp == 's' || resp == 'S') {
            System.out.println("Indica un nombre para el fichero");
            nombreF = leer.readLine();
            File fichero = new File(nombreF);
            if (!fichero.exists()) {
                fichero.createNewFile();
                System.out.println("El fichero fue creado correctamente");
                System.out.println("---------------------------------------");
                oos = new ObjectOutputStream(new FileOutputStream(fichero));
                do {
                    System.out.println("Escoja registro añadir");
                    System.out.println("Opcion 1: Medico");
                    System.out.println("Opcion 2: Administrativos");
                    System.out.print("Opcion: ");
                    op = Byte.parseByte(leer.readLine());
                    switch (op) {
                        case 1:
                            System.out.println("------------------------------------");
                            System.out.println("Rellena los siguientes campos");
                            System.out.print("Codigo: ");
                            String codigoM = leer.readLine();
                            System.out.print("Nombre: ");
                            String nombreM = leer.readLine();
                            System.out.print("E-Mail: ");
                            String emailM = leer.readLine();
                            System.out.print("Especialidad: ");
                            String especialidad = leer.readLine();
                            System.out.print("Sueldo: ");
                            float sueldoM = Float.parseFloat(leer.readLine());
                            System.out.print("Horas extra: ");
                            int horasExtra = Integer.parseInt(leer.readLine());
                            do {
                                System.out.println("-----------------");
                                System.out.println("Pacientes: ");
                                System.out.print("Dni paciente: ");
                                String dniP = leer.readLine();
                                System.out.print("Nombre paciente: ");
                                String nombreP = leer.readLine();
                                System.out.print("Seguro paciente: ");
                                String seguro = leer.readLine();
                                System.out.print("Patologia paciente: ");
                                String patologia = leer.readLine();
                                System.out.println("-----------------");

                                System.out.println("¿Quiere añadir otro paciente?");
                                resp = leer.readLine().charAt(0);
                                arrayEnfer.add(new Enfermos(dniP, nombreP, seguro, patologia));
                            } while (resp == 's' || resp == 'S');

                            System.out.println("------------------------------------");
                            oos.writeObject(new Medico(especialidad, horasExtra, sueldoM, codigoM, nombreM, emailM, arrayEnfer));

                            b = false;
                            break;
                        case 2:
                            System.out.println("------------------------------------");
                            System.out.println("Rellena los siguientes campos");
                            System.out.print("Codigo: ");
                            String codigoA = leer.readLine();
                            System.out.print("Nombre: ");
                            String nombreA = leer.readLine();
                            System.out.print("E-Mail: ");
                            String emailA = leer.readLine();
                            System.out.print("Categoria: ");
                            String categoria = leer.readLine();
                            System.out.print("Sueldo: ");
                            float sueldoA = Integer.parseInt(leer.readLine());
                            oos.writeObject(new Administrativos(categoria, sueldoA, codigoA, nombreA, emailA));
                            b = false;
                            break;
                        default:
                            System.out.println("Esa opcion no es correcta");
                            break;
                    }
                } while (b);
                if (oos != null) {
                    oos.close();
                }
            } else {
                System.out.println("El fichero ya existe");
            }
        } else {
            System.out.println("Volviendo al menu. Escoja otra opcion");
        }
    }

    public static void Visualizar() throws IOException {
        char resp = ' ';
        ObjectInputStream ois = null;
        byte op;
        boolean b = true;
        ArrayList<Enfermos> arrayEnfer = new ArrayList();
        Personal objTemp;

        try {
            System.out.println("¿Quiere visualizar algun registro?");
            resp = leer.readLine().charAt(0);
            if (resp == 's' || resp == 'S') {
                System.out.println("Indica el archivo del que quiere visualizar");
                String nombreF = leer.readLine();
                File fichero = new File(nombreF);
                ois = new ObjectInputStream(new FileInputStream(fichero));
                do {
                    System.out.println("----------------------------");
                    System.out.println("Escoja tipo de registro");
                    System.out.println("Opcion 1: Medico");
                    System.out.println("Opcion 2: Administrativo");
                    System.out.println("Opcion 3: Fin");
                    System.out.print("Opcion: ");
                    op = Byte.parseByte(leer.readLine());

                    switch (op) {
                        case 1:
                            do {
                                objTemp = (Personal) ois.readObject();
                                if (objTemp instanceof Medico) {
                                    System.out.println("-------------------------------------------------");
                                    System.out.println("Codigo: " + ((Medico) objTemp).getCodigo());
                                    System.out.println("Nombre: " + ((Medico) objTemp).getNombre());
                                    System.out.println("E-Mail: " + ((Medico) objTemp).getEmail());
                                    System.out.println("Especialidad: " + ((Medico) objTemp).getEspecialidad());
                                    System.out.println("Sueldo: " + ((Medico) objTemp).getSueldo());
                                    System.out.println("Horas extra: " + ((Medico) objTemp).getNumHorasExtra());
                                    System.out.println("Nomina: " + ((Medico) objTemp).nomina());
                                    arrayEnfer = ((Medico) objTemp).getArrayEnfer();
                                    for (int i = 0; i < arrayEnfer.size(); i++) {
                                        System.out.println("=======================================");
                                        System.out.println("Paciente:");
                                        System.out.println("Dni: " + ((Medico) objTemp).getArrayEnfer().get(i).getDni());
                                        System.out.println("Nombre: " + ((Medico) objTemp).getArrayEnfer().get(i).getNombre());
                                        System.out.println("Seguro: " + ((Medico) objTemp).getArrayEnfer().get(i).getSeguro());
                                        System.out.println("Patologia: " + ((Medico) objTemp).getArrayEnfer().get(i).getPatologia());
                                    }
                                    System.out.println("=======================================");
                                }
                            } while (b);
                            break;
                        case 2:
                            do {
                                objTemp = (Personal) ois.readObject();
                                if (objTemp instanceof Administrativos) {
                                    System.out.println("-------------------------------------------------");
                                    System.out.println("Codigo: " + ((Administrativos) objTemp).getCodigo());
                                    System.out.println("Nombre: " + ((Administrativos) objTemp).getNombre());
                                    System.out.println("E-Mail: " + ((Administrativos) objTemp).getEmail());
                                    System.out.println("Categoria: " + ((Administrativos) objTemp).getCategoria());
                                    System.out.println("Sueldo: " + ((Administrativos) objTemp).getSueldo());
                                    System.out.println("Nomina: " + ((Administrativos) objTemp).nomina());
                                }
                            } while (b);
                            break;
                        case 3:
                            System.out.println("Fin de visualizacion");
                            break;
                        default:
                            System.out.println("Esa opcion no es correcta");
                            break;
                    }
                } while (op != 3);
            } else {
                System.out.println("Volviendo al menu. Escoja otra opcion");
            }
        } catch (EOFException e) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ois != null) {
                ois.close();
            }
        }
    }

    public static void Altas() throws IOException {
        ObjectOutputStream oos = null;
        char resp = ' ';
        byte op;
        boolean b = true;
        ArrayList<Enfermos> arrayEnfer = new ArrayList();

        try {
            System.out.println("¿Quiere añadir nuevos registros?");
            resp = leer.readLine().charAt(0);
            if (resp == 's' || resp == 'S') {
                System.out.println("Indica el fichero en el que añadir");
                String nombreF = leer.readLine();
                File fichero = new File(nombreF);
                oos = new ObjectOutputStreamSinCabecera(new FileOutputStream(fichero, true));
                if (fichero.exists()) {
                    do {
                        System.out.println("--------------------------");
                        System.out.println("Escoja registro añadir");
                        System.out.println("Opcion 1: Medico");
                        System.out.println("Opcion 2: Administrativos");
                        System.out.println("Opcion 3: Fin");
                        System.out.print("Opcion: ");
                        op = Byte.parseByte(leer.readLine());
                        switch (op) {
                            case 1:
                                System.out.println("------------------------------------");
                                System.out.println("Rellena los siguientes campos");
                                System.out.print("Codigo: ");
                                String codigoM = leer.readLine();
                                System.out.print("Nombre: ");
                                String nombreM = leer.readLine();
                                System.out.print("E-Mail: ");
                                String emailM = leer.readLine();
                                System.out.print("Especialidad: ");
                                String especialidad = leer.readLine();
                                System.out.print("Sueldo: ");
                                float sueldoM = Integer.parseInt(leer.readLine());
                                System.out.print("Horas extra: ");
                                int horasExtra = Integer.parseInt(leer.readLine());
                                do {
                                    System.out.println("-----------------");
                                    System.out.println("Pacientes");
                                    System.out.print("Dni paciente: ");
                                    String dniP = leer.readLine();
                                    System.out.print("Nombre paciente: ");
                                    String nombreP = leer.readLine();
                                    System.out.print("Seguro paciente: ");
                                    String seguro = leer.readLine();
                                    System.out.print("Patologia paciente: ");
                                    String patologia = leer.readLine();
                                    System.out.println("-----------------");

                                    arrayEnfer.add(new Enfermos(dniP, nombreP, seguro, patologia));
                                    System.out.println("¿Quiere añadir otro paciente?");
                                    resp = leer.readLine().charAt(0);
                                } while (resp == 's' || resp == 'S');
                                System.out.println("------------------------------------");
                                oos.writeObject(new Medico(especialidad, horasExtra, sueldoM, codigoM, nombreM, emailM, arrayEnfer));

                                break;
                            case 2:
                                System.out.println("------------------------------------");
                                System.out.println("Rellena los siguientes campos");
                                System.out.print("Codigo: ");
                                String codigoA = leer.readLine();
                                System.out.print("Nombre: ");
                                String nombreA = leer.readLine();
                                System.out.print("E-Mail: ");
                                String emailA = leer.readLine();
                                System.out.print("Categoria: ");
                                String categoria = leer.readLine();
                                System.out.print("Sueldo: ");
                                float sueldoA = Integer.parseInt(leer.readLine());
                                oos.writeObject(new Administrativos(categoria, sueldoA, codigoA, nombreA, emailA));

                                break;
                            case 3:
                                System.out.println("Fin de añadir");
                                break;
                            default:
                                System.out.println("Esa opcion no es correcta");
                                break;
                        }
                    } while (op != 3);
                } else {
                }
            } else {
            }
        } catch (NullPointerException e) {
        } finally {
            if (oos != null) {
                oos.close();
            }
        }
    }

    public static void Borrar() throws IOException {
        char resp = ' ';
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        byte op;
        File ficheroTemp = new File("nombreTemp");
        boolean b = true;
        ArrayList<Enfermos> arrayEnfer = new ArrayList();
        Personal objTemp;

        try {
            System.out.println("¿Quieres borrar algun registro?");
            resp = leer.readLine().charAt(0);
            if (resp == 's' || resp == 'S') {
                System.out.println("Escoja fichero en el que borrar");
                String nombreF = leer.readLine();
                File fichero = new File(nombreF);
                ois = new ObjectInputStream(new FileInputStream(fichero));
                oos = new ObjectOutputStream(new FileOutputStream(ficheroTemp));
                if (fichero.exists()) {
                    do {
                        System.out.println("-------------------------------");
                        System.out.println("Escoja el tipo de registro");
                        System.out.println("Opcion 1: Medico");
                        System.out.println("Opcion 2: Administrativo");
                        System.out.println("Opcion 3: Fin");
                        System.out.print("Opcion: ");
                        op = Byte.parseByte(leer.readLine());
                        System.out.println("-------------------------------");
                        switch (op) {
                            case 1:
                                System.out.println("Indica el registro a borrar");
                                String codigo = leer.readLine();
                                do {
                                    objTemp = (Personal) ois.readObject();
                                    if (codigo.compareToIgnoreCase(objTemp.getCodigo()) != 0) {
                                        oos.writeObject(objTemp);
                                    }
                                } while (b);
                                break;
                            case 2:
                                System.out.println("Indica el registro a borrar");
                                String codigoA = leer.readLine();
                                do {
                                    objTemp = (Personal) ois.readObject();
                                    if (codigoA.compareToIgnoreCase(objTemp.getCodigo()) != 0) {
                                        oos.writeObject(objTemp);
                                    }
                                } while (b);
                                break;
                            case 3:
                                System.out.println("Fin del borrado");
                                break;
                            default:
                                System.out.println("Esa opcion no es correcta");
                                break;
                        }
                    } while (op != 3);

                } else {
                    System.out.println("El fichero no existe");
                }
            } else {
                System.out.println("Volviendo al menu. Escoja otra opcion");
            }
        } catch (EOFException e) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassCastException e) {
        } finally {
            if (ois != null) {
                ois.close();
            }
            if (oos != null) {
                oos.close();
            }
        }
    }

    public static void Buscar() throws IOException, ClassNotFoundException {
        char resp = ' ';
        byte op;
        ObjectInputStream ois = null;
        Personal objTemp;
        boolean b = true;

        try {
            System.out.println("¿Quieres buscar algun registro?");
            resp = leer.readLine().charAt(0);
            if (resp == 's' || resp == 'S') {
                System.out.println("Indica el fichero en el que buscar");
                String nombreF = leer.readLine();
                File fichero = new File(nombreF);
                ois = new ObjectInputStream(new FileInputStream(fichero));
                if (fichero.exists()) {
                    do {
                        System.out.println("---------------------------------------");
                        System.out.println("Escoja el tipo de registro a buscar");
                        System.out.println("Opcion 1: Medico");
                        System.out.println("Opcion 2: Administrativo");
                        System.out.println("Opcion 3: Fin");
                        System.out.print("Opcion: ");
                        op = Byte.parseByte(leer.readLine());
                        System.out.println("-------------------------------");
                        switch (op) {
                            case 1:
                                System.out.println("Indica el registro que quieres buscar");
                                System.out.print("Codigo: ");
                                String codigoM = leer.readLine();
                                arrayMedico = cargar(nombreF);
                                for (int i = 0; i < arrayMedico.size(); i++) {
                                    for (int j = i + 1; j < arrayMedico.size(); j++) {
                                        if (Integer.parseInt(arrayMedico.get(i).getCodigo())
                                                >= Integer.parseInt(arrayMedico.get(j).getCodigo())) {

                                            String auxC = arrayMedico.get(i).getCodigo();
                                            arrayMedico.get(i).setCodigo(arrayMedico.get(j).getCodigo());
                                            arrayMedico.get(j).setCodigo(auxC);

                                            String auxN = arrayMedico.get(i).getCodigo();
                                            arrayMedico.get(i).setCodigo(arrayMedico.get(j).getCodigo());
                                            arrayMedico.get(j).setCodigo(auxN);

                                            String auxE = arrayMedico.get(i).getCodigo();
                                            arrayMedico.get(i).setCodigo(arrayMedico.get(j).getCodigo());
                                            arrayMedico.get(j).setCodigo(auxE);

                                            String auxEs = arrayMedico.get(i).getCodigo();
                                            arrayMedico.get(i).setCodigo(arrayMedico.get(j).getCodigo());
                                            arrayMedico.get(j).setCodigo(auxEs);

                                            String auxS = arrayMedico.get(i).getCodigo();
                                            arrayMedico.get(i).setCodigo(arrayMedico.get(j).getCodigo());
                                            arrayMedico.get(j).setCodigo(auxS);

                                            String auxH = arrayMedico.get(i).getCodigo();
                                            arrayMedico.get(i).setCodigo(arrayMedico.get(j).getCodigo());
                                            arrayMedico.get(j).setCodigo(auxH);

                                            String auxNo = arrayMedico.get(i).getCodigo();
                                            arrayMedico.get(i).setCodigo(arrayMedico.get(j).getCodigo());
                                            arrayMedico.get(j).setCodigo(auxNo);

                                            ArrayList<Enfermos> auxAr = arrayMedico.get(i).getArrayEnfer();
                                            arrayMedico.get(i).setArrayEnfer(arrayMedico.get(j).getArrayEnfer());
                                            arrayMedico.get(j).setArrayEnfer(auxAr);

                                        }
                                    }
                                }
                                for (int i = 0; i < arrayMedico.size(); i++) {
                                    int Final = arrayMedico.size() - 1;
                                    while (i < Final) {
                                        int media = (i + Final) / 2;
                                        if (Integer.parseInt(codigoM) == Integer.parseInt(arrayMedico.get(media).getCodigo())) {
                                            i = media;
                                            Final = media;
                                        } else {
                                            if (Integer.parseInt(codigoM) > Integer.parseInt(arrayMedico.get(media).getCodigo())) {
                                                i = media + 1;
                                            } else {
                                                Final = media - 1;
                                            }
                                        }
                                    }
                                    if (Integer.parseInt(codigoM) == Integer.parseInt(arrayMedico.get(i).getCodigo())) {

                                        System.out.println("-------------------------------------------------");
                                        System.out.println("Codigo: " + (arrayMedico.get(i).getCodigo()));
                                        System.out.println("Nombre: " + (arrayMedico.get(i).getNombre()));
                                        System.out.println("E-Mail: " + (arrayMedico.get(i).getEmail()));
                                        System.out.println("Especialidad: " + (arrayMedico.get(i).getEspecialidad()));
                                        System.out.println("Sueldo: " + (arrayMedico.get(i).getSueldo()));
                                        System.out.println("Horas extra: " + (arrayMedico.get(i).getNumHorasExtra()));
                                        System.out.println("Nomina: " + (arrayMedico.get(i).nomina()));
                                        for (int z = 0; z < arrayMedico.get(i).getArrayEnfer().size(); z++) {
                                            System.out.println("=======================================");
                                            System.out.println("Paciente:");
                                            System.out.println("Dni: " + (arrayMedico.get(i).getArrayEnfer().get(z).getDni()));
                                            System.out.println("Nombre: " + (arrayMedico.get(i).getArrayEnfer().get(z).getNombre()));
                                            System.out.println("Seguro: " + (arrayMedico.get(i).getArrayEnfer().get(z).getSeguro()));
                                            System.out.println("Patologia: " + (arrayMedico.get(i).getArrayEnfer().get(z).getPatologia()));
                                        }
                                        System.out.println("=======================================");

                                    } else {
                                        System.out.println("Ese registro no existe");
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Indica el regsitro que quieres buscar");
                                String codigoA = leer.readLine();
                                do {
                                    objTemp = (Personal) ois.readObject();
                                    if (objTemp instanceof Administrativos) {
                                        if (codigoA.compareToIgnoreCase(objTemp.getCodigo()) == 0) {
                                            System.out.println("-------------------------------------------------");
                                            System.out.println("Codigo: " + ((Administrativos) objTemp).getCodigo());
                                            System.out.println("Nombre: " + ((Administrativos) objTemp).getNombre());
                                            System.out.println("E-Mail: " + ((Administrativos) objTemp).getEmail());
                                            System.out.println("Categoria: " + ((Administrativos) objTemp).getCategoria());
                                            System.out.println("Sueldo: " + ((Administrativos) objTemp).getSueldo());
                                            System.out.println("Nomina: " + ((Administrativos) objTemp).nomina());
                                        }
                                    }
                                } while (b);
                                break;
                            case 3:
                                System.out.println("Fin de la busqueda");
                                break;
                            default:
                                System.out.println("Esa opcion no es correcta");
                                break;
                        }
                    } while (op != 3);
                } else {
                    System.out.println("El fichero no existe");
                }
            } else {
                System.out.println("Volviendo al menu. Escoja otra opcion");
            }
        } catch (EOFException e) {
        } finally {
            if (ois != null) {
                ois.close();
            }
        }
    }

    public static ArrayList cargar(String nombre) throws IOException, ClassNotFoundException {
        Personal objTemp;
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(nombre));
            //do { al ser Seriacion de objetos que referencian a otros objetos no hace falta do-while
            //porque lee todo los registros de golpe
                objTemp = (Personal) ois.readObject();
                if (objTemp instanceof Medico) {
                    arrayMedico.add((Medico) objTemp);
                }
            //} while (b);
        } catch (NullPointerException e) {
        } catch (EOFException e) {
        } finally {
            if (ois != null) {
                ois.close();
            }
        }
        return arrayMedico;
    }
}
