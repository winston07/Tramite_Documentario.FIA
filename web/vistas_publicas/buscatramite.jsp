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

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link href="../css/chosen.css" rel="stylesheet" />
        <title>Registro de Tramite</title>
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
        <script src="../js/jquery.js" ></script>
        <script src="../js/public/ajaxmostrarestado.js" ></script>
        
        
        
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
                            <a  href="../vistas_publicas/buscatramite.jsp"><i class="fa fa-dashboard fa-3x"></i>busqueda de proceso</a>
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
                            <h2 id="imp" >Busqueda Tramite:</h2>
                            <form class="center-block" media="print">
                                <div id="imp">
                                    Codigo:<select data-placeholder="Codigo del Alumno" class="chzn-select"   style="width: 200px;" name="codigo" onchange="mostrarestado();" id="cod">
                                        <option value="null"></option>
                                        <%
                                            InterSolicitante iSolicitante = new ModeloSolicitante();
                                        %>
                                        <%
                                            List<Solicitante> liSolicitante = iSolicitante.listar_Solicitante();
                                        %>
                                        <%for (int i = 0; i < liSolicitante.size(); i++) {%>
                                        <option value="<%=liSolicitante.get(i).getCodigo()%>"><%=liSolicitante.get(i).getCodigo()%></option>
                                        <%}%>
                                    </select>
                                    <!--               -->
                                    
                                    <div id="resultados"></div>
                                    
                                 
                                    <!--               
                                    <table>
                                        <td><tr id="resultados">
                                    </table>
                                    <!--             -->
                                  
                                </div>
                                  <!--  
                                <div id="noimp">
                                    <a  name="imp" value="Imprimir" onclick="toogle1('block', 'modal', 'ventana');registarPedido()" class="btn btn-warning">-buscar-</a>

                                </div>-->
                            </form>
                        </center>

                        <script src="../js/jsocultar/jquery.1.6.4.min.js" type="text/javascript"></script>
                        <script src="../js/jsocultar/chosen.jquery.js" type="text/javascript"></script>
                        <script type="text/javascript">
                                        $(".chzn-select").chosen();
                                        $(".chzn-select-deselect").chosen({allow_single_deselect: true});
                        </script>

                    </div>
                </div>
            </div

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
                <a href="#close" title="Cerrar" onclick="toogle1('none', 'modal', 'ventana');window.print()" >Close</a>
            </div>
        </div>

    </body>
</html>

