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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author adrian
 */
public class Ejercicio_BBDD_AutoresLibros {

    static Statement sentencia;
    static Connection conexion;
    static ResultSet rstAux;

    static final String driver = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3307/Libreria?user=root&password=usbw";

    public static void main(String[] args) throws IOException, SQLException {

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.out.println("No se encontró el Driver " + driver);
            System.exit(0);
        }
        try {
            conexion = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("No hay ningún Driver registrado que reconozca la URL especificada");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Se ha producido algún otro error.");
            System.exit(0);
        }
        try {
            sentencia = conexion.createStatement();
        } catch (Exception e) {
            System.out.println("Error al conectarse con el driver que maneja la BD " + e);
            System.exit(0);
        }

        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        byte op;

        do {
            System.out.println("-------------------------------");
            System.out.println("         Menu         ");
            System.out.println("-------------------------------");
            System.out.println("Opcion 1: Crear Tablas");
            System.out.println("Opcion 2: Nuevas Filas");
            System.out.println("Opcion 3: Borrar Filas(autor)");
            System.out.println("Opcion 4: Borrar Filas(libro)");
            System.out.println("Opcion 5: Consultas (Libros)");
            System.out.println("Opcion 6: Consultas (Autor)");
            System.out.println("Opcion 7: Salir");
            System.out.println("-------------------------------");
            System.out.print("Opcion: ");
            op = Byte.parseByte(leer.readLine());
            switch (op) {
                case 1:
                    CrearTablas.crear(sentencia, conexion);
                    break;
                case 2:
                    NuevasFilas.Nuevas(sentencia, conexion, rstAux);
                    break;
                case 3:
                    BorrarFilasPorAutor.Borrar(sentencia, conexion, rstAux);
                    break;
                case 4:
                    BorrarFilasPorLibro.Borrar(sentencia, conexion, rstAux);
                    break;
                case 5:
                    RecuperarFilasPorLibros.Recuperar(sentencia, conexion, rstAux);
                    break;
                case 6:
                    RecuperarFilasPorAutor.Recuperar(sentencia, conexion, rstAux);
                    break;
                case 7:
                    sentencia.close();
                    conexion.close();
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (op != 7);
    }
}
