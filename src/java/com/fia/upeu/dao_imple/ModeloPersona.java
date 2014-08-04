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
    boolean estado = false;

    @Override
    public List<Persona> listar_Persona() {
        List<Persona> list = new ArrayList<Persona>();
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("select * from PERSONA");
            while (rs.next()) {
                Persona per = new Persona();
                per.setIdPersona(rs.getString("IDPERSONA"));
                per.setNombre(rs.getString("PERL_NOMBRE"));
                per.setPaterno(rs.getString("PER_APELLIDO_PATERNO"));
                per.setMaterno(rs.getString("PER_APELLIDO_MATERNO"));
                per.setCorreo(rs.getString("PER_CORREO"));
                per.setTelefono(rs.getString("PER_TELEFONO"));
                per.setSexo(rs.getString("PER_SEXO"));
                per.setDireccion(rs.getString("PER_DIRECCION"));
                per.setCorreo(null);
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
    public List<Persona> listar_Id_Persona(String idPersona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar_Persona(String nombre, String paterno, String materno, String correo, String telefono, String sexo, String direccion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar_Persona(String idPersona, String nombre, String paterno, String materno, String correo, String telefono, String sexo, String direccion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar_Persona(String idPersona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
