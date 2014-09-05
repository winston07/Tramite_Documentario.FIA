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
                //String idPed = request.getParameter("idPed");

                //out.println( idvali);
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
                            + "   <th colspan='2'>NOTA</th>\n"
                            + "  </tr>");
                    int i = 0;
                    while (rs.next()) {
                        out.println(""
                                + "<tr id='" + i + "'>\n"
                                + " <td><input class=\"form-control\" type=\"text\" readonly id='" + rs.getString(5) + "ciclo0' value='" + rs.getString(6) + "'/></td>\n"
                                + " <td><input class=\"form-control\" type=\"text\" readonly id='" + rs.getString(5) + "nombre0' value='" + rs.getString(7) + "'/></td>\n"
                                + " <td><input class=\"form-control\" type=\"text\" readonly id='" + rs.getString(5) + "cr0' value='" + rs.getString(8) + "'/></td>\n"
                                + " <td><input class=\"form-control\" type=\"text\" readonly id='" + rs.getString(5) + "ht0' value='" + rs.getString(9) + "'/></td>\n"
                                + " <td><input class=\"form-control\" type=\"text\" readonly id='" + rs.getString(5) + "hnp0' value='" + rs.getString(10) + "'/></td>\n"
                                + " <td><input class=\"form-control\" type=\"text\" readonly id='" + rs.getString(5) + "th0' value='" + rs.getString(11) + "'/></td>\n"
                                + " <td><input class=\"form-control\" type=\"text\" readonly id='" + rs.getString(5) + "nota0' value='" + rs.getString(12) + "'/></td>\n"
                                + " <td>\n"
                                + " <div class=\"image_holder1\"><a href=\"#\" onclick=\"enviardatos('" + rs.getString(5) + "',document.getElementById('" + rs.getString(5) + "ciclo0').value, document.getElementById('" + rs.getString(5) + "nombre0').value,document.getElementById('" + rs.getString(5) + "cr0').value,document.getElementById('" + rs.getString(5) + "ht0').value,document.getElementById('" + rs.getString(5) + "hnp0').value,document.getElementById('" + rs.getString(5) + "th0').value,document.getElementById('" + rs.getString(5) + "nota0').value,'" + rs.getString(5) + "ciclo','" + rs.getString(5) + "nombre','" + rs.getString(5) + "cr','" + rs.getString(5) + "ht','" + rs.getString(5) + "hnp','" + rs.getString(5) + "th','" + rs.getString(5) + "nota');\"><img src=\"../img/fle.png\" alt=\"\" width=\"20px\" height=\"20px\"/></a><div class=\"image_info1\"> <div class=\"text-justify\">Enviar la Informacion Directamente.</div></div>"
                                + " </td>\n"
                                + " </tr> ");
                        i++;
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
                    int e = 0;
                    
                    int f = 1000;
                    while (val.next()) {
                        
                        out.println("  "
                                + " "
                                + " <tr id='" + f + "' class=" + val.getRow() + ">\n"
                                + "                                        <td><input value='" + val.getString(13) + "' onkeyup=\"guardarIndividual('CUR_CICLO','" + val.getString(5) + "',document.getElementById('" + val.getString(5) + "ciclo').value)\" id='" + val.getString(5) + "ciclo' type=\"text\" size=\"\" class=\"form-control "+e+"ciclo\"></td>\n"
                                + "                                        <td><input value='" + val.getString(14) + "' onkeyup=\"guardarIndividual('CUR_NOMBRE','" + val.getString(5) + "',document.getElementById('" + val.getString(5) + "nombre').value)\" id='" + val.getString(5) + "nombre'type=\"text\" size=\"\" class=\"form-control "+e+"curso\"></td>\n"
                                + "                                        <td><input value='" + val.getString(15) + "' onkeyup=\"guardarIndividual('CUR_CR','" + val.getString(5) + "',document.getElementById('" + val.getString(5) + "cr').value)\" id='" + val.getString(5) + "cr'type=\"text\" size=\"\"  class=\"form-control "+e+"cr\"></td>\n"
                                + "                                        <td><input value='" + val.getString(16) + "' onkeyup=\"guardarIndividual('CUR_HT','" + val.getString(5) + "',document.getElementById('" + val.getString(5) + "ht').value)\" id='" + val.getString(5) + "ht'type=\"text\" size=\"\" class=\"form-control "+e+"ht\"></td>\n"
                                + "                                        <td><input value='" + val.getString(17) + "' onkeyup=\"guardarIndividual('CUR_HNP','" + val.getString(5) + "',document.getElementById('" + val.getString(5) + "hnp').value)\" id='" + val.getString(5) + "hnp'type=\"text\" size=\"\" class=\"form-control "+e+"hnp\"></td>\n"
                                + "                                        <td><input value='" + val.getString(18) + "' onkeyup=\"guardarIndividual('CUR_TH','" + val.getString(5) + "',document.getElementById('" + val.getString(5) + "th').value)\" id='" + val.getString(5) + "th'type=\"text\" size=\"\" class=\"form-control "+e+"th\"></td>\n"
                                + "                                        <td><input value='" + val.getString(19) + "' onkeyup=\"guardarIndividual('CUR_NOTA','" + val.getString(5) + "',document.getElementById('" + val.getString(5) + "nota').value)\" id='" + val.getString(5) + "nota'type=\"text\" size=\"\" class=\"form-control "+e+"nota\"></td>\n"
                                + "                                        <td><div class=\"image_holder1\"><a class='center-block' href=\"#\"><img src=\"../img/x.png\" alt=\"\" width=\"20px\" height=\"20px\"/></a><div class=\"image_info1  btn-info\" onmouseout=\"cambiarcolor2('" + e + "','" + f + "')\" onmousemove=\"cambiarcolor('" + e + "','" + f + "');\"> <div class=\"text-justify\">Ten Encuenta que luego no podras recuperar la informacion. <br /> ¿Estas seguro?</div> <br /> <a href=\"#\" class=\"btn btn-danger center-block\">Eliminar...!</a></div></div></td> "
                                + " </tr>\n"
                        );
                        e++;
                        f++;
                      
                    }
                    out.println("                                </table>\n"
                            + "                            </div>\n"
                            + "                        </form>\n"
                            + "                    </div>"
                            + "<div class='col-md-12 text-center'>"
                            + "                                <button type=\"submit\" class=\"btn btn-primary\">Terminar el Proceso</button>\n"
                            + "</div>"
                            + "");
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
            Logger.getLogger(ControlPedidoD.class.getName()).log(Level.SEVERE, null, ex);
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
