/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionobjeto_maquinaria;

/**
 *
 * @author adrian
 */
public class Agricola extends Maquinaria {

    private String traccion;
    private float impuestoEspecial;

    public Agricola (String marca, String modelo, float precio, String traccion, float impuestoEspecial) {
        super(marca, modelo, precio);
        this.traccion=traccion;
        this.impuestoEspecial=impuestoEspecial;
    }
    
    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    public float getImpuestoEspecial() {
        return impuestoEspecial;
    }

    public void setImpuestoEspecial(float impuestoEspecial) {
        this.impuestoEspecial = impuestoEspecial;
    }
    
    @Override
    public int Impuesto() {
        return (int) (super.getPrecio() * impuestoEspecial);
    }
}
