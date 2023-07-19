/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacion_alumnoprofesor;

import java.io.Serializable;

/**
 *
 * @author adrian
 */
public class Asignaturas implements Serializable{

    private String nombre;
    private String curso;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Asignaturas(String nombre, String curso) {
        this.nombre = nombre;
        this.curso = curso;
    }

}
