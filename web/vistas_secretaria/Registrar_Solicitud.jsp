
<%@page import="com.fia.upeu.modelo.Escuela_Usuario_Listar"%>
<%@page import="com.fia.upeu.dao_imple.ModeloEscuela"%>
<%@page import="com.fia.upeu.modelo.Escuela"%>
<%@page import="com.fia.upeu.dao.InterEscuela"%>
<%@page import="com.fia.upeu.modelo.Tipo_Tramite"%>
<%@page import="com.fia.upeu.modelo.Solicitante"%>
<%@page import="com.fia.upeu.dao_imple.ModeloSolicitante"%>
<%@page import="com.fia.upeu.dao.InterSolicitante"%>

<%@page import="com.fia.upeu.dao_imple.ModelTipo_Tramite"%>
<%@page import="com.fia.upeu.dao.InterTipo_Tramite"%>
<%@page import="java.util.List"%>
<%
    HttpSession sesion = request.getSession(true);
    String usuario = (String) sesion.getAttribute("IDUSER");
    String idRol = (String) sesion.getAttribute("IDROL");
    if (usuario != null) {

%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link href="../css/chosen.css" rel="stylesheet" />
        <title>Registro de Solicitud</title>
        <link rel="shortcut icon" type="image/x-icon" href="../img/logoing.png">
        <!-- BOOTSTRAP STYLES-->
        <link href="../css/bootstrap.css" rel="stylesheet" />
        <!-- FONTAWESOME STYLES-->
        <link href="../css/font-awesome.css" rel="stylesheet" />
        <!--IMPRIMIR-->
        <link href="../css/Impresion.css" rel="stylesheet" type="text/css" media="print"/>
        <!-- MORRIS CHART STYLES-->
        <link href="../js/morris/morris-0.4.3.min.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
        <link href="../css/custom.css" rel="stylesheet" />
        <!-- GOOGLE FONTS-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

        <link rel="stylesheet" href="../css/modal2.css" />
        <link rel="stylesheet" href="../js/jquery.js" />
        <link rel="stylesheet" href="../js/sec/js.printl.js" />

        <script type="text/javascript" src="../js/sec/registrarPedido.js"></script>
        <script type="text/javascript" src="../js/sec/registroSolicitante.js"></script>
    </head>

    <body>
        <div id="wrapper">
            <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
                <div id="noimp" class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="portal.jsp"><img src="../img/logoing.png" class="img-responsive" id="logo"/><b class="titulo">Facultad de Ingenieria y Arquitectura</b></a> 
                </div>
                <div id="noimp" style="color: white;
                     padding: 15px 50px 5px 50px;
                     float: right;
                     font-size: 16px;"> Ultima Conexion : 30 May 2014 &nbsp; <a href="#" class="btn btn-danger square-btn-adjust">Cerrar Sesion</a>
                </div>
            </nav>   
            <!-- /. NAV TOP  -->
            <nav class="navbar-default navbar-side" role="navigation">
                <div id="noimp" class="sidebar-collapse">
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
                    </ul>

                </div>

            </nav> 

            <!-- /. NAV SIDE  -->
            <div id="page-wrapper">
                <div  class="row">
                    <div class="col-md-12">
                        <center>
                            <!--<a href="#modal3"  class="btn btn-success right">Agregar</a>-->
                            <h2 id="imp" >Registro de Solicitud</h2>
                            <form class="center-block" media="print">
                                <div id="imp">
                                    Codigo:<select data-placeholder="Codigo del Alumno" class="chzn-select2"   style="width: 200px;" name="codigo" onchange="enviar();" id="cod" required="">
                                        <option value="null"></option>
                                        <%                                            InterSolicitante iSolicitante = new ModeloSolicitante();
                                        %>
                                        <%
                                            List<Solicitante> liSolicitante = iSolicitante.listar_Solicitante();
                                        %>
                                        <%for (int i = 0; i < liSolicitante.size(); i++) {%>
                                        <option value="<%=liSolicitante.get(i).getIdSolicitante()%>"><%=liSolicitante.get(i).getCodigo()%></option>
                                        <%}%>
                                    </select>
                                    <!--               -->
                                    <table>
                                        <td><tr id="resultados">
                                    </table>
                                    <!--               -->
                                    Tramite:<select data-placeholder="Tipo de Tramite" class="chzn-select form-control"  tabindex="2" style="width: 200px;" name="tipotramite" id="tra" required>

                                        <option value="" ></option>
                                        <%
                                            InterTipo_Tramite tTramite = new ModelTipo_Tramite();
                                        %>
                                        <%
                                            List<Tipo_Tramite> ltTramite = tTramite.listar_Tipo_Tramite();

                                        %>
                                        <%for (int i = 0; i < ltTramite.size(); i++) {%>
                                        <option value="<%=ltTramite.get(i).getId_Tipo_Tramite()%>"><%=ltTramite.get(i).getNombreTramite()%></option>
                                        <%}%>
                                    </select>
                                    <!--               -->
                                    <table>
                                        <tbody id="resultados"></tbody>
                                    </table>
                                    <!--             -->

                                    Escuela:<select data-placeholder="Escuela" class="chzn-select form-control" tabindex="2" style="width: 200px;" name="escuela" id="escu" required="true">
                                        <option value=""></option>
                                        <%
                                            InterEscuela lEscuela = new ModeloEscuela();
                                        %>
                                        <%   List<Escuela_Usuario_Listar> ltEscuela = lEscuela.listar_Id_Escuela_Usuario(usuario);
                                        %>
                                        <%for (int i = 0; i < ltEscuela.size(); i++) {%>
                                        <option value="<%=ltEscuela.get(i).getIdEscuela()%>"><%=ltEscuela.get(i).getNombre()%></option>
                                        <%}%>  
                                    </select>

                                </div>
                                <div id="noimp" >
                                    <a  name="imp" value="Imprimir" onclick="toogle1('block', 'modal', 'ventana');
                                            registarPedido()" class="btn btn-warning">Registrar</a>
                                    
                                </div>

                            </form>
                        </center>

                        <script src="../js/jsocultar/jquery.1.6.4.min.js" type="text/javascript"></script>
                        <script src="../js/jsocultar/chosen.jquery.js" type="text/javascript"></script>
                        <script type="text/javascript">
                                        $(".chzn-select").chosen();
                                        $(".chzn-select-deselect").chosen({allow_single_deselect: true});
                        </script>
                        <script src="../js/jsocultar/chosen.jquery2.js" type="text/javascript"></script>
                        <script type="text/javascript">
                                        $(".chzn-select2").chosen();
                                        $(".chzn-select-deselect2").chosen({allow_single_deselect: true});
                        </script>


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
        <div id="modal" style="display:none">
            <div id="ventana" class="contenedor" style="display:none">
                <div id="res"></div>
                <a href="#close" title="Cerrar" onclick="toogle1('none', 'modal', 'ventana');
                                            window.print()" >Close</a>
            </div>
        </div>
        <!-- Portfolio Modals -->
        <div class="portfolio-modal modal fade" id="portfolioModal1" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-content">
                <div class="close-modal" data-dismiss="modal">
                    <div class="lr">
                        <div class="rl">
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 col-lg-offset-2">
                            <div class="modal-body">
                                <h2>Registrar Nuevo Solicitante</h2>
                                <form class="form form-control-static" action="#" >
                                    <label class="label label-info">Codigo</label> <input type="text" class="form-control" placeholder="Codigo del Portal Academico" required autofocus id="codigo">
                                    <label class="label label-info">Nombres</label> <input type="text" class="form-control" placeholder="Nombres" required autofocus id="nombres">
                                    <label class="label label-info">Apellido Paterno</label><input type="text" class="form-control" placeholder="Apellido Paterno" required  id="ap_paterno">
                                    <label class="label label-info">Apellido Materno</label><input type="text" class="form-control" placeholder="Apellido Materno" required  id="ap_materno">
                                    <label class="label label-info">Correo Electronico</label><input type="email" class="form-control" placeholder="Correo Electronico" required  id="email">
                                    <label class="label label-info">Numero de Telefono</label><input type="tel" class="form-control" placeholder="Numero de Telefono" required  id="tel">
                                    <label class="label label-info">Sexo</label><select name="" id="sexo" class="chzn-select form-control">
                                        <option value="-" disabled="" selected="">Selecione Una Opcion</option>
                                        <option value="M">Masculino</option>
                                        <option value="F">Femenino</option>
                                    </select>
                                    <label class="label label-info">Direccion</label><input type="text" class="form-control" placeholder="Direccion..."   id="direccion">
                                    <div class="checkbox">                
                                    </div>                                
                                    <button type="submit" class="btn btn-success" onclick="registrarSolicitante(document.getElementById('codigo').value,document.getElementById('nombres').value, document.getElementById('ap_paterno').value, document.getElementById('ap_materno').value,
                                                                                                                document.getElementById('email').value, document.getElementById('tel').value, document.getElementById('sexo').value,document.getElementById('direccion').value);"> Registrar Nuevo Solicitante</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
<%
    }
%>
