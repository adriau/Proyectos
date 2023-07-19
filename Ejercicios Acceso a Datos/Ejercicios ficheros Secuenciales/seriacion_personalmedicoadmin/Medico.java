/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacion_personalmedicoadmin;

import java.util.ArrayList;

/**
 *
 * @author a13adrianac
 */
public class Medico extends Personal {

    private String especialidad;
    private int NumHorasExtra;
    private float sueldo;
    private float sueldoBruto;
    private float sueldoNeto;
    private ArrayList<Enfermos> arrayEnfer = null;

    public Medico(String especialidad, int NumHorasExtra, float sueldo, String codigo, String nombre, String email, ArrayList<Enfermos> arrayEnfer) {
        super(codigo, nombre, email);
        this.especialidad = especialidad;
        this.NumHorasExtra = NumHorasExtra;
        this.sueldo = sueldo;
        this.arrayEnfer = arrayEnfer;
    } 

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getNumHorasExtra() {
        return NumHorasExtra;
    }

    public void setNumHorasExtra(int NumHorasExtra) {
        this.NumHorasExtra = NumHorasExtra;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public ArrayList<Enfermos> getArrayEnfer() {
        return arrayEnfer;
    }

    public void setArrayEnfer(ArrayList<Enfermos> arrayEnfer) {
        this.arrayEnfer = arrayEnfer;
    }

    public float nomina() {
        sueldoBruto = sueldo + (NumHorasExtra*100);
	sueldoNeto = sueldoBruto-(sueldoBruto*(40/100));
        return sueldoNeto;
    }
}
