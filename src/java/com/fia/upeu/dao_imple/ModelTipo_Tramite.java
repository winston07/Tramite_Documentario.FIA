/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao_imple;

import com.fia.upeu.config.Conexion;
import com.fia.upeu.dao.InterTipo_Tramite;
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
public class ModelTipo_Tramite implements InterTipo_Tramite{
    ResultSet rs = null;
    Statement stmt = null;
    Connection cx = null;
    boolean estado = false;

    @Override
    public List<Tipo_Tramite> listar_Tipo_Tramite() {
        
        List<Tipo_Tramite> list = new ArrayList<Tipo_Tramite>();
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("select * from TIPO_TRAMITE");
            while (rs.next()) {
                Tipo_Tramite tipoTra = new Tipo_Tramite();
                tipoTra.setId_Tipo_Tramite(rs.getString("ID_TIPO_TRAMITE"));
                tipoTra.setIdValidacion(rs.getString("IDVALIDACION"));
                tipoTra.setNombreTramite(rs.getString("NOMBRE_TRAMITE"));
                list.add(tipoTra);
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
    public List<Tipo_Tramite> listar_Id_Tipo_Tramite(String idTipo_Tramite) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar_Tipo_Tramite(String idValidacion, String nombre_Tramite) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar_Tipo_Tramite(String idValidacion, String nombre_Tramite) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar_Tipo_Tramite(String idTipo_Tramite) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
