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

    public boolean agregar_Solicitante(String codigo, String idPersona);

    public boolean modificar_Solicitante(String idSolictante,String codigo, String idPersona);

    public boolean eliminar_Solicitante(String idSolicitante);
}
