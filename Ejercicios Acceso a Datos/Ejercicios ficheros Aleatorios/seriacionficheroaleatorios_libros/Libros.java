/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacionficheroaleatorios_libros;

/**
 *
 * @author adrian
 */
public class Libros {

    public static final int longitudMaxima = 140;
    public static int numeroRegistros;

    //Atributos
    private String nombre;
    private String codigo;
    private float precio;

    public Libros(String codigo, String nombre, float precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int tamaño() {
        //longitud en bytes de los atributos (un float = 4 bytes)
        //multiplicamos por 2 ya que hay 2 String
        int tamaño = (int) (nombre.length() + codigo.length()) * 2 + 4;
        return tamaño;
    }

}
