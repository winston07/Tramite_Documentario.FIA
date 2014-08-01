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
public class Escuela {
    private String escuela;
    private String idFacultad;
    private String nombre;
    
    
    public Escuela(){
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(String idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Escuela(String escuela, String idFacultad, String nombre) {
        this.escuela = escuela;
        this.idFacultad = idFacultad;
        this.nombre = nombre;
    }
}
