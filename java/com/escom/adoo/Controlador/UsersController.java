/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.adoo.Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julio
 */
public class UsersController {

    Statement set;
    PreparedStatement pr = null;
    ResultSet rs = null;
    Connection cn = null;

    public boolean addNewUser(String nombreUsuario, String password,String apellido, String nombre, String email, int privilegio) {
        boolean a = false;

        String sql = "INSERT INTO Usuario(nombreUsuario,password,nombre,apellido,email,DPrivilegios_idDPrivilegios) "
                + "VALUES(?,?,?,?,?,?)";
        try {
            cn = Conexion.getConexion();
            pr = cn.prepareStatement(sql);

            pr.setString(1, nombreUsuario);
            pr.setString(2, password);
            pr.setString(3, nombre);
            pr.setString(4, apellido);
            pr.setString(5, email);
            pr.setInt(6, privilegio);
            
            int l = pr.executeUpdate();
            a = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

        return a;
    }
    
    public boolean deleteUser(String nombreUsuario) {
        boolean a = false;

        String sql = "DELETE FROM Usuario WHERE nombreUsuario=?";
        try {
            cn = Conexion.getConexion();
            pr = cn.prepareStatement(sql);
            pr.setString(1, nombreUsuario);
            int l = pr.executeUpdate();
            a = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

        return a;
    }

}
