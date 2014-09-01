/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.control;

import com.fia.upeu.dao.InterPedido;
import com.fia.upeu.dao.InterVal_Cur_Validado;
import com.fia.upeu.dao_imple.ModeloPedido;
import com.fia.upeu.dao_imple.ModeloVal_Cur_Val;
import com.fia.upeu.dao_imple.ModeloValidacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kelvin Thony
 */
@WebServlet(name = "ControlValidacionD", urlPatterns = {"/ControlValidacionD"})
public class ControlValidacionD extends HttpServlet {

    ResultSet upr;
    ResultSet rs;
    InterPedido iPedido = new ModeloPedido();
    boolean estado = false;
    InterVal_Cur_Validado iVCV = new ModeloVal_Cur_Val();

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String opc = request.getParameter("opc");
        try {
            if (opc.equals("sync")) {
                String id = request.getParameter("id");
                String est = request.getParameter("estado");
                rs = iPedido.listar_To_Evaluar(id, est);
                while (rs.next()) {
                    out.println("<tr class='btn-info'>");
                    out.println("<td>" + rs.getString(6) + "</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + ", " + rs.getString(3) + "</td><td>" + rs.getString(9) + "</td><td>" + rs.getString(11) + "</td>"
                            + "<td><a class=\"fa fa-edit fa-2x\" onclick=\"alert('" + rs.getString(6) + rs.getString(1) + "')\" href='#' style=\"color: white;\"></a></td>");
                    out.println("<td><a class=\"fa fa-trash-o fa-2x\" style=\"color: white;\" onclick=\"toogle3('block', 'modal', 'ventana');elimanarValidacion('" + rs.getString(6) + "', '" + rs.getString(4) + "', '" + rs.getString(1) + "', '" + rs.getString(2) + "');\" ></a></td>");
                    out.println("<td><a href='../vistas_secretaria/Validacion.jsp?idP=" + rs.getString(6) + "&idT=" + rs.getString(7) + "&idS=" + rs.getString(8) + "&nom=" + rs.getString(1) + "&ape=" + rs.getString(2) + "&idV=" + rs.getString(10) + "'  class=\"fa fa-check-square-o fa-2x\" style=\"color: white;\"></a></td>");

                    out.println("</tr> ");
                }

            }
            if(opc.equals("guardarCursos")){
                String idValidacion = request.getParameter("idvalidacion");
                String ciclo = request.getParameter("ciclo");
                String curso = request.getParameter("curso");
                String cr = request.getParameter("cr");
                String ht = request.getParameter("ht");
                String hnp = request.getParameter("hnp");
                String th = request.getParameter("th");
                String nota = request.getParameter("nota");
                 estado= iVCV.agregar_Val_Cur_Valido(ciclo, curso, cr, ht, hnp, th, nota, idValidacion);
                 if(estado){
                     
                 }else{
                     
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControlValidacionD.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControlValidacionD.class.getName()).log(Level.SEVERE, null, ex);
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
