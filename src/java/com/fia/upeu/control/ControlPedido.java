/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fia.upeu.control;

import com.fia.upeu.dao.InterPedido;
import com.fia.upeu.dao_imple.ModeloPedido;
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

    ResultSet upr;
    ResultSet rs;
    InterPedido iPedido = new ModeloPedido();
    boolean estado = false;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
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

        try {
            if (opc.equals("Guardar")) {
                Date dat = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fechanow = sdf.format(dat);
                String Periodo = iPedido.periodo();
                String escuela = "ESC00001";
                String usuario = "USU00001";

                String codigo = request.getParameter("codigo");
                String tramite = request.getParameter("tipotramite");
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Imprimir</title>");
                out.println("<link href='css/bootstrap.css' rel='stylesheet'/>");

                estado = iPedido.agregar_Pedido(Periodo,escuela,tramite,codigo, fechanow,usuario );

                //estado = iPedido.agregar_Pedido(Periodo, escuela, tramite, codigo, fechanow, usuario, "Ingresando Cursos");
                //upr = iPedido.ultimo_pedido();
                //upr.next();
                // String ped = upr.getString("ULTIMOPEDIDO");

                // rs = iPedido.listar_To_Print(codigo, ped, tramite);
                //out.println(codigo + tramite + Periodo + codigo + fechanow + Periodo);

                if (estado) {
                    out.println("Exito");
                } else {
                    out.println("No Inserto");
                }
                // out.println(codigo + ped + tramite + Periodo + codigo );
                boolean bi = false;
                rs.next();
                out.println("</head>");
                out.println("<body class='text-center' style='color:blue; font-size: 20px;'>");
                out.println("Datos del Alumno: " + rs.getString(1) + "," + rs.getString(2) + "," + " " + rs.getString(3) + "</br>");
                out.println("Alumno Codigo: " + rs.getString(4) + "</br>");
                out.println("Tramite: " + rs.getString(5) + "</br>");
                out.println(" <a href='vistas_secretaria/Validacion.jsp?codigo=" + codigo + "&pedido=" + rs.getString(6) + "&tramite=" + rs.getString(7) + "&validacion=" + rs.getString(9) + "' >Continuar</a>");

                out.println("</body>");
                out.println("</html>");
            }
            if (opc.equals("sync")) {
                String id = request.getParameter("id");
                rs = iPedido.listar_To_Evaluar(id);
                while (rs.next()) {
                    out.println("<tr class='btn-info'>");
                    out.println("<td>" + rs.getString(6) + "</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + ", " + rs.getString(3) + "</td><td>" + rs.getString(9) + "</td><td>"
                            + "<a href='../vistas_secretaria/Validacion.jsp' class=\"fa fa-edit fa-2x\" style=\"color: white;\"></a></td>");
                    out.println("<td><a href='../vistas_secretaria/Validacion.jsp?idP="+rs.getString(6)+"&idT="+rs.getString(7)+"&idS="+rs.getString(8)+"&nom="+rs.getString(1)+"&ape="+rs.getString(2)+"&idV="+rs.getString(10)+"' type=\"button\" class=\"fa fa-check-square-o fa-2x\"></a></td>");
                    out.println("</tr> ");
                }

            }
            if (opc.equals("synconvalidacion")) {
                String id = request.getParameter("id");
                rs = iPedido.listar_To_Evaluar(id);
                while (rs.next()) {
                    out.println("<tr class='btn-info'>");
                    out.println("<td>" + rs.getString(6) + "</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + ", " + rs.getString(3) + "</td><td>" + rs.getString(9) + "</td><td>"
                            + "<a href='../vistas_secretaria/Validacion.jsp' class=\"fa fa-edit fa-2x\" style=\"color: white;\"></a></td>");
                    out.println("<td><a href='../vistas_secretaria/ValidarConvalidacion.jsp?idP="+rs.getString(6)+"&idT="+rs.getString(7)+"&idS="+rs.getString(8)+"&nom="+rs.getString(1)+"&ape="+rs.getString(2)+"&idV="+rs.getString(10)+"' type=\"button\" class=\"fa fa-check-square-o fa-2x\"></a></td>");
                    out.println("</tr> ");
                }
            }

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
