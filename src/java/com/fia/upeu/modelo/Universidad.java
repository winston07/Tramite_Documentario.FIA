/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.modelo;

/**
 *
 * @author XPC
 */
public class Universidad {
    private String iduniversidad;

    public String getIduniversidad() {
        return iduniversidad;
    }

    public void setIduniversidad(String iduniversidad) {
        this.iduniversidad = iduniversidad;
    }

    public String getUni_nombre() {
        return uni_nombre;
    }

    public void setUni_nombre(String uni_nombre) {
        this.uni_nombre = uni_nombre;
    }

    public String getUni_direccion() {
        return uni_direccion;
    }

    public void setUni_direccion(String uni_direccion) {
        this.uni_direccion = uni_direccion;
    }
    private String uni_nombre;
    private String uni_direccion;
    public Universidad (String iduniversidad, String uni_nombre, String uni_direccion){
        this.iduniversidad=iduniversidad;
        this.uni_direccion=uni_direccion;
        this.uni_nombre=uni_nombre;
        
    }
    public Universidad(){
    }
}
