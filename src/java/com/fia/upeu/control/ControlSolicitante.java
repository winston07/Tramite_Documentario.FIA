/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.control;

import com.fia.upeu.dao.InterSolicitante;
import com.fia.upeu.dao_imple.ModeloSolicitante;
import com.fia.upeu.modelo.Solicitante;
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
@WebServlet(name = "ControlSolicitante", urlPatterns = {"/ControlSolicitante"})
public class ControlSolicitante extends HttpServlet {

    InterSolicitante is = new ModeloSolicitante();
    List<Solicitante> lsoli;

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
        out.println(opc);
        String read = "readonly=''";
        try {
            if (opc.equals("s")) {
                String id = request.getParameter("id");
                lsoli = is.listar_Id_Solicitante(id);
                for (int i = 0; i < lsoli.size(); i++) {
                    out.println("<tr><td>Nombres: &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<input type='text' name='nombres' value='"+lsoli.get(i).getNombre()+"' "+read+"/></td></tr>");
                    out.println("<tr><td>Apellido Paterno:&nbsp &nbsp &nbsp &nbsp&nbsp<input type='text' name='apellido_p' value='"+lsoli.get(i).getPaterno()+"' "+read+"/></td></tr>");
                    out.println("<tr><td>Apellido Materno:&nbsp &nbsp &nbsp &nbsp<input type='text' name='apellido_m' value='"+lsoli.get(i).getMaterno()+"' "+read+"/></td></tr>");
                }
            }
            

        } finally {
            out.close();
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
