/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.modelo;

/**
 *
 * @author Kelvin Thony
 */
public class Persona {

    private String idPersona;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private String correo;
    private String num_tel;
    private String sexo;
    private String direccion;
    private String estado;
    
    public Persona(){
    }

    public Persona(String idPersona, String nombre, String ap_paterno, String ap_materno, String correo, String num_tel, String sexo, String direccion, String estado) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.correo = correo;
        this.num_tel = num_tel;
        this.sexo = sexo;
        this.direccion = direccion;
        this.estado = estado;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
