/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fia.upeu.control;

import com.fia.upeu.dao.InterfacePlan_In;
import com.fia.upeu.dao_imple.ModeloPlan_In;
import com.fia.upeu.modelo.Plan_In;
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
 * @author Winston
 */
@WebServlet(name = "ControlPlan_In", urlPatterns = {"/ControlPlan_In"})
public class ControlPlan_In extends HttpServlet{
    InterfacePlan_In ip=new ModeloPlan_In();
    List<Plan_In> lpli;

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
        PrintWriter out = response.getWriter();
        String opc = request.getParameter("opc");
        out.println(opc);
        String read = "readonly=''";
        try {
            if (opc.equals("s")) {
                String id = request.getParameter("id");
                lpli = ip.list_Plan_In(id);
                for (int i = 0; i < lpli.size(); i++) {
                   // out.println("<tr><td>Nombres:<input type='text' name='nombres' value='"+lsoli.get(i).getNombre()+"' "+read+"/></td></tr>");
                    //out.println("<tr><td>Apellido Paterno:<input type='text' name='apellido_p' value='"+lsoli.get(i).getPaterno()+"' "+read+"/></td></tr>");
                   // out.println("<tr><td>Apellido Materno:<input type='text' name='apellido_m' value='"+lsoli.get(i).getMaterno()+"' "+read+"/></td></tr>");
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
