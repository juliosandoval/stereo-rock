/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.adoo.Servlet;

import com.escom.adoo.Controlador.GestionaAlbum;
import com.escom.adoo.Controlador.GestionaBanda;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio
 */
public class AddAlbumServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddAlbumServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddAlbumServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        PrintWriter out = response.getWriter();

        String nombre = request.getParameter("nombrealbum").toUpperCase();
        String fecha = request.getParameter("fecha_lanzamiento").toUpperCase();
        int pistas = Integer.parseInt(request.getParameter("pistas"));
        String portada = request.getParameter("portada").toUpperCase();
        String contrPortada = request.getParameter("contraportada").toUpperCase();
        String nombreBanda = request.getParameter("banda").toUpperCase();
        String nombreEstudio = request.getParameter("estudio").toUpperCase();

        GestionaAlbum g = new GestionaAlbum();
        int a = g.addAlbum(nombre, fecha, pistas, portada, contrPortada, nombreBanda, nombreEstudio);
        if (a == 2) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Datos guardados :)');");
            out.println("location='registro_album.jsp';");
            out.println("</script>");

        } else if(a == 1){

            out.println("<script type=\"text/javascript\">");
            out.println("alert('Error al guardar, no existe una banda o estudio con ese nombre :(');");
            out.println("location='registro_album.jsp';");
            out.println("</script>");
        } else if(a == 0){

            out.println("<script type=\"text/javascript\">");
            out.println("alert('Error al guardar, contacte a sistemas :(');");
            out.println("location='registro_album.jsp';");
            out.println("</script>");
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
