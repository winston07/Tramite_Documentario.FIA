/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao;

import com.fia.upeu.modelo.Solicitante;
import java.util.List;

/**
 *
 * @author Kelvin Thony
 */
public interface InterSolicitante {
    public List<Solicitante> listar_Solicitante();

    public List<Solicitante> listar_Id_Solicitante(String idSolicitante);

    public boolean agregar_Solicitante(String nombre,String ap_p,String ap_m,String correo,String telefono,String sexo,String direccion,String codigo);

    public boolean modificar_Solicitante(String idSolictante,String codigo, String idPersona);

    public boolean eliminar_Solicitante(String idSolicitante);
}
