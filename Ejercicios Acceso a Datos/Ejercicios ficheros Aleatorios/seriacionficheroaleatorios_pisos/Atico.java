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
public class Atico extends PisoEstandar {

    private float metrosTerraza;
    private float totalreciboA;

    public Atico(String codigo, String nombrePropietario, String mesRecibo, float cuotaFija, float agua, float calefacion, float metrosTerraza) {
        super(codigo, nombrePropietario, mesRecibo, cuotaFija, agua, calefacion);
        this.metrosTerraza = metrosTerraza;
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
        totalreciboA = (super.totalRecibo() + metrosTerraza * 0.45f);
        return totalreciboA;
    }
}
