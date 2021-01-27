/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.adoo.Controlador;

import com.escom.adoo.Prototype.EstudioGrabacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julio
 */
public class GestionaEstudioGrabacion {

    Connection cn = null;
    PreparedStatement pr = null;
    ResultSet rs = null;
    EstudioGrabacion e = null;

    public EstudioGrabacion consultaEstudioGrabacion(String nombreEstudio) {

        try {
            cn = Conexion.getConexion();
            if (cn == null) {
                System.out.println("NO CONECTA");
            }

            String sql = "SELECT * FROM EstudioGrabacion WHERE nombreEstudio=?";
            pr = cn.prepareStatement(sql);
            pr.setString(1, nombreEstudio);

            rs = pr.executeQuery();
            if (rs.next()) {
                e = new EstudioGrabacion();
                e.setNombreEstudio(rs.getString("nombreEstudio"));
                e.setNumeroTelefono(rs.getString("numeroTelefono"));
                e.setDireccionEstudio(rs.getString("direccionEstudio"));
                e.setSitioWeb(rs.getString("sitioWeb"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return e;
    }

    public boolean addEstudioGrabacion(String nombreEstudio,
            String direccionEstudio,
            String numeroTelefono,
            String sitioWeb) {

        boolean a = false;
        int idCancion = 0;
        String sql = "INSERT INTO EstudioGrabacion(nombreEstudio,"
                + "direccionEstudio,numeroTelefono,sitioWeb) "
                + "VALUES(?,?,?,?)";
        try {
            cn = Conexion.getConexion();
            pr = cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            pr.setString(1, nombreEstudio);
            pr.setString(2, direccionEstudio);
            pr.setString(3, numeroTelefono);
            pr.setString(4, sitioWeb);

            int l = pr.executeUpdate();
            a = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

        return a;
    }
    
    public boolean deleteEstudio(String nombreEstudio) {
        boolean a = false;

        String sql = "DELETE FROM Album WHERE nombreEstudio=?";
        try {
            cn = Conexion.getConexion();
            pr = cn.prepareStatement(sql);
            pr.setString(1, nombreEstudio);
            int l = pr.executeUpdate();
            a = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

        return a;
    }
}
