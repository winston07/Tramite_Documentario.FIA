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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Kelvin Thony
 */
public class ModeloPeriodo {
    ResultSet rs = null;
    Statement stmt = null;
    Connection cx = null;
    
    public void agregar_Periodo(){
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            stmt.executeQuery("e");
           
        } catch (Exception ex) {
        }
        
    }
    public String periodo() {
        String respuesta=null;
        Date dat = new Date();
        String fechanow;
        int diain = 1;
        int mesin = 6;
        int mesout = 12;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        fechanow = sdf.format(dat);
        String cortadodia = fechanow.substring(0, 2);
        String cortadomes = fechanow.substring(3, 5);
        String cortanio = fechanow.substring(6, 10);
        int diain2 = Integer.parseInt(cortadodia);
        int mesin2 = Integer.parseInt(cortadomes);
        int anio = Integer.parseInt(cortanio);
        //System.out.println("dia:"+diain2+"-Mes:"+mesout2);
        if (diain2 >= diain && mesin2 <= mesin) {
            respuesta = anio + "-1";
        }

        if (diain2 > diain && mesin2 <= mesout) {
            respuesta = anio + "-2";
            
        }
        return respuesta;
    }
    
}
