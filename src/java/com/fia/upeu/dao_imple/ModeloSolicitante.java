/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao_imple;

import com.fia.upeu.modelo.Solicitante;
import com.fia.upeu.config.Conexion;
import com.fia.upeu.dao.InterSolicitante;
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
public class ModeloSolicitante implements InterSolicitante{
     ResultSet rs = null;
    Statement stmt = null;
    Connection cx = null;
    boolean estado = false;
    @Override
    public List<Solicitante> listar_Solicitante() {
        
        List<Solicitante> list = new ArrayList<Solicitante>();
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("select * from SOLICITANTE");
            while (rs.next()) {
                Solicitante sol = new Solicitante();
                sol.setIdSolicitante(rs.getString("IDSOLICITANTE"));
                sol.setCodigo(rs.getString("SOL_CODIGO"));
                sol.setIdPersona(rs.getString("IDPERSONA"));
                list.add(sol);
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
    public List<Solicitante> listar_Id_Solicitante(String idSolicitante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar_Solicitante(String codigo, String idPersona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar_Solicitante(String idSolictante, String codigo, String idPersona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar_Solicitante(String idSolicitante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
