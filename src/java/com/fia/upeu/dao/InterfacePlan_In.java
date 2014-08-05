/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao;
import com.fia.upeu.modelo.Plan_In;


import java.util.List;
/**
 *
 * @author XPC
 */
public interface InterfacePlan_In {
    public List<Plan_In> list_Plan_In();
    public boolean agregar_Plan_In(String plan_codigo, String plan_estado);
    public boolean modificar_Plan_Ino_(String plan_codigo, String plan_estado);
    public boolean eliminar_Plan_In(String idplan);
            
}
