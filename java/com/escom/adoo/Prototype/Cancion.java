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
public class Cancion {
    
    private String nombre;
    private String compositor;
    private String fechaLanzamiento;
    private int duracion;
    private String observaciones;
    private String invitados;
    private String urlTablatura;
    private String traductor;
    private String emailTraductor;

    public Cancion(String nombre, String compositor, String fechaLanzamiento, int duracion, String observaciones, String invitados, String urlTablatura, String traductor, String emailTraductor) {
        this.nombre = nombre;
        this.compositor = compositor;
        this.fechaLanzamiento = fechaLanzamiento;
        this.duracion = duracion;
        this.observaciones = observaciones;
        this.invitados = invitados;
        this.urlTablatura = urlTablatura;
        this.traductor = traductor;
        this.emailTraductor = emailTraductor;
    }

    public Cancion() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getInvitados() {
        return invitados;
    }

    public void setInvitados(String invitados) {
        this.invitados = invitados;
    }

    public String getUrlTablatura() {
        return urlTablatura;
    }

    public void setUrlTablatura(String urlTablatura) {
        this.urlTablatura = urlTablatura;
    }

    public String getTraductor() {
        return traductor;
    }

    public void setTraductor(String traductor) {
        this.traductor = traductor;
    }

    public String getEmailTraductor() {
        return emailTraductor;
    }

    public void setEmailTraductor(String emailTraductor) {
        this.emailTraductor = emailTraductor;
    }
    
    
    
    
    
}
