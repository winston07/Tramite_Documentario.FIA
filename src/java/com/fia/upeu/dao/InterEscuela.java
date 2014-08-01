/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao;

import com.fia.upeu.modelo.Escuela;
import java.util.List;

/**
 *
 * @author Kelvin Thony
 */
public interface InterEscuela {
    public List<Escuela> listar_Escuela();

    public List<Escuela> listar_Id_Escuela(String idPedido);

    public boolean agregar_Pedido(String idFacultad, String nombre);

    public boolean modificar_Pedido(String idEscuela, String idFacultad, String nombre);

    public boolean eliminar_Pedido(String idPedido);
}
