/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.modelo;

/**
 *
 * @author alum.fial7
 */
public class Usuario {

    private String idUduario;
    private String usuario;
    private String clave;
    private String estado;
    private String idPersona;
    private String idRol;

    public String getIdUduario() {
        return idUduario;
    }

    public void setIdUduario(String idUduario) {
        this.idUduario = idUduario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public Usuario(String idUduario, String usuario, String clave, String estado, String idPersona) {
        this.idUduario = idUduario;
        this.usuario = usuario;
        this.clave = clave;
        this.estado = estado;
        this.idPersona = idPersona;
    }

    public Usuario() {
    }

}
