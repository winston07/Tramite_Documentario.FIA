/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao;

import com.fia.upeu.dao_imple.Tipo_Tramite;
import java.util.List;

/**
 *
 * @author Kelvin Thony
 */
public interface InterTipo_Tramite {
    public List<Tipo_Tramite> listar_Tipo_Tramite();

    public List<Tipo_Tramite> listar_Id_Tipo_Tramite(String idTipo_Tramite);

    public boolean agregar_Tipo_Tramite(String idValidacion, String nombre_Tramite);

    public boolean modificar_Tipo_Tramite(String idValidacion, String nombre_Tramite);

    public boolean eliminar_Tipo_Tramite(String idTipo_Tramite);
}
