/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacion_personalmedicoadmin;

import java.io.Serializable;

/**
 *
 * @author a13adrianac
 */
public class Enfermos implements Serializable{

    private String dni;
    private String nombre;
    private String seguro;
    private String patologia;

    public Enfermos(String dni, String nombre, String seguro, String patologia) {
        this.dni = dni;
        this.nombre = nombre;
        this.seguro = seguro;
        this.patologia = patologia;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }
}
