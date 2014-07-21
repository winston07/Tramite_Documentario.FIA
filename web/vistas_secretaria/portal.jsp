<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Portal Secretaria </title>
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
        <script type="text/javascript" src="js/jquery.js"></script>
        <script>
            $(document).ready(function() {
                $("#mos").click(function() {
                    $("#div").show("slow");
                });
                $("#ocu").click(function() {
                    $("#div").hide("slow");
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
                     font-size: 16px;"> Ultima Conexion : 30 May 2014 &nbsp; <a href="#" class="btn btn-danger square-btn-adjust">Cerrar Sesion</a> </div>
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


                </div>

            </nav>  
            <!-- /. NAV SIDE  -->
            <div id="page-wrapper">
                <div class="row">
                    <div class="col-md-12">
                        <h2>Bienvenida al Sistema de Tramites Documentarios</h2>
                        <div>
                            <p>Q tall como le va</p>
                        </div>
                        <div id="div" style="display: none;">
                            <div class="col-md-6">
                                <div class="table-responsive">
                                    <table class="table">
                                        <tr>
                                            <th>#</th>
                                            <th>Table heading</th>
                                            <th>Table heading</th>
                                            <th>Table heading</th>
                                            <th>Table heading</th>
                                            <th>Table heading</th>
                                            <th>Table heading</th>
                                        </tr>
                                        <tr>
                                            <td>1</td>
                                            <td>Table cell</td>
                                            <td>Table cell</td>
                                            <td>Table cell</td>
                                            <td>Table cell</td>
                                            <td>Table cell</td>
                                            <td>Table cell</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>Table cell</td>
                                            <td>Table cell</td>
                                            <td>Table cell</td>
                                            <td>Table cell</td>
                                            <td>Table cell</td>
                                            <td>Table cell</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="table-responsive">
                                    <table class="table">
                                        <tr>
                                            <th>#</th>
                                            <th>Table heading</th>
                                            <th>Table heading</th>
                                            <th>Table heading</th>
                                            <th>Table heading</th>
                                            <th>Table heading</th>
                                            <th>Table heading</th>
                                        </tr>
                                        <tr>
                                            <td>1</td>
                                            <td>Table cell</td>
                                            <td>Table cell</td>
                                            <td>Table cell</td>
                                            <td>Table cell</td>
                                            <td>Table cell</td>
                                            <td>Table cell</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>Table cell</td>
                                            <td>Table cell</td>
                                            <td>Table cell</td>
                                            <td>Table cell</td>
                                            <td>Table cell</td>
                                            <td>Table cell</td>
                                        </tr>
                                    </table>
                                </div>
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
