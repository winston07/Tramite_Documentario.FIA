/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.fia.upeu.modelo.Escuela_Usuario_Listar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



/**
 *
 * @author Kelvin Thony
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IndexOutOfBoundsException, SQLException{
        hola h = new hola();
        String a = h.periodo();
        String b = h.hora();
        //List<Escuela_Usuario_Listar> kp = h.escuela_Usuario2("USU00002");
        
        ResultSet rs = h.escuela_Usuario("USU00002");
        while(rs.next()){
        System.out.println(rs.getString(1));
        }

    }

   

}
