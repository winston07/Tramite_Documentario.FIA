/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.dao_imple;

import com.fia.upeu.config.Conexion;
import com.fia.upeu.dao.InterEscuela;
import com.fia.upeu.modelo.Escuela;
import com.fia.upeu.modelo.Escuela_Usuario_Listar;
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
public class ModeloEscuela implements InterEscuela {

    ResultSet rs = null;
    Statement stmt = null;
    Connection cx = null;
    boolean estado = false;

    @Override
    public List<Escuela> listar_Escuela() {
        List<Escuela> list = new ArrayList<Escuela>();
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("select * from escuela");
            while (rs.next()) {
                Escuela esc = new Escuela();
                esc.setEscuela(rs.getString("IDESCUELA"));
                esc.setIdFacultad(rs.getString("IDFACULTAD"));
                esc.setNombre(rs.getString("ESC_NOMBRE"));
                list.add(esc);
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
    public List<Escuela> listar_Id_Escuela(String idPedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar_Pedido(String idFacultad, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar_Pedido(String idEscuela, String idFacultad, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar_Pedido(String idPedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Escuela_Usuario_Listar> listar_Id_Escuela_Usuario(String idUsuario) {
    List<Escuela_Usuario_Listar> list = new ArrayList<Escuela_Usuario_Listar>();
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("select e.idescuela,e.esc_nombre from escuela e,escuela_usuario eu where e.idescuela=eu.idescuela and eu.idusuario='"+idUsuario+"'");
            while (rs.next()) {
                Escuela_Usuario_Listar esc = new Escuela_Usuario_Listar();
                esc.setIdEscuela(rs.getString("IDESCUELA"));
                esc.setNombre(rs.getString("ESC_NOMBRE"));
                list.add(esc);
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
