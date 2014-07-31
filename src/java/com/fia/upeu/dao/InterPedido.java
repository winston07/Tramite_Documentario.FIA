/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.dao;

import com.fia.upeu.modelo.Pedido;
import java.util.List;

/**
 *
 * @author Kelvin Thony
 */
public interface InterPedido {

    public List<Pedido> listar_Pedido();

    public List<Pedido> listar_Id_Pedido(String idPedido);

    public boolean agregar_Pedido(String fecha, String Periodo, String escuela, String tipo_Tramite, String validacion, String solicitante);

    public boolean modificar_Pedido(String fecha, String Periodo, String escuela, String tipo_Tramite, String validacion, String solicitante);

    public boolean eliminar_Pedido(String idPedido);
}