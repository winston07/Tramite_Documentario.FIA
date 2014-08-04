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
public class Solicitante extends Persona{
    String idSolicitante;
    String codigo;
    String idPersona;

    public Solicitante(){
    }
    public Solicitante(String idSolicitante, String codigo, String idPersona) {
        this.idSolicitante = idSolicitante;
        this.codigo = codigo;
        this.idPersona = idPersona;
    }

    public String getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(String idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }  
    
}
