/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao;
import  com.fia.upeu.modelo.Plan_Curso_in;

import java.util.List;

/**
 *
 * @author XPC
 */
public interface InterPlan_Curso_in {
    public List<Plan_Curso_in>list_Plan_Curso();
    boolean ingresar_Plan_Curso (String idplan, String idcurso,String plan_cur_ciclos);
    boolean modificar_Plan_Curso(String idplan, String idcurso,String plan_cur_ciclos);
    boolean eliminar_Plan_Cruso(String idplan_curso);
    
    
    
}
