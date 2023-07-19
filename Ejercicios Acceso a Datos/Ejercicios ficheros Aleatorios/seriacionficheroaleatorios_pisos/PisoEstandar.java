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
public class PisoEstandar {

    public static final int maximaLongitud = 140;

    //Atributos
    private String codigo;
    private String nombrePropietario;
    private String mesRecibo;
    private float cuotaFija;
    private float agua;
    private float calefaccion;
    private float totalRecibo;

    public PisoEstandar(String codigo, String nombrePropietario, String mesRecibo, float cuotaFija, float agua, float calefaccion) {
        this.codigo = codigo;
        this.nombrePropietario = nombrePropietario;
        this.mesRecibo = mesRecibo;
        this.cuotaFija = cuotaFija;
        this.agua = agua;
        this.calefaccion = calefaccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getMesRecibo() {
        return mesRecibo;
    }

    public void setMesRecibo(String mesRecibo) {
        this.mesRecibo = mesRecibo;
    }

    public float getCuotaFija() {
        return cuotaFija;
    }

    public void setCuotaFija(float cuotaFija) {
        this.cuotaFija = cuotaFija;
    }

    public float getAgua() {
        return agua;
    }

    public void setAgua(float agua) {
        this.agua = agua;
    }

    public float getCalefaccion() {
        return calefaccion;
    }

    public void setCalefaccion(float calefaccion) {
        this.calefaccion = calefaccion;
    }

    public int tamañoRegistro() {
        int tamaño = ((nombrePropietario.length() + mesRecibo.length() + codigo.length()) * 2 + 12);
        return tamaño;
    }

    public float totalRecibo() {
        totalRecibo = getCuotaFija() + getAgua() + 0.40f + getCalefaccion() * 0.70f;
        return totalRecibo;
    }
}
