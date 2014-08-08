/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao_imple;

import com.fia.upeu.config.Conexion;
import com.fia.upeu.dao.InterfacePlan_In;
import com.fia.upeu.modelo.Plan_In;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XPC
 */
public class ModeloPlan_In implements InterfacePlan_In{
    ResultSet rs = null;
    Statement stmt = null;
    Connection cx = null;
    boolean estado;

    @Override
    public List<Plan_In> list_Plan_In() {
         List<Plan_In> list = new ArrayList<Plan_In>();
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("select * from plan_in");
            while (rs.next()) {
                Plan_In pli = new Plan_In();
                pli.setIdplan(rs.getString("IDPLAN"));
                pli.setPlan_codigo(rs.getString("PLAN_CODIGO"));
                pli.setPlan_estado(rs.getString("PLAN_ESTADO"));                
                list.add(pli);
            }
        } catch (SQLException e) {
        } catch (Exception ex) {
            Logger.getLogger(ModeloUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.cx.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModeloUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return list;
    }

    @Override
    public boolean agregar_Plan_In(String plan_codigo, String plan_estado) {
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            stmt.executeQuery("insert into plan_in values ('1','')");
            estado = true;
        } catch (Exception ex) {
            estado = false;
        }

        return estado;
    }

    @Override
    public boolean modificar_Plan_Ino_(String plan_codigo, String plan_estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar_Plan_In(String idplan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Plan_In> list_Plan_In(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
