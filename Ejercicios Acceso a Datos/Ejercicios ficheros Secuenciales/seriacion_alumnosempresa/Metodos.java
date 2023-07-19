/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacion_alumnosempresa;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author adrian
 */
public class Metodos {

    private static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<I_interfaz_Nexo> arrayAlum = new ArrayList();
    private static ArrayList<I_interfaz_Nexo> arrayEmpr = new ArrayList();
    private static File fichero;

    public static void Crear() throws IOException {
        ObjectOutput oos = null;
        char resp = ' ';
        String nombreF;
        byte op;
        boolean b = true;

        System.out.println("¿Desea crear un fichero?");
        resp = leer.readLine().charAt(0);
        if (resp == 's' || resp == 'S') {
            System.out.println("Escriba el nombre del fichero");
            nombreF = leer.readLine();
            fichero = new File(nombreF);

            if (!fichero.exists()) {
                fichero.createNewFile();
                oos = new ObjectOutputStream(new FileOutputStream(fichero));
                do {
                    System.out.println("------------------------------------------");
                    System.out.println("Que tipo de registro quiere añadir");
                    System.out.println("Opcion 1: Alumno");
                    System.out.println("Opcion 2: Empresa");
                    op = Byte.parseByte(leer.readLine());
                    switch (op) {
                        case 1:
                            System.out.println("------------------------------------------");
                            System.out.print("Codigo del alumno: ");
                            String codigo = leer.readLine();
                            System.out.print("Nombre del alumno: ");
                            String nombreA = leer.readLine();
                            System.out.print("E-mail del alumno: ");
                            String email = leer.readLine();
                            System.out.print("Telefono del alumno: ");
                            String telefonoA = leer.readLine();

                            oos.writeObject(new C_Alumno(codigo, nombreA, telefonoA, email));
                            b = false;
                            break;
                        case 2:
                            System.out.println("------------------------------------------");
                            System.out.print("Cif de la empresa: ");
                            String cif = leer.readLine();
                            System.out.print("Nombre de la empresa: ");
                            String nombreE = leer.readLine();
                            System.out.print("Direccion de la empresa: ");
                            String direccion = leer.readLine();
                            System.out.print("Telefono de la empresa: ");
                            String telefonoE = leer.readLine();

                            oos.writeObject(new C_Empresa(cif, nombreE, direccion, telefonoE));
                            b = false;
                            break;
                        default:
                            System.out.println("Esa opcion no es correcta");
                            break;
                    }
                } while (b);
            } else {
            }
        } else {
            System.out.println("Volviendo al menu. Escoja otra opcion");
        }
    }

    public static void Cargar() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        char resp = ' ';
        boolean b = true;

        try {
            System.out.println("¿Quiere cargar algun dato?");
            resp = leer.readLine().charAt(0);
            if (resp == 's' || resp == 'S') {
                System.out.println("Escribe el fichero del que cargar los datos");
                String nombreF = leer.readLine();
                fichero = new File(nombreF);
                ois = new ObjectInputStream(new FileInputStream(fichero));
                if (fichero.exists()) {
                    if (fichero.length() != 0) {
                        // do {
                        //lee todos los registros de golpe (Seriacion de objetos que referencian a otros objetos)
                        I_interfaz_Nexo objTemp = (I_interfaz_Nexo) ois.readObject(); 
                        //Crea una direccion de memoria que se le pasara al array sin machacar la que tenia
                        if (objTemp instanceof C_Alumno) {
                            arrayAlum.add(objTemp);
                        } else {
                            arrayEmpr.add(objTemp);
                        }
                        //} while (b);
                    } else {
                        System.out.println("El fichero esta vacio");
                    }
                } else {
                    System.out.println("El fichero no existe");
                }
            } else {
                System.out.println("Volviendo al menu. Escoja otra opcion");
            }
        } catch (EOFException e) {
        } catch (ClassCastException e) {
        }
    }

    public static void Altas() throws IOException {
        char resp = ' ';
        byte op;

        System.out.println("¿Desea dar de alta algun registro?");
        resp = leer.readLine().charAt(0);
        if (resp == 's' || resp == 'S') {
            do {
                System.out.println("------------------------------------------");
                System.out.println("Que tipo de registro quiere añadir");
                System.out.println("Opcion 1: Alumno");
                System.out.println("Opcion 2: Empresa");
                System.out.println("Opcion 3: Fin");
                System.out.print("Opcion: ");
                op = Byte.parseByte(leer.readLine());
                switch (op) {
                    case 1:
                        System.out.println("------------------------------------------");
                        System.out.print("Codigo del alumno: ");
                        String codigo = leer.readLine();
                        System.out.print("Nombre del alumno: ");
                        String nombreA = leer.readLine();
                        System.out.print("E-mail del alumno: ");
                        String email = leer.readLine();
                        System.out.print("Telefono del alumno: ");
                        String telefonoA = leer.readLine();

                        arrayAlum.add(new C_Alumno(codigo, nombreA, telefonoA, email));
                        break;
                    case 2:
                        System.out.println("------------------------------------------");
                        System.out.print("Cif de la empresa:");
                        String cif = leer.readLine();
                        System.out.print("Nombre de la empresa: ");
                        String nombreE = leer.readLine();
                        System.out.print("Direccion de la empresa: ");
                        String direccion = leer.readLine();
                        System.out.print("Telefono de la empresa: ");
                        String telefonoE = leer.readLine();

                        arrayEmpr.add(new C_Empresa(cif, nombreE, direccion, telefonoE));
                        break;
                    case 3:
                        System.out.println("Fin de las altas de registros");
                        break;
                    default:
                        System.out.println("Esa opcion no es correcta");
                        break;
                }
            } while (op != 3);
        } else {
            System.out.println("Volviendo al menu. Escoja otra opcion");
        }
    }

    public static void Consultar() throws IOException {
        char resp = ' ';
        byte op;
        boolean b = true;

        System.out.println("¿Desea consultar algun registro?");
        resp = leer.readLine().charAt(0);
        if (resp == 's' || resp == 'S') {
            do {
                System.out.println("------------------------------------------");
                System.out.println("¿Que tipo de registro desea consultar?");
                System.out.println("Opcion 1: Alumnos");
                System.out.println("Opcion 2: Empresas");
                System.out.println("Opcion 3: Fin");
                System.out.print("Opcion: ");
                op = Byte.parseByte(leer.readLine());
                switch (op) {
                    case 1:
                        System.out.println("----------------------------------");
                        for (int i = 0; i < arrayAlum.size(); i++) {
                            System.out.println(((C_Alumno) arrayAlum.get(i)).getCodigo());
                            System.out.println(((C_Alumno) arrayAlum.get(i)).getNombre());
                            System.out.println(((C_Alumno) arrayAlum.get(i)).getEmail());
                            System.out.println(((C_Alumno) arrayAlum.get(i)).getTelefono());
                            System.out.println("----------------------------------");
                        }
                        break;
                    case 2:
                        System.out.println("----------------------------------");
                        for (int i = 0; i < arrayEmpr.size(); i++) {
                            System.out.println(((C_Empresa) arrayEmpr.get(i)).getCif());
                            System.out.println(((C_Empresa) arrayEmpr.get(i)).getNombre());
                            System.out.println(((C_Empresa) arrayEmpr.get(i)).getDireccion());
                            System.out.println(((C_Empresa) arrayEmpr.get(i)).getTelefono());
                            System.out.println("----------------------------------");
                        }
                        break;
                    case 3:
                        System.out.println("Fin de las consultas de registros");
                        break;
                    default:
                        System.out.println("Esa opcion no es valida");
                        break;
                }
            } while (op != 3);

        } else {
            System.out.println("Volviendo al menu. Escoja otra opcion");
        }
    }

    public static void Borrar() throws IOException {
        char resp = ' ';
        byte op;
        String codigo;
        String cif;

        System.out.println("¿Quiere borrar algun registro?");
        resp = leer.readLine().charAt(0);
        if (resp == 's' || resp == 'S') {
            do {
                System.out.println("------------------------------------------");
                System.out.println("¿Que tipo de registro quiere borrar?");
                System.out.println("Opcion 1: Alumno");
                System.out.println("Opcion 2: Empresa");
                System.out.println("Opcion 3: Fin");
                System.out.print("Opcion: ");
                op = Byte.parseByte(leer.readLine());
                switch (op) {
                    case 1:
                        System.out.println("Indique el registro a borrar");
                        codigo = leer.readLine();
                        for (int i = 0; i < arrayAlum.size(); i++) {
                            if (codigo.equalsIgnoreCase(((C_Alumno) arrayAlum.get(i)).getCodigo())) {
                                System.out.println("---------------------------");
                                System.out.println(((C_Alumno) arrayAlum.get(i)).getCodigo());
                                System.out.println(((C_Alumno) arrayAlum.get(i)).getNombre());
                                System.out.println(((C_Alumno) arrayAlum.get(i)).getEmail());
                                System.out.println(((C_Alumno) arrayAlum.get(i)).getTelefono());
                                System.out.println("---------------------------");

                                System.out.println("¿Quiere borrar este registro?");
                                resp = leer.readLine().charAt(0);
                                if (resp == 's' || resp == 'S') {
                                    arrayAlum.remove(i);
                                }
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Indique el registro a borrar");
                        cif = leer.readLine();
                        for (int i = 0; i < arrayEmpr.size(); i++) {
                            if (cif.equalsIgnoreCase(((C_Empresa) arrayEmpr.get(i)).getCif())) {
                                System.out.println(((C_Empresa) arrayEmpr.get(i)).getCif());
                                System.out.println(((C_Empresa) arrayEmpr.get(i)).getNombre());
                                System.out.println(((C_Empresa) arrayEmpr.get(i)).getDireccion());
                                System.out.println(((C_Empresa) arrayEmpr.get(i)).getTelefono());
                                System.out.println("----------------------------------");

                                System.out.println("¿Quiere borrar este registro?");
                                resp = leer.readLine().charAt(0);
                                if (resp == 's' || resp == 'S') {
                                    arrayEmpr.remove(i);
                                }
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Fin del borrado de registros");
                        break;
                    default:
                        System.out.println("Esa opcion no es valida");
                        break;
                }
            } while (op != 3);
        } else {
            System.out.println("Volviendo al menu. Escoja otra opcion");
        }
    }

    public static void Modificar() throws IOException {
        char resp = ' ';
        byte op;
        String codigo;
        String cif;

        System.out.println("¿Quiere modificar algun registro?");
        resp = leer.readLine().charAt(0);
        if (resp == 's' || resp == 'S') {
            do {
                System.out.println("------------------------------------------");
                System.out.println("¿Que tipo de registro quiere borrar?");
                System.out.println("Opcion 1: Alumno");
                System.out.println("Opcion 2: Empresa");
                System.out.println("Opcion 3: Fin");
                System.out.print("Opcion: ");
                op = Byte.parseByte(leer.readLine());
                switch (op) {
                    case 1:
                        System.out.println("Indique el registro a Modificar");
                        codigo = leer.readLine();
                        for (int i = 0; i < arrayAlum.size(); i++) {
                            if (codigo.equalsIgnoreCase(((C_Alumno) arrayAlum.get(i)).getCodigo())) {
                                System.out.println("---------------------------");
                                System.out.println(((C_Alumno) arrayAlum.get(i)).getCodigo());
                                System.out.println(((C_Alumno) arrayAlum.get(i)).getNombre());
                                System.out.println(((C_Alumno) arrayAlum.get(i)).getEmail());
                                System.out.println(((C_Alumno) arrayAlum.get(i)).getTelefono());
                                System.out.println("---------------------------");

                                System.out.println("¿Quiere Modificar este registro?");
                                resp = leer.readLine().charAt(0);
                                if (resp == 's' || resp == 'S') {
                                    do {
                                        System.out.println("------------------------------------------");
                                        System.out.println("¿Que campo quiere modificar?");
                                        System.out.println("Opcion 1: Codigo");
                                        System.out.println("Opcion 2: Nombre");
                                        System.out.println("Opcion 3: E-mail");
                                        System.out.println("Opcion 4: Telefono");
                                        System.out.println("Opcion 5: Fin");
                                        System.out.print("Opcion: ");
                                        op = Byte.parseByte(leer.readLine());
                                        switch (op) {
                                            case 1:
                                                System.out.println(((C_Alumno) arrayAlum.get(i)).getCodigo());
                                                System.out.println("¿Quiere modificar este campo?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Codigo nuevo: ");
                                                    String codigoN = leer.readLine();
                                                    ((C_Alumno) arrayAlum.get(i)).setCodigo(codigoN);
                                                }
                                                break;
                                            case 2:
                                                System.out.println(((C_Alumno) arrayAlum.get(i)).getNombre());
                                                System.out.println("¿Quiere modificar este campo?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Nombre nuevo: ");
                                                    String nombreAN = leer.readLine();
                                                    ((C_Alumno) arrayAlum.get(i)).setNombre(nombreAN);
                                                }
                                                break;
                                            case 3:
                                                System.out.println(((C_Alumno) arrayAlum.get(i)).getEmail());
                                                System.out.println("¿Quiere modificar este campo?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("E-mail nuevo: ");
                                                    String emailN = leer.readLine();
                                                    ((C_Alumno) arrayAlum.get(i)).setEmail(emailN);
                                                }
                                                break;
                                            case 4:
                                                System.out.println(((C_Alumno) arrayAlum.get(i)).getTelefono());
                                                System.out.println("¿Quiere modificar este campo?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Telefono nuevo: ");
                                                    String telefonoN = leer.readLine();
                                                    ((C_Alumno) arrayAlum.get(i)).setTelefono(telefonoN);
                                                }
                                                break;
                                            case 5:
                                                System.out.println("Fin de modificacion del registro");
                                                break;
                                            default:
                                                System.out.println("Esa opcion no es valida");
                                                break;
                                        }
                                    } while (op != 5);
                                }
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Indique el registro a Modificar");
                        cif = leer.readLine();
                        for (int i = 0; i < arrayEmpr.size(); i++) {
                            if (cif.equalsIgnoreCase(((C_Empresa) arrayEmpr.get(i)).getCif())) {
                                System.out.println(((C_Empresa) arrayEmpr.get(i)).getCif());
                                System.out.println(((C_Empresa) arrayEmpr.get(i)).getNombre());
                                System.out.println(((C_Empresa) arrayEmpr.get(i)).getDireccion());
                                System.out.println(((C_Empresa) arrayEmpr.get(i)).getTelefono());
                                System.out.println("----------------------------------");

                                System.out.println("¿Quiere Modificar este registro?");
                                resp = leer.readLine().charAt(0);
                                if (resp == 's' || resp == 'S') {
                                    do {
                                        System.out.println("------------------------------------------");
                                        System.out.println("¿Que campo quiere modificar?");
                                        System.out.println("Opcion 1: Cif");
                                        System.out.println("Opcion 2: Nombre");
                                        System.out.println("Opcion 3: Direccion");
                                        System.out.println("Opcion 4: Telefono");
                                        System.out.println("Opcion 5: Fin");
                                        System.out.print("Opcion: ");
                                        op = Byte.parseByte(leer.readLine());
                                        switch (op) {
                                            case 1:
                                                System.out.println(((C_Empresa) arrayEmpr.get(i)).getCif());
                                                System.out.println("¿Quiere modificar este campo?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Cif nuevo: ");
                                                    String cifN = leer.readLine();
                                                    ((C_Empresa) arrayEmpr.get(i)).setCif(cifN);
                                                }
                                                break;
                                            case 2:
                                                System.out.println(((C_Empresa) arrayEmpr.get(i)).getNombre());
                                                System.out.println("¿Quiere modificar este campo?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Nombre nuevo: ");
                                                    String nombreEN = leer.readLine();
                                                    ((C_Empresa) arrayEmpr.get(i)).setNombre(nombreEN);
                                                }
                                                break;
                                            case 3:
                                                System.out.println(((C_Empresa) arrayEmpr.get(i)).getDireccion());
                                                System.out.println("¿Quiere modificar este campo?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Direccion nueva: ");
                                                    String direccionN = leer.readLine();
                                                    ((C_Empresa) arrayEmpr.get(i)).setDireccion(direccionN);
                                                }
                                                break;
                                            case 4:
                                                System.out.println(((C_Empresa) arrayEmpr.get(i)).getTelefono());
                                                System.out.println("¿Quiere modificar este campo?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Telefono nuevo: ");
                                                    String telefonoEN = leer.readLine();
                                                    ((C_Empresa) arrayEmpr.get(i)).setTelefono(telefonoEN);
                                                }
                                                break;
                                            case 5:
                                                System.out.println("Fin de modificacion del registro");
                                                break;
                                            default:
                                                System.out.println("Esa opcion no es valida");
                                                break;
                                        }
                                    } while (op != 5);
                                }
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Fin de la modificacion");
                        break;
                    default:
                        System.out.println("Esa opcion no es valida");
                        break;
                }
            } while (op != 3);
        } else {
            System.out.println("Volviendo al menu. Escoja otra opcion");
        }
    }

    public static void grabar() throws IOException {
        char resp = ' ';
        ObjectOutputStream oos = null;
        try {
            System.out.println("¿Quieres guardar los cambios?");
            resp = leer.readLine().charAt(0);
            oos = new ObjectOutputStream(new FileOutputStream(fichero));
            if (resp == 's' || resp == 'S') {
                oos.writeObject(arrayAlum);
                oos.writeObject(arrayEmpr);
                System.out.println("Se guardo correctamente");
            } else {
            }
        } catch (NullPointerException e) {
        }
    }

    public static void busqueda() throws IOException {
        char resp = ' ';
        byte op;
        int i = 0;
        int j;
        String codigoB;
        String cifB;

        System.out.println("¿Realizar busqueda dicotomica?");
        resp = leer.readLine().charAt(0);
        if (resp == 's' || resp == 'S') {
            do {
                System.out.println("¿Que tipo de registro quiere burcar?");
                System.out.println("Opcion 1: Alumno");
                System.out.println("Opcion 2: Empresa");
                System.out.println("Opcion 3: Fin");
                System.out.print("Opcion: ");
                op = Byte.parseByte(leer.readLine());
                switch (op) {
                    case 1:
                        for (i = 0; i < arrayAlum.size() - 1; i++) {
                            for (j = i + 1; j < arrayAlum.size(); j++) {
                                if ((Integer.parseInt(((C_Alumno) arrayAlum.get(i)).getCodigo())) >= (Integer.parseInt(((C_Alumno) arrayAlum.get(j)).getCodigo()))) {
                                    String auxC = ((C_Alumno) arrayAlum.get(i)).getCodigo();
                                    ((C_Alumno) arrayAlum.get(i)).setCodigo(((C_Alumno) arrayAlum.get(j)).getCodigo());
                                    ((C_Alumno) arrayAlum.get(j)).setCodigo(auxC);

                                    String auxN = ((C_Alumno) arrayAlum.get(i)).getNombre();
                                    ((C_Alumno) arrayAlum.get(i)).setNombre(((C_Alumno) arrayAlum.get(j)).getNombre());
                                    ((C_Alumno) arrayAlum.get(j)).setNombre(auxN);

                                    String auxE = ((C_Alumno) arrayAlum.get(i)).getEmail();
                                    ((C_Alumno) arrayAlum.get(i)).setEmail(((C_Alumno) arrayAlum.get(j)).getEmail());
                                    ((C_Alumno) arrayAlum.get(j)).setTelefono(auxE);

                                    String auxT = ((C_Alumno) arrayAlum.get(i)).getTelefono();
                                    ((C_Alumno) arrayAlum.get(i)).setTelefono(((C_Alumno) arrayAlum.get(j)).getTelefono());
                                    ((C_Alumno) arrayAlum.get(j)).setTelefono(auxT);
                                }
                            }
                        }

                        System.out.println("Indica el codigo del alumno que quiere buscar");
                        codigoB = leer.readLine();
                        for (i = 0; i < arrayAlum.size(); i++) {
                            int end = arrayAlum.size() - 1;
                            while (i < end) {
                                int media = (i + end) / 2;
                                if (Integer.parseInt(codigoB) == Integer.parseInt(((C_Alumno) arrayAlum.get(media)).getCodigo())) {
                                    i = media;
                                    end = media;
                                } else {
                                    if (Integer.parseInt(codigoB) > Integer.parseInt(((C_Alumno) arrayAlum.get(media)).getCodigo())) {
                                        i = media + 1;
                                    } else {
                                        end = media - 1;
                                    }
                                }
                            }
                            if (Integer.parseInt(codigoB) == Integer.parseInt(((C_Alumno) arrayAlum.get(i)).getCodigo())) {
                                System.out.println("---------------------------");
                                System.out.println(((C_Alumno) arrayAlum.get(i)).getCodigo());
                                System.out.println(((C_Alumno) arrayAlum.get(i)).getNombre());
                                System.out.println(((C_Alumno) arrayAlum.get(i)).getEmail());
                                System.out.println(((C_Alumno) arrayAlum.get(i)).getTelefono());
                                System.out.println("---------------------------");
                            }
                        }
                        break;
                    case 2:
                        for (i = 0; i < arrayEmpr.size() - 1; i++) {
                            for (j = i + 1; j < arrayEmpr.size(); j++) {
                                if ((Integer.parseInt(((C_Empresa) arrayEmpr.get(i)).getCif())) >= (Integer.parseInt(((C_Empresa) arrayEmpr.get(j)).getCif()))) {
                                    String auxC = ((C_Empresa) arrayEmpr.get(i)).getCif();
                                    ((C_Empresa) arrayEmpr.get(i)).setCif(((C_Empresa) arrayEmpr.get(j)).getCif());
                                    ((C_Empresa) arrayEmpr.get(j)).setCif(auxC);

                                    String auxN = ((C_Empresa) arrayEmpr.get(i)).getNombre();
                                    ((C_Empresa) arrayEmpr.get(i)).setNombre(((C_Empresa) arrayEmpr.get(j)).getNombre());
                                    ((C_Empresa) arrayEmpr.get(j)).setNombre(auxN);

                                    String auxE = ((C_Empresa) arrayEmpr.get(i)).getDireccion();
                                    ((C_Empresa) arrayEmpr.get(i)).setDireccion(((C_Empresa) arrayEmpr.get(j)).getDireccion());
                                    ((C_Empresa) arrayEmpr.get(j)).setDireccion(auxE);

                                    String auxT = ((C_Empresa) arrayEmpr.get(i)).getTelefono();
                                    ((C_Empresa) arrayEmpr.get(i)).setTelefono(((C_Empresa) arrayEmpr.get(j)).getTelefono());
                                    ((C_Empresa) arrayEmpr.get(j)).setTelefono(auxT);
                                }
                            }
                        }

                        System.out.println("Indica el codigo del alumno que quiere buscar");
                        cifB = leer.readLine();
                        for (i = 0; i < arrayEmpr.size(); i++) {
                            int end = arrayEmpr.size() - 1;
                            while (i < end) {
                                int media = (i + end) / 2;
                                if (Integer.parseInt(cifB) == Integer.parseInt(((C_Empresa) arrayEmpr.get(media)).getCif())) {
                                    i = media;
                                    end = media;
                                } else {
                                    if (Integer.parseInt(cifB) > Integer.parseInt(((C_Empresa) arrayEmpr.get(media)).getCif())) {
                                        i = media + 1;
                                    } else {
                                        end = media - 1;
                                    }
                                }
                            }
                            if (Integer.parseInt(cifB) == Integer.parseInt(((C_Empresa) arrayEmpr.get(i)).getCif())) {
                                System.out.println("---------------------------");
                                System.out.println(((C_Empresa) arrayEmpr.get(i)).getCif());
                                System.out.println(((C_Empresa) arrayEmpr.get(i)).getNombre());
                                System.out.println(((C_Empresa) arrayEmpr.get(i)).getDireccion());
                                System.out.println(((C_Empresa) arrayEmpr.get(i)).getTelefono());
                                System.out.println("----------------------------------");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Volviendo al menu. Escoja otra opcion");
                        break;
                    default:
                        System.out.println("Esa opcion no es correcta");
                        break;
                }
            } while (op != 3);
        } else {
            System.out.println("Escoja otra opcion");
        }
    }
}
