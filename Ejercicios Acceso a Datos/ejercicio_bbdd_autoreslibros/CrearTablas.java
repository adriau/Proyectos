/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_bbdd_autoreslibros;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author adrian
 */
public class CrearTablas {

    public static void crear(Statement sentencia, Connection conexion) throws IOException, SQLException {

        try {
            sentencia.execute("CREATE TABLE autores ("
                    + "codigoAutor VARCHAR(5) Primary key, "
                    + "nombreAutor VARCHAR(15) NOT NULL,"
                    + "nacionalidad VARCHAR(15));");

            sentencia.execute("CREATE TABLE libros ("
                    + "codigoLibro VARCHAR(5) Primary Key,"
                    + " titulo VARCHAR(20) NOT NULL,"
                    + " precio FLOAT NOT NULL,"
                    + " autor VARCHAR(5) NOT NULL, "
                    + "FOREIGN KEY (autor) REFERENCES autores(codigoAutor));");
        } catch (SQLException sql) {
            System.out.println("No se creo la tabla autores " + sql.getMessage());
            System.exit(0);
        }
    }
}
