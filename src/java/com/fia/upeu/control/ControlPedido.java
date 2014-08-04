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
import java.text.SimpleDateFormat;
import java.util.Date;

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

    InterPedido iPedido = new ModeloPedido();
    boolean estado = false;
    Date dat = new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy"); 

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
        //Para insetar la fecha de sistema
        
        //------------------------------------------------------
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String codigo = request.getParameter("codigo");
        String tramite = request.getParameter("tipotramite");
        String opc = request.getParameter("opc");
        String validacion = "null";
        String Ped = "PED081";

        String fechainicio =sdf.format(dat);
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Imprimir</title>");
            out.println("<link href='css/bootstrap.css' rel='stylesheet'/>");
            if (opc.equals("insertar")) {
                estado = iPedido.agregar_Pedido("PEI001", "null", tramite, validacion, codigo, Ped, fechainicio);
                if (estado) {
                    out.println("<script type='text/javascript'> alert('Exito');</script>");
                } else {
                    out.println("<script type='text/javascript'> alert('sin Exito');</script>");
                }
            }
            out.println("</head>");
            out.println("<body class='text-center' style='color:blue; font-size: 20px;'>");  
            out.println("Datos del Alumno: "+nombres+","+apellidos+" </br>");
           out.println("Alumno Codigo: "+codigo+"</br>"); 
           out.println("Tramite: "+tramite+"</br>");
           out.println(" <a href='vistas_secretaria/Validacion.jsp?codigo="+codigo+"' >Continuar</a>");
            
            out.println("</body>");
            out.println("</html>");

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
