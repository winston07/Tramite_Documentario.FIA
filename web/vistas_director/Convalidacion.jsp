<%-- 
   Document   : Convalidacion
   Created on : Jul 17, 2014, 11:44:34 AM
   Author     : Wins
--%>
<%@page import="com.fia.upeu.dao_imple.ModeloPlan_In"%>
<%@page import="com.fia.upeu.dao.InterfacePlan_In"%>
<%@page import="com.fia.upeu.modelo.Plan_In"%>
<%@page import="com.fia.upeu.dao_imple.ModeloSolicitante"%>
<%@page import="com.fia.upeu.modelo.Solicitante"%>
<%@page import="com.fia.upeu.dao.InterSolicitante"%>
<%@page import="com.fia.upeu.modelo.Curso_in"%>
<%@page import="com.fia.upeu.dao_imple.ModeloCurso_in"%>
<%@page import="com.fia.upeu.dao.InterCurso_in"%>
<%@page import="com.fia.upeu.modelo.Escuela"%>
<%@page import="java.util.List"%>
<%@page import="com.fia.upeu.dao.InterEscuela"%>
<%@page import="com.fia.upeu.dao_imple.ModeloEscuela"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" href="../css/Boton.css" rel="stylesheet">
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Portal Director</title>
        <!-- BOOTSTRAP STYLES-->
        <link href="../css/bootstrap.css" rel="stylesheet" />
        <!-- FONTAWESOME STYLES-->
        <link href="../css/font-awesome.css" rel="stylesheet" />
        <!-- MORRIS CHART STYLES-->
        <link href="../js/morris/morris-0.4.3.min.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
        <link href="../css/custom.css" rel="stylesheet" />
        <link rel="stylesheet" href="../css/stylemodal.css" />
        <link rel="stylesheet" href="../css/modal2.css" />
        <link rel="stylesheet" href="../css/stylehover.css" />

        <!-- GOOGLE FONTS-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
        <script type="text/javascript" src="../js/jquery.js"></script>
        <script type="text/javascript" src="../js/dir/ajaxlistarconvalidaciones.js"></script>
       
    </head>
    <body>
        <div id="wrapper">
            <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="portal.jsp"><img src="../img/logoing.png" class="img-responsive" id="logo" /><b class="titulo">Facultad de Ingenieria y Arquitectura</b></a> 
                </div>
                <a href="#" class="btn btn-danger square-btn-adjust">Cerrar Sesion</a>

            </nav>   
            <!-- /. NAV TOP  -->
            <nav class="navbar-default navbar-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav" id="main-menu">
                        <li class="text-center">
                            <img src="../img/find_user.png" class="user-image img-responsive"/>
                        </li>


                        <li>
                            <a  href="Validacion.jsp"><i class="fa fa-dashboard fa-3x"></i>Validacion</a>
                        </li>
                        <li class="active">
                            <a  href="Convalidacion.jsp"><i class="fa fa-desktop fa-3x"></i>Convalidacion</a>
                        </li>
                        <li>
                            <a  href="#"><i class="fa fa-qrcode fa-3x"></i> Tabs & Panels</a>
                        </li>

                        
                </div>

            </nav>  
            <!-- /. NAV SIDE  -->
            <div id="page-wrapper">
                <div class="row">
                    <div class="col-md-12">
                        <h2>Lista de Solicitudes</h2>   
                        <h5>Listado de las Solicitudes</h5>     
                        <div class="table-responsive">
                            <form  name="conva"id="conva">
                                <table class="table" id="tablita">

                                    <tr style="font-size:17px; font-weight: bold;">
                                    <a onclick="modal()" >hola</a>

                                    <td>#</td><td>Universidad</td><td>Facultad</td><td>EAP-in</td><td>EAP-out</td><td>Codigo</td><td>Solicitante</td><td>Plan Priveniente</td><td>Plan Sugerido</td><td colspan="3">Opciones</td>
                                    </tr>
                                    <tbody id="resultados"></tbody>
                                </table>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
            <!-- /. PAGE WRAPPER  -->
        </div>
        <!-- /. WRAPPER  -->
        <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
        <!-- JQUERY SCRIPTS -->
        <script src="../js/jquery-1.10.2.js"></script>
        <!-- BOOTSTRAP SCRIPTS -->
        <script src="../js/bootstrap.min.js"></script>
        <!-- METISMENU SCRIPTS -->
        <script src="../js/jquery.metisMenu.js"></script>
        <!-- MORRIS CHART SCRIPTS -->
        <script src="../js/morris/raphael-2.1.0.min.js"></script>
        <script src="../js/morris/morris.js"></script>
        <!-- CUSTOM SCRIPTS -->
        <script src="../js/custom.js"></script>
        <div id="modal1" style="display:none">
            <div id="ventana1" class="contenedor1" style="display:none">                

                <a href="#close" title="Cerrar" onclick="tooglevalidar('none', 'modal1', 'ventana1')" >Close</a>
                <div id="res">                 

                </div>
                <ACRONYM  title="Aquí el texto emergente de ayuda ">

                    <p> Texto de cualquier tipo </p>  

                </ACRONYM>
            </div>
        </div>
        <div id="modal" style="display:none">
            <div id="ventana" class="contenedor" style="display:none">

                <a href="#close" title="Cerrar" onclick="toogle3('none', 'modal', 'ventana')" >Close</a>
            </div>
        </div>


        <!--modal termina -->



    </body>
</html>
