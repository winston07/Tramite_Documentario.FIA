
<%@page import="com.fia.upeu.modelo.Pedido"%>
<%@page import="com.fia.upeu.dao_imple.ModeloPedido"%>
<%@page import="com.fia.upeu.dao.InterPedido"%>
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
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Portal Secretaria</title>
        <link href="../css/chosen.css" rel="stylesheet" />
        <link rel="shortcut icon" type="image/x-icon" href="../img/logoing.png">
        <!-- BOOTSTRAP STYLES-->
        <link href="../css/bootstrap.css" rel="stylesheet" />
        <link href="../css/Buttons.css" rel="stylesheet" />
        <!-- FONTAWESOME STYLES-->
        <link href="../css/font-awesome.css" rel="stylesheet" />
        <!-- MORRIS CHART STYLES-->
        <link href="../js/morris/morris-0.4.3.min.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
        <link href="../css/custom.css" rel="stylesheet" />
        <!-- GOOGLE FONTS-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
        <!--tabla ingreso validacion secretaria -->
        <link rel="stylesheet" type="text/css" href="../css/estilos.css">
        <link rel="stylesheet" href="../css/modal2.css" />
        <script type="text/javascript" src="../js/jquery.js"></script>
        <script type="text/javascript" src="../js/sec/ajaxlistarvalidaciones.js"></script>

    </head>
    <body>

        <div id="wrapper">

            <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">

                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">                        
                        <span class="sr-only"></span>
                        <span class="sr-only"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>

                    </button>


                    <a class="navbar-brand" href="portal.jsp"><img src="../img/logoupeu.png" class="img-responsive" id="logo"/><b class="titulo">Facultad de Ingenieria y Arquitectura</b></a> 
                </div>

                <script>
                    var meses = new Array("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
                    var diasSemana = new Array("Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado");
                    var f = new Date();
                    document.write(diasSemana[f.getDay()] + ", " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear());
                </script>


                <h1>TRAMITES DOCUMENTALES DE VALIDACION</h1>
                <div style="position:absolute; left:1200px; top:10px; width:728px; height:70px "><a href="#" class="btn btn-danger square-btn-adjust" >Cerrar Sesion</a></div> 

            </nav>
            <!-- /. NAV TOP  -->
            <nav class="navbar-default navbar-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav" id="main-menu">
                        <li class="text-center">
                            <img src="../img/logosecretaria.png" class="user-image img-responsive"/>
                        </li>


                        <li>
                            <a  href="../vistas_secretaria/Registrar_Solicitud.jsp"><i class="fa fa-dashboard fa-3x"></i>Registro</a>
                        </li>
                        <li>
                            <a  href="../vistas_secretaria/Val_pendientes.jsp"><i class="fa fa-check-square-o fa-3x"></i>Validacion</a>
                        </li>
                        <li>
                            <a  href="../vistas_secretaria/Convalidacion.jsp"><i class="fa fa-th-list fa-3x"></i>Convalidacion</a>
                        </li>


                </div>


            </nav>  

            <!-- /. NAV SIDE  -->

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-md-12">                        
                        <!--ingrese datos tabla-->  
                        <h1 class="text-info text-center">Validaciones en Espera.</h1>
                        <table class="table table-responsive tabs-stacked text-center  table-bordered">
                            <tr class="btn-lg btn-warning">
                                <td>IdPedido</td><td>Codigo Solicitante</td><td>Nombres de Solicitante</td><td>Apellidos de Solicitante</td><td>Estado</td><td>Escuela</td><td colspan="4">Opciones</td>
                            </tr> 
                            <tbody id="resultados"></tbody>


                        </table>
                        <div id="ex"></div>


                    </div>
                    
                    <a onclick="toogle3('block', 'modal', 'ventana');elimanarValidacion('kel', 'kel', 'kel', 'kel');" >Aqui xD</a>
                </div>
            </div>
        </div>


        <!-- /. PAGE WRAPPER  -->
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
        <div id="modal" style="display:none">
            <div id="ventana" class="contenedor" style="display:none">
                <div id="res"></div>
                <a href="#close" title="Cerrar" onclick="toogle3('none', 'modal', 'ventana');" >Close</a>
            </div>
        </div>


    </body>
</html>
