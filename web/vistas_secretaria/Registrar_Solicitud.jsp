
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
        <link rel="stylesheet" href="../js/dataTables/jquery.js" />
        <script type="text/javascript">
            function enviar()
            {

                var id = $("#id").val();

                $.ajax({
                    async: true,
                    type: "POST",
                    dataType: "html",
                    contentType: "text/html",
                    //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
                    //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
                    url: "../ControlCurso?opc=ajax&id=" + id + "&curso=" + curso + "&cr=" + cr + "&ht=" + ht + "&hnp=" + hnp + "&th=" + th + "&nota=" + nota + "",
                    //url: "../ControlCurso",
                    // data: "id=" + id & "curso=" + curso & "cr=" + cr & "ht=" + ht & "hnp=" + hnp & "th=" + th & "nota=" + nota & "opc=" + "ajax",
                    data: "id=" + id,
                    beforeSend: inicioEnvio,
                    success: llegada,
                    timeout: 4000,
                    error: problemas
                });
                return false;
            }
            function inicioEnvio()
            {
                var x = $("#resultados");
                // x.html('Cargando...');
            }
            function llegada(datos)
            {
                $("#resultados").html(datos);
            }
            function problemas()
            {
                $("#resultados").text('Problemas en el servidor.');
            }
        </script>
        <style>
            .modalmask {
                position: fixed;
                font-family: Arial, sans-serif;
                top: 0;
                right: 0;
                bottom: 0;
                left: 0;
                background: rgba(0,0,0,0.8);
                z-index: 99999;
                opacity:0;
                -webkit-transition: opacity 400ms ease-in;
                -moz-transition: opacity 400ms ease-in;
                transition: opacity 400ms ease-in;
                pointer-events: none;
            }
            .modalmask:target {
                opacity:1;
                pointer-events: auto;
            }
            .modalbox{
                width: 400px;
                position: relative;
                padding: 5px 20px 13px 20px;
                background: #fff;
                border-radius:3px;
                -webkit-transition: all 500ms ease-in;
                -moz-transition: all 500ms ease-in;
                transition: all 500ms ease-in;

            }

            .movedown {
                margin: 0 auto;
            }
            .rotate {
                margin: 10% auto;
                -webkit-transform: scale(-5,-5); 
                transform: scale(-5,-5);
            }
            .resize {
                margin: 10% auto;
                width:0;
                height:0;

            }
            .modalmask:target .movedown{		
                margin:10% auto;
            }
            .modalmask:target .rotate{		
                transform: rotate(360deg) scale(1,1);
                -webkit-transform: rotate(360deg) scale(1,1);
            }

            .modalmask:target .resize{
                width:400px;
                height:200px;
            }
            .close {
                background: #606061;
                color: #FFFFFF;
                line-height: 25px;
                position: absolute;
                right: 1px;
                text-align: center;
                top: 1px;
                width: 24px;
                text-decoration: none;
                font-weight: bold;
                border-radius:3px;
                font-size:16px;
            }

            .close:hover { 
                background: #FAAC58; 
                color:#222;
            }         
            .nsc{
                position:absolute;
                bottom:40%;
                right:0;
            }
        </style>

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

                               <form class="center-block text-center" action="../ControlPedido" >
                               <br/>
                               Codigo: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                               <!-- modal empieza-->

                               <div id="modal3" class="modalmask">
                                   <div class="modalbox resize">
                                       <a href="#close" title="Close" class="close">X</a>
                                       <form action="" class="form-control">
                                           <table>
                                               <h2>Agregar Nuevo Solicitante</h2>
                                               <tr><td>Nombres:</td><td><input type="text" /></td></tr>
                                               <tr><td>Apellido Paterno:</td><td><input type="text" /></td</tr>
                                               <tr><td>Apellido Materno:</td><td><input type="text" /></td></tr>
                                               <tr><td>Nombres:</td><td><input type="text" /></td></tr>
                                               <tr><td>Apellido Paterno:</td><td><input type="text" /></td</tr>
                                               <tr><td>Apellido Materno:</td><td><input type="text" /></td></tr>                                               
                                               <td><input type="submit">Insertar</button></td>
                                               </tr>
                                           </table>
                                       </form>
                                   </div>
                               </div>
                               <!--modal termina -->

                               <select data-placeholder="Codigo del Alumno" class="chzn-select form-control text-center"  tabindex="2" style="width: 200px;" name="codigo">
                                   <option value="null"></option>
                                   <option value="">N</option>

                                   <%
                                       InterSolicitante iSolicitante = new ModeloSolicitante();
                                   %>
                                   <%
                                       List<Solicitante> liSolicitante = iSolicitante.listar_Solicitante();
                                   %>
                                   <%for (int i = 0; i < liSolicitante.size(); i++) {%>
                                   <option value="<%=liSolicitante.get(i).getIdSolicitante()%>"><%=liSolicitante.get(i).getCodigo() + "-" + liSolicitante.get(i).getNombre() + "-" + liSolicitante.get(i).getPaterno()%></option>
                                   <%}%>
                               </select>
                               <a href="#modal3"  class="btn btn-success right">Agregar</a>
                               <br/>                         
                               Tramite:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                               <select data-placeholder="Tipo de Tramite" class="chzn-select form-control"  tabindex="2" style="width: 200px;" name="tipotramite">
                                   <option value=""></option>
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

                               <br/><br/>
                               &nbsp;&nbsp;&nbsp;&nbsp;
                               &nbsp;&nbsp;&nbsp;&nbsp;
                               &nbsp;&nbsp;&nbsp;<button type="submit" name="opc" value="insertar">Imprimir y Registrar</button>
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


    </body>
</html>
