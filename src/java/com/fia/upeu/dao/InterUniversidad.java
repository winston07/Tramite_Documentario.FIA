/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao;
import com.fia.upeu.modelo.Universidad;
import java.util.List;

/**
 *
 * @author XPC
 */
public interface InterUniversidad {
    public List<Universidad>list_Universidad();
    boolean ingresar_Universidad(String iduniversidad,String uni_nombre, String uni_direccion);
    boolean eliminar_Universidad(String iduniversidad);
    boolean modificar_Universidad(String iduniversidad,String uni_nombre,String uni_direccion);
    
}
