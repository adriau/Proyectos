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
public class RecuperarFilasPorAutor {

    public static void Recuperar(Statement sentencia, Connection conexion, ResultSet rstAux) throws IOException, SQLException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        char resp = ' ';

        System.out.println("¿Quieres visualizar alguna fila?");
        resp = leer.readLine().charAt(0);
        if (resp == 's' || resp == 'S') {
            System.out.println("Indica el autor por el que recuperar");
            String codAutor = leer.readLine();
            System.out.println("************************************");
            try {
                rstAux = sentencia.executeQuery("SELECT codigoLibro, titulo, precio, autor "
                        + "FROM libros WHERE autor ='" + codAutor + "';");

                System.out.println("--------------------------------------------");
                System.out.println("Autor    Codigo Libro    Titulo    Precio");
                System.out.println("--------------------------------------------");
                while (rstAux.next()) {
                    System.out.println(rstAux.getString("autor") + "      "
                            + rstAux.getString("codigoLibro") + "             "
                            + rstAux.getString("titulo") + "       "
                            + rstAux.getFloat("precio"));
                }
                System.out.println("--------------------------------------------");
                System.out.println();
            } catch (SQLException sql) {
                System.out.println("No se puede recuperar los datos: " + sql.getMessage());
            }
        }
    }
}
