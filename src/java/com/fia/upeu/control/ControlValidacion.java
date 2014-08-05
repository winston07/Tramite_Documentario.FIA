/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.control;

import com.fia.upeu.dao.InterValidacion;
import com.fia.upeu.dao_imple.ModeloValidacion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kelvin Thony
 */
@WebServlet(name = "ControlValidacion", urlPatterns = {"/ControlValidacion"})
public class ControlValidacion extends HttpServlet {
    InterValidacion inValidacion = new ModeloValidacion();
    boolean es;
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
        PrintWriter out = response.getWriter();
        try {
            String opc = request.getParameter("opc");
            if (opc.equals("cabecera")) {
                String oldescuela = request.getParameter("escuela");
                String newEscuela="Sistemas";
                String idSoli = request.getParameter("codigo");
                String pedido = request.getParameter("pedido");
                String tramite = request.getParameter("tramite");
                String oldplan = request.getParameter("oldplan");
                String newplan = request.getParameter("newplan");
                String validacion = request.getParameter("validacion");
                out.println(idSoli+"-"+pedido+"-"+tramite+"-"+oldplan+"-"+newplan+"-"+newEscuela+"-"+oldescuela+"-"+validacion);
                es=inValidacion.modificar_Validacion(validacion, "5" , oldplan, newplan, oldescuela, newEscuela, "1");
                if(es){
                    out.println("insertado");
                }else{
                    out.println("no");
                }
                

            }

        } finally {
            out.close();
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
