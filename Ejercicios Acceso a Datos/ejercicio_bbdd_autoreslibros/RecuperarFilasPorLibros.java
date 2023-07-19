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
public class RecuperarFilasPorLibros {

    public static void Recuperar(Statement sentencia, Connection conexion, ResultSet rstAux) throws IOException, SQLException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        char resp = ' ';

        System.out.println("¿Quieres visualizar alguna fila?");
        resp = leer.readLine().charAt(0);
        if (resp == 's' || resp == 'S') {
            try {
                System.out.println("Indica el libro por el que visualizar");
                String titulo = leer.readLine();

                rstAux = sentencia.executeQuery("Select * From autores a, libros l "
                        + "WHERE codigoAutor = autor and l.titulo='" + titulo + "';");

                while (rstAux.next()) {
                    System.out.println(rstAux.getString("codigoAutor") + "          "
                            + rstAux.getString("nombreAutor") + "         "
                            + rstAux.getString("nacionalidad") + "         "
                            + rstAux.getString("codigoLibro") + "         "
                            + rstAux.getString("titulo") + "         "
                            + rstAux.getFloat("precio"));

                }
                System.out.println("-------------------------------------------");
                System.out.println();
            } catch (SQLException sql) {
                System.out.println("No se pudo recuperar los datos: " + sql.getMessage());
            } finally {
                rstAux.close();
            }
        }
    }
}
