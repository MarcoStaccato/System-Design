package com.marcostacato.controller;

import com.staccato.model.Alumno;
import com.staccato.model.AlumnoBD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marco
 */
@WebServlet(name = "Registrot", urlPatterns = {"/Registro"})
public class Registro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre =" ";
        String apePat =" ";
        String apeMat =" ";
        String edad   ="0";
        String genero =" ";
        String lic    =" ";
        String semestre=" ";
        
        nombre = request.getParameter("nombre");
        apePat = request.getParameter("apePat");
        apeMat = request.getParameter("apeMat");
        edad   = request.getParameter("edad");
        genero = request.getParameter("genero");
        lic    = request.getParameter("licenciatura");
        semestre = request.getParameter("semestre");
        
        if (edad.isEmpty()) {
            edad = "0";
        }
        
        Alumno al = new Alumno(nombre, apePat, apeMat, Integer.parseInt(edad), genero,
                                lic, semestre);
        AlumnoBD.agregarAluno(al);
        
        response.sendRedirect("consulta");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
