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
public class GestionaArtista {
    
    Statement set;
    PreparedStatement pr = null;
    ResultSet rs = null;
    Connection cn = null;
    
    
    
    public boolean addArtista(String nombreArtista,
    String fechaNacimiento,
    String ciudadNacimiento,
    String genero,
    String sitioWeb,
    String biografia) {

        boolean a = false;
        int idCancion = 0;
        String sql = "INSERT INTO Artista(nombre,Nacimiento,cdNac,Genero,sitioWeb,bio) "
                + "VALUES(?,?,?,?,?,?)";
        try {
            cn = Conexion.getConexion();
            pr = cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            pr.setString(1, nombreArtista);
            pr.setString(2, fechaNacimiento);
            pr.setString(3, ciudadNacimiento);
            pr.setString(4, genero);
            pr.setString(5, sitioWeb);
            pr.setString(6, biografia);
            
            int l = pr.executeUpdate();
            a = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

        return a;
    }
    
    public boolean deleteArtista(String nombre) {
        boolean a = false;

        String sql = "DELETE FROM Artista WHERE nombre=?";
        try {
            cn = Conexion.getConexion();
            pr = cn.prepareStatement(sql);
            pr.setString(1, nombre);
            int l = pr.executeUpdate();
            a = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

        return a;
    }
    
    
}
