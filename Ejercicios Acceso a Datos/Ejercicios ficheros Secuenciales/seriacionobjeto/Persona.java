/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionobjeto;
import java.io.Serializable;

/**
 *
 * @author a13adrianac
 */
public class Persona implements Serializable{

    String nombre;
    String dni;
    String estudio;
    int sueldo;

    public Persona() {
    }

    public Persona(String nombre, String dni, String estudio, int sueldo) {
        this.nombre = nombre;
        this.dni = dni;
        this.estudio = estudio;
        this.sueldo = sueldo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nomber) {
        this.nombre = nomber;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
}
