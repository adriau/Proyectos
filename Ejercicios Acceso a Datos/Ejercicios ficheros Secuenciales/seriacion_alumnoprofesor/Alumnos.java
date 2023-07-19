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
public class Alumnos extends Persona {
    private float suma;
    private ArrayList<AsignaturasNotas> Asnotas;

    public Alumnos(String dni, String nombre, ArrayList<AsignaturasNotas> Asnotas) throws IOException {
        super(dni, nombre);
        this.Asnotas = Asnotas;
    }
    
    public float getSuma() {
        return suma;
    }

    public void setSuma(float suma) {
        this.suma = suma;
    }

    public ArrayList<AsignaturasNotas> getAsnotas() {
        return Asnotas;
    }

    public void setAsnotas(ArrayList<AsignaturasNotas> Asnotas) {
        this.Asnotas = Asnotas;
    }

    @Override
    public float calculo() {
        int a = 0;
        for (int i = 0; i < Asnotas.size(); i++) {
            suma = suma + ((Asnotas)).get(i).getNota();
            a++;
        }
        float nota = suma / a;
        return nota;
    }
}
