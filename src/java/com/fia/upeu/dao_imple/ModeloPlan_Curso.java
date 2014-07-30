/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao_imple;

import com.fia.upeu.dao.InterPlan_Curso;
import com.fia.upeu.modelo.Plan_Curso;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author XPC
 */
public class ModeloPlan_Curso  implements InterPlan_Curso{
    ResultSet rs = null;
    Statement stmt = null;
    Connection cx = null;

    @Override
    public List<Plan_Curso> list_Plan_Curso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ingresar_Plan_Curso(String idplan, String idcurso, String plan_cur_ciclos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar_Plan_Curso(String idplan, String idcurso, String plan_cur_ciclos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar_Plan_Cruso(String idplan_curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
