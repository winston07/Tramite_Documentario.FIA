/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.dao_imple;

import com.fia.upeu.config.Conexion;
import com.fia.upeu.dao.InterValidacion;
import com.fia.upeu.modelo.Validacion;
import java.sql.CallableStatement;
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
    public boolean agregar_Validacion(String id, String val_Numero, String val_Plan_in, String val_plan_out, String val_inst_in, String val_inst_out) {
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            stmt.executeQuery("insert into VALIDACION values ('" + id + "','" + val_Numero + "','" + val_Plan_in + "','" + val_plan_out + "','" + val_inst_in + "','" + val_inst_out + "','1')");
            estado = true;
        } catch (Exception ex) {
            estado = false;
        }

        return estado;
    }

    @Override
    public boolean modificar_Validacion(String idValidacion, String val_Plan_in, String val_plan_out, String val_inst_in, String val_inst_out) {
        try {
            cx = Conexion.getConex();
            cx.setAutoCommit(false);
            CallableStatement insert = cx.prepareCall("{ call  fiaupdatevalidacion(?,?,?,?,?,?) }");
            // cargar parametros al SP
            //CallableStatement insert = connMY.prepareCall("{ call execute fiainsertpedido4 ('2014-2','ESC00001','TRM00001','08/08/14','1','01:04:09','USU00001','Ingresando Cursos','SOL00003') }");
            insert.setString(1,idValidacion);
            insert.setString(2, val_Plan_in );
            insert.setString(3, val_plan_out);
            insert.setString(4, val_inst_in);
            insert.setString(5, val_inst_out);
            insert.setString(6, "1");
            // ejecutar el SP
            insert.executeQuery();
            // confirmar si se ejecuto sin errores
            cx.commit();
            estado = true;
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
