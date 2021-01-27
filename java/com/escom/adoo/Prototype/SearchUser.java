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
public class SearchUser {
    
    private String username;
    private String name;
    private String rol;

    public SearchUser(String username, String name, String rol) {
        this.username = username;
        this.name = name;
        this.rol = rol;
    }

    public SearchUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    

       
}
