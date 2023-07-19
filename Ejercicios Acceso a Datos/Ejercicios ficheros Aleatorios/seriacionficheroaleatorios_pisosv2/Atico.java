/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionficheroaleatorios_pisosv2;

/**
 *
 * @author adrian
 */
public class Atico extends PisoEstandar {

    private float metrosTerraza;

    public Atico(char tipo, String codigo, String nombrePropietario, String mesRecibo, float cuotaFija, float agua, float calefaccion, float metrosTerraza) {
        super(tipo, codigo, nombrePropietario, mesRecibo, cuotaFija, agua, calefaccion);
        this.metrosTerraza=metrosTerraza;
    }

    public float getMetrosTerraza() {
        return metrosTerraza;
    }

    public void setMetrosTerraza(float metrosTerraza) {
        this.metrosTerraza = metrosTerraza;
    }

    @Override
    public int tamañoRegistro() {
        int tamañoA = (super.tamañoRegistro() + 4);
        return tamañoA;
    }

    @Override
    public float totalRecibo() {
        float totalrecibo = (super.totalRecibo() + metrosTerraza * 0.45f);
        return totalrecibo;
    }
}
