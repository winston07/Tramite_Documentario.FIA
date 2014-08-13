
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
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Portal Secretaria</title>
        <link rel="stylesheet" href="../css/modal.css" />
        <link href="../css/chosen.css" rel="stylesheet" />
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
        <link rel="stylesheet" href="../js/dataTables/jquery.js" />

        <script type="text/javascript" src="../js/sec/registrarValidacion.js"></script>

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
                    var diasSemana = new Array("Domingo", "Lunes", "Martes", "Mi�rcoles", "Jueves", "Viernes", "S�bado");
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
                        <p>Registro de Validaciones de Alumnos</p>
                        <center>    

                            <form action="../ControlValidacion" method="post" name="formulario" id="formulario">
                                <strong> Escuela </strong>
                                <select data-placeholder="Escuela" class="chzn-select form-control"  tabindex="2" style="width: 200px;" id="inst_in" required="">
                                    <option value=""></option>
                                    <%
                                        String ids = request.getParameter("idS");
                                        String tramite = request.getParameter("idT");
                                        String pedido = request.getParameter("idP");
                                        String validacion = request.getParameter("idV");
                                        InterEscuela tEscuela = new ModeloEscuela();

                                    %>
                                    <%                                        List<Escuela> ltEscuela = tEscuela.listar_Escuela();
                                    %>
                                    <%for (int i = 0; i < ltEscuela.size(); i++) {%>
                                    <option value="<%=ltEscuela.get(i).getEscuela()%>"><%=ltEscuela.get(i).getNombre()%></option>
                                    <%}%>

                                    <%
                                        InterSolicitante tSolicitante = new ModeloSolicitante();
                                        List<Solicitante> lsoli = tSolicitante.listar_Id_Solicitante(ids);
                                    %>

                                </select>

                                <p>
                                    <%for (int w = 0; w < lsoli.size(); w++) {%>
                                    <strong >Codigo </strong>
                                    <input class="text-box"name="lalal" type="text" id="codigo" size="20" maxlength="50" value="<%=lsoli.get(w).getCodigo()%>" readonly="false" />
                                    <input type="hidden" id="codigo" value="<%=ids%>"  />
                                    <input type="hidden" id="pedido" value="<%=pedido%>" />
                                    <input type="hidden" id="tramite" value="<%=tramite%>" />
                                    <input type="hidden" id="validacion" value="<%=validacion%>" />
                                    <strong>Nombres:</strong>
                                    <input  class="text-box"name="nombres" type="text" id="nombre" size="20" maxlength="50" value="<%=lsoli.get(w).getNombre()%>" readonly="true"/>
                                    <strong>Apellidos:</strong>
                                    <input  class="text-box"name="apellidos" type="text" id="apellidos" size="30" maxlength="50" value="<%=lsoli.get(w).getPaterno() + "," + lsoli.get(w).getMaterno()%>" readonly="true"/>
                                    <%}%>

                                </p>
                                <p>
                                    <strong>Plan</strong> 
                                    <select id="plan_in" data-placeholder="Plan" class="chzn-select form-control"  tabindex="2" style="width: 200px;" name="oldplan" onchange="enviarplan_in()" required="">
                                        <option value=""></option>
                                        <%  InterfacePlan_In tPlanin = new ModeloPlan_In();
                                        %>
                                        <%  List<Plan_In> ltPlanin = tPlanin.list_Plan_In();
                                        %>
                                        <%for (int i = 0; i < ltPlanin.size(); i++) {%>
                                        <option value="<%=ltPlanin.get(i).getIdplan()%>"><%=ltPlanin.get(i).getIdplan()%></option>
                                        <%}%>




                                    </select>
                                    <strong>Plan Nuevo</strong>
                                    <select id="plan_out" data-placeholder="Plan" class="chzn-select form-control"  tabindex="2" style="width: 200px;" name="newplan" onchange="enviarplan_in()" required="">
                                        <option value=""></option>
                                        <%  InterfacePlan_In tPlanin1 = new ModeloPlan_In();
                                        %>
                                        <%  List<Plan_In> ltPlanin1 = tPlanin1.list_Plan_In();
                                        %>
                                        <%for (int i = 0; i < ltPlanin1.size(); i++) {%>
                                        <option value="<%=ltPlanin1.get(i).getIdplan()%>"><%=ltPlanin1.get(i).getIdplan()%></option>
                                        <%}%>




                                    </select>
                                    <br/>
                                    <a  class="btn btn-warning" value="cabecera" name="opc"  onclick="registarValidacion()" href="#modal3" id="opc" >Agregar Cabecera</a>
                                </p>
                                <br/>
                            </form>
                            <div id="res"></div>
                            <!--INGRESO DE TRABLA JQUERY -->

                            <table align="center" width="800" class="table-responsive">
                                <caption>Plan academico </caption>

                                <tr>
                                    <th>Ciclo</th><th>Nombre Curso</th><th>CR</th><th>HT</th><th>HNP</th><th>TH</th><th>Nota</th><th width="40">&nbsp;</th>
                                </tr> 



                                <tr style="vertical-align: middle">
                                    <td valign="middle" ><input type="text"  size="3"class="clsAnchoTotal form-control" name="id" id="id"></td>
                                    <td valign="middle" ><input type="text" size="20" class="clsAnchoTotal form-control" id="curso"></td>
                                    <td><input type="text" size="3"class="clsAnchoTotal form-control" id="cr"></td>
                                    <td><input type="text" size="3"class="clsAnchoTotal form-control" id="ht"></td>
                                    <td><input type="text"size="3" class="clsAnchoTotal form-control" id="hnp"></td>
                                    <td><input type="text" size="3"class="clsAnchoTotal form-control" id="th"></td>
                                    <td><input valign="center"type="text" size="3"class="clsAnchoTotal form-control" id="nota"></td>



                                </tr>

                                <div id="resultados"> </div>

                            </table>
                            <tr>
                            <button type="submit" value="insertar" class="btn btn-info" id="enviar" onclick="enviar()">Agregar</button> 
                            </tr>

                        </center>
                        <script src="../js/jsocultar/jquery.1.6.4.min.js" type="text/javascript"></script>
                        <script src="../js/jsocultar/chosen.jquery.js" type="text/javascript"></script>
                        <script type="text/javascript">
                                $(".chzn-select").chosen();
                                $(".chzn-select-deselect").chosen({allow_single_deselect: true});
                        </script>
                    </div>
                </div>


                <p>
                <center>
                    <div>
                        <input type="button" class="btn btn-success"name="ingresar" id="enviar" value="ingresar" />
                        <input type="button" class="btn btn-danger"name="cancelar" id="cancelar" value="Cancelar" />
                        <!--<a href="#" onClick="return false" onmouseOver="alert('')">
                        <img src="../img/interrogacion.png" width="45" height="45">
                    </a>-->
                        <br />
                    </div>
                </center>
                </p>
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
<div id="modal3" class="modalmask">


    <div id="noimp" class="modalbox resize">


        <h2 id="noimp">Pedido Agregado Correctamente</h2>

        <a id="noimp" href="#close" title="Close" class="btn btn-success" onclick="ocultarBotton()" style="float: right;">Aceptar</a>
    </div>
</div>


</body>
</html>
