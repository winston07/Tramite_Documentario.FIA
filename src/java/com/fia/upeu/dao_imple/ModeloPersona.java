/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.dao_imple;

import com.fia.upeu.config.Conexion;
import com.fia.upeu.dao.InterPersona;
import com.fia.upeu.modelo.Persona;
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
public class ModeloPersona implements InterPersona {

    ResultSet rs = null;
    Statement stmt = null;
    Connection cx = null;

    @Override
    public List<Persona> listar_Persona() {
        List<Persona> list = new ArrayList<Persona>();
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("select * from usuario");
            while (rs.next()) {
                Persona per = new Persona();
                per.setIdPersona(rs.getString("IDPERSONA"));
                per.setNombre(rs.getString("PERL_NOMBRE"));
                per.setAp_paterno(rs.getString("PER_APELLIDO_PATERNO"));
                per.setAp_materno(rs.getString("PER_APELLIDO_MATERNO"));
                per.setCorreo(rs.getString("PER_CORREO"));
                per.setNum_tel(rs.getString("PER_TELEFONO"));
                per.setSexo(rs.getString("PER_SEXO"));
                per.setDireccion(rs.getString("PER_DIRECCION"));
                per.setEstado(rs.getString("PER_ESTADO"));
                list.add(per);
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
    public List<Persona> listar_Id_Persona(String id) {
        List<Persona> list = new ArrayList<Persona>();
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("select * from usuario WHERE idpersona='"+id+"'");
            while (rs.next()) {
                Persona per = new Persona();
                per.setIdPersona(rs.getString("IDPERSONA"));
                per.setNombre(rs.getString("PERL_NOMBRE"));
                per.setAp_paterno(rs.getString("PER_APELLIDO_PATERNO"));
                per.setAp_materno(rs.getString("PER_APELLIDO_MATERNO"));
                per.setCorreo(rs.getString("PER_CORREO"));
                per.setNum_tel(rs.getString("PER_TELEFONO"));
                per.setSexo(rs.getString("PER_SEXO"));
                per.setDireccion(rs.getString("PER_DIRECCION"));
                per.setEstado(rs.getString("PER_ESTADO"));
                list.add(per);
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
    public boolean agrePersona(String nombre, String ap_paterno, String ap_Materno, String correo, String telefono, String sexo, String direccion, String estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modiPersona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean elimPersona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
