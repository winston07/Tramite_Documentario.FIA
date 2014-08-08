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
import java.util.List;

/**
 *
 * @author Kelvin Thony
 */
public class ModeloAuditoria implements Inter_Au{

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
    
}
