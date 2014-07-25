/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.fia.upeu.config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Kelvin Thony
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
           ResultSet rs;
         Connection cx = Conexion.getConex();
        String query = "select * from usuario";
        Statement sp = cx.createStatement();
        rs=sp.executeQuery(query);
        while(rs.next()){
            System.out.println(rs.getString(2));
        }    

    }

     void listar() throws Exception {
        ResultSet rs;
         Connection cx = Conexion.getConex();
        String query = "select * from usuario;";
        Statement sp = cx.createStatement();
        rs=sp.executeQuery(query);
        while(rs.next()){
            System.out.println(rs.getString(1));
        }
        

    }

}
