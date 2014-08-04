/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.dao;

import com.fia.upeu.modelo.Persona;
import java.util.List;

/**
 *
 * @author Kelvin Thony
 */
public interface InterPersona {
    public List<Persona> listar_Persona();

    public List<Persona> listar_Id_Persona(String idPersona);

    public boolean agregar_Persona(String nombre, String paterno,String materno,String correo,String telefono, String sexo,String direccion);

    public boolean modificar_Persona(String idPersona,String nombre, String paterno,String materno,String correo,String telefono, String sexo,String direccion);

    public boolean eliminar_Persona(String idPersona);
}
