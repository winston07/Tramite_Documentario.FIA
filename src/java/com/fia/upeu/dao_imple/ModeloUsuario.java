/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.dao_imple;

import com.fia.upeu.config.Conexion;
import com.fia.upeu.dao.InterUsuario;
import com.fia.upeu.modelo.Usuario;
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
 * @author alum.fial7
 */
public class ModeloUsuario implements InterUsuario {

    ResultSet rs = null;
    Statement stmt = null;
    Connection cx = null;

  

    public Usuario editarUsuario(String idUsuario) {
        return null;
    }

    public boolean guardarUsuario() {
        return true;
    }

    public boolean eliminarUsuario(String id_Usuario) {
        return true;
    }

    @Override
    public List<Usuario> list_Usuario() {

        List<Usuario> list = new ArrayList<Usuario>();
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("select * from usuario");
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setIdUduario(rs.getString("IDUSUARIO"));
                usu.setUsuario(rs.getString("USU_LOGIN"));
                usu.setClave(rs.getString("USU_PASWORD"));
                usu.setEstado(rs.getString("USU_ESTADO"));
                usu.setIdPersona(rs.getString("IDPERSONA"));
                usu.setIdEscuela(rs.getString("IDESCUELA"));
                usu.setIdRol(rs.getString("IDROLES"));
                list.add(usu);
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
    public ResultSet validar_Usuario(String usuario,String clave) {
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("select * from usuario where usu_login='" + usuario + "' and usu_pasword='" + clave + "'");
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ModeloUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
