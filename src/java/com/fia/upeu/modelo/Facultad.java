/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.modelo;

/**
 *
 * @author NetOraPro
 */
public class Facultad {
    private String idfacutad;
    private String iduniversidad;
    private String fa_nombre;
    public Facultad(String idfacultad,String idUniversidad,String fa_nombre){
        this.fa_nombre=fa_nombre;
        this.idfacutad=idfacultad;
        this.iduniversidad=idUniversidad;
    }
    public Facultad(){
    }

    public String getIdfacutad() {
        return idfacutad;
    }

    public void setIdfacutad(String idfacutad) {
        this.idfacutad = idfacutad;
    }

    public String getIduniversidad() {
        return iduniversidad;
    }

    public void setIduniversidad(String iduniversidad) {
        this.iduniversidad = iduniversidad;
    }

    public String getFa_nombre() {
        return fa_nombre;
    }

    public void setFa_nombre(String fa_nombre) {
        this.fa_nombre = fa_nombre;
    }

    public void setIdUniversidad(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setnombre(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setFa_Nombre(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setFacultad(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
}
