/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionficheroaleatorios_pisos;

/**
 *
 * @author adrian
 */
public class Duplex extends PisoEstandar {

    private float cuotaEspecial;

    public Duplex(String codigo, String nombrePropietario, String mesRecibo, float cuotaFija, float agua, float calefacion, float cuotaEspecial) {
        super(codigo, nombrePropietario, mesRecibo, cuotaFija, agua, calefacion);
        this.cuotaEspecial = cuotaEspecial;
    }

    public float getCuotaEspecial() {
        return cuotaEspecial;
    }

    public void setCuotaEspecial(float cuotaEspecial) {
        this.cuotaEspecial = cuotaEspecial;
    }

    @Override
    public int tamañoRegistro() {
        int tamañoD = (super.tamañoRegistro() + 4);
        return tamañoD;
    }

    @Override
    public float totalRecibo() {
        float totalrecibo = (super.totalRecibo() + cuotaEspecial);
        return totalrecibo;
    }
}
