package com.escom.adoo.Controlador;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @autor Archivo: Usuario.java Creado: 6/5/2009 02:35:26 PM
 */
public class Usuario {

    private String usuario_Nombre;
    private String usuario_User;
    private String usuario_Clave;
    private String usuario_Correo;
    private int privilegio = 0;

    /**
     * Crea un nueva instancia de la clase usuario con magia de sirenas
     */
    public Usuario() {

    }

    /**
     * Metodo usado para verificar si un usuario esta registrado en la Base de
     * Datos con su User y Clave de forma correcta
     *
     * @param user Que viene a ser el user del Usuario
     * @param clave Que viene a ser la clave del Usuario
     */
    public void verificarUsuario(String user, String clave) {

        Connection cn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            cn = Conexion.getConexion();
            if (cn == null) {
                System.out.println("NO CONECTA");
            }

            String sql = "SELECT * FROM Usuario WHERE nombreUsuario=? AND password=?";
            pr = cn.prepareStatement(sql);
            pr.setString(1, user);
            pr.setString(2, clave);
            rs = pr.executeQuery();
            if (rs.next()) {

                usuario_Nombre = rs.getString("nombre");
                usuario_Correo = rs.getString("email");
                usuario_User = rs.getString("nombreUsuario");
                usuario_Clave = rs.getString("password");
                privilegio = rs.getInt("DPrivilegios_idDPrivilegios");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

    public String getUsuario_Nombre() {
        return usuario_Nombre;
    }

    public String getUsuario_User() {
        return usuario_User;
    }

    public String getUsuario_Clave() {
        return usuario_Clave;
    }

    public int getPrivilegio() {
        return privilegio;
    }

    public String getUsuario_Correo() {
        return usuario_Correo;
    }

}
