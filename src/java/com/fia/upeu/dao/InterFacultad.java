/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao;

import com.fia.upeu.modelo.Facultad;
import java.util.List;

/**
 *
 * @author NetOraPro
 */
public interface InterFacultad {
public List<Facultad>list_facultad();
public boolean AgregarFacultad(String idfacultad,String iduniversidad,String fa_nombre);
public boolean ModificarFacultad(String idfacultad,String iduniversidad,String fa_nombre);
public boolean EliminarFacultad(String idfacultad);

    
}
