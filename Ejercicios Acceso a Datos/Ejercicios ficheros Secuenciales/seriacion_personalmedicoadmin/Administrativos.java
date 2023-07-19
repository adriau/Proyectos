/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacion_personalmedicoadmin;

/**
 *
 * @author a13adrianac
 */
public class Administrativos extends Personal {

    private String categoria;
    private float sueldo;
    private float sueldoNeto;
    private float sueldoBruto;

    public Administrativos(String categoria, float sueldo, String codigo, String nombre, String email) {
        super(codigo, nombre, email);
        this.categoria = categoria;
        this.sueldo = sueldo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public float nomina() {
        sueldoBruto = sueldo;
        sueldoNeto = sueldo - (sueldo * 20 / 100);

        return sueldoNeto;
    }

}
