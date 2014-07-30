/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.modelo;

/**
 *
 * @author XPC
 */
public class Plan_In {
    private String idplan;

    public String getIdplan() {
        return idplan;
    }

    public void setIdplan(String idplan) {
        this.idplan = idplan;
    }

    public String getPlan_codigo() {
        return plan_codigo;
    }

    public void setPlan_codigo(String plan_codigo) {
        this.plan_codigo = plan_codigo;
    }

    public String getPlan_estado() {
        return plan_estado;
    }

    public void setPlan_estado(String plan_estado) {
        this.plan_estado = plan_estado;
    }
    private String plan_codigo;
    private String plan_estado;
    
    public Plan_In (String idplan, String plan_codigo, String plan_estado){
        this.idplan=idplan;
        this.plan_codigo=plan_codigo;
        this.plan_estado=plan_estado;
        
    }
     public Plan_In(){
    }
    
}


   