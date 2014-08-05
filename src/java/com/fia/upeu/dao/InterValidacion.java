/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao;

import com.fia.upeu.modelo.Validacion;
import java.util.List;

/**
 *
 * @author Kelvin Thony
 */
public interface InterValidacion {
    public List<Validacion> listar_Validacion();

    public List<Validacion> listar_Id_Validacion(String idValidacion);

    public boolean agregar_Validacion(String id ,String val_Numero, String val_Plan_in, String val_plan_out, String val_inst_in,String val_inst_out);

    public boolean modificar_Validacion(String idValidacion,String val_Numero, String val_Plan_in, String val_plan_out, String val_inst_in,String val_inst_out,String estado);

    public boolean eliminar_Validacion(String idValidacion);
}
