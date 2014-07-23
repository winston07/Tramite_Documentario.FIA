/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.modelo;

import com.fia.upeu.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author alum.fial7
 */
public class ModeloUsuario {

    ResultSet rs;
    boolean resultado = false;

    public ResultSet listarUsuario() {
        return rs;
    }

    public ResultSet ValidaUsuario(String usuario, String clave) throws Exception  {
        System.out.println(usuario+clave);
        Connection cx = Conexion.getConex();
        String query = "select usu_login,usu_pasword from  USUARIO where usu_login='"+usuario+"' and usu_pasword='"+clave+"';";
        PreparedStatement ps = cx.prepareStatement(query);
        rs = ps.executeQuery();
        return rs;
    }
}
