/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao;

import com.fia.upeu.modelo.Curso_in;
import java.util.List;

/**
 *
 * @author Kelvin Thony
 */
public interface InterCurso_in {
    public List<Curso_in> listar_Curso();

    public List<Curso_in> listar_Id_Curso(String idCurso);

    public boolean agregar_Curso(String cur_Nombre, String cur_Cr, String cur_ht, String cur_Hnp, String cur_Th,String cur_Nota);

    public boolean modificar_Curso(String idCurso,String cur_Nombre, String cur_Cr, String cur_ht, String cur_Hnp, String cur_Th,String cur_Nota,String estado);

    public boolean eliminar_Curso(String idCurso);
}
