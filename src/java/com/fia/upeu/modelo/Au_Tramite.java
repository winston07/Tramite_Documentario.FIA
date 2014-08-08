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
public class Au_Tramite {
    private String idAu_Tramite;
    private String idUsuario;
    private String idPedido;
    private String Au_Estado;
    private String Au_Fecha;
    private String Au_Hora;
    private String Au_Escuela;
    
    public Au_Tramite(){
    }

    public Au_Tramite(String idAu_Tramite, String idUsuario, String idPedido, String Au_Estado, String Au_Fecha, String Au_Hora, String Au_Escuela) {
        this.idAu_Tramite = idAu_Tramite;
        this.idUsuario = idUsuario;
        this.idPedido = idPedido;
        this.Au_Estado = Au_Estado;
        this.Au_Fecha = Au_Fecha;
        this.Au_Hora = Au_Hora;
        this.Au_Escuela = Au_Escuela;
    }

    public String getIdAu_Tramite() {
        return idAu_Tramite;
    }

    public void setIdAu_Tramite(String idAu_Tramite) {
        this.idAu_Tramite = idAu_Tramite;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getAu_Estado() {
        return Au_Estado;
    }

    public void setAu_Estado(String Au_Estado) {
        this.Au_Estado = Au_Estado;
    }

    public String getAu_Fecha() {
        return Au_Fecha;
    }

    public void setAu_Fecha(String Au_Fecha) {
        this.Au_Fecha = Au_Fecha;
    }

    public String getAu_Hora() {
        return Au_Hora;
    }

    public void setAu_Hora(String Au_Hora) {
        this.Au_Hora = Au_Hora;
    }

    public String getAu_Escuela() {
        return Au_Escuela;
    }

    public void setAu_Escuela(String Au_Escuela) {
        this.Au_Escuela = Au_Escuela;
    }
    
    
}
