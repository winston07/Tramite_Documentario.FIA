<%@page import="java.util.Iterator"%>
<%@page import="com.fia.upeu.modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="com.fia.upeu.dao_imple.ModeloUsuario"%>
<%@page import="com.fia.upeu.dao.InterUsuario"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link href="../css/chosen.css" rel="stylesheet" />
        <title>Registro de Solicitud</title>
        <!-- BOOTSTRAP STYLES-->
        <link href="../css/bootstrap.css" rel="stylesheet" />
        <!-- FONTAWESOME STYLES-->
        <link href="../css/font-awesome.css" rel="stylesheet" />
        <!-- MORRIS CHART STYLES-->
        <link href="../js/morris/morris-0.4.3.min.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
        <link href="../css/custom.css" rel="stylesheet" />
        <!-- GOOGLE FONTS-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
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
                    <a class="navbar-brand" href="portal.jsp"><img src="../img/logoing.png" class="img-responsive" id="logo"/><b class="titulo">Facultad de Ingenieria y Arquitectura</b></a> 
                </div>
                <div style="color: white;
                     padding: 15px 50px 5px 50px;
                     float: right;
                     font-size: 16px;"> Ultima Conexion : 30 May 2014 &nbsp; <a href="#" class="btn btn-danger square-btn-adjust">Cerrar Sesion</a>
                </div>
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
                            <a  href="../vistas_secretaria/Validacion.jsp"><i class="fa fa-check-square-o fa-3x"></i>Validacion</a>
                        </li>
                        <li>
                            <a  href="../vistas_secretaria/Convalidacion.jsp"><i class="fa fa-th-list fa-3x"></i>Convalidacion</a>
                        </li>
                    </ul>

                </div>

            </nav>  
            <!-- /. NAV SIDE  -->
            <div id="page-wrapper">
                <div class="row">
                    <div class="col-md-12">
                        <center>
                            <h2>Registro de Solicitud</h2> 

                            <form class="center-block">
                                <br/>
                                Codigo: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                                <select data-placeholder="Codigo del Alumno" class="chzn-select form-control"  tabindex="2" style="width: 200px;" name="codigo">
                                    <option value=""></option>
                                    <%
                                        InterUsuario iUsuario = new ModeloUsuario();
                                    %>
                                    <%
                                        List<Usuario> lUsuario = iUsuario.list_Usuario();
                                        
                                    %>
                                    <%for (int i = 0; i < lUsuario.size(); i++){%>
                                    <option value="<%=lUsuario.get(i).getUsuario()%>"><%=lUsuario.get(i).getUsuario()%></option>
                                    <%}%>
                                </select>
                                <br/><br/>
                                Nombre: &nbsp;&nbsp;&nbsp;<input type="text" name="nombres" required><br/><br/>
                                Apellidos:&nbsp; <input type="text" name="apellidos" required><br/><br/>                           
                                Tramite:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <select data-placeholder="Codigo del Alumno" class="chzn-select form-control"  tabindex="2" style="width: 200px;" name="codigo">
                                    <option value=""></option>
                                    <%
                                        InterUsuario iUsuario = new ModeloUsuario();
                                    %>
                                    <%
                                        List<Usuario> lUsuario = iUsuario.list_Usuario();
                                        
                                    %>
                                    <%for (int i = 0; i < lUsuario.size(); i++){%>
                                    <option value="<%=lUsuario.get(i).getUsuario()%>"><%=lUsuario.get(i).getUsuario()%></option>
                                    <%}%>
                                </select>

                                <br/><br/>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;<button type="submit" name="opc">Imprimir y Registrar</button>
                            </form>
                            <script src="../js/jsocultar/jquery.1.6.4.min.js" type="text/javascript"></script>
                            <script src="../js/jsocultar/chosen.jquery.js" type="text/javascript"></script>
                            <script type="text/javascript">
                                $(".chzn-select").chosen();
                                $(".chzn-select-deselect").chosen({allow_single_deselect: true});
                            </script>
                        </center>
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


    </body>
</html>
