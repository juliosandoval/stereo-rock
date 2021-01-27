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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julio
 */
public class BusquedaController {

    public List<ResultadoBusqueda> busquedas(String key, int tipo) {

        Connection cn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<ResultadoBusqueda> datos = new ArrayList<>();
        int itera = 1;
        try {
            cn = Conexion.getConexion();
            if (cn == null) {
                System.out.println("NO CONECTA");
            }
            
             String sql = "SELECT * FROM Usuario WHERE nombreUsuario=? AND password=?";

            switch (tipo) {
                case 0:
                    break;
                case 1:
                    sql = "SELECT * FROM Artista WHERE nombre LIKE \"%"+key+"%\"";
                    pr = cn.prepareStatement(sql);
                    rs = pr.executeQuery();
                    while(rs.next()) {
                        datos.add(new ResultadoBusqueda(itera++,rs.getString("nombre"),rs.getString("cdNac"),"Artista"));
                        
                    }
                   
                    break;
                case 2:
                    
                    
                    sql = "SELECT * FROM Album "
                            + "WHERE nombreAlbum LIKE \"%"+key+"%\"";
                    pr = cn.prepareStatement(sql);
                    rs = pr.executeQuery();
                    while(rs.next()) {
                        datos.add(new ResultadoBusqueda(itera++,rs.getString("nombreAlbum"),
                                rs.getString("Banda_nombreBanda"),"Album"));
                    }
                    
                    
                    break;
                case 3:
                    
                    sql = "SELECT * FROM Banda"
                            + " WHERE nombreBanda LIKE \"%"+key+"%\"";
                    pr = cn.prepareStatement(sql);
                    rs = pr.executeQuery();
                    while(rs.next()) {
                        datos.add(new ResultadoBusqueda(itera++,rs.getString("nombreBanda"),
                                rs.getString("ciudadCreacion"),"Banda"));
                    }
                    
                    break;
                case 4:
                    
                    sql = "SELECT * FROM Cancion"
                            + " WHERE nombre LIKE \"%"+key+"%\"";
                    pr = cn.prepareStatement(sql);
                    rs = pr.executeQuery();
                    while(rs.next()) {
                        datos.add(new ResultadoBusqueda(itera++,rs.getString("nombre"),
                                rs.getString("compositor"),"Cancion"));
                        
                       
                    }
                    break;
            }

            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());

        }
        
        return datos;

    }

}
