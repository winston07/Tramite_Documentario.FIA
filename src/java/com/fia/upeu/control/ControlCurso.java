/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.control;

import com.fia.upeu.dao.InterCurso_in;
import com.fia.upeu.dao_imple.ModeloCurso_in;
import com.fia.upeu.modelo.Curso_in;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kelvin Thony
 */
@WebServlet(name = "ControlCurso", urlPatterns = {"/ControlCurso"})
public class ControlCurso extends HttpServlet {

    InterCurso_in iCurso_in = new ModeloCurso_in();
    boolean estado = false;
    List<Curso_in> lCur_in;

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
        response.setContentType("text/html");
        try {

        } finally {
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
        PrintWriter out = response.getWriter();
        String opc = request.getParameter("opc");
        if (opc.equals("ajax")) {

            String id = request.getParameter("id");
            String curso = request.getParameter("curso");
            String cr = request.getParameter("cr");
            String ht = request.getParameter("ht");
            String hnp = request.getParameter("hnp");
            String th = request.getParameter("th");
            String nota = request.getParameter("nota");
            estado = iCurso_in.agregar_Curso(id, curso, cr, ht, hnp, th, nota);
            if (estado) {
                lCur_in = iCurso_in.listar_Curso();
                out.println("<table class='table-responsive'>");
                out.println(" <tr>");
                out.println("<th class='form-control'>Ciclo</th><th>Nombre Curso</th><th>CR</th><th>HT</th><th>HNP</th><th>TH</th><th>Nota</th><th width='40'>&nbsp;</th>");
                out.println("</tr>");
                for (int i = 0; i < lCur_in.size(); i++) {

                    out.println("<tr>");
                    out.println("<td><input type='text'  size='3'class='form-control' value='"+ lCur_in.get(i).getIdCurso() +"'id='id'></td>");
                    out.println("<td><input type='text'  size='3'class='form-control' value='"+ lCur_in.get(i).getCurNombre() +"'id='curso'></td>");
                    out.println("<td><input type='text'  size='3'class='form-control' value='"+ lCur_in.get(i).getCur_Cr() +"'id='cr></td>");
                    out.println("<td><input type='text'  size='3'class='form-control' value='"+ lCur_in.get(i).getCur_Ht() +"' id='ht'></td>");
                    out.println("<td><input type='text'  size='3'class='form-control' value='"+ lCur_in.get(i).getCur_Hnp() +"'id='hnp'></td>");
                    out.println("<td><input type='text'  size='3'class='form-control' value='"+ lCur_in.get(i).getCur_Th() +"'id='th'></td>");
                    out.println("<td><input type='text'  size='3'class='form-control' value='"+ lCur_in.get(i).getCur_Nota() +"'id='nota'></td>");
                    out.println("</tr>");
                }
                out.println("</table>");

            } else {
                out.println("no insertado" + id + curso + cr + ht + hnp + th + nota);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
