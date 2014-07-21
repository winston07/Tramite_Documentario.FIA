<%-- 
    Document   : Convalidacion
    Created on : Jul 17, 2014, 11:44:34 AM
    Author     : Wins
--%>

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
        <!-- GOOGLE FONTS-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
        <script type="text/javascript" src="../js/jquery.js"></script>
        <script>
            $(document).ready(function() {
                $("#mos").click(function() {
                    $("#div").show("slow");
                     $("#ocultar").hide("slow");
                });
                $("#ocu").click(function() {
                    $("#div").hide("slow")
                    $("#ocultar").show("slow");
                });
                $("#mos2").click(function() {
                    $("#div").show("slow");
                    $("#nomostrar").hide("slow");
                    $("#div2").show("slow");

                });
                $("#ocu2").click(function() {
                    $("#div").hide("slow");
                    $("#nomostrar").show("slow");
                });
            });
        </script>
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
                <div style="color: white;
                     padding: 15px 50px 5px 50px;
                     float: right;
                     font-size: 16px;"> Ultima Conexion : <script>
                    var meses = new Array("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
                    var diasSemana = new Array("Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado");
                    var f = new Date();
                    document.write(diasSemana[f.getDay()] + ", " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear());
                </script> <a href="#" class="btn btn-danger square-btn-adjust">Cerrar Sesion</a> </div>
                     
            </nav>   
            <!-- /. NAV TOP  -->
            <nav class="navbar-default navbar-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav" id="main-menu">
                        <li class="text-center">
                            <img src="../img/find_user.png" class="user-image img-responsive"/>
                        </li>


                        <li>
                            <a  href="portal.jsp"><i class="fa fa-dashboard fa-3x"></i>Validacion</a>
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
                            <form action="ImprimirConvalidacion.jsp">
                                <table class="table" id="tablita">
                                    <tr style="font-size:17px; font-weight: bold;">
                                        <td>#</td><td>Universidad</td><td>Facultad</td><td>EAP</td><td>Codigo</td><td>Solicitante</td><td>Plan Priveniente</td><td>Plan Sugerido</td><td colspan="2">Opciones</td>
                                    </tr>
                                    <tr id="nomostrar">
                                        <td>1</td><td>Nacional de San Marcos</td><td>Ciencias Empresariales</td><td>FIA</td><td>201122837</td><td>Kelvin Meza E</td><td>2011-2</td><td>2014-2</td>
                                        <td>
                                            <input id="mos" type="button" value="Mostrar" href="#" class="btn btn-success"/>
                                            <input id="ocu" type="button" value="Ocultar" href="#" class="btn btn-warning"/>
                                            <input id="ocu" type="submit" value="Imprimir" src="ImprimirConvalidacion.jsp" class="btn btn-info"/>
                                        </td>
                                    </tr>
                                    <tr id="ocultar">
                                        <td>2</td><td>Nacional de Ingenieria</td><td>Ingenieria</td><td>SALUD</td><td>201122837</td><td>Kelvin Meza E</td><td>2011-2</td><td>2014-2</td>
                              <td>
                                  <input id="mos2" type="button" value="Mostrar" href="#" class="btn btn-success"/>
                                            <input id="ocu2" type="button" value="Ocultar" href="#" class="btn btn-warning"/>
                                            <input id="ocu2" type="submit" value="Imprimir" href="ImprimirConvalidacion.jsp" class="btn btn-info"/>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>


                        <div id="div" style="display: none;">
                            <div class="col-md-6">
                                <div class="table-responsive">
                                    <h1 class="text-center text-success">Plan 2011</h1>
                                    <table class="table">
                                        <tr>
                                            <th>CICLO</th>
                                            <th>CURSO</th>
                                            <th>CR</th>
                                            <th>HT</th>
                                            <th>HNP</th>
                                            <th>TH</th>
                                            <th>NOTA</th>
                                        </tr>
                                        <tr>
                                            <td><label class="control-label">3</label></td>
                                            <td><label class="control-label">Lenguaje de Programacion 2</label></td>
                                            <td><label class="control-label">4</label></td>
                                            <td><label class="control-label">4</label></td>
                                            <td><label class="control-label">4</label></td>
                                            <td><label class="control-label">8</label></td>
                                            <td><label class="control-label">20</label></td>
                                            <td>
                                                <label class="control-label"><a href="" class="btn btn-danger">X</a></label>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><label class="control-label">1</label></td>
                                            <td><label class="control-label">Matematica</label></td>
                                            <td><label class="control-label">4</label></td>
                                            <td><label class="control-label">4</label></td>
                                            <td><label class="control-label">4</label></td>
                                            <td><label class="control-label">8</label></td>
                                            <td><label class="control-label">20</label></td>
                                            <td>
                                                <label class="control-label"><a href="" class="btn btn-danger">X</a></label>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <form>
                                    <div class="table-responsive">
                                        <h1 class="text-center text-success">Plan 2014</h1>
                                        <table class="table">
                                            <tr>
                                                <th>CICLO</th>
                                                <th>CURSO</th>
                                                <th>CR</th>
                                                <th>HT</th>
                                                <th>HNP</th>
                                                <th>TH</th>
                                                <th>NOTA</th>
                                            </tr>
                                            <tr>
                                                <td><input type="text" size="3" class="form-control"></td>
                                                <td><input type="text" size="20" class="form-control"></td>
                                                <td><input type="text" size="3"  class="form-control"></td>
                                                <td><input type="text" size="3" class="form-control"></td>
                                                <td><input type="text" size="3" class="form-control"></td>
                                                <td><input type="text" size="3" class="form-control"></td>
                                                <td><input type="text" size="3" class="form-control"></td>
                                            </tr>
                                            <tr>
                                                <td><input type="text" size="3" class="form-control"></td>
                                                <td><input type="text" size="20" class="form-control"></td>
                                                <td><input type="text" size="3"  class="form-control"></td>
                                                <td><input type="text" size="3" class="form-control"></td>
                                                <td><input type="text" size="3" class="form-control"></td>
                                                <td><input type="text" size="3" class="form-control"></td>
                                                <td><input type="text" size="3" class="form-control"></td>
                                            </tr>                                            
                                        </table>
                                        <button type="submit" class="btn btn-primary">Guardar</button>
                                        <button type="submit" class="btn btn-danger">Cancelar</button>
                                    </div>
                                </form>
                            </div>

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


    </body>
</html>
