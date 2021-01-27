/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.adoo.Prototype;

/**
 *
 * @author Julio
 */
public class Banda {
    
    String nombreBanda;
    int anioCreacion;
    String ciudadCreacion;

    public Banda(String nombreBanda, int anioCreacion, String ciudadCreacion) {
        this.nombreBanda = nombreBanda;
        this.anioCreacion = anioCreacion;
        this.ciudadCreacion = ciudadCreacion;
    }

    public Banda() {
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public void setNombreBanda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
    }

    public int getAnioCreacion() {
        return anioCreacion;
    }

    public void setAnioCreacion(int anioCreacion) {
        this.anioCreacion = anioCreacion;
    }

    public String getCiudadCreacion() {
        return ciudadCreacion;
    }

    public void setCiudadCreacion(String ciudadCreacion) {
        this.ciudadCreacion = ciudadCreacion;
    }
    
    
    
}
