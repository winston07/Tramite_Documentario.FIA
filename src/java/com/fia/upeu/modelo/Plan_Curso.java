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
public class Plan_Curso {
    private String idplan;

    public String getIdplan() {
        return idplan;
    }

    public void setIdplan(String idplan) {
        this.idplan = idplan;
    }

    public String getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(String idcurso) {
        this.idcurso = idcurso;
    }

    public String getIdplan_curso() {
        return idplan_curso;
    }

    public void setIdplan_curso(String idplan_curso) {
        this.idplan_curso = idplan_curso;
    }

    public String getPlan_cur_ciclos() {
        return plan_cur_ciclos;
    }

    public void setPlan_cur_ciclos(String plan_cur_ciclos) {
        this.plan_cur_ciclos = plan_cur_ciclos;
    }
    private String idcurso;
    private String idplan_curso;
    private String plan_cur_ciclos;
    
    public Plan_Curso (String idcurso,String idplan,String idplan_curso,String plan_cur_ciclos){
    this.idplan=idplan;
    this.idcurso=idcurso;
    this.idplan_curso=idplan_curso;
    this.plan_cur_ciclos=plan_cur_ciclos;
    }
    public Plan_Curso(){
    }
    
    
}
