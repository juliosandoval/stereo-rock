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
public class Album {
    
    private String nombre;
    private String fecha;
    private int pistas;
    private String portada;
    private String contrPortada;
    private String nombreBanda;
    private String nombreEstudio;

    public Album(String nombre, String fecha, int pistas, String portada, String contrPortada, String nombreBanda, String nombreEstudio) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.pistas = pistas;
        this.portada = portada;
        this.contrPortada = contrPortada;
        this.nombreBanda = nombreBanda;
        this.nombreEstudio = nombreEstudio;
    }

    public Album() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPistas() {
        return pistas;
    }

    public void setPistas(int pistas) {
        this.pistas = pistas;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getContrPortada() {
        return contrPortada;
    }

    public void setContrPortada(String contrPortada) {
        this.contrPortada = contrPortada;
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public void setNombreBanda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
    }

    public String getNombreEstudio() {
        return nombreEstudio;
    }

    public void setNombreEstudio(String nombreEstudio) {
        this.nombreEstudio = nombreEstudio;
    }
    
    
    
    
    
}
