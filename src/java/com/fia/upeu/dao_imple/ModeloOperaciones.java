/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.dao_imple;

import com.fia.upeu.config.Conexion;
import com.fia.upeu.dao.InterOperaciones;
import com.fia.upeu.modelo.Curso_in;
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
 * @author Kelvin
 */
public class ModeloOperaciones implements InterOperaciones {

    ResultSet rs = null;
    Statement stmt = null;
    Connection cx = null;
    boolean estado = false;

    @Override
    public List<Curso_in> listar_Add_Validacion() {
        List<Curso_in> list = new ArrayList<Curso_in>();
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("select * from CUR_VALIDACION");
            while (rs.next()) {
                Curso_in cur_in = new Curso_in();
                cur_in.setPlan_codigo(rs.getString("PLAN_CUR_CICLOS"));
                cur_in.setCurNombre(rs.getString("CUR_NOMBRE"));
                cur_in.setCur_Cr(rs.getString("CUR_CR"));
                cur_in.setCur_Ht(rs.getString("CUR_HT"));
                cur_in.setCur_Hnp(rs.getString("CUR_HNP"));
                cur_in.setCur_Th(rs.getString("CUR_TH"));
                cur_in.setCur_Nota(rs.getString("CUR_NOTA"));
                list.add(cur_in);
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
}
