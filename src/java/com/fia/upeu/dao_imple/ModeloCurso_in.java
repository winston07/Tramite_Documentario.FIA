/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao_imple;

import com.fia.upeu.config.Conexion;
import com.fia.upeu.dao.InterCurso_in;
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
 * @author Kelvin Thony
 */
public class ModeloCurso_in implements InterCurso_in{
    ResultSet rs = null;
    Statement stmt = null;
    Connection cx = null;
    boolean estado = false;
    @Override
    public List<Curso_in> listar_Curso() {
         List<Curso_in> list = new ArrayList<Curso_in>();
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("select * from curso");
            while (rs.next()) {
                Curso_in cur_in = new Curso_in();
                cur_in.setIdCurso(rs.getString("IDCURSO"));
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

    @Override
    public List<Curso_in> listar_Id_Curso(String idCurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar_Curso(String cur_Nombre, String cur_Cr, String cur_ht, String cur_Hnp, String cur_Th,String cur_Nota) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar_Curso(String idCurso, String cur_Nombre, String cur_Cr, String cur_ht, String cur_Hnp, String cur_Th, String estado,String cur_Nota) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar_Curso(String idCurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
