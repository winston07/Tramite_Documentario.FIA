/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.dao_imple;

import com.fia.upeu.config.Conexion;
import com.fia.upeu.dao.InterValidacion;
import com.fia.upeu.modelo.Validacion;
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
 * @author Kelvin Thony
 */
public class ModeloValidacion implements InterValidacion {

    ResultSet rs = null;
    Statement stmt = null;
    Connection cx = null;
    boolean estado = false;

    @Override
    public List<Validacion> listar_Validacion() {
        List<Validacion> list = new ArrayList<Validacion>();
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("select * from validacion WHERE val_estado='1'");
            while (rs.next()) {
                Validacion val = new Validacion();
                val.setIdvalidacion(rs.getString("IDVALIDACION"));
                val.setIdvalidacion(rs.getString("VAL_NRO"));
                val.setIdvalidacion(rs.getString("VAL_PLAN_IN"));
                val.setIdvalidacion(rs.getString("VAL_PLAN_OUT"));
                val.setIdvalidacion(rs.getString("VAL_INST_IN"));
                val.setIdvalidacion(rs.getString("VAL_INST_OUT"));
                list.add(val);
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
    public List<Validacion> listar_Id_Validacion(String idValidacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar_Validacion(String id,String val_Numero, String val_Plan_in, String val_plan_out, String val_inst_in, String val_inst_out) {
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            stmt.executeQuery("insert into VALIDACION values ('"+id+"','"+val_Numero+"','"+val_Plan_in+"','"+val_plan_out+"','"+val_inst_in+"','"+val_inst_out+"','1')");
            estado = true;
        } catch (Exception ex) {
            estado = false;
        }

        return estado;
    }

    @Override
    public boolean modificar_Validacion(String idValidacion, String val_Numero, String val_Plan_in, String val_plan_out, String val_inst_in, String val_inst_out, String estadoo) {
       try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            stmt.executeUpdate("UPDATE validacion SET val_plan_in='"+val_Plan_in+"',val_plan_out='"+val_plan_out+"',val_inst_in='"+val_inst_in+"',val_inst_out='"+val_inst_out+"',val_estado='1' WHERE idvalidacion='"+idValidacion+"'");
            estado=true;
        } catch (Exception ex) {
            estado = false;
        }

        return estado;
    }

    @Override
    public boolean eliminar_Validacion(String idValidacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
