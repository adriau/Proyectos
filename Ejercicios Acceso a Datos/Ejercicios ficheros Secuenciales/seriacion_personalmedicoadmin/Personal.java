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
public abstract class Personal implements Serializable{
    private String codigo;
    private String nombre;
    private String email;

    public Personal(String codigo, String nombre, String email) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.email = email;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public abstract float nomina();
}
