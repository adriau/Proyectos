/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacion_alumnoprofesor;



/**
 *
 * @author adrian
 */
public class AsignaturasNotas extends Asignaturas{

    private float nota;

    public AsignaturasNotas(String nombre, String curso, float nota) {
        super(nombre, curso);
        this.nota=nota;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

}
