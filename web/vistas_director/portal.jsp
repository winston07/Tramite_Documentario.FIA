<%
    HttpSession sesion = request.getSession(true);
    String usuario = (String) sesion.getAttribute("IDUSER");
    String idRol = (String) sesion.getAttribute("IDROL");
    if (usuario != null) {       
        out.println("alert('"+usuario+"')");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Portal Director</title>
        <!--Chosen con bootsrap-->
        <link href="../css/chosen.css" rel="stylesheet" />
        <!-- BOOTSTRAP STYLES-->
        <link href="../css/bootstrap.css" rel="stylesheet" />
        <!-- FONTAWESOME STYLES-->
        <link href="../css/font-awesome.css" rel="stylesheet" />
        <!-- MORRIS CHART STYLES-->
        <link href="../js/morris/morris-0.4.3.min.css" rel="stylesheet" />
        <!--MODAL ESTILOS-->
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
        <!-- CUSTOM STYLES-->
        <link href="../css/custom.css" rel="stylesheet" />
        <!-- GOOGLE FONTS-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
        <script type="text/javascript" src="../js/jquery.js"></script>
        <script type="text/javascript" src="../js/jsocultar/ocultar.js"></script>

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
                     font-size: 16px;"> Ultim Conexion : 30 May 2014 &nbsp; <a href="#" class="btn btn-danger square-btn-adjust">Cerrar Sesion</a> 
                </div>
            </nav>   
            <!-- /. NAV TOP  -->
            <nav class="navbar-default navbar-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav" id="main-menu">
                        <li class="text-center">
                            <img src="../img/find_user.png" class="user-image img-responsive"/>
                        </li>
                        <li class="active">
                            <a  href="Validacion.jsp"><i class="fa fa-dashboard fa-3x"></i>Validacion</a>
                        </li>
                        <li>
                            <a  href="Convalidacion.jsp"><i class="fa fa-desktop fa-3x"></i>Convalidacion</a>
                        </li>
                        <li>
                            <a  href="#"><i class="fa fa-qrcode fa-3x"></i> Tabs y Panels</a>
                        </li>


                </div>

            </nav>  
            <!-- /. NAV SIDE  -->
            <div id="page-wrapper">
                <div class="row">
                   
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
<%}%>
