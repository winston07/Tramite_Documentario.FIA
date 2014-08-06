/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.dao_imple;

import com.fia.upeu.config.Conexion;
import com.fia.upeu.dao.InterPedido;
import com.fia.upeu.modelo.Pedido;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kelvin Thony
 */
public class ModeloPedido implements InterPedido {

    ResultSet rs = null;
    Statement stmt = null;
    Connection cx = null;
    boolean estado = false;

    @Override
    public List<Pedido> listar_Pedido() {
        List<Pedido> list = new ArrayList<Pedido>();
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("select * from pedido");
            while (rs.next()) {
                Pedido ped = new Pedido();
                ped.setFecha(rs.getString("IDPEDIDO"));
                ped.setFecha(rs.getString("IDPERIODO"));
                ped.setFecha(rs.getString("IDESCUELA"));
                ped.setFecha(rs.getString("ID_TIPO_TRAMITE"));
                ped.setFecha(rs.getString("ID_VALIDACION"));
                ped.setFecha(rs.getString("PED_FECHA"));
                ped.setFecha(rs.getString("PED_FECHA"));
                ped.setFecha(rs.getString("IDSOLICITANTE"));
                list.add(ped);
            }
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

    @Override
    public List<Pedido> listar_Id_Pedido(String idPedido) {
        List<Pedido> list = new ArrayList<Pedido>();
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("select * from usuario WHERE idpedido='" + idPedido + "'");
            while (rs.next()) {
                Pedido ped = new Pedido();
                ped.setFecha(rs.getString("IDPEDIDO"));
                ped.setFecha(rs.getString("IDPERIODO"));
                ped.setFecha(rs.getString("IDESCUELA"));
                ped.setFecha(rs.getString("ID_TIPO_TRAMITE"));
                ped.setFecha(rs.getString("ID_VALIDACION"));
                ped.setFecha(rs.getString("PED_FECHA"));
                ped.setFecha(rs.getString("PED_FECHA"));
                ped.setFecha(rs.getString("IDSOLICITANTE"));
                list.add(ped);
            }
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

    @Override
    public boolean agregar_Pedido(String Periodo, String escuela, String tipo_Tramite, String validacion, String solicitante, String pedido, String fecha) {
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            stmt.executeQuery("insert into PEDIDO values ('" + Periodo + "','" + escuela + "','" + tipo_Tramite + "','" + validacion + "','" + pedido + "','" + fecha + "','1','" + solicitante + "')");
            estado = true;
        } catch (Exception ex) {
            estado = false;
        }

        return estado;
    }

    @Override
    public boolean modificar_Pedido(String fecha, String Periodo, String escuela, String tipo_Tramite, String validacion, String solicitante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar_Pedido(String idPedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet listar_To_Print(String sol, String ped, String tra) {
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("SELECT PER.PERL_NOMBRE AS NOMBRE,PER.PER_APELLIDO_PATERNO AS AP_PATERNO, PER.PER_APELLIDO_MATERNO AS AP_MATERNO,SO.SOL_CODIGO AS CODIGO, TT.NOMBRE_TRAMITE AS NOMBRE_TRAMITE,PE.IDPEDIDO AS PEDIDO,TT.ID_TIPO_TRAMITE,SO.IDSOLICITANTE,PE.IDVALIDACION FROM PEDIDO PE,TIPO_TRAMITE TT,SOLICITANTE SO,PERSONA PER WHERE SO.IDSOLICITANTE=PE.IDSOLICITANTE AND SO.IDPERSONA=PER.IDPERSONA AND SO.IDSOLICITANTE='" + sol + "' AND PE.IDPEDIDO='" + ped + "' AND TT.ID_TIPO_TRAMITE='" + tra + "'");

        } catch (Exception ex) {
            Logger.getLogger(ModeloPedido.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    @Override
    public ResultSet listar_To_Evaluar() {
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("select * from PEDIDOSESPERA where ID_TIPO_TRAMITE='TRM001'");

        } catch (Exception ex) {
            Logger.getLogger(ModeloPedido.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

}
