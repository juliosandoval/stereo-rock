/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.adoo.Controlador;

import com.escom.adoo.Prototype.SearchUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julio
 */
public class SearchUserController {
    
    private Connection cn = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;

    public List<SearchUser> getUsers() {
        cn = Conexion.getConexion();
        List<SearchUser> datos = new ArrayList<>();
        SearchUser se;
        try {
            String sql = "SELECT nombreUsuario,nombre,apellido,desPrivilegio FROM Usuario"
                    + " INNER JOIN DPrivilegios ON "
                    + "Usuario.DPrivilegios_idDPrivilegios=DPrivilegios.idDPrivilegios";
            pr = cn.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                se = new SearchUser();
                se.setUsername(rs.getString("nombreUsuario"));
                se.setName(rs.getString("nombre")+" "+rs.getString("apellido"));
                se.setRol(rs.getString("desPrivilegio"));
                datos.add(se);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

}
