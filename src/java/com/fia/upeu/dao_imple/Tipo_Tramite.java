/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao_imple;

/**
 *
 * @author Kelvin Thony
 */
public class Tipo_Tramite {
    String id_Tipo_Tramite;
    String idValidacion;
    String nombreTramite;
    
    public Tipo_Tramite(){
    }

    public Tipo_Tramite(String id_Tipo_Tramite, String idValidacion, String nombreTramite) {
        this.id_Tipo_Tramite = id_Tipo_Tramite;
        this.idValidacion = idValidacion;
        this.nombreTramite = nombreTramite;
    }
    

    public String getId_Tipo_Tramite() {
        return id_Tipo_Tramite;
    }

    public void setId_Tipo_Tramite(String id_Tipo_Tramite) {
        this.id_Tipo_Tramite = id_Tipo_Tramite;
    }

    public String getIdValidacion() {
        return idValidacion;
    }

    public void setIdValidacion(String idValidacion) {
        this.idValidacion = idValidacion;
    }

    public String getNombreTramite() {
        return nombreTramite;
    }

    public void setNombreTramite(String nombreTramite) {
        this.nombreTramite = nombreTramite;
    }
}
