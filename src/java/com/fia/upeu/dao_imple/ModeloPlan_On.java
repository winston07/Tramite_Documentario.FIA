/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao_imple;

import com.fia.upeu.dao.InterPlan_On;
import com.fia.upeu.modelo.Plan_On;
import java.util.List;

/**
 *
 * @author NetOraPro
 */
public class ModeloPlan_On implements InterPlan_On{

    @Override
    public List<Plan_On> list_Plan_On() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean AgregarPlan_On(String idplan, String plan_on_codigo, String plan_on_estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminaPlan_On(String idplan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ModificcarPlan_On(String idplan, String plan_on_codigo, String plan_on_estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
