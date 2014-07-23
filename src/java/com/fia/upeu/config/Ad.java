/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.config;

import java.sql.Connection;

/**
 *
 * @author Kelvin Thony
 */
public class Ad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Connection cx = Conexion.getConex();
        if(cx!=null){
            System.out.println("Conexion Exitosa");
        }
    }
    
}
