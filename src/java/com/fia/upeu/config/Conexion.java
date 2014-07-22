/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author christinecolumbia
 */
public class Conexion {

    private static Connection conex = null;

    public static Connection getConex() throws Exception {
        Class.forName("oracle.jdbc.OracleDriver").newInstance();
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "root";
        String pwd = "";
        
        conex = DriverManager.getConnection(url, user, pwd);

        return conex;
    }

    public static  void CerrarConexion() throws SQLException {
        conex.close();
    }
}
