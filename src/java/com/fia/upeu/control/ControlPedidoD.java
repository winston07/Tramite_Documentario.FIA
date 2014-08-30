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
@WebServlet(name = "ControlPedidoD", urlPatterns = {"/ControlPedidoD"})
public class ControlPedidoD extends HttpServlet {

    ResultSet upr;
    ResultSet rs;
    InterPedido iPedido = new ModeloPedido();
    InterValidacion iV = new ModeloValidacion();
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
            if (opc.equals("eliminarvalidacion")) {
                String idpedido = request.getParameter("idpedido");
                String idvali = request.getParameter("idvali");
                estado = iPedido.eliminarcascada(idpedido, idvali);
                if (estado) {
                    out.println("eliminado");
                } else {
                    out.println("no eliminado");
                }
            }
            if (opc.equals("verpro")) {

                String idpedido = request.getParameter("idpedido");
                String idvali = request.getParameter("idvali");
                out.println("Seguro que desea eliminar este archivo" + idpedido + "<button href=\"#close\" title=\"Cerrar\" onclick=\"elimanarValidacion1('" + idpedido + "', '" + idvali + "');toogle3('none', 'modal', 'ventana');\" >Close</button>");

            }
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

                estado = iPedido.agregar_Pedido(Periodo, escuela, tramite, codigo, fechanow, usuario);

                //estado = iPedido.agregar_Pedido(Periodo, escuela, tramite, codigo, fechanow, usuario, "Ingresando Cursos");
                //upr = iPedido.ultimo_pedido();
                //upr.next();
                // String ped = upr.getString("ULTIMOPEDIDO");
                // rs = iPedido.listar_To_Print(codigo, ped, tramite);
                //out.println(codigo + tramite + Periodo + codigo + fechanow + Periodo);
                if (estado) {
                    out.println("Exito");
                } else {
                    out.println("No Inserto" + codigo + Periodo + fechanow);
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
                String est = request.getParameter("estado");
                rs = iPedido.listar_To_Evaluar(id, est);
                while (rs.next()) {
                    out.println("alert('aqui''" + id + "''" + est + "')");
                    out.println("<tr class='btn-info'>");
                    out.println("<td>" + rs.getString(6) + "</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(1) + ", " + rs.getString(2) + " " + rs.getString(3) + "</td><td>" + rs.getString(16) + "</td><td>" + rs.getString(17) + "</td><td>" + rs.getString(11) + "</td><td>" + rs.getString(15) + "</td>"
                            + "<td><a class=\"fa fa-edit fa-2x\" onclick=\"alert('" + rs.getString(6) + rs.getString(1) + "')\" href='#' style=\"color: white;\"></a></td>");
                    out.println("<td><a class=\"fa fa-trash-o fa-2x\" href='#' style=\"color: white;\" onclick=\"toogle3('block', 'modal', 'ventana');elimanarValidacion1('" + rs.getString(6) + "', '" + rs.getString(4) + "', '" + rs.getString(1) + "', '" + rs.getString(2) + "');\" ></a></td>");
                    out.println("<td><a href='../vistas_secretaria/Validacion.jsp?idP=" + rs.getString(6) + "&idT=" + rs.getString(7) + "&idS=" + rs.getString(8) + "&nom=" + rs.getString(1) + "&ape=" + rs.getString(2) + "&idV=" + rs.getString(10) + "'  class=\"fa fa-check-square-o fa-2x\" style=\"color: white;\"></a></td>");

                    out.println("</tr> ");
                }

            }
            if (opc.equals("synconvalidacion")) {
                String id = request.getParameter("id");
                String est = request.getParameter("estado");
                rs = iPedido.listar_To_Evaluar(id, est);
                while (rs.next()) {
                    out.println("<tr class='btn-info'>");
                    out.println("<td>" + rs.getString(6) + "</td><td>" + rs.getString(12) + "</td><td>" + rs.getString(13) + "</td><td>" + rs.getString(14) + ",</td><td> " + rs.getString(15) + "</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(1) + ", " + rs.getString(2) + " " + rs.getString(3) + "</td><td>" + rs.getString(16) + "</td><td>" + rs.getString(17) + "</td>"
                            + "<td><a class=\"fa fa-edit fa-2x\" onclick=\"alert('" + rs.getString(6) + rs.getString(1) + "')\" href='#' style=\"color: white;\"></a></td>");
                    out.println("<td><a class=\"fa fa-trash-o fa-2x\" href='#' style=\"color: white;\" onclick=\"toogle3('block', 'modal', 'ventana');elimanarValidacion1('" + rs.getString(6) + "', '" + rs.getString(4) + "', '" + rs.getString(1) + "', '" + rs.getString(2) + "');\" ></a></td>");
                    out.println("<td><a   class=\"fa fa-check-square-o fa-2x\" href='#' style=\"color: white;\" onclick=\"tooglevalidar('block', 'modal1', 'ventana1','" + rs.getString(10) + "','" + rs.getString(6) + "');\" ></a></td>");

                    out.println("</tr> ");
                }
            }
            if (opc.equals("validar")) {
                String idvali = request.getParameter("idvali");
                String idPed = request.getParameter("idPed");

                //out.println("olas" + idvali + idPed);
                rs = iV.listarValidacion(idvali);
                ResultSet plan = iV.listarValidacion(idvali);
                ResultSet val = iV.listarValidacion(idvali);
                plan.next();
                String planold = plan.getString(1);
                String plannew = plan.getString(2);
                if (rs != null) {
                    out.println("<div class=\"col-md-6\">");
                    out.println(" <div class=\"table-responsive\">");
                    out.println("<h1 class=\"text-center text-success\">Plan " + planold + "</h1>");
                    out.println("<table class=\"table\">");
                    out.println("<tr>\n"
                            + "   <th>CICLO</th>\n"
                            + "   <th>CURSO</th>\n"
                            + "   <th>CR</th>\n"
                            + "   <th>HT</th>\n"
                            + "   <th>HNP</th>\n"
                            + "   <th>TH</th>\n"
                            + "   <th>NOTA</th>\n"
                            + "  </tr>");
                    while (rs.next()) {
                        out.println(""
                                + "<tr>\n"
                                + " <td><label class=\"control-label\">" + rs.getString(6) + "</label></td>\n"
                                + " <td><label class=\"control-label\">" + rs.getString(7) + "</label></td>\n"
                                + " <td><label class=\"control-label\">" + rs.getString(8) + "</label></td>\n"
                                + " <td><label class=\"control-label\">" + rs.getString(9) + "</label></td>\n"
                                + " <td><label class=\"control-label\">" + rs.getString(10) + "</label></td>\n"
                                + " <td><label class=\"control-label\">" + rs.getString(11) + "</label></td>\n"
                                + " <td><label class=\"control-label\">" + rs.getString(12) + "</label></td>\n"
                                + " <td>\n"
                                + " </td>\n"
                                + " </tr> ");
                    }
                    out.println("</table>");
                    out.println(" </div>");
                    out.println(" </div>");
                    out.println(" <div class=\"col-md-6\">\n"
                            + "                        <form>\n"
                            + "                            <div class=\"table-responsive\">\n"
                            + "                                <h1 class=\"text-center text-success\">Plan " + plannew + "</h1>\n"
                            + "                                <table class=\"table\">\n"
                            + "                                    <tr>\n"
                            + "                                        <th>CICLO</th>\n"
                            + "                                        <th>CURSO</th>\n"
                            + "                                        <th>CR</th>\n"
                            + "                                        <th>HT</th>\n"
                            + "                                        <th>HNP</th>\n"
                            + "                                        <th>TH</th>\n"
                            + "                                        <th>NOTA</th>\n"
                            + "                                        <th>OPCIONES</th>\n"
                            + "                                    </tr>\n");
                    while (val.next()) {
                        out.println("   "
                                + "                                 <tr>\n"
                                + "                                        <td><input type=\"text\" size=\"3\" class=\"form-control\"></td>\n"
                                + "                                        <td><input type=\"text\" size=\"20\" class=\"form-control\"></td>\n"
                                + "                                        <td><input type=\"text\" size=\"3\"  class=\"form-control\"></td>\n"
                                + "                                        <td><input type=\"text\" size=\"3\" class=\"form-control\"></td>\n"
                                + "                                        <td><input type=\"text\" size=\"3\" class=\"form-control\"></td>\n"
                                + "                                        <td><input type=\"text\" size=\"3\" class=\"form-control\"></td>\n"
                                + "                                        <td><input type=\"text\" size=\"3\" class=\"form-control\"></td>\n"
                                + "                                         <td><div class=\"image_holder1\">HolaMundo<div class=\"image_info1\">Lorem ipsum dolor sit amet, consectetur adipisicing elit... <br /> <a href=\"#\" class=\"btn btn-danger left\">x</a></div></div></td> "
                                + " </tr>\n");
                    }
                    out.println("                                </table>\n"
                            + "                                <button type=\"submit\" class=\"btn btn-primary\">Guardar</button>\n"
                            + "                                <button type=\"submit\" class=\"btn btn-danger\">Cancelar</button>\n"
                            + "                            </div>\n"
                            + "                        </form>\n"
                            + "                    </div>");
                } else {
                    out.println("No Hubo Conexion con el Servidor");
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
            Logger.getLogger(ControlPedidoD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControlPedidoD.class.getName()).log(Level.SEVERE, null, ex);
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
