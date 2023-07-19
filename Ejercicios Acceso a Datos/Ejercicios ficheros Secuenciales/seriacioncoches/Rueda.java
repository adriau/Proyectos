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
public class Rueda implements Serializable{

    String marcaRueda;
    String dimension;

    public Rueda(String marcaRueda, String dimension) {
        this.marcaRueda = marcaRueda;
        this.dimension = dimension;
    }

    public String getMarcaRueda() {
        return marcaRueda;
    }

    public void setMarcaRueda(String marcaRueda) {
        this.marcaRueda = marcaRueda;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

}
