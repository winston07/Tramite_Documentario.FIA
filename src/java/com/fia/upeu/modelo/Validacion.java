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
public class Validacion {
    private String idvalidacion;
    private String val_nro;
    private String val_plan_in;
    private String val_plan_out;
    private String val_inst_int;
    private String val_inst_out;
    private String val_estado;

    public String getIdvalidacion() {
        return idvalidacion;
    }

    public void setIdvalidacion(String idvalidacion) {
        this.idvalidacion = idvalidacion;
    }

    public String getVal_nro() {
        return val_nro;
    }

    public void setVal_nro(String val_nro) {
        this.val_nro = val_nro;
    }

    public String getVal_plan_in() {
        return val_plan_in;
    }

    public void setVal_plan_in(String val_plan_in) {
        this.val_plan_in = val_plan_in;
    }

    public String getVal_plan_out() {
        return val_plan_out;
    }

    public void setVal_plan_out(String val_plan_out) {
        this.val_plan_out = val_plan_out;
    }

    public String getVal_inst_int() {
        return val_inst_int;
    }

    public void setVal_inst_int(String val_inst_int) {
        this.val_inst_int = val_inst_int;
    }

    public String getVal_inst_out() {
        return val_inst_out;
    }

    public void setVal_inst_out(String val_inst_out) {
        this.val_inst_out = val_inst_out;
    }

    public String getVal_estado() {
        return val_estado;
    }

    public void setVal_estado(String val_estado) {
        this.val_estado = val_estado;
    }
    
    
    public Validacion(String idvalidacion, String val_nro,String val_plan_in , String val_plan_out,String val_inst_out,String val_inst_int, String val_estado){
    this.idvalidacion=idvalidacion;
    this.val_estado=val_estado;
    this.val_inst_int=val_inst_int;
    this.val_inst_out=val_inst_out;
    this.val_nro=val_nro;
    this.val_plan_in=val_plan_in;
    this.val_plan_out=val_plan_out;
    }  
    public Validacion(){
    }
}
