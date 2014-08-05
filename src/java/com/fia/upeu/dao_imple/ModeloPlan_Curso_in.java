/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao_imple;

import com.fia.upeu.config.Conexion;
import com.fia.upeu.dao.InterPlan_Curso_in;
import com.fia.upeu.modelo.Plan_Curso_in;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author XPC
 */
public class ModeloPlan_Curso_in  implements InterPlan_Curso_in{
    ResultSet rs = null;
    Statement stmt = null;
    Connection cx = null;
    boolean estado;

    @Override
    public List<Plan_Curso_in> list_Plan_Curso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ingresar_Plan_Curso(String idplan, String idcurso, String plan_cur_ciclos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar_Plan_Curso(String idplan, String idcurso, String plan_cur_ciclos) {
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            stmt.executeUpdate("UPDATE validacion SET val_plan_in='',val_plan_out='',val_inst_in='',val_inst_out='',val_estado='1' WHERE idvalidacion=''");
            estado=true;
        } catch (Exception ex) {
            estado = false;
        }

        return estado;
    }

    @Override
    public boolean eliminar_Plan_Cruso(String idplan_curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
