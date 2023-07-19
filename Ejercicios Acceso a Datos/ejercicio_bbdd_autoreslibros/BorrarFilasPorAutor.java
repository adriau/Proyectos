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
 * @author adrian
 */
public class BorrarFilasPorAutor {

    public static void Borrar(Statement sentencia, Connection conexion, ResultSet rsAux) throws IOException, SQLException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        char resp = ' ';

        System.out.println("¿Quieres eliminar algun dato?");
        resp = leer.readLine().charAt(0);
        if (resp == 's' || resp == 'S') {
            System.out.println("Indica que autor quieres borrar");
            String codAutor = leer.readLine();
            try {
                rsAux = sentencia.executeQuery("Select * FROM autores "
                        + "WHERE codigoAutor ='" + codAutor + "';");

                while (rsAux.next()) {
                    System.out.println(rsAux.getString("codigoAutor") + "          "
                            + rsAux.getString("nombreAutor") + "         "
                            + rsAux.getString("nacionalidad"));
                }
                try {
                    System.out.println("¿Quieres borrar el registro?");
                    resp = leer.readLine().charAt(0);
                    if (resp == 's' || resp == 'S') {
                        sentencia.execute("DELETE FROM autores "
                                + "WHERE codigoAutor ='" + codAutor + "';");
                        System.out.println("Autor eliminado");
                    }
                } catch (SQLException sql) {
                    System.out.println("Error al borrar los datos: " + sql.getMessage());
                }
            } catch (SQLException sql) {
                System.out.println("Error al recuperar los datos: " + sql.getMessage());
            } finally{
                rsAux.close();
            }

        }
    }
}
