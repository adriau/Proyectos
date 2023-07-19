/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_bbdd_autoreslibros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a13adrianac
 */
public class NuevasFilas {

    public static void Nuevas(Statement sentencia, Connection conexion, ResultSet rstAux) throws IOException, SQLException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        char resp = ' ';
        byte op;

        System.out.println("¿Quieres añadir datos a las tablas?");
        resp = leer.readLine().charAt(0);
        if (resp == 's' || resp == 'S') {
            System.out.println("-----------------------------------------");
            System.out.println("Indica la tabla en la que añadir datos");
            System.out.println("Opcion 1: Autores");
            System.out.println("Opcion 2: Libros");
            System.out.println("Opcion 3: Fin");
            System.out.println("-----------------------------------------");
            System.out.print("Opcion: ");
            op = Byte.parseByte(leer.readLine());

            switch (op) {
                case 1:
                    System.out.println("Rellene los siguientes datos: ");
                    System.out.print("Codigo del autor: ");
                    String codAutor = leer.readLine();
                    System.out.print("Nombre del autor: ");
                    String nombreAutor = leer.readLine();
                    System.out.print("Nacionalidad: ");
                    String nacionalidad = leer.readLine();

                    try {
                        sentencia.executeUpdate("INSERT INTO autores (codigoAutor, nombreAutor, nacionalidad) "
                                + "VALUES('" + codAutor + "','" + nombreAutor + "','" + nacionalidad + "')");
                    } catch (SQLException sql) {
                        System.out.println("No se puedo añadir los datos " + sql.getMessage());
                    }

                    break;
                case 2:
                    System.out.println("Rellene los siguientes datos: ");
                    System.out.print("Codigo del libro: ");
                    String codLibro = leer.readLine();
                    System.out.print("titulo del libro: ");
                    String titulo = leer.readLine();
                    System.out.print("precio del libro: ");
                    float precio = Float.parseFloat(leer.readLine());
                    System.out.print("autor del libro: ");
                    String autor = leer.readLine();

                    try {
                        sentencia.executeUpdate("INSERT INTO libros (codigoLibro, titulo, precio, autor) "
                                + "VALUES('" + codLibro + "','" + titulo + "'," + precio + ",'" + autor + "')");
                    } catch (SQLException sql) {
                        System.out.println(sql.getMessage());
                    }

                    break;
                case 3:
                    System.out.println("Fin de añadir datos");
                    break;
                default:
                    System.out.println("Esa opcion no es valida");
                    break;
            }
        }
    }
}
