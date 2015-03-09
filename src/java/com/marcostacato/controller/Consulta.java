package com.marcostacato.controller;

import com.staccato.model.Alumno;
import com.staccato.model.AlumnoBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Consulta", urlPatterns = {"/consulta"})
public class Consulta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Alumno> alumnos;

        String nombre = request.getParameter("nombre");
        String lic = request.getParameter("lic");
        String sem = request.getParameter("sem");
        
        System.out.println(nombre +" | "+lic +" | "+sem);

        if (nombre == null && lic == null && sem == null) {
            alumnos = AlumnoBD.getAlumnos();
        } else {
            if (nombre.isEmpty()) {
                nombre = null;
            }
            if (lic.isEmpty()) {
                lic = null;
            }
            if (sem.isEmpty() || sem.contains("#")) {
                sem = null;
            }
            
            alumnos = AlumnoBD.getLista(nombre, lic, sem);
        }

        String tabla = "<table>";
        String trs = "<tr>";
        trs += "<th>Nombre</th>";
        trs += "<th>Apellido Paterno</th>";
        trs += "<th>Apellido Materno</th>";
        trs += "<th>Edad</th>";
        trs += "<th>Genero</th>";
        trs += "<th>Licenciatura</th>";
        trs += "<th>Semestre</th>";
        trs += "</tr>";

        for (Alumno alumno : alumnos) {
            trs += "<tr>";
            trs += "<td>" + alumno.getNombre() + "</td>";
            trs += "<td>" + alumno.getApePat() + "</td>";
            trs += "<td>" + alumno.getApeMat() + "</td>";
            trs += "<td>" + alumno.getEdad() + "</td>";
            trs += "<td>" + alumno.getGenero() + "</td>";
            trs += "<td>" + alumno.getLicenciatura() + "</td>";
            trs += "<td>" + alumno.getSemestre() + "</td>";
            trs += "</tr>";
        }

        tabla = tabla + trs + "</table>";

        if (alumnos.isEmpty()) {
            tabla += "<p>lo sentimos, la busqueda no arrojó resultados<p>";
        }
        
        String input = "<form action='consulta'>";
        input += "nombre: <input type='text' name='nombre'/>";
        input += "licenciatura: <select name='lic'>";
        input += "<option></option><option>Civil</option><option>Computacion</option><option>Electronica</option><option>Mecanica</option></select>";
        input += "semestre: <input type='number' name='sem'/>";
        input += "<button onClick=''>buscar</button></form>";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Consulta</title>");
            out.println("</head>");
            out.println("<body>");
            out.println(input);
            out.println(tabla);
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
