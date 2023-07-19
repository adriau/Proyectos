/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionobjeto_maquinaria;



/**
 *
 * @author adrian
 */
public class Industrial extends Maquinaria{

    private String potencia;
    private float impuestoIndustrial;

    public Industrial (String marca, String modelo, float precio, String potencia, float impuestoIndustrial) {
        super(marca, modelo, precio);
        this.potencia=potencia;
        this.impuestoIndustrial=impuestoIndustrial;
    }
    
    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public float getImpuestoIndustrial() {
        return impuestoIndustrial;
    }

    public void setImpuestoIndustrial(float impuestoIndustrial) {
        this.impuestoIndustrial = impuestoIndustrial;
    }

    @Override
    public int Impuesto() {
        return (int) (super.getPrecio() * impuestoIndustrial);
    }
}
