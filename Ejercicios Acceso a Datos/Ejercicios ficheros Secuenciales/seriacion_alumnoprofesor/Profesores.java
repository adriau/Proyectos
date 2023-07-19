/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacion_alumnoprofesor;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author adrian
 */
public class Profesores extends Persona {

    private float salarioNeto;
    private float salarioBruto;

    private float salario_base;
    private String titulacion;
    private byte trienio;
    private ArrayList<Asignaturas> modulos = new ArrayList<>();

    public Profesores(String dni, String nombre, String titulacion, ArrayList<Asignaturas> modulos, float salario_base, byte trienio) throws IOException {
        super(dni, nombre);
        this.titulacion = titulacion;
        this.modulos = modulos;
        this.salario_base=salario_base;
        this.trienio=trienio;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public byte getTrienio() {
        return trienio;
    }

    public void setTrienio(byte trienio) {
        this.trienio = trienio;
    }

    public float getSueldo_base() {
        return salario_base;
    }

    public void setSueldo_base(float sueldo_base) {
        this.salario_base = sueldo_base;
    }

    public ArrayList<Asignaturas> getModulos() {
        return modulos;
    }

    public void setModulos(ArrayList<Asignaturas> modulos) {
        this.modulos = modulos;
    }

    @Override
    public float calculo() {
        salarioBruto = (salario_base + trienio) * 100;
        salarioNeto = salarioBruto - (salarioBruto * 30 / 100);
        return salarioNeto;
    }

}
