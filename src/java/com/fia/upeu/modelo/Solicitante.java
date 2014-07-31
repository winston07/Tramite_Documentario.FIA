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
public class Solicitante {
    private String idSolicitante;
    private String idPersona;
    private String sol_Codigo;
    
    public Solicitante(){

    }

    public Solicitante(String idSolicitante, String idPersona, String sol_Codigo) {
        this.idSolicitante = idSolicitante;
        this.idPersona = idPersona;
        this.sol_Codigo = sol_Codigo;
    }
    

    public String getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(String idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getSol_Codigo() {
        return sol_Codigo;
    }

    public void setSol_Codigo(String sol_Codigo) {
        this.sol_Codigo = sol_Codigo;
    }
}
