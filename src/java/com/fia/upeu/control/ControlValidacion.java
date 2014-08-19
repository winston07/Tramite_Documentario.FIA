/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.control;

import com.fia.upeu.dao.InterVal_Cur_Validado;
import com.fia.upeu.dao.InterValidacion;
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
@WebServlet(name = "ControlValidacion", urlPatterns = {"/ControlValidacion"})
public class ControlValidacion extends HttpServlet {

    InterValidacion inValidacion = new ModeloValidacion();
    InterVal_Cur_Validado inVal_Cur_Val = new ModeloVal_Cur_Val();
    boolean es;
    ResultSet rs;

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
        try {
            String opc = request.getParameter("opc");
            if (opc.equals("cabecera")) {
                String oldescuela = request.getParameter("escuela");
                String newEscuela = "ESC00001";
                //String idSoli = request.getParameter("codigo");
                //String pedido = request.getParameter("pedido");
                //String tramite = request.getParameter("tramite");
                String oldplan = request.getParameter("oldplan");
                String newplan = request.getParameter("newplan");
                String validacion = request.getParameter("validacion");
                String uni_in = request.getParameter("uni");
                String fac_in = request.getParameter("fac");
                //out.println(""+oldplan+"-"+newplan+"-"+newEscuela+"-"+oldescuela+"-"+validacion);
                es = inValidacion.modificar_Validacion(validacion, oldplan, newplan, oldescuela, newEscuela,uni_in,fac_in);

                if (es) {
                    out.println("<img src='../img/exito.png' alt='' />");

                } else {
                    out.println("<img src='../img/can.png' alt='' />");
                }

            }
            if (opc.equals("addcurso")) {
                String vali = request.getParameter("validacion");
                String cr = request.getParameter("cr");
                String ht = request.getParameter("ht");
                String hnp = request.getParameter("hnp");
                String th = request.getParameter("th");
                String nota = request.getParameter("nota");
                String ciclo = request.getParameter("ciclo");
                String curso = request.getParameter("curso");
                

                es = inVal_Cur_Val.agregar_Val_Cur_Valido(ciclo, curso, cr, ht, hnp, th, nota, vali);
                if (es) {
                    rs = inVal_Cur_Val.listar_Val_Cur(vali);
                    out.println("<table class='table-responsive'>");
                    out.println(" <tr>");
                    out.println("<table align=\"center\" width=\"800\" class=\"table-responsive\">");
                    out.println(" <tr>");
                    out.println("<th>Ciclo</th><th>Nombre Curso</th><th>CR</th><th>HT</th><th>HNP</th><th>TH</th><th>Nota</th><th width=\"40\">&nbsp;</th>");
                    out.println("</tr>");
                    while (rs.next()) {

                        out.println("<tr>");
                        out.println("<td><input type='text' readonly='true'  size='3'class='clsAnchoTotal form-control' value='" + rs.getString(10) + "'></td>");
                        out.println("<td><input type='text' readonly='true' size='20'class='clsAnchoTotal form-control' value='" + rs.getString(8) + "'></td>");
                        out.println("<td><input type='text' readonly='true' size='3'class='clsAnchoTotal form-control' value='" + rs.getString(4) + "'id='cr'></td>");
                        out.println("<td><input type='text' readonly='true' size='3'class='clsAnchoTotal form-control' value='" + rs.getString(5) + "' id='ht'></td>");
                        out.println("<td><input type='text' readonly='true' size='3'class='clsAnchoTotal form-control' value='" + rs.getString(6) + "'id='hnp'></td>");
                        out.println("<td><input type='text' readonly='true' size='3'class='clsAnchoTotal form-control' value='" + rs.getString(7) + "'id='th'></td>");
                        out.println("<td><input type='text' readonly='true' size='3'class='clsAnchoTotal form-control' value='" + rs.getString(9) + "'id='nota'></td>");
                        out.println("<td><a type=\"button\" class=\"fa fa-trash-o fa-2x\"></a></td>");
                        out.println("<td><a type=\"button\" class=\"fa fa-edit fa-2x\"></a></td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");

                } else {
                    out.println("Error");
                }
            }
            if (opc.equals("listar")) {
                String vali = request.getParameter("validacion");
                rs = inVal_Cur_Val.listar_Val_Cur(vali);

                if (rs!=null) {

                    out.println("<table class='table-responsive'>");
                    out.println(" <tr>");
                    out.println("<table align=\"center\" width=\"800\" class=\"table-responsive\">");
                    
                    for (int i =0;rs.next();i++) {

                        out.println("<tr>");
                        out.println("<td><input type='text' readonly='true'  size='3'class='clsAnchoTotal form-control' value='" + rs.getString(10) + "'></td>");
                        out.println("<td><input type='text' readonly='true' size='20'class='clsAnchoTotal form-control' value='" + rs.getString(8) + "'></td>");
                        out.println("<td><input type='text' readonly='true' size='3'class='clsAnchoTotal form-control' value='" + rs.getString(4) + "'id='cr'></td>");
                        out.println("<td><input type='text' readonly='true' size='3'class='clsAnchoTotal form-control' value='" + rs.getString(5) + "' id='ht'></td>");
                        out.println("<td><input type='text' readonly='true' size='3'class='clsAnchoTotal form-control' value='" + rs.getString(6) + "'id='hnp'></td>");
                        out.println("<td><input type='text' readonly='true' size='3'class='clsAnchoTotal form-control' value='" + rs.getString(7) + "'id='th'></td>");
                        out.println("<td><input type='text' readonly='true' size='3'class='clsAnchoTotal form-control' value='" + rs.getString(9) + "'id='nota'></td>");
                        out.println("<td><a type=\"button\" class=\"fa fa-trash-o fa-2x\"></a></td>");
                        out.println("<td><a type=\"button\" class=\"fa fa-edit fa-2x\"></a></td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");

                } else {
                    out.println("Error");
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
            Logger.getLogger(ControlValidacion.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControlValidacion.class.getName()).log(Level.SEVERE, null, ex);
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
