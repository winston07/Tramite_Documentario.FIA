/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.dao_imple;

import com.fia.upeu.config.Conexion;
import com.fia.upeu.dao.InterVal_Cur_Validado;
import com.fia.upeu.modelo.Val_Cur_Validado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kelvin Thony
 */
public class ModeloVal_Cur_Val implements InterVal_Cur_Validado {

    ResultSet rs = null;
    Statement stmt = null;
    Connection cx = null;
    boolean estado = false;

    @Override
    public List<Val_Cur_Validado> listar_Val_Cur_Valido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Val_Cur_Validado> listar_Id_Val_Cur_Valido(String idV_Cur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar_Val_Cur_Valido(String ciclo, String curso, String cr, String ht, String hnp, String th, String nota, String vali) {

        try {
            cx = Conexion.getConex();
            //cx.nativeSQL("execute fiainsertpedido ('2014-2','ESC00001','TRM00001','null','07/08/2014','1','SOL00002')");

            cx.setAutoCommit(false);
            CallableStatement insert = cx.prepareCall("{ call  fiainsertval_cur_val(?,?,?,?,?,?,?,?) }");
            // cargar parametros al SP
            //CallableStatement insert = connMY.prepareCall("{ call execute fiainsertpedido4 ('2014-2','ESC00001','TRM00001','08/08/14','1','01:04:09','USU00001','Ingresando Cursos','SOL00003') }");

            insert.setString(1, ciclo);
            insert.setString(2, curso);
            insert.setString(3, cr);
            insert.setString(4, ht);
            insert.setString(5, hnp);
            insert.setString(6, th);
            insert.setString(7, nota);
            insert.setString(8, vali);
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
    public boolean modificar_Val_Cur_Valido(String idcurso, String ciclo, String curso, String cr, String ht, String hnp, String th, String nota) {
        try {
            cx = Conexion.getConex();
            cx.setAutoCommit(false);
            CallableStatement insert = cx.prepareCall("{ call  fiainsertCursoV (?,?,?,?,?,?,?,?,?) }");
            // cargar parametros al SP
            //CallableStatement insert = connMY.prepareCall("{ call execute fiainsertpedido4 ('2014-2','ESC00001','TRM00001','08/08/14','1','01:04:09','USU00001','Ingresando Cursos','SOL00003') }");
            insert.setString(1, ciclo);
            insert.setString(2, curso);
            insert.setString(3, cr);
            insert.setString(4, ht);
            insert.setString(5, hnp);
            insert.setString(6, th);
            insert.setString(7, nota);
            insert.setString(8, "1");
            insert.setString(9, idcurso);
            // ejecutar el SP
            insert.executeQuery();
            // confirmar si se ejecuto sin errores
            cx.commit();
            estado = true;
            cx.close();
        } catch (Exception ex) {
            estado = false;
        }

        return estado;
    }

    @Override
    public boolean eliminar_Val_Cur_Valido(String idV_Cur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet listar_Val_Cur(String idv) {
        try {
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            rs = stmt.executeQuery("select * from validacion_curso_validado where IDVALIDACION='" + idv + "' order by ciclo ");

        } catch (Exception ex) {
            Logger.getLogger(ModeloPedido.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    @Override
    public boolean modificarIndividual(String columna, String idCurso, String valor) {
        String sql="";
        try {
           sql=" update curso set "+columna+" = '"+valor+"' WHERE idcurso=(select idcurso from validacion_curso_validado where idcurso_valido='"+idCurso+"')";
            cx = Conexion.getConex();
            stmt = cx.createStatement();
            stmt.executeUpdate(sql);
            estado=true;
        } catch (Exception ex) {
            Logger.getLogger(ModeloVal_Cur_Val.class.getName()).log(Level.SEVERE, null, ex);
            estado=false;
        }
        return estado;
    }

}
