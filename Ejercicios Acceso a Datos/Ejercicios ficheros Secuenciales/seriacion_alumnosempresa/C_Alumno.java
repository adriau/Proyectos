/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriacion_alumnosempresa;

/**
 *
 * @author a13adrianac
 */
public class C_Alumno implements I_interfaz_Nexo{

    private String codigo;
    private String nombre;
    private String telefono;
    private String email;

    public C_Alumno(String codigo, String nombre, String telefono, String email) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
