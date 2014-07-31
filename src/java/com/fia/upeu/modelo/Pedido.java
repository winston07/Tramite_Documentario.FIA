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
public class Pedido {

    private String fecha;
    private String estado;
    private String idPeriodo;
    private String idEscuela;
    private String idTipoTramite;
    private String idValidacion;
    private String idSolicitante;
    
    public Pedido(){
    }

    public Pedido(String fecha, String estado, String idPeriodo, String idEscuela, String idTipoTramite, String idValidacion, String idSolicitante) {
        this.fecha = fecha;
        this.estado = estado;
        this.idPeriodo = idPeriodo;
        this.idEscuela = idEscuela;
        this.idTipoTramite = idTipoTramite;
        this.idValidacion = idValidacion;
        this.idSolicitante = idSolicitante;
    }
    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(String idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(String idEscuela) {
        this.idEscuela = idEscuela;
    }

    public String getIdTipoTramite() {
        return idTipoTramite;
    }

    public void setIdTipoTramite(String idTipoTramite) {
        this.idTipoTramite = idTipoTramite;
    }

    public String getIdValidacion() {
        return idValidacion;
    }

    public void setIdValidacion(String idValidacion) {
        this.idValidacion = idValidacion;
    }

    public String getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(String idSolicitante) {
        this.idSolicitante = idSolicitante;
    }
    
}
