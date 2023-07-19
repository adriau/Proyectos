/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacioncoches;

import java.io.Serializable;

/**
 *
 * @author a13adrianac
 */
public class Coche implements Serializable{

    String marca;
    String modelo;
    Rueda rueda;

    public Coche(String marca, String modelo, Rueda rueda) {
        this.marca = marca;
        this.modelo = modelo;
        this.rueda = rueda;
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

    public Rueda getRueda() {
        return rueda;
    }

    public void setRueda(Rueda rueda) {
        this.rueda = rueda;
    }

}
