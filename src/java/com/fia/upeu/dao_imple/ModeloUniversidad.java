/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao_imple;

import com.fia.upeu.config.Conexion;
import com.fia.upeu.dao.InterUniversidad;
import com.fia.upeu.modelo.Universidad;
import com.fia.upeu.modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.fia.upeu.modelo.Universidad;

/**
 *
 * @author XPC
 */
public class ModeloUniversidad implements InterUniversidad{
      ResultSet rs = null;
    Statement stmt = null;
    Connection cx = null;
    boolean estado = false;


    @Override
    public List<Universidad> list_Universidad() {
        
        List<Universidad> list = new ArrayList<Universidad>();
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("select * from Universidad");
            while (rs.next()) {
                Universidad uni = new Universidad();
                uni.setIdUniversidad(rs.getString("IDUNIVERSIDAD"));
                uni.setUni_Nombre(rs.getString("UNI_NOMBRE"));
                uni.setUni_Direccion(rs.getString("UNI_DIRECCION"));
                list.add(uni);
            }
        } catch (SQLException e) {
        } catch (Exception ex) {
            Logger.getLogger(ModeloUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.cx.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModeloUniversidad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return list;
    }

    public boolean ingresar_Universidad(String uni_nombre, String uni_direccion ,String iduniversidad) {
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            stmt.executeQuery("insert into Universidad values ('" + uni_nombre +  "','" +iduniversidad + "','" + uni_direccion + "')");
            estado = true;
        } catch (Exception ex) {
            estado = false;
        }

        return estado;
    }

    @Override
    public boolean eliminar_Universidad(String iduniversidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar_Universidad(String iduniversidad, String uni_nombre, String uni_direccion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
