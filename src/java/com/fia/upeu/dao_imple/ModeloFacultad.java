/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao_imple;

import com.fia.upeu.config.Conexion;
import com.fia.upeu.dao.InterFacultad;
import com.fia.upeu.modelo.Facultad;
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
 * @author NetOraPro
 */
public class ModeloFacultad implements InterFacultad{
    ResultSet rs = null;
    Statement stmt = null;
    Connection cx = null;
    boolean estado = false;

    @Override
    public List<Facultad> list_facultad() {
        List<Facultad> list = new ArrayList<Facultad>();
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("select * from facultad");
            while (rs.next()) {
                Facultad esc = new Facultad();
                esc.setFacultad(rs.getString("IDFACULTAD"));
                esc.setIdUniversidad(rs.getString("IDUNIVERSIDAD"));
                esc.setFa_Nombre(rs.getString("FA_NOMBRE"));                
                list.add(esc);
            }
        } catch (SQLException e) {
        } catch (Exception ex) {
            Logger.getLogger(ModeloFacultad.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            try {
                this.cx.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModeloFacultad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return list;
    }

    @Override
    public boolean AgregarFacultad(String idfacultad, String iduniversidad, String fa_nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ModificarFacultad(String idfacultad, String iduniversidad, String fa_nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarFacultad(String idfacultad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
