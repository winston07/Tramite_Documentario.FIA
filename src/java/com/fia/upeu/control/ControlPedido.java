/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.control;

import com.fia.upeu.dao.InterPedido;
import com.fia.upeu.dao.InterValidacion;
import com.fia.upeu.dao_imple.ModeloPedido;
import com.fia.upeu.dao_imple.ModeloValidacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "ControlPedido", urlPatterns = {"/ControlPedido"})
public class ControlPedido extends HttpServlet {

    ResultSet rs;
    InterPedido iPedido = new ModeloPedido();
    boolean estado = false;
    Date dat = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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
        //Para insetar la fecha de sistema
        PrintWriter out = response.getWriter();
        //------------------------------------------------------
        response.setContentType("text/html;charset=UTF-8");
        String opc = request.getParameter("opc");

        String fechainicio = sdf.format(dat);
        try {
            if (opc.equals("insertar")) {
                String codigo = request.getParameter("codigo");
                String tramite = request.getParameter("tipotramite");
                String validacion = "null";
                String ped = "PED081";
                InterPedido iped = new ModeloPedido();
                InterValidacion iVal = new ModeloValidacion();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Imprimir</title>");
                out.println("<link href='css/bootstrap.css' rel='stylesheet'/>");

                estado = iPedido.agregar_Pedido("PEI001", "1", tramite, validacion, codigo, ped, fechainicio);
                rs = iped.listar_To_Print(codigo, ped, tramite);
                
                if (estado) {
                    out.println("<script type='text/javascript'> alert('Exito');</script>");
                } else {
                    out.println("<script type='text/javascript'> alert('sin Exito');</script>");
                }
                boolean bi = false;
                rs.next();
                bi = iVal.agregar_Validacion(rs.getString(9), "", "", "", "", "");
                out.println("</head>");
                out.println("<body class='text-center' style='color:blue; font-size: 20px;'>");
                

                out.println("Datos del Alumno: " + rs.getString(1) + "," + rs.getString(2) + "," + " " + rs.getString(3) + "</br>");
                out.println("Alumno Codigo: " + rs.getString(4) + "</br>");
                out.println("Tramite: " + rs.getString(5) + "</br>");
                out.println(" <a href='vistas_secretaria/Validacion.jsp?codigo=" + codigo + "&pedido=" + rs.getString(6) + "&tramite=" + rs.getString(7) + "&validacion="+rs.getString(9)+"' >Continuar</a>");

                out.println("</body>");
                out.println("</html>");
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
            Logger.getLogger(ControlPedido.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControlPedido.class.getName()).log(Level.SEVERE, null, ex);
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
