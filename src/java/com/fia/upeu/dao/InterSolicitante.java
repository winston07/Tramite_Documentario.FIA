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
    List<Solicitante> listar_Solicitante();
    List<Solicitante> listar_Id_Solicitante(String id);
    boolean agreSolicitande(String nombre, String ap_paterno, String ap_Materno, String correo, String telefono, String sexo, String direccion, String estado);
    boolean modiSolicitante();
    boolean elimSolicitante();
}
