/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.dao_imple;

import com.fia.upeu.config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author alum.fial7
 */
public class ModeloUsuario {

    ResultSet rs = null;
    Statement stmt = null;
     Connection cx = null;
     
    public ResultSet ValidarUsuario(String usuario, String clave) throws Exception {
        
        cx=Conexion.getConex();
        stmt = cx.createStatement();
        rs = stmt.executeQuery("select * from usuario where usu_login='"+usuario+"' and usu_pasword='"+clave+"'");
        return rs;
    }
}
