/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.adoo.Controlador;

import com.escom.adoo.Prototype.Banda;
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
public class GestionaAlbum {

    Statement set;
    PreparedStatement pr = null;
    ResultSet rs = null;
    Connection cn = null;
    EstudioGrabacion e;
    Banda b;

    public int addAlbum(String nombreAlbum,
            String fecha,
            int pistas,
            String portada,
            String contrPortada,
            String nombreBanda,
            String nombreEstudio) {

        int a = 0;
        int idCancion = 0;
        String sql = "INSERT INTO Album(nombreAlbum,fecha,pistas,portada,"
                + "contrPortada,Banda_nombreBanda,EstudioGrabacion_nombreEstudio) "
                + "VALUES(?,?,?,?,?,?,?)";
        try {

            GestionaBanda g = new GestionaBanda();
            GestionaEstudioGrabacion gA = new GestionaEstudioGrabacion();
            e = gA.consultaEstudioGrabacion(nombreEstudio);
            b = g.consultaBanda(nombreBanda);

            if (e != null && b != null) {
                cn = Conexion.getConexion();
                pr = cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

                pr.setString(1, nombreAlbum);
                pr.setString(2, fecha);
                pr.setInt(3, pistas);
                pr.setString(4, portada);
                pr.setString(5, contrPortada);
                pr.setString(6, nombreBanda);
                pr.setString(7, nombreEstudio);

                int l = pr.executeUpdate();
                a = 2;
            } else {
                a = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

        return a;
    }
    

    
    
    public boolean deleteAlbum(String nombreAlbum) {
        boolean a = false;

        String sql = "DELETE FROM Album WHERE nombreAlbum=?";
        try {
            cn = Conexion.getConexion();
            pr = cn.prepareStatement(sql);
            pr.setString(1, nombreAlbum);
            int l = pr.executeUpdate();
            a = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

        return a;
    }

}
