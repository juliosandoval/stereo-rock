/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.adoo.Controlador;

import com.escom.adoo.Prototype.Banda;
import com.escom.adoo.Prototype.Cancion;
import com.escom.adoo.Prototype.EstudioGrabacion;
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
public class GestionaBanda {
    
    
    Statement set;
    PreparedStatement pr = null;
    ResultSet rs = null;
    Connection cn = null;
    Cancion c;
    
    public boolean addBanda(String nombreBanda,
    int anioCreacion,
    String ciudadCreacion) {

        boolean a = false;
        int idCancion = 0;
        String sql = "INSERT INTO Banda(nombreBanda,anioCreacion,ciudadCreacion) "
                + "VALUES(?,?,?)";
        try {
            cn = Conexion.getConexion();
            pr = cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            pr.setString(1, nombreBanda);
            pr.setInt(2, anioCreacion);
            pr.setString(3, ciudadCreacion);
            
            int l = pr.executeUpdate();
            a = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

        return a;
    }
    
    public Banda consultaBanda(String nombreBanda) {

        Connection cn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        Banda e = null;
        try {
            cn = Conexion.getConexion();
            if (cn == null) {
                System.out.println("NO CONECTA");
            }

            String sql = "SELECT * FROM Banda WHERE nombreBanda=?";
            pr = cn.prepareStatement(sql);
            pr.setString(1, nombreBanda);
            
            rs = pr.executeQuery();
            if (rs.next()) {
                e = new Banda();
                e.setAnioCreacion(rs.getInt("anioCreacion"));
                e.setCiudadCreacion(rs.getString("ciudadCreacion"));
                e.setNombreBanda(rs.getString("nombreBanda"));

                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return e;
    }
    
    public boolean deleteBanda(String nombreBanda) {
        boolean a = false;

        String sql = "DELETE FROM Banda WHERE nombreBanda=?";
        try {
            cn = Conexion.getConexion();
            pr = cn.prepareStatement(sql);
            pr.setString(1, nombreBanda);
            int l = pr.executeUpdate();
            a = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

        return a;
    }
    
}
