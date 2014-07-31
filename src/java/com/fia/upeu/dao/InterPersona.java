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
    List<Persona> listar_Persona();
    List<Persona> listar_Id_Persona(String id);
    boolean agrePersona(String nombre, String ap_paterno, String ap_Materno, String correo, String telefono, String sexo, String direccion, String estado);
    boolean modiPersona();
    boolean elimPersona();
    
}
