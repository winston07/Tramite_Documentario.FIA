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
public class Escuela_Usuario_Listar {
    private String idEscuela;
    private String nombre;
    private String usuario;
    
    
    public Escuela_Usuario_Listar(){}

    public Escuela_Usuario_Listar(String idEscuela, String nombre, String usuario) {
        this.idEscuela = idEscuela;
        this.nombre = nombre;
        this.usuario = usuario;
    }

    public String getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(String idEscuela) {
        this.idEscuela = idEscuela;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}
