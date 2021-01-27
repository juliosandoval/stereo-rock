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
public class EstudioGrabacion {
    
    private String nombreEstudio;
    private String direccionEstudio;
    private String numeroTelefono;
    private String sitioWeb;

    public EstudioGrabacion() {
    }

    public EstudioGrabacion(String nombreEstudio, String direccionEstudio, String numeroTelefono, String sitioWeb) {
        this.nombreEstudio = nombreEstudio;
        this.direccionEstudio = direccionEstudio;
        this.numeroTelefono = numeroTelefono;
        this.sitioWeb = sitioWeb;
    }

    public String getNombreEstudio() {
        return nombreEstudio;
    }

    public void setNombreEstudio(String nombreEstudio) {
        this.nombreEstudio = nombreEstudio;
    }

    public String getDireccionEstudio() {
        return direccionEstudio;
    }

    public void setDireccionEstudio(String direccionEstudio) {
        this.direccionEstudio = direccionEstudio;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

}