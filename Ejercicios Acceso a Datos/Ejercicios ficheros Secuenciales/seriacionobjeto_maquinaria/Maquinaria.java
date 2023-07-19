/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionobjeto_maquinaria;

import java.io.Serializable;

/**
 *
 * @author adrian
 */
public abstract class Maquinaria implements Serializable{

    private String marca;
    private String modelo;
    private float precio;

    public Maquinaria(String marca, String modelo, float precio){
        this.marca=marca;
        this.modelo=modelo;
        this.precio=precio;
    }
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public abstract int Impuesto();
}
