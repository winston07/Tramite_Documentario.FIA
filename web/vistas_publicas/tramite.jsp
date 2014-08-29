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
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Proceso de Tramite</title>
        <!-- BOOTSTRAP STYLES-->
        <link href="../css/bootstrap.css" rel="stylesheet" />
        <link rel="shortcut icon" type="image/x-icon" href="../img/logoing.png">
        <!-- FONTAWESOME STYLES-->
        <link href="../css/font-awesome.css" rel="stylesheet" />
        <!-- MORRIS CHART STYLES-->
        <link href="../js/morris/morris-0.4.3.min.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
        <link href="../css/custom.css" rel="stylesheet" />
        
     
        <link rel="stylesheet" href="../css/modal2.css" />
        <link rel="stylesheet" href="../js/jquery.js" />
        <link rel="stylesheet" href="../js/sec/js.printl.js" />
        
        <!-- GOOGLE FONTS-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    </head>
    <body>
        <div id="wrapper">
            <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="sr-only"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="portal.jsp"><img src="../img/logoing.png" class="img-responsive" id="logo"/><b class="titulo">Facultad de Ingenieria y Arquitectura</b></a> 
                </div>
                
            </nav>   
            <!-- /. NAV TOP  -->
            <nav class="navbar-default navbar-side" role="navigation">
                 <div class="sidebar-collapse">
                    <ul class="nav" id="main-menu">
                        <li class="text-center">
                            <img src="../img/find_user.png" class="user-image img-responsive"/>
                        </li>

                    </ul>

                </div>

            </nav>  
            <!-- /. NAV SIDE  -->
            <div id="page-wrapper">
                <div class="row">
                    <div class="col-md-12">
                        <center>
                        <h2>Proceso de Tramite</h2>
                        <form>
                            <strong>CODIGO 
                               <select data-placeholder="Escuela" class="chzn-select form-control" tabindex="2" style="width: 200px;" name="escuelak" id="e">
                               <option value=""></option>
                                    <%
                                        InterEscuela lEscuela=new ModeloEscuela();
                                    %>
                                    <%   List<Escuela>  ltEscuela=lEscuela.listar_Escuela();                                                                                    
                                    %>
                                    <%for (int i = 0; i <ltEscuela.size(); i++) {%>
                                    <option value="<%=ltEscuela.get(i).getEscuela()%>"><%=ltEscuela.get(i).getNombre()%></option>
                                    <%}%>  
                                </select>
                             
        </strong>
                            <a href="vistas/portal.jsp"><button type="submit">Buscar Tramite</button></a>                       
                        </form>
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
