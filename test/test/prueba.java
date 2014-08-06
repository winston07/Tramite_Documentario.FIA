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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Kelvin Thony
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String fecha;
        Date dat = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        fecha = sdf.format(dat);
        Date d = sdf.parse(fecha);
        System.out.println("aqui esta la fecha" + d);
    }

}
