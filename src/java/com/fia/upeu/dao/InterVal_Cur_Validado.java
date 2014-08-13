/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao;

import com.fia.upeu.modelo.Val_Cur_Validado;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Kelvin Thony
 */
public interface InterVal_Cur_Validado {
    public List<Val_Cur_Validado> listar_Val_Cur_Valido();

    public List<Val_Cur_Validado> listar_Id_Val_Cur_Valido(String idV_Cur);

    public boolean agregar_Val_Cur_Valido(String val, String val_cur_val);

    public boolean modificar_Val_Cur_Valido(String idV_Cur ,String val, String val_cur_val, String id_curso);

    public boolean eliminar_Val_Cur_Valido(String idV_Cur);
    
    public ResultSet listar_Val_Cur(String idV);
}
