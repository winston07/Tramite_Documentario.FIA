/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.dao_imple;

import com.fia.upeu.config.Conexion;
import com.fia.upeu.dao.Inter_Au;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Kelvin Thony
 */
public class ModeloAuditoria implements Inter_Au {
    ResultSet rs = null;
    Statement stmt = null;
    Connection cx = null;
    boolean estado = false;

    @Override
    public List<Inter_Au> listar_Au(String idAu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inter_Au> listar_Id_Au(String idAu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar_Au(String usuario, String pedido, String estado, String fecha, String escuela) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public boolean modificar_Au(String idAu, String usuario, String pedido, String estado, String fecha, String escuela) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar_Au(String idAu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar_estado(String idvali,String Estado) {
        try {
            cx = Conexion.getConex();
            cx.setAutoCommit(false);
            CallableStatement insert = cx.prepareCall("{ call  fiaupdateautramite(?,?) }");
            // cargar parametros al SP
            //CallableStatement insert = connMY.prepareCall("{ call execute fiainsertpedido4 ('2014-2','ESC00001','TRM00001','08/08/14','1','01:04:09','USU00001','Ingresando Cursos','SOL00003') }");
            insert.setString(1, idvali);
            insert.setString(2, Estado);
            // ejecutar el SP
            insert.executeQuery();
            // confirmar si se ejecuto sin errores
            cx.commit();
            estado = true;
        } catch (Exception ex) {
            estado = false;
        }

        return estado;
    }

}
