/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionficheroaleatorios_pisosv2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;


/**
 *
 * @author adrian
 */
public class Metodos {

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static PisoEstandar piso;
    static Atico atico;
    static Duplex duplex;

    public static void crear() throws IOException {
        File fichero = new File("prueba");

        if (!fichero.exists()) {
            fichero.createNewFile();
        }
    }

    public static void altas() throws IOException {
        char resp = ' ';
        byte op;
        RandomAccessFile raf = null;
        char tipo;
        String codigo;
        String nombrePropietario;
        String mesRecibo;
        float cuotaFija;
        float agua;
        float calefaccion;
        float cuotaEspecial;
        float metrosTerraza;
        boolean b = true;

        File fichero = new File("prueba");
        raf = new RandomAccessFile(fichero, "rw");

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
                        do {
                            System.out.println("------------------------------");
                            System.out.println("Rellena los siguientes campos");
                            System.out.print("Codigo: ");
                            codigo = leer.readLine();
                            System.out.print("Nombre del propietario: ");
                            nombrePropietario = leer.readLine();
                            System.out.print("Mes del recibo: ");
                            mesRecibo = leer.readLine();
                            System.out.print("Cuota fija: ");
                            cuotaFija = Float.parseFloat(leer.readLine());
                            System.out.print("Agua: ");
                            agua = Float.parseFloat(leer.readLine());
                            System.out.print("Calefaccion: ");
                            calefaccion = Float.parseFloat(leer.readLine());
                            System.out.println("------------------------------");

                            tipo = 'P';
                            piso = new PisoEstandar(tipo, codigo, nombrePropietario, mesRecibo, cuotaFija, agua, calefaccion);
                            if (piso.tamañoRegistro() + 4 < piso.maximaLongitud) {
                                raf.seek(numeroRegistro(fichero) * piso.maximaLongitud);

                                raf.writeChar(tipo);
                                raf.writeUTF(codigo);
                                raf.writeUTF(nombrePropietario);
                                raf.writeUTF(mesRecibo);
                                raf.writeFloat(cuotaFija);
                                raf.writeFloat(agua);
                                raf.writeFloat(calefaccion);
                                raf.writeFloat(piso.totalRecibo());
                                b = false;
                            } else {
                                System.out.println("El tamaño del registro excede el tamaño maximo. Intentalo otra vez");
                            }
                        } while (b);
                        break;
                    case 2:
                        do {
                            System.out.println("------------------------------");
                            System.out.println("Rellena los siguientes campos");
                            System.out.print("Codigo: ");
                            codigo = leer.readLine();
                            System.out.print("Nombre del propietario: ");
                            nombrePropietario = leer.readLine();
                            System.out.print("Mes del recibo: ");
                            mesRecibo = leer.readLine();
                            System.out.print("Cuota fija: ");
                            cuotaFija = Float.parseFloat(leer.readLine());
                            System.out.print("Agua: ");
                            agua = Float.parseFloat(leer.readLine());
                            System.out.print("Calefaccion: ");
                            calefaccion = Float.parseFloat(leer.readLine());
                            System.out.print("Metros de la terraza: ");
                            metrosTerraza = Float.parseFloat(leer.readLine());
                            System.out.println("------------------------------");

                            tipo = 'A';
                            atico = new Atico(tipo, codigo, nombrePropietario, mesRecibo, cuotaFija, agua, calefaccion, metrosTerraza);
                            if (atico.tamañoRegistro() + 4 < atico.maximaLongitud) {
                                raf.seek(numeroRegistro(fichero) * atico.maximaLongitud);

                                raf.writeChar(tipo);
                                raf.writeUTF(codigo);
                                raf.writeUTF(nombrePropietario);
                                raf.writeUTF(mesRecibo);
                                raf.writeFloat(cuotaFija);
                                raf.writeFloat(agua);
                                raf.writeFloat(calefaccion);
                                raf.writeFloat(metrosTerraza);
                                raf.writeFloat(atico.totalRecibo());
                                b = false;
                            } else {
                                System.out.println("El tamaño del registro excede el tamaño maximo. Intentalo otra vez");
                            }
                        } while (b);
                        break;
                    case 3:
                        do {
                            System.out.println("------------------------------");
                            System.out.println("Rellena los siguientes campos");
                            System.out.print("Codigo: ");
                            codigo = leer.readLine();
                            System.out.print("Nombre del propietario: ");
                            nombrePropietario = leer.readLine();
                            System.out.print("Mes del recibo: ");
                            mesRecibo = leer.readLine();
                            System.out.print("Cuota fija: ");
                            cuotaFija = Float.parseFloat(leer.readLine());
                            System.out.print("Agua: ");
                            agua = Float.parseFloat(leer.readLine());
                            System.out.print("Calefaccion: ");
                            calefaccion = Float.parseFloat(leer.readLine());
                            System.out.print("Cuota Especial: ");
                            cuotaEspecial = Float.parseFloat(leer.readLine());
                            System.out.println("------------------------------");

                            tipo = 'D';
                            duplex = new Duplex(tipo, codigo, nombrePropietario, mesRecibo, cuotaFija, agua, calefaccion, cuotaEspecial);
                            if (duplex.tamañoRegistro() + 4 < duplex.maximaLongitud) {
                                raf.seek(numeroRegistro(fichero) * duplex.maximaLongitud);

                                raf.writeChar(tipo);
                                raf.writeUTF(codigo);
                                raf.writeUTF(nombrePropietario);
                                raf.writeUTF(mesRecibo);
                                raf.writeFloat(cuotaFija);
                                raf.writeFloat(agua);
                                raf.writeFloat(calefaccion);
                                raf.writeFloat(cuotaEspecial);
                                raf.writeFloat(duplex.totalRecibo());
                                b = false;
                            } else {
                                System.out.println("El tamaño del registro excede el tamaño maximo. Intentalo otra vez");
                            }
                        } while (b);
                        break;
                    case 4:
                        System.out.println("Fin de altas");
                        break;
                    default:
                        System.out.println("Esa opcion no es validad");
                        break;
                }
            } while (op != 4);
        } else {
        }
    }

    public static void listar() throws IOException {
        char resp = ' ';
        byte op;
        RandomAccessFile raf = null;
        char tipo;
        String codigo;
        String nombrePropietario;
        String mesRecibo;
        float cuotaFija;
        float agua;
        float calefaccion;
        float cuotaEspecial;
        float metrosTerraza;
        float recibo;

        File fichero = new File("prueba2");
        raf = new RandomAccessFile(fichero, "r");

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
                        tipo = 'P';
                        for (int i = 0; i < numeroRegistro(fichero); i++) {
                            if (i >= 0 && i < numeroRegistro(fichero)) {
                                raf.seek(i * piso.maximaLongitud);
                                char campo = raf.readChar();
                                if (tipo == campo) {

                                    codigo = raf.readUTF();
                                    nombrePropietario = raf.readUTF();
                                    mesRecibo = raf.readUTF();
                                    cuotaFija = raf.readFloat();
                                    agua = raf.readFloat();
                                    calefaccion = raf.readFloat();
                                    recibo = raf.readFloat();

                                    System.out.println("------------------------------");
                                    System.out.println("Tipo: " + tipo);
                                    System.out.println("codigo: " + codigo);
                                    System.out.println("Nombre: " + nombrePropietario);
                                    System.out.println("Mes del recibo: " + mesRecibo);
                                    System.out.println("Cuota fija: " + cuotaFija);
                                    System.out.println("Litros de agua: " + agua);
                                    System.out.println("Calefaccion: " + calefaccion);
                                    System.out.println("Recibo: " + recibo);
                                    System.out.println("------------------------------");
                                }
                            }
                        }
                        break;
                    case 2:
                        tipo = 'A';
                        for (int i = 0; i < numeroRegistro(fichero); i++) {
                            if (i >= 0 && i < numeroRegistro(fichero)) {
                                raf.seek(i * atico.maximaLongitud);
                                char campo = raf.readChar();
                                if (tipo == campo) {

                                    codigo = raf.readUTF();
                                    nombrePropietario = raf.readUTF();
                                    mesRecibo = raf.readUTF();
                                    cuotaFija = raf.readFloat();
                                    agua = raf.readFloat();
                                    calefaccion = raf.readFloat();
                                    metrosTerraza = raf.readFloat();
                                    recibo = raf.readFloat();

                                    System.out.println("------------------------------");
                                    System.out.println("Tipo: " + tipo);
                                    System.out.println("codigo: " + codigo);
                                    System.out.println("Nombre: " + nombrePropietario);
                                    System.out.println("Mes del recibo: " + mesRecibo);
                                    System.out.println("Cuota fija: " + cuotaFija);
                                    System.out.println("Litros de agua: " + agua);
                                    System.out.println("Calefaccion: " + calefaccion);
                                    System.out.println("Metros de la terraza: " + metrosTerraza);
                                    System.out.println("Recibo: " + recibo);
                                    System.out.println("------------------------------");
                                }
                            }
                        }
                        break;
                    case 3:
                        tipo = 'D';
                        for (int i = 0; i < numeroRegistro(fichero); i++) {
                            if (i >= 0 && i < numeroRegistro(fichero)) {
                                raf.seek(i * duplex.maximaLongitud);
                                char campo = raf.readChar();
                                if (tipo == campo) {

                                    codigo = raf.readUTF();
                                    nombrePropietario = raf.readUTF();
                                    mesRecibo = raf.readUTF();
                                    cuotaFija = raf.readFloat();
                                    agua = raf.readFloat();
                                    calefaccion = raf.readFloat();
                                    cuotaEspecial = raf.readFloat();
                                    recibo = raf.readFloat();

                                    System.out.println("------------------------------");
                                    System.out.println("Tipo: " + tipo);
                                    System.out.println("codigo: " + codigo);
                                    System.out.println("Nombre: " + nombrePropietario);
                                    System.out.println("Mes del recibo: " + mesRecibo);
                                    System.out.println("Cuota fija: " + cuotaFija);
                                    System.out.println("Litros de agua: " + agua);
                                    System.out.println("Calefaccion: " + calefaccion);
                                    System.out.println("Cuota Especial" + cuotaEspecial);
                                    System.out.println("Recibo: " + recibo);
                                    System.out.println("------------------------------");
                                }
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Fin del visualizado");
                        break;
                    default:
                        System.out.println("Esa opcion no es correcta");
                        break;
                }
            } while (op != 4);

        } else {
            System.out.println("Volviendo al menu");
        }
    }

    public static void baja() throws IOException {
        char resp = ' ';
        byte op;
        RandomAccessFile raf = null;
        RandomAccessFile raf2 = null;
        char tipo;
        String codigo;
        String nombrePropietario;
        String mesRecibo;
        float cuotaFija;
        float agua;
        float calefaccion;
        float cuotaEspecial;
        float metrosTerraza;
        float recibo;

        File fichero = new File("prueba");
        raf = new RandomAccessFile(fichero, "r");
        File fichero2 = new File("prueba2");
        raf2 = new RandomAccessFile(fichero2, "rw");

        System.out.println("¿Quieres dar de baja algun registro?");
        resp = leer.readLine().charAt(0);
        if (resp == 's' || resp == 'S') {
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
                    tipo = 'P';
                    System.out.println("Indica el registro que quieres borrar");
                    String campoCP = leer.readLine();
                    for (int i = 0; i < numeroRegistro(fichero); i++) {
                        if (i >= 0 && i < numeroRegistro(fichero)) {
                            raf.seek(i * piso.maximaLongitud);
                            char campoP = raf.readChar();
                            if (tipo == campoP) {
                                codigo = raf.readUTF();
                                if (campoCP.compareToIgnoreCase(codigo) == 0) {
                                    nombrePropietario = raf.readUTF();
                                    mesRecibo = raf.readUTF();
                                    cuotaFija = raf.readFloat();
                                    agua = raf.readFloat();
                                    calefaccion = raf.readFloat();
                                    recibo = raf.readFloat();

                                    System.out.println("------------------------------");
                                    System.out.println("Tipo: " + tipo);
                                    System.out.println("codigo: " + codigo);
                                    System.out.println("Nombre: " + nombrePropietario);
                                    System.out.println("Mes del recibo: " + mesRecibo);
                                    System.out.println("Cuota fija: " + cuotaFija);
                                    System.out.println("Litros de agua: " + agua);
                                    System.out.println("Calefaccion: " + calefaccion);
                                    System.out.println("Recibo: " + recibo);
                                    System.out.println("------------------------------");

                                    System.out.println("¿Quieres borrar este registro?");
                                    resp = leer.readLine().charAt(0);
                                    if (resp == 's' || resp == 'S') {
                                        grabar(fichero, campoCP);
                                    }
                                }
                            }
                        } else {
                            System.out.println("No hay registros");
                        }
                    }
                    break;
                case 2:
                    tipo = 'A';
                    System.out.println("Indica el registro que quieres borrar");
                    String campoCA = leer.readLine();
                    for (int i = 0; i < numeroRegistro(fichero); i++) {
                        if (i >= 0 && i < numeroRegistro(fichero)) {
                            raf.seek(i * piso.maximaLongitud);
                            char campoP = raf.readChar();
                            if (tipo == campoP) {
                                codigo = raf.readUTF();
                                if (campoCA.compareToIgnoreCase(codigo) == 0) {
                                    nombrePropietario = raf.readUTF();
                                    mesRecibo = raf.readUTF();
                                    cuotaFija = raf.readFloat();
                                    agua = raf.readFloat();
                                    calefaccion = raf.readFloat();
                                    metrosTerraza = raf.readFloat();
                                    recibo = raf.readFloat();

                                    System.out.println("------------------------------");
                                    System.out.println("Tipo: " + tipo);
                                    System.out.println("codigo: " + codigo);
                                    System.out.println("Nombre: " + nombrePropietario);
                                    System.out.println("Mes del recibo: " + mesRecibo);
                                    System.out.println("Cuota fija: " + cuotaFija);
                                    System.out.println("Litros de agua: " + agua);
                                    System.out.println("Calefaccion: " + calefaccion);
                                    System.out.println("Metros de la terraza: " + metrosTerraza);
                                    System.out.println("Recibo: " + recibo);
                                    System.out.println("------------------------------");

                                    System.out.println("¿Quieres borrar este registro?");
                                    resp = leer.readLine().charAt(0);
                                    if (resp == 's' || resp == 'S') {
                                        grabar(fichero, campoCA);
                                    }
                                }
                            }
                        } else {
                            System.out.println("No hay registros");
                        }
                    }
                    break;
                case 3:
                    tipo = 'D';
                    System.out.println("Indica el registro que quieres borrar");
                    String campoCD = leer.readLine();
                    for (int i = 0; i < numeroRegistro(fichero); i++) {
                        if (i >= 0 && i < numeroRegistro(fichero)) {
                            raf.seek(i * piso.maximaLongitud);
                            char campoP = raf.readChar();
                            if (tipo == campoP) {
                                codigo = raf.readUTF();
                                if (campoCD.compareToIgnoreCase(codigo) == 0) {
                                    nombrePropietario = raf.readUTF();
                                    mesRecibo = raf.readUTF();
                                    cuotaFija = raf.readFloat();
                                    agua = raf.readFloat();
                                    calefaccion = raf.readFloat();
                                    cuotaEspecial = raf.readFloat();
                                    recibo = raf.readFloat();

                                    System.out.println("------------------------------");
                                    System.out.println("Tipo: " + tipo);
                                    System.out.println("codigo: " + codigo);
                                    System.out.println("Nombre: " + nombrePropietario);
                                    System.out.println("Mes del recibo: " + mesRecibo);
                                    System.out.println("Cuota fija: " + cuotaFija);
                                    System.out.println("Litros de agua: " + agua);
                                    System.out.println("Calefaccion: " + calefaccion);
                                    System.out.println("Cuota especial: " + cuotaEspecial);
                                    System.out.println("Recibo: " + recibo);
                                    System.out.println("------------------------------");

                                    System.out.println("¿Quieres borrar este registro?");
                                    resp = leer.readLine().charAt(0);
                                    if (resp == 's' || resp == 'S') {
                                        grabar(fichero, campoCD);
                                    }
                                }
                            }
                        } else {
                            System.out.println("No hay registros");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Fin de las bajas");
                    break;
                default:
                    System.out.println("Esa opcion no es correcta");
                    break;
            }
        } else {
        }
    }

    public static void grabar(File fichero, String campo) throws IOException {
        RandomAccessFile raf = null;
        RandomAccessFile raf2 = null;
        char tipo;
        String codigo;
        String nombrePropietario;
        String mesRecibo;
        float cuotaFija;
        float agua;
        float calefaccion;
        float cuotaEspecial;
        float metrosTerraza;
        float recibo;
        
        raf = new RandomAccessFile(fichero, "r");
        File fichero2 = new File("prueba2");
        raf2 = new RandomAccessFile(fichero2, "rw");
        
        for (int j = 0; j < numeroRegistro(fichero); j++) {
            raf.seek(j * piso.maximaLongitud);
            tipo = raf.readChar();
            if (tipo == 'P') {
                codigo = raf.readUTF();
                if (codigo.compareToIgnoreCase(campo) != 0) {
                    nombrePropietario = raf.readUTF();
                    mesRecibo = raf.readUTF();
                    cuotaFija = raf.readFloat();
                    agua = raf.readFloat();
                    calefaccion = raf.readFloat();
                    recibo = raf.readFloat();

                    raf2.seek(j * piso.maximaLongitud);
                    raf2.writeChar(tipo);
                    raf2.writeUTF(codigo);
                    raf2.writeUTF(nombrePropietario);
                    raf2.writeUTF(mesRecibo);
                    raf2.writeFloat(cuotaFija);
                    raf2.writeFloat(agua);
                    raf2.writeFloat(calefaccion);
                    raf2.writeFloat(recibo);
                }
            }
            if (tipo == 'A') {
                String codigoA = raf.readUTF();
                if (codigoA.compareToIgnoreCase(campo) != 0) {
                    nombrePropietario = raf.readUTF();
                    mesRecibo = raf.readUTF();
                    cuotaFija = raf.readFloat();
                    agua = raf.readFloat();
                    calefaccion = raf.readFloat();
                    metrosTerraza = raf.readFloat();
                    recibo = raf.readFloat();

                    raf2.seek(j * piso.maximaLongitud);
                    raf2.writeChar(tipo);
                    raf2.writeUTF(codigoA);
                    raf2.writeUTF(nombrePropietario);
                    raf2.writeUTF(mesRecibo);
                    raf2.writeFloat(cuotaFija);
                    raf2.writeFloat(agua);
                    raf2.writeFloat(calefaccion);
                    raf2.writeFloat(metrosTerraza);
                    raf2.writeFloat(recibo);
                }
            }
            if (tipo == 'D') {
                String codigoD = raf.readUTF();
                if (codigoD.compareToIgnoreCase(campo) != 0) {
                    nombrePropietario = raf.readUTF();
                    mesRecibo = raf.readUTF();
                    cuotaFija = raf.readFloat();
                    agua = raf.readFloat();
                    calefaccion = raf.readFloat();
                    cuotaEspecial = raf.readFloat();
                    recibo = raf.readFloat();

                    raf2.seek(j * piso.maximaLongitud);
                    raf2.writeChar(tipo);
                    raf2.writeUTF(codigoD);
                    raf2.writeUTF(nombrePropietario);
                    raf2.writeUTF(mesRecibo);
                    raf2.writeFloat(cuotaFija);
                    raf2.writeFloat(agua);
                    raf2.writeFloat(calefaccion);
                    raf2.writeFloat(cuotaEspecial);
                    raf2.writeFloat(recibo);
                }
            }
        }
    }
    
    public static int numeroRegistro(File fichero) {
        int tamaño = (int) Math.ceil((double) fichero.length() / (double) PisoEstandar.maximaLongitud);
        return tamaño;
    }
}
