<%@page import="com.fia.upeu.dao_imple.ModeloEscuela"%>
<%@page import="com.fia.upeu.modelo.Escuela"%>
<%@page import="com.fia.upeu.dao.InterEscuela"%>
<%@page import="com.fia.upeu.dao_imple.ModeloSolicitante"%>
<%@page import="com.fia.upeu.modelo.Solicitante"%>
<%@page import="java.util.List"%>
<%@page import="com.fia.upeu.dao.InterSolicitante"%>
<!DOCTYPE html>
<%
    String ids = request.getParameter("idS");
    String tramite = request.getParameter("idT");
    String pedido = request.getParameter("idP");
    String validacion = request.getParameter("idV");
    InterSolicitante tSolicitante = new ModeloSolicitante();
    List<Solicitante> lsoli = tSolicitante.listar_Id_Solicitante(ids);

%>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Portal Secretaria</title>
        <!-- BOOTSTRAP STYLES-->
        <link rel="stylesheet" href="../css/chosen.css" />
        <link href="../css/bootstrap.css" rel="stylesheet" />
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
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <!-- descargadoo ya ! error <script type="text/javascript" src="js/jquery.min.js"></script>-->
        <script type="text/javascript" src="../js/manipulacion.js"></script>
        <script type="text/javascript" src="../js/efec.js" ></script>
        <script type="text/javascript" src="../js/sec/registrarConvalidacion.js"></script>
        <!--fin tabla -->

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


                <h1>TRAMITES DOCUMENTALES DE CONVALIDACION</h1>
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
                        <p>Registro de Convalidacion del Alumno</p>
                        <center>

                            <form action="" method="post" name="formulario" id="formulario">

                                <input type="hidden" id="codigo" value="<%=ids%>"  />
                                <input type="hidden" id="pedido" value="<%=pedido%>" />
                                <input type="hidden" id="tramite" value="<%=tramite%>" />
                                <input type="hidden" id="validacion" name="validacion" value="<%=validacion%>" />
                                <p>
                                    <strong> Universidad</strong>
                                    <input class="text-box" name="universidad" type="text" id="unversidad" size="20" maxlength="50" />
                                    <strong> Facultad</strong>
                                    <input class="text-box" name="facultad" type="text" id="facultad" size="20" maxlength="50" />
                                    <strong> De  E.A.P</strong>
                                    <input class="text-box" name="escuela" type="text" id="inst_in" size="20" maxlength="50" />
                                    <select data-placeholder="A..." class="chzn-select form-control"  tabindex="2" style="width: 200px;" id="inst_out"   required="">
                                        <option value=""></option>
                                        <%
                                            InterEscuela tEscuela = new ModeloEscuela();
                                            List<Escuela> ltEscuela = tEscuela.listar_Escuela();

                                        %>
                                        <%                                                                                            %>
                                        <%for (int i = 0; i < ltEscuela.size(); i++) {%>
                                        <option value="<%=ltEscuela.get(i).getEscuela()%>"><%=ltEscuela.get(i).getNombre()%></option>
                                        <%}%>


                                    </select>
                                <p><strong >Codigo </strong>
                                    <input class="text-box" name="Codigo" type="text" id="codigo" size="20" maxlength="50" value="<%=lsoli.get(0).getCodigo()%>" readonly="" />
                                    <strong>Plan</strong>
                                    <input class="text-box" name="plan" type="text" id="plan_in1" size="5" maxlength="50" />
                                    <strong>Plan Nuevo</strong>
                                    <input class="text-box" name="plannuevo" type="text" id="plan_out" size="5" maxlength="50" />
                                </p>
                                <p><strong>Nombres:</strong>
                                    <input  class="text-box" type="text" name="descripcion" id="nombre" size="20" maxlength="50" value="<%=lsoli.get(0).getNombre()%>" readonly/>
                                    <strong>Apellidos:</strong>
                                    <input  class="text-box" type="text" name="apellidos" id="apellidos" size="30" maxlength="50" value="<%=lsoli.get(0).getPaterno() + "," + lsoli.get(0).getMaterno()%>" readonly/>
                                </p>
                                <br/>
                                <!--INGRESO DE TRABLA JQUERY -->
                                <!--<a href="#" onClick="return false" onmouseOver="alert('Ingrese cursos del alumno ')">
                                <img src="../img/interrogacion.png" width="45" height="45">-->

                                <table align="center" width="800" class="table-responsive">
                                    <tbody id="resultados"> </tbody>
                                    <caption>Plan academico </caption>

                                    <tr>
                                        <th>Ciclo</th><th>Nombre Curso</th><th>CR</th><th>HT</th><th>HNP</th><th>TH</th><th>Nota</th><th width="40">&nbsp;</th>
                                    </tr> 


                                    <tr style="vertical-align: middle">
                                    <input type="hidden" id="validacion1" value="<%=validacion%>" />
                                    <td valign="middle" ><input type="text"  size="3"class="clsAnchoTotal form-control" name="ciclo" id="ciclo1"></td>
                                    <td valign="middle" ><input type="text" size="20" class="clsAnchoTotal form-control" name="curso" id="curso1"></td>
                                    <td><input type="text" size="3"class="clsAnchoTotal form-control" id="cr1" name="cr"></td>
                                    <td><input type="text" size="3"class="clsAnchoTotal form-control" id="ht1" name="ht"></td>
                                    <td><input type="text"size="3" class="clsAnchoTotal form-control" id="hnp1" name="hnp"></td>
                                    <td><input type="text" size="3"class="clsAnchoTotal form-control" id="th1" name="th"></td>
                                    <td><input valign="center"type="text" size="3"class="clsAnchoTotal form-control" id="nota1" name="nota"></td>



                                    </tr>



                                </table>
                                <table><tfoot>
                                    <a  class="btn btn-info" onclick="registarConvalidacion();
                                            enviarDatos();" type="submit">Agregar</a> 
                                    </tfoot>
                                </table>
                            </form>
                            <script src="../js/jsocultar/jquery.1.6.4.min.js" type="text/javascript"></script>
                            <script src="../js/jsocultar/chosen.jquery.js" type="text/javascript"></script>
                            <script type="text/javascript">
                                        $(".chzn-select").chosen();
                                        $(".chzn-select-deselect").chosen({allow_single_deselect: true});
                            </script>
                    </div>
                </div>

                </table>

                <p>
                <center>
                    <div>
                        <a type="submit" class="btn btn-success" id="enviarcur" value="ingresar" onclick="toogle5('block', 'modal', 'ventana');
                                enviarCursos1()" >Enviar Cursos</a>

                        </a>
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
<div id="modal" style="display:none">
    <div id="ventana" class="contenedor" style="display:none">
        <div id="res"></div>
        <a href="#close" title="Cerrar" onclick="toogle5('none', 'modal', 'ventana')" >Close</a>
    </div>
</div>


</body>
</html>
