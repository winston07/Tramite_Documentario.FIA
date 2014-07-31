/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao;

import com.fia.upeu.modelo.Plan_On;
import java.util.List;

/**
 *
 * @author NetOraPro
 */
public interface InterPlan_On {
    public List<Plan_On>list_Plan_On();
    public boolean AgregarPlan_On(String idplan,String plan_on_codigo,String plan_on_estado);
    public boolean eliminaPlan_On(String idplan);
    public boolean ModificcarPlan_On(String idplan,String plan_on_codigo,String plan_on_estado);
    
    
}
