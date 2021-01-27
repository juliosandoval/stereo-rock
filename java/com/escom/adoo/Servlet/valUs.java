/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.adoo.Servlet;


import com.escom.adoo.Controlador.Conexion;
import com.escom.adoo.Controlador.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alumnos
 */
public class valUs extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Connection con; //
    private Statement set;
    private ResultSet rs;

    public void init(ServletConfig cfg) throws ServletException {

        try {
            con = Conexion.getConexion();

            System.out.println("Se ha conectado");
        } catch (Exception e) {
            System.out.println("No se ha conectado");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String usuario = request.getParameter("username");
        String pass = request.getParameter("password");
        

        Usuario u = new Usuario();
        System.out.println("qwertyuiop");
        u.verificarUsuario(usuario, pass);

        switch (u.getPrivilegio()) {
            case 1: {
                //El usuario existe en la base de datos y clave correcta
                //Creamos la sesion
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("usuario", u);
                HttpSession sesionOk = request.getSession();
                String iddesesion = sesionOk.getId();
                System.out.println("usuario:    " + usuario + "        id de sesión: " + iddesesion);
                sesionOk.setAttribute("usuario", usuario);
                sesionOk.setAttribute("privilegio", u.getPrivilegio());
                sesionOk.setAttribute("user", u);
                response.sendRedirect("adminpanel.jsp");
                break;
            }
            case 2: {
                //El usuario existe en la base de datos y clave correcta
                //Creamos la sesion
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("usuario", u);
                HttpSession sesionOk = request.getSession();
                String iddesesion = sesionOk.getId();
                System.out.println("usuario:    " + usuario + "        id de sesión: " + iddesesion);
                sesionOk.setAttribute("usuario", usuario);
                sesionOk.setAttribute("privilegio", u.getPrivilegio());
                sesionOk.setAttribute("user", u);
                response.sendRedirect("results.jsp");
                break;
            }
            default:
                //El usuario no existe o clave incorrecta
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Datos incorrectos, intente de nuevo');");
                out.println("location='index.jsp';");
                out.println("</script>");
                break;
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
