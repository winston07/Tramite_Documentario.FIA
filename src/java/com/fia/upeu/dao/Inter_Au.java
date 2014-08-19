/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao;

import java.util.List;

/**
 *
 * @author Kelvin Thony
 */
public interface Inter_Au {
     public List<Inter_Au> listar_Au(String idAu);
    
     public List<Inter_Au> listar_Id_Au(String idAu);

    public boolean agregar_Au(String usuario, String pedido,String estado,String fecha,String escuela);

    public boolean modificar_Au(String idAu,String usuario, String pedido,String estado,String fecha,String escuela);

    public boolean eliminar_Au(String idAu);
    
    public boolean modificar_estado(String idvali,String Estado);
    
}
