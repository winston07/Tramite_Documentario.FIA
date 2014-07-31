/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.modelo;

/**
 *
 * @author NetOraPro
 */
public class Plan_On {
    private String idplan;
    private String plan_on_codigo;
    private String plan_on_estado;
    public String getIdplan() {
        return idplan;
    }

    public void setIdplan(String idplan) {
        this.idplan = idplan;
    }

    public String getPlan_on_codigo() {
        return plan_on_codigo;
    }

    public void setPlan_on_codigo(String plan_on_codigo) {
        this.plan_on_codigo = plan_on_codigo;
    }

    public String getPlan_on_estado() {
        return plan_on_estado;
    }

    public void setPlan_on_estado(String plan_on_estado) {
        this.plan_on_estado = plan_on_estado;
    }
    
    
    public Plan_On(String idplan,String plan_on_codigo,String plan_on_estado){
    this.idplan=idplan;
    this.plan_on_codigo=plan_on_codigo;
    this.plan_on_estado=plan_on_estado;
    }
    
    public Plan_On(){
}
    
}
