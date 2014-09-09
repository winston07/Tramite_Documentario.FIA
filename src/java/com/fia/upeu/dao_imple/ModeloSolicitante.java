/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.dao_imple;

import com.fia.upeu.modelo.Solicitante;
import com.fia.upeu.config.Conexion;
import com.fia.upeu.dao.InterSolicitante;
import java.sql.CallableStatement;
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
public class ModeloSolicitante implements InterSolicitante {

    ResultSet rs = null;
    Statement stmt = null;
    Connection cx = null;
    boolean estado = false;

    @Override
    public List<Solicitante> listar_Solicitante() {

        List<Solicitante> list = new ArrayList<Solicitante>();
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("select * from SOLICITANTE, PERSONA where SOLICITANTE.IDPERSONA=PERSONA.IDPERSONA");
            while (rs.next()) {
                Solicitante sol = new Solicitante();
                sol.setIdSolicitante(rs.getString("IDSOLICITANTE"));
                sol.setCodigo(rs.getString("SOL_CODIGO"));
                sol.setIdPersona(rs.getString("IDPERSONA"));
                sol.setNombre(rs.getString("PERL_NOMBRE"));
                sol.setPaterno(rs.getString("PER_APELLIDO_PATERNO"));
                list.add(sol);
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
    public List<Solicitante> listar_Id_Solicitante(String idSolicitante) {
        List<Solicitante> list = new ArrayList<Solicitante>();
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("select * from SOLICITANTE, PERSONA where SOLICITANTE.IDPERSONA=PERSONA.IDPERSONA and SOLICITANTE.IDSOLICITANTE='"+idSolicitante+"'");
            while (rs.next()) {
                Solicitante sol = new Solicitante();
                sol.setIdSolicitante(rs.getString("IDSOLICITANTE"));
                sol.setCodigo(rs.getString("SOL_CODIGO"));
                sol.setNombre(rs.getString("PERL_NOMBRE"));
                sol.setPaterno(rs.getString("PER_APELLIDO_PATERNO"));
                sol.setMaterno(rs.getString("PER_APELLIDO_MATERNO"));
                list.add(sol);
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
    public boolean agregar_Solicitante(String nombre,String ap_p,String ap_m,String correo,String telefono,String sexo,String direccion,String codigo) {
         try {
            cx=Conexion.getConex();
            //cx.nativeSQL("execute fiainsertpedido ('2014-2','ESC00001','TRM00001','null','07/08/2014','1','SOL00002')");

            cx.setAutoCommit(false);
            CallableStatement insert = cx.prepareCall("{ call  fiainsertarpersonasolicitante ('"+nombre+"','"+ap_p+"','"+ap_m+"','"+correo+"','"+telefono+"','"+sexo+"','"+direccion+"','"+codigo+"') }");
            // cargar parametros al SP
            //CallableStatement insert = connMY.prepareCall("{ call execute fiainsertpedido4 ('2014-2','ESC00001','TRM00001','08/08/14','1','01:04:09','USU00001','Ingresando Cursos','SOL00003') }");
           
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

    @Override
    public boolean modificar_Solicitante(String idSolictante, String codigo, String idPersona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar_Solicitante(String idSolicitante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
