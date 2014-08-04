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
public class Curso_in extends Plan_In{

    private String idCurso;
    private String curNombre;
    private String cur_Cr;
    private String cur_Ht;
    private String cur_Hnp;
    private String cur_Th;
    private String cur_Nota;
    private String cur_estado;
    
    public Curso_in(){
    }

    public Curso_in(String idCurso, String curNombre, String cur_Cr, String cur_Ht, String cur_Hnp, String cur_Th, String cur_Nota, String cur_estado) {
        this.idCurso = idCurso;
        this.curNombre = curNombre;
        this.cur_Cr = cur_Cr;
        this.cur_Ht = cur_Ht;
        this.cur_Hnp = cur_Hnp;
        this.cur_Th = cur_Th;
        this.cur_Nota = cur_Nota;
        this.cur_estado = cur_estado;
    }

    public String getCur_Nota() {
        return cur_Nota;
    }

    public void setCur_Nota(String cur_Nota) {
        this.cur_Nota = cur_Nota;
    }
   

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getCurNombre() {
        return curNombre;
    }

    public void setCurNombre(String curNombre) {
        this.curNombre = curNombre;
    }

    public String getCur_Cr() {
        return cur_Cr;
    }

    public void setCur_Cr(String cur_Cr) {
        this.cur_Cr = cur_Cr;
    }

    public String getCur_Ht() {
        return cur_Ht;
    }

    public void setCur_Ht(String cur_Ht) {
        this.cur_Ht = cur_Ht;
    }

    public String getCur_Hnp() {
        return cur_Hnp;
    }

    public void setCur_Hnp(String cur_Hnp) {
        this.cur_Hnp = cur_Hnp;
    }

    public String getCur_Th() {
        return cur_Th;
    }

    public void setCur_Th(String cur_Th) {
        this.cur_Th = cur_Th;
    }

    public String getCur_estado() {
        return cur_estado;
    }

    public void setCur_estado(String cur_estado) {
        this.cur_estado = cur_estado;
    }
    

}
