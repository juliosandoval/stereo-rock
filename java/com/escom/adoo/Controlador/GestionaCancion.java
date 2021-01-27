/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.adoo.Controlador;

import com.escom.adoo.Prototype.Cancion;
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
public class GestionaCancion {

    Statement set;
    PreparedStatement pr = null;
    ResultSet rs = null;
    Connection cn = null;
    Cancion c;

    public boolean addCancion(String nombre,
            String compositor,
            String fechaLanzamiento,
            int duracion,
            String observaciones,
            String invitados,
            String urlTablatura,
            String fechaTablatura,
            String traductor,
            String emailTraductor) {

        boolean a = false;
        int idCancion = 0;
        String sql = "INSERT INTO Cancion(nombre,compositor,fechaLanzamiento,"
                + "duracion,observaciones) "
                + "VALUES(?,?,?,?,?)";
        try {
            cn = Conexion.getConexion();
            pr = cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            pr.setString(1, nombre);
            pr.setString(2, compositor);
            pr.setString(3, fechaLanzamiento);
            pr.setInt(4, duracion);
            pr.setString(5, observaciones);
            int l = pr.executeUpdate();

            rs = pr.getGeneratedKeys();
            if (rs.next()) {
                idCancion = rs.getInt(1);
            }

            if (idCancion > 0) {
                sql = "INSERT INTO Tablatura(url,fecha,traductor,emailTraductor,"
                        + "Cancion_idCancion) "
                        + "VALUES(?,?,?,?,?)";
                pr = cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

                pr.setString(1, urlTablatura);
                pr.setString(2, fechaTablatura);
                pr.setString(3, traductor);
                pr.setString(4, emailTraductor);
                pr.setInt(5, idCancion);
                l = pr.executeUpdate();

                a = true;
            } else {
                a = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

        return a;
    }
    
    public boolean deleteCancion(String nombreCancion) {
        boolean a = false;

        String sql = "DELETE FROM Album WHERE nombre=?";
        try {
            cn = Conexion.getConexion();
            pr = cn.prepareStatement(sql);
            pr.setString(1, nombreCancion);
            int l = pr.executeUpdate();
            a = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

        return a;
    }

}
