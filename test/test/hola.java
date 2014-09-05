/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.fia.upeu.config.Conexion;
import com.fia.upeu.dao_imple.ModeloUsuario;
import com.fia.upeu.modelo.Escuela_Usuario_Listar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kelvin Thony
 */
public class hola {
    ResultSet rs = null;
    Statement stmt = null;
    Connection cx = null;
    boolean estado = false;

    public String periodo() {
        String respuesta = null;
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

        if (diain2 >= diain && mesin2 <= mesout) {
            respuesta = anio + "-2";

        }
        return respuesta;
    }

    public String hora() {
        Date dat = new Date();
        String fechanow;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        fechanow = sdf.format(dat);

        return fechanow;
    }
    public ResultSet escuela_Usuario(String idUsuario){
    
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("SELECT * FROM listarescuela_usuario where idusuario='" + idUsuario + "'");
            
        } catch (Exception ex) {
            Logger.getLogger(ModeloUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.cx.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModeloUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return rs;
    }
     public List<Escuela_Usuario_Listar> escuela_Usuario2(String idUsuario) throws IndexOutOfBoundsException {
        
        List<Escuela_Usuario_Listar> list = new ArrayList<Escuela_Usuario_Listar>();
        ResultSet usu;
        String a;
        String b;
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            usu = stmt.executeQuery("SELECT * FROM listarescuela_usuario where idusuario='" + idUsuario + "'");
            while (usu.next()) {
                Escuela_Usuario_Listar esc1 = new Escuela_Usuario_Listar();
                esc1.setIdEscuela(usu.getString(1));
                esc1.setNombre(usu.getString(2));
                esc1.setUsuario(usu.getString(3));
                list.add(esc1);
            }
            a=list.get(1).getIdEscuela();
            b=list.get(2).getIdEscuela();
            rs = stmt.executeQuery("SELECT * FROM escuela WHERE idescuela='" + a + "' OR '" + b + "'=idescuela");

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

}
