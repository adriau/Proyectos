/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionficheroaleatorios_pisos;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author adrian
 */
public class Metodos {

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static PisoEstandar piso;
    static Atico atico;
    static Duplex duplex;
    static int cantidadP = 0;
    static int cantidadA = 0;
    static int cantidadD = 0;
    static int totalCargas = 0;

    public static void crear() throws IOException {
        File fichero = new File("piso");
        File fichero2 = new File("atico");
        File fichero3 = new File("duplex");

        if (!fichero.exists()) {
            fichero.createNewFile();
        }

        if (!fichero2.exists()) {
            fichero2.createNewFile();
        }

        if (!fichero3.exists()) {
            fichero3.createNewFile();
        }
    }

    public static void altas() {
        char resp = ' ';
        byte op;
        RandomAccessFile raf = null;
        try {

            System.out.println("¿Quieres dar de alta algun registro?");
            resp = leer.readLine().charAt(0);
            if (resp == 's' || resp == 'S') {

                do {
                    System.out.println("------------------------------");
                    System.out.println("Escoja el tipo de registro");
                    System.out.println("Opcion 1: Piso estandar");
                    System.out.println("Opcion 2: Atico");
                    System.out.println("Opcion 3: Duplex");
                    System.out.println("Opcion 4: Fin");
                    System.out.println("------------------------------");
                    System.out.print("Opcion: ");
                    op = Byte.parseByte(leer.readLine());

                    switch (op) {
                        case 1:
                            File fichero = new File("piso");
                            raf = new RandomAccessFile(fichero, "rw");
                            System.out.println("¿Quieres añadir un nuevo piso?");
                            resp = leer.readLine().charAt(0);
                            if (resp == 's' || resp == 'S') {
                                System.out.println("------------------------------");
                                System.out.println("Rellena los siguientes campos");
                                System.out.print("Codigo: ");
                                String codigo = leer.readLine();
                                System.out.print("Nombre del propietario: ");
                                String nombrePropietario = leer.readLine();
                                System.out.print("Mes del recibo: ");
                                String mesRecibo = leer.readLine();
                                System.out.print("Cuota Fija: ");
                                float cuotaFija = Float.parseFloat(leer.readLine());
                                System.out.print("Litros de agua caliente: ");
                                float agua = Float.parseFloat(leer.readLine());
                                System.out.print("Calefaccion: ");
                                float calefaccion = Float.parseFloat(leer.readLine());
                                System.out.println("------------------------------");

                                piso = new PisoEstandar(codigo, nombrePropietario, mesRecibo, cuotaFija, agua, calefaccion);

                                if (piso.tamañoRegistro() + 4 > piso.maximaLongitud) {
                                    System.out.println("El tamaño del registro a excedido la longitud permitida");
                                } else {

                                    raf.seek(numeroRegistros(fichero) * piso.maximaLongitud);

                                    raf.writeUTF(codigo);
                                    raf.writeUTF(nombrePropietario);
                                    raf.writeUTF(mesRecibo);
                                    raf.writeFloat(cuotaFija);
                                    raf.writeFloat(agua);
                                    raf.writeFloat(calefaccion);
                                    raf.writeFloat(piso.totalRecibo());
                                }
                            }
                            break;
                        case 2:
                            File fichero2 = new File("atico");
                            raf = new RandomAccessFile(fichero2, "rw");

                            System.out.println("¿Quieres añadir un nuevo atico?");
                            resp = leer.readLine().charAt(0);
                            if (resp == 's' || resp == 'S') {
                                System.out.println("------------------------------");
                                System.out.println("Rellena los siguientes campos");
                                System.out.print("Codigo: ");
                                String codigo = leer.readLine();
                                System.out.print("Nombre del propietario: ");
                                String nombrePropietario = leer.readLine();
                                System.out.print("Mes del recibo: ");
                                String mesRecibo = leer.readLine();
                                System.out.print("Cuota Fija: ");
                                float cuotaFija = Float.parseFloat(leer.readLine());
                                System.out.print("Litros de agua caliente: ");
                                float agua = Float.parseFloat(leer.readLine());
                                System.out.print("Calefaccion: ");
                                float calefaccion = Float.parseFloat(leer.readLine());
                                System.out.print("Metros de la terraza: ");
                                float metrosTerraza = Float.parseFloat(leer.readLine());
                                System.out.println("------------------------------");

                                atico = new Atico(codigo, nombrePropietario, mesRecibo, cuotaFija, agua, calefaccion, metrosTerraza);

                                if (atico.tamañoRegistro() + 4 > atico.maximaLongitud) {
                                    System.out.println("El tamaño del registro a excedido la longitud permitida");
                                } else {
                                    raf.seek(numeroRegistros(fichero2) * atico.maximaLongitud);

                                    raf.writeUTF(codigo);
                                    raf.writeUTF(nombrePropietario);
                                    raf.writeUTF(mesRecibo);
                                    raf.writeFloat(cuotaFija);
                                    raf.writeFloat(agua);
                                    raf.writeFloat(calefaccion);
                                    raf.writeFloat(metrosTerraza);
                                    raf.writeFloat(atico.totalRecibo());
                                }
                            }
                            break;
                        case 3:
                            File fichero3 = new File("duplex");
                            raf = new RandomAccessFile(fichero3, "rw");

                            System.out.println("¿Quieres añadir un nuevo duplex?");
                            resp = leer.readLine().charAt(0);
                            if (resp == 's' || resp == 'S') {
                                System.out.println("------------------------------");
                                System.out.println("Rellena los siguientes campos");
                                System.out.print("Codigo: ");
                                String codigo = leer.readLine();
                                System.out.print("Nombre del propietario: ");
                                String nombrePropietario = leer.readLine();
                                System.out.print("Mes del recibo: ");
                                String mesRecibo = leer.readLine();
                                System.out.print("Cuota Fija: ");
                                float cuotaFija = Float.parseFloat(leer.readLine());
                                System.out.print("Litros de agua caliente: ");
                                float agua = Float.parseFloat(leer.readLine());
                                System.out.print("Calefaccion: ");
                                float calefaccion = Float.parseFloat(leer.readLine());
                                System.out.print("Cuota Especial: ");
                                float cuetoEspecial = Float.parseFloat(leer.readLine());
                                System.out.println("------------------------------");

                                duplex = new Duplex(codigo, nombrePropietario, mesRecibo, cuotaFija, agua, calefaccion, cuetoEspecial);

                                if (duplex.tamañoRegistro() + 4 > duplex.maximaLongitud) {
                                    System.out.println("El tamaño del registro a excedido la longitud permitida");
                                } else {
                                    raf.seek(numeroRegistros(fichero3) * duplex.maximaLongitud);

                                    raf.writeUTF(codigo);
                                    raf.writeUTF(nombrePropietario);
                                    raf.writeUTF(mesRecibo);
                                    raf.writeFloat(cuotaFija);
                                    raf.writeFloat(agua);
                                    raf.writeFloat(calefaccion);
                                    raf.writeFloat(cuetoEspecial);
                                    raf.writeFloat(duplex.totalRecibo());
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Fin de las altas");
                            break;
                        default:
                            System.out.println("Esa opcion no es valida");
                            break;
                    }
                    if (raf != null) {
                        raf.close();
                    }
                } while (op != 4);
            } else {
            }
        } catch (IOException e) {
        }
    }

    public static void listar() throws IOException {
        char resp = ' ';
        byte op;
        RandomAccessFile raf = null;
        String codigo;
        String nombrePropietario;
        String mesRecibo;
        float cuotaFija;
        float agua;
        float calefaccion;
        float cuotaEspecial;
        float metrosTerraza;
        float recibo;

        try {
            System.out.println("¿Quieres visualizar algun registro?");
            resp = leer.readLine().charAt(0);
            if (resp == 's' || resp == 'S') {

                do {
                    System.out.println("------------------------------");
                    System.out.println("Escoja el tipo de registro");
                    System.out.println("Opcion 1: Piso estandar");
                    System.out.println("Opcion 2: Atico");
                    System.out.println("Opcion 3: Duplex");
                    System.out.println("Opcion 4: Fin");
                    System.out.println("------------------------------");
                    System.out.print("Opcion: ");
                    op = Byte.parseByte(leer.readLine());

                    switch (op) {
                        case 1:
                            File fichero = new File("piso2");
                            raf = new RandomAccessFile(fichero, "r");
                            System.out.println("¿Quieres visualizar los pisos?");
                            resp = leer.readLine().charAt(0);

                            if (resp == 's' || resp == 'S') {
                                for (int i = 0; i < numeroRegistros(fichero); i++) {
                                    if (i >= 0 && i < numeroRegistros(fichero)) {
                                        raf.seek(i * PisoEstandar.maximaLongitud);

                                        codigo = raf.readUTF();
                                        nombrePropietario = raf.readUTF();
                                        mesRecibo = raf.readUTF();
                                        cuotaFija = raf.readFloat();
                                        agua = raf.readFloat();
                                        calefaccion = raf.readFloat();
                                        recibo = raf.readFloat();

                                        System.out.println("------------------------------");
                                        System.out.println("codigo: " + codigo);
                                        System.out.println("Nombre: " + nombrePropietario);
                                        System.out.println("Mes del recibo: " + mesRecibo);
                                        System.out.println("Cuota fija: " + cuotaFija);
                                        System.out.println("Litros de agua: " + agua);
                                        System.out.println("Calefaccion: " + calefaccion);
                                        System.out.println("Recibo: " + recibo);
                                        System.out.println("------------------------------");
                                    } else {
                                        System.out.println("No hay registros");
                                    }
                                }
                            }
                            break;
                        case 2:
                            File fichero2 = new File("atico");
                            raf = new RandomAccessFile(fichero2, "r");

                            System.out.println("¿Quieres visualizar los aticos?");
                            resp = leer.readLine().charAt(0);

                            if (resp == 's' || resp == 'S') {
                                for (int i = 0; i < numeroRegistros(fichero2); i++) {
                                    if (i >= 0 && i < numeroRegistros(fichero2)) {
                                        raf.seek(i * atico.maximaLongitud);

                                        codigo = raf.readUTF();
                                        nombrePropietario = raf.readUTF();
                                        mesRecibo = raf.readUTF();
                                        cuotaFija = raf.readFloat();
                                        agua = raf.readFloat();
                                        calefaccion = raf.readFloat();
                                        metrosTerraza = raf.readFloat();
                                        recibo = raf.readFloat();

                                        System.out.println("------------------------------");
                                        System.out.println("codigo: " + codigo);
                                        System.out.println("Nombre: " + nombrePropietario);
                                        System.out.println("Mes del recibo: " + mesRecibo);
                                        System.out.println("Cuota fija: " + cuotaFija);
                                        System.out.println("Litros de agua: " + agua);
                                        System.out.println("Calefaccion: " + calefaccion);
                                        System.out.println("Metros de la Terraza: " + metrosTerraza);
                                        System.out.println("Recibo: " + recibo);
                                        System.out.println("------------------------------");
                                    } else {
                                        System.out.println("No hay registros");
                                    }
                                }
                            }
                            break;
                        case 3:
                            File fichero3 = new File("duplex");
                            raf = new RandomAccessFile(fichero3, "r");

                            System.out.println("¿Quieres visualizar los duplex?");
                            resp = leer.readLine().charAt(0);
                            if (resp == 's' || resp == 'S') {
                                for (int i = 0; i < numeroRegistros(fichero3); i++) {
                                    if (i >= 0 && i < numeroRegistros(fichero3)) {
                                        raf.seek(i * duplex.maximaLongitud);

                                        codigo = raf.readUTF();
                                        nombrePropietario = raf.readUTF();
                                        mesRecibo = raf.readUTF();
                                        cuotaFija = raf.readFloat();
                                        agua = raf.readFloat();
                                        calefaccion = raf.readFloat();
                                        cuotaEspecial = raf.readFloat();
                                        recibo = raf.readFloat();

                                        System.out.println("------------------------------");
                                        System.out.println("codigo: " + codigo);
                                        System.out.println("Nombre: " + nombrePropietario);
                                        System.out.println("Mes del recibo: " + mesRecibo);
                                        System.out.println("Cuota fija: " + cuotaFija);
                                        System.out.println("Litros de agua: " + agua);
                                        System.out.println("Calefaccion: " + calefaccion);
                                        System.out.println("Cuota Especial: " + cuotaEspecial);
                                        System.out.println("Recibo: " + recibo);
                                        System.out.println("------------------------------");
                                    } else {
                                        System.out.println("No hay ningun registro");
                                    }
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Fin de la visualizacion");
                            break;
                        default:
                            System.out.println("Esa opcion no es valida");
                            break;
                    }
                    if (raf != null) {
                        raf.close();
                    }
                } while (op != 4);
            } else {
            }
        } catch (EOFException e) {
        }
    }

    public static void baja() throws IOException {
        char resp = ' ';
        byte op;
        RandomAccessFile raf;
        RandomAccessFile raf2;
        
        String codigo;
        String nombrePropietario;
        String mesRecibo;
        float cuotaFija;
        float agua;
        float calefaccion;
        float metrosTerraza;
        float cuotaEspecial;
        float recibo;

        try {
            System.out.println("¿Quieres borrar un registro?");
            resp = leer.readLine().charAt(0);
            if (resp == 's' || resp == 'S') {
                do {
                    System.out.println("------------------------------");
                    System.out.println("Escoja el tipo de registro");
                    System.out.println("Opcion 1: Piso estandar");
                    System.out.println("Opcion 2: Atico");
                    System.out.println("Opcion 3: Duplex");
                    System.out.println("Opcion 4: Fin");
                    System.out.println("------------------------------");
                    System.out.print("Opcion: ");
                    op = Byte.parseByte(leer.readLine());
                    switch (op) {
                        case 1:
                            System.out.println("¿Quieres borrar un piso?");
                            resp = leer.readLine().charAt(0);
                            if (resp == 's' || resp == 'S') {
                                System.out.println("Indica el registro que quieres borrar");
                                String campo = leer.readLine();

                                File fichero = new File("piso");
                                File fichero2 = new File("piso2");
                                raf = new RandomAccessFile(fichero, "r");
                                raf2 = new RandomAccessFile(fichero2, "rw");

                                for (int i = 0; i < numeroRegistros(fichero); i++) {
                                    raf.seek(i * piso.maximaLongitud);
                                    codigo = raf.readUTF();
                                    if (campo.compareToIgnoreCase(codigo) == 0) {
                                        nombrePropietario = raf.readUTF();
                                        mesRecibo = raf.readUTF();
                                        cuotaFija = raf.readFloat();
                                        agua = raf.readFloat();
                                        calefaccion = raf.readFloat();
                                        recibo = raf.readFloat();

                                        System.out.println("------------------------------");
                                        System.out.println("codigo: " + codigo);
                                        System.out.println("Nombre: " + nombrePropietario);
                                        System.out.println("Mes del recibo " + mesRecibo);
                                        System.out.println("Cuota fija " + cuotaFija);
                                        System.out.println("Litros de agua " + agua);
                                        System.out.println("Calefaccion " + calefaccion);
                                        System.out.println("Recibo " + recibo);
                                        System.out.println("------------------------------");

                                        System.out.println("¿Quieres borrar este registro?");
                                        resp = leer.readLine().charAt(0);
                                        if (resp == 's' || resp == 'S') {
                                            for (int j = 0; j < numeroRegistros(fichero); j++) {
                                                raf.seek(j * piso.maximaLongitud);

                                                String codigoC = raf.readUTF();
                                                String nombrePropietarioC = raf.readUTF();
                                                String mesReciboC = raf.readUTF();
                                                float cuotaFijaC = raf.readFloat();
                                                float aguaC = raf.readFloat();
                                                float calefaccionC = raf.readFloat();
                                                float reciboC = raf.readFloat();
                                                
                                                if (campo.compareToIgnoreCase(codigoC) != 0) {
                                                    raf2.seek(j * piso.maximaLongitud);

                                                    raf2.writeUTF(codigoC);
                                                    raf2.writeUTF(nombrePropietarioC);
                                                    raf2.writeUTF(mesReciboC);
                                                    raf2.writeFloat(cuotaFijaC);
                                                    raf2.writeFloat(aguaC);
                                                    raf2.writeFloat(calefaccionC);
                                                    raf2.writeFloat(reciboC);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        default:
                            break;

                    }
                } while (op != 4);

            } else {
            }
        } catch (EOFException e) {
        }
    }

    public static void modificar() throws IOException {
        char resp = ' ';
        byte op;
        RandomAccessFile raf = null;

        String codigo;
        String nombrePropietario;
        String mesRecibo;
        float cuotaFija;
        float agua;
        float calefaccion;
        float recibo;
        float metrosTerraza;
        float cuotaEspecial;

        System.out.println("¿Quieres modificar un registro?");
        resp = leer.readLine().charAt(0);
        if (resp == 's' || resp == 'S') {
            do {
                System.out.println("------------------------------");
                System.out.println("Escoja el tipo de registro");
                System.out.println("Opcion 1: Piso estandar");
                System.out.println("Opcion 2: Atico");
                System.out.println("Opcion 3: Duplex");
                System.out.println("Opcion 4: Fin");
                System.out.println("------------------------------");
                System.out.print("Opcion: ");
                op = Byte.parseByte(leer.readLine());

                switch (op) {
                    case 1:
                        File fichero = new File("piso");
                        raf = new RandomAccessFile(fichero, "rw");

                        System.out.println("¿Quieres modificar un piso?");
                        resp = leer.readLine().charAt(0);
                        if (resp == 's' || resp == 'S') {
                            System.out.println("Indica el registro que quieres modificar");
                            String campo = leer.readLine();
                            for (int i = 0; i < numeroRegistros(fichero); i++) {
                                raf.seek(i * piso.maximaLongitud);
                                codigo = raf.readUTF();

                                if (campo.compareToIgnoreCase(codigo) == 0) {
                                    nombrePropietario = raf.readUTF();
                                    mesRecibo = raf.readUTF();
                                    cuotaFija = raf.readFloat();
                                    agua = raf.readFloat();
                                    calefaccion = raf.readFloat();
                                    recibo = raf.readFloat();

                                    System.out.println("------------------------------");
                                    System.out.println("codigo: " + codigo);
                                    System.out.println("Nombre: " + nombrePropietario);
                                    System.out.println("Mes del recibo " + mesRecibo);
                                    System.out.println("Cuota fija " + cuotaFija);
                                    System.out.println("Litros de agua " + agua);
                                    System.out.println("Calefaccion " + calefaccion);
                                    System.out.println("Recibo " + recibo);
                                    System.out.println("------------------------------");

                                    do {
                                        System.out.println("¿Que campo quieres modificar?");
                                        System.out.println("Opcion 1: Codigo");
                                        System.out.println("Opcion 2: Nombre del Propietario");
                                        System.out.println("Opcion 3: Mes del recibo");
                                        System.out.println("Opcion 4: Cuota Fija");
                                        System.out.println("Opcion 5: Litros de agua");
                                        System.out.println("Opcion 6: Calefaccion");
                                        System.out.println("Opcion 7: Fin");
                                        System.out.println("------------------------------");
                                        System.out.print("Opcion: ");
                                        op = Byte.parseByte(leer.readLine());

                                        switch (op) {
                                            case 1:
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("¿Quieres modificar el codigo: " + codigo + "?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Indica el Codigo nuevo: ");
                                                    codigo = leer.readLine();
                                                }
                                                System.out.println("-----------------------------------------------");
                                                break;
                                            case 2:
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("¿Quieres modificar el nombre de propietario: " + nombrePropietario + "?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Indica el Nombre del propietario nuevo: ");
                                                    nombrePropietario = leer.readLine();
                                                }
                                                System.out.println("-----------------------------------------------");
                                                break;
                                            case 3:
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("¿Quieres modificar el mes de recibo: " + mesRecibo + "?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Indica el Mes de recibo nuevo: ");
                                                    mesRecibo = leer.readLine();
                                                }
                                                System.out.println("-----------------------------------------------");
                                                break;
                                            case 4:
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("¿Quieres modificar la cuota fija: " + cuotaFija + "?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Indica la cuota fija nueva: ");
                                                    cuotaFija = Float.parseFloat(leer.readLine());
                                                }
                                                System.out.println("-----------------------------------------------");
                                                break;
                                            case 5:
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("¿Quieres modificar los litros de agua: " + agua + "?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Indica los litros de agua nuevos: ");
                                                    agua = Float.parseFloat(leer.readLine());
                                                }
                                                System.out.println("-----------------------------------------------");
                                                break;
                                            case 6:
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("¿Quieres modificar la calefaccion: " + calefaccion + "?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Indica la calefaccion nueva: ");
                                                    calefaccion = Float.parseFloat(leer.readLine());
                                                }
                                                System.out.println("-----------------------------------------------");
                                                break;
                                            case 7:
                                                raf.seek(i * piso.maximaLongitud);

                                                raf.writeUTF(codigo);
                                                raf.writeUTF(nombrePropietario);
                                                raf.writeUTF(mesRecibo);
                                                raf.writeFloat(cuotaFija);
                                                raf.writeFloat(agua);
                                                raf.writeFloat(calefaccion);
                                                raf.writeFloat(recibo);

                                                System.out.println("Fin de modificado");
                                                break;
                                            default:
                                                System.out.println("Esa opcion no es correcta;");
                                                break;
                                        }
                                    } while (op != 7);
                                }
                            }
                        }
                        break;
                    case 2:
                        File fichero2 = new File("atico");
                        raf = new RandomAccessFile(fichero2, "rw");

                        System.out.println("¿Quieres modificar un atico?");
                        resp = leer.readLine().charAt(0);
                        if (resp == 's' || resp == 'S') {
                            System.out.println("Indica el registro que quieres modificar");
                            String campo = leer.readLine();
                            for (int i = 0; i < numeroRegistros(fichero2); i++) {
                                raf.seek(i * atico.maximaLongitud);
                                codigo = raf.readUTF();

                                if (campo.compareToIgnoreCase(codigo) == 0) {
                                    nombrePropietario = raf.readUTF();
                                    mesRecibo = raf.readUTF();
                                    cuotaFija = raf.readFloat();
                                    agua = raf.readFloat();
                                    calefaccion = raf.readFloat();
                                    metrosTerraza = raf.readFloat();
                                    recibo = raf.readFloat();

                                    System.out.println("------------------------------");
                                    System.out.println("codigo: " + codigo);
                                    System.out.println("Nombre: " + nombrePropietario);
                                    System.out.println("Mes del recibo: " + mesRecibo);
                                    System.out.println("Cuota fija: " + cuotaFija);
                                    System.out.println("Litros de agua: " + agua);
                                    System.out.println("Calefaccion: " + calefaccion);
                                    System.out.println("Metros de la Terraza: " + metrosTerraza);
                                    System.out.println("Recibo: " + recibo);
                                    System.out.println("------------------------------");

                                    do {
                                        System.out.println("¿Que campo quieres modificar?");
                                        System.out.println("Opcion 1: Codigo");
                                        System.out.println("Opcion 2: Nombre del Propietario");
                                        System.out.println("Opcion 3: Mes del recibo");
                                        System.out.println("Opcion 4: Cuota Fija");
                                        System.out.println("Opcion 5: Litros de agua");
                                        System.out.println("Opcion 6: Calefaccion");
                                        System.out.println("Opcion 7: Metros terraza");
                                        System.out.println("Opcion 8: Fin");
                                        System.out.println("------------------------------");
                                        System.out.print("Opcion: ");
                                        op = Byte.parseByte(leer.readLine());

                                        switch (op) {
                                            case 1:
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("¿Quieres modificar el codigo: " + codigo + "?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Indica el Codigo nuevo: ");
                                                    codigo = leer.readLine();
                                                }
                                                System.out.println("-----------------------------------------------");
                                                break;
                                            case 2:
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("¿Quieres modificar el nombre de propietario: " + nombrePropietario + "?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Indica el Nombre del propietario nuevo: ");
                                                    nombrePropietario = leer.readLine();
                                                }
                                                System.out.println("-----------------------------------------------");
                                                break;
                                            case 3:
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("¿Quieres modificar el mes de recibo: " + mesRecibo + "?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Indica el Mes de recibo nuevo: ");
                                                    mesRecibo = leer.readLine();
                                                }
                                                System.out.println("-----------------------------------------------");
                                                break;
                                            case 4:
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("¿Quieres modificar la cuota fija: " + cuotaFija + "?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Indica la cuota fija nueva: ");
                                                    cuotaFija = Float.parseFloat(leer.readLine());
                                                }
                                                System.out.println("-----------------------------------------------");
                                                break;
                                            case 5:
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("¿Quieres modificar los litros de agua: " + agua + "?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Indica los litros de agua nuevos: ");
                                                    agua = Float.parseFloat(leer.readLine());
                                                }
                                                System.out.println("-----------------------------------------------");
                                                break;
                                            case 6:
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("¿Quieres modificar la calefaccion: " + calefaccion + "?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Indica la calefaccion nueva: ");
                                                    calefaccion = Float.parseFloat(leer.readLine());
                                                }
                                                System.out.println("-----------------------------------------------");
                                                break;
                                            case 7:
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("¿Quieres modificar los metros de la terraza: " + metrosTerraza + "?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Indica los metros de terraza nuevos: ");
                                                    metrosTerraza = Float.parseFloat(leer.readLine());
                                                }
                                                System.out.println("-----------------------------------------------");
                                                break;
                                            case 8:
                                                raf.seek(i * atico.maximaLongitud);

                                                raf.writeUTF(codigo);
                                                raf.writeUTF(nombrePropietario);
                                                raf.writeUTF(mesRecibo);
                                                raf.writeFloat(cuotaFija);
                                                raf.writeFloat(agua);
                                                raf.writeFloat(calefaccion);
                                                raf.writeFloat(metrosTerraza);
                                                raf.writeFloat(recibo);

                                                System.out.println("Fin de modificado");
                                                break;
                                            default:
                                                System.out.println("Esa opcion no es correcta;");
                                                break;
                                        }
                                    } while (op != 8);
                                }
                            }
                        }
                        break;
                    case 3:
                        File fichero3 = new File("duplex");
                        raf = new RandomAccessFile(fichero3, "rw");

                        System.out.println("¿Quieres modificar un duplex?");
                        resp = leer.readLine().charAt(0);
                        if (resp == 's' || resp == 'S') {
                            System.out.println("Indica el registro que quieres modificar");
                            String campo = leer.readLine();
                            for (int i = 0; i < numeroRegistros(fichero3); i++) {
                                raf.seek(i * duplex.maximaLongitud);
                                codigo = raf.readUTF();

                                if (campo.compareToIgnoreCase(codigo) == 0) {
                                    nombrePropietario = raf.readUTF();
                                    mesRecibo = raf.readUTF();
                                    cuotaFija = raf.readFloat();
                                    agua = raf.readFloat();
                                    calefaccion = raf.readFloat();
                                    cuotaEspecial = raf.readFloat();
                                    recibo = raf.readFloat();

                                    System.out.println("------------------------------");
                                    System.out.println("codigo: " + codigo);
                                    System.out.println("Nombre: " + nombrePropietario);
                                    System.out.println("Mes del recibo: " + mesRecibo);
                                    System.out.println("Cuota fija: " + cuotaFija);
                                    System.out.println("Litros de agua: " + agua);
                                    System.out.println("Calefaccion: " + calefaccion);
                                    System.out.println("Cuota Especial: " + cuotaEspecial);
                                    System.out.println("Recibo: " + recibo);
                                    System.out.println("------------------------------");

                                    do {
                                        System.out.println("¿Que campo quieres modificar?");
                                        System.out.println("Opcion 1: Codigo");
                                        System.out.println("Opcion 2: Nombre del Propietario");
                                        System.out.println("Opcion 3: Mes del recibo");
                                        System.out.println("Opcion 4: Cuota Fija");
                                        System.out.println("Opcion 5: Litros de agua");
                                        System.out.println("Opcion 6: Calefaccion");
                                        System.out.println("Opcion 7: Cuota Especial");
                                        System.out.println("Opcion 8: Fin");
                                        System.out.println("------------------------------");
                                        System.out.print("Opcion: ");
                                        op = Byte.parseByte(leer.readLine());

                                        switch (op) {
                                            case 1:
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("¿Quieres modificar el codigo: " + codigo + "?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Indica el Codigo nuevo: ");
                                                    codigo = leer.readLine();
                                                }
                                                System.out.println("-----------------------------------------------");
                                                break;
                                            case 2:
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("¿Quieres modificar el nombre de propietario: " + nombrePropietario + "?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Indica el Nombre del propietario nuevo: ");
                                                    nombrePropietario = leer.readLine();
                                                }
                                                System.out.println("-----------------------------------------------");
                                                break;
                                            case 3:
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("¿Quieres modificar el mes de recibo: " + mesRecibo + "?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Indica el Mes de recibo nuevo: ");
                                                    mesRecibo = leer.readLine();
                                                }
                                                System.out.println("-----------------------------------------------");
                                                break;
                                            case 4:
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("¿Quieres modificar la cuota fija: " + cuotaFija + "?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Indica la cuota fija nueva: ");
                                                    cuotaFija = Float.parseFloat(leer.readLine());
                                                }
                                                System.out.println("-----------------------------------------------");
                                                break;
                                            case 5:
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("¿Quieres modificar los litros de agua: " + agua + "?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Indica los litros de agua nuevos: ");
                                                    agua = Float.parseFloat(leer.readLine());
                                                }
                                                System.out.println("-----------------------------------------------");
                                                break;
                                            case 6:
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("¿Quieres modificar la calefaccion: " + calefaccion + "?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Indica la calefaccion nueva: ");
                                                    calefaccion = Float.parseFloat(leer.readLine());
                                                }
                                                System.out.println("-----------------------------------------------");
                                                break;
                                            case 7:
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("¿Quieres modificar la cuota especial: " + cuotaEspecial + "?");
                                                resp = leer.readLine().charAt(0);
                                                if (resp == 's' || resp == 'S') {
                                                    System.out.print("Indica la cuota especial nueva: ");
                                                    cuotaEspecial = Float.parseFloat(leer.readLine());
                                                }
                                                System.out.println("-----------------------------------------------");
                                                break;
                                            case 8:
                                                raf.seek(i * duplex.maximaLongitud);

                                                raf.writeUTF(codigo);
                                                raf.writeUTF(nombrePropietario);
                                                raf.writeUTF(mesRecibo);
                                                raf.writeFloat(cuotaFija);
                                                raf.writeFloat(agua);
                                                raf.writeFloat(calefaccion);
                                                raf.writeFloat(cuotaEspecial);
                                                raf.writeFloat(recibo);

                                                System.out.println("Fin de modificado");
                                                break;
                                            default:
                                                System.out.println("Esa opcion no es correcta;");
                                                break;
                                        }
                                    } while (op != 8);
                                }
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Fin de modificacion");
                        break;
                    default:
                        break;
                }
            } while (op != 4);
        } else {
        }
    }

    public static void consulta() throws IOException {
        char resp = ' ';
        ArrayList<PisoEstandar> pisos = new ArrayList();
        PisoEstandar objTemp = null;
        int cantidad = 0;
        int cantidadTotalP = 0;
        int cantidadTotalA = 0;
        int cantidadTotalD = 0;

        String nombre;

        pisos = cargar();

        try {
            System.out.println("¿Quieres consultar algun registro?");
            resp = leer.readLine().charAt(0);
            if (resp == 's' || resp == 'S') {
                System.out.println("Indica el registro que quieres consultar");
                String campo = leer.readLine();

                for (int i = 0; i < pisos.size(); i++) {
                    nombre = pisos.get(i).getNombrePropietario();
                    if (campo.compareToIgnoreCase(nombre) == 0) {
                        cantidad++;
                    }

                    if (i == pisos.size() - 1) {
                        for (int j = 0; j < cantidadP; j++) {
                            nombre = pisos.get(j).getNombrePropietario();
                            if (pisos.contains(piso)) {
                                if (campo.compareToIgnoreCase(nombre) == 0) {
                                    cantidadTotalP++;
                                }
                            }
                        }

                        for (int j = 0; j < cantidadA; j++) {
                            nombre = pisos.get(j).getNombrePropietario();
                            if (pisos.contains(atico)) {
                                if (campo.compareToIgnoreCase(nombre) == 0) {
                                    cantidadTotalA++;
                                }
                            }
                        }

                        for (int j = 0; j < cantidadD; j++) {
                            nombre = pisos.get(j).getNombrePropietario();
                            if (pisos.contains(duplex)) {
                                if (campo.compareToIgnoreCase(nombre) == 0) {
                                    cantidadTotalD++;
                                }
                            }
                        }
                    }
                }
                System.out.println("Tiene " + cantidadTotalP + " Piso");
                System.out.println("Tiene " + cantidadTotalA + " atico");
                System.out.println("Tiene " + cantidadTotalD + " duplex");
                System.out.println("Cantidad de pisos: " + cantidad);
            } else {
            }
        } catch (NullPointerException e) {
        }

    }

    public static int numeroRegistros(File fichero) {
        int numeroRegistros = (int) Math.ceil((double) fichero.length() / (double) piso.maximaLongitud);
        return numeroRegistros;
    }

    public static ArrayList cargar() throws FileNotFoundException, IOException {
        

        File fichero = new File("piso");
        File fichero2 = new File("atico");
        File fichero3 = new File("duplex");
        RandomAccessFile raf = new RandomAccessFile(fichero, "r");
        RandomAccessFile raf2 = new RandomAccessFile(fichero2, "r");
        RandomAccessFile raf3 = new RandomAccessFile(fichero3, "r");
        ArrayList<PisoEstandar> pisos = new ArrayList();

        String codigo;
        String nombrePropietario;
        String mesRecibo;
        float cuotaFija;
        float agua;
        float calefaccion;
        float recibo;
        float metrosTerraza;
        float cuotaEspecial;

        try {
            for (int i = 0; i < numeroRegistros(fichero); i++) {
                if (i >= 0 && i < numeroRegistros(fichero)) {
                    raf.seek(i * PisoEstandar.maximaLongitud);

                    codigo = raf.readUTF();
                    nombrePropietario = raf.readUTF();
                    mesRecibo = raf.readUTF();
                    cuotaFija = raf.readFloat();
                    agua = raf.readFloat();
                    calefaccion = raf.readFloat();
                    recibo = raf.readFloat();

                    if (totalCargas < 1) {
                        cantidadP++;
                    }

                    piso = new PisoEstandar(codigo, nombrePropietario, mesRecibo, cuotaFija, agua, calefaccion);
                    pisos.add(piso);
                }
            }

            for (int i = 0; i < numeroRegistros(fichero2); i++) {
                if (i >= 0 && i < numeroRegistros(fichero2)) {
                    raf2.seek(i * PisoEstandar.maximaLongitud);

                    codigo = raf2.readUTF();
                    nombrePropietario = raf2.readUTF();
                    mesRecibo = raf2.readUTF();
                    cuotaFija = raf2.readFloat();
                    agua = raf2.readFloat();
                    calefaccion = raf2.readFloat();
                    metrosTerraza = raf2.readFloat();
                    recibo = raf2.readFloat();

                    if (totalCargas < 1) {
                        cantidadA++;
                    }
                    
                    atico = new Atico(codigo, nombrePropietario, mesRecibo, cuotaFija, agua, calefaccion, metrosTerraza);
                    pisos.add(atico);
                }
            }

            for (int i = 0; i < numeroRegistros(fichero3); i++) {
                if (i >= 0 && i < numeroRegistros(fichero3)) {
                    raf3.seek(i * PisoEstandar.maximaLongitud);

                    codigo = raf3.readUTF();
                    nombrePropietario = raf3.readUTF();
                    mesRecibo = raf3.readUTF();
                    cuotaFija = raf3.readFloat();
                    agua = raf3.readFloat();
                    calefaccion = raf3.readFloat();
                    cuotaEspecial = raf3.readFloat();
                    recibo = raf3.readFloat();

                    if (totalCargas < 1) {
                        cantidadD++;
                    }
                    
                    duplex = new Duplex(codigo, nombrePropietario, mesRecibo, cuotaFija, agua, calefaccion, cuotaEspecial);
                    pisos.add(duplex);
                }
            }
            
            totalCargas++;
        } catch (EOFException e) {
        }
        return pisos;
    }
}
