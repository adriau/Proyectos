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
public class BorrarFilasPorLibro {

    public static void Borrar(Statement sentencia, Connection conexion, ResultSet rstAux) throws IOException, SQLException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        char resp = ' ';

        System.out.println("¿Quieres borrar algun libro?");
        resp = leer.readLine().charAt(0);
        if (resp == 's' || resp == 'S') {
            System.out.println("Indica el libro que quieres borrar");
            String codLibro = leer.readLine();
            try {
                rstAux = sentencia.executeQuery("SELECT * FROM libros WHERE codigoLibro='" + codLibro + "';");
                while (rstAux.next()) {
                    System.out.println(rstAux.getString("codigoLibro") + "         "
                            + rstAux.getString("titulo") + "         "
                            + rstAux.getFloat("precio") + "         "
                            + rstAux.getString("autor"));
                }
                System.out.println("¿Quieres borrar este registro?");
                resp = leer.readLine().charAt(0);
                if (resp == 's' || resp == 'S') {
                    try {
                        sentencia.execute("DELETE FROM libros "
                                + "WHERE codigoLibro ='" + codLibro + "';");
                        System.out.println("libro eliminado");
                    } catch (SQLException sql) {
                        System.out.println("No se pudo eliminar el libro: " + sql.getMessage());
                    }
                }
            } catch (SQLException sql) {
                System.out.println("no se puede visualizar el libro: " + sql.getMessage());
            } finally {
                rstAux.close();
            }
        }
    }
}
