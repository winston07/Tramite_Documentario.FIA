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
public class Val_Cur_Validado {
    private String id_cur_val;
    private String idvalidacion;
    private String idcurso_validado;
    private String id_curso;

    public Val_Cur_Validado(String id_cur_val, String idvalidacion, String idcurso_validado, String id_curso) {
        this.id_cur_val = id_cur_val;
        this.idvalidacion = idvalidacion;
        this.idcurso_validado = idcurso_validado;
        this.id_curso = id_curso;
    }
    public Val_Cur_Validado(){
    }

    public String getId_cur_val() {
        return id_cur_val;
    }

    public void setId_cur_val(String id_cur_val) {
        this.id_cur_val = id_cur_val;
    }

    public String getIdvalidacion() {
        return idvalidacion;
    }

    public void setIdvalidacion(String idvalidacion) {
        this.idvalidacion = idvalidacion;
    }

    public String getIdcurso_validado() {
        return idcurso_validado;
    }

    public void setIdcurso_validado(String idcurso_validado) {
        this.idcurso_validado = idcurso_validado;
    }

    public String getId_curso() {
        return id_curso;
    }

    public void setId_curso(String id_curso) {
        this.id_curso = id_curso;
    }
    
}
