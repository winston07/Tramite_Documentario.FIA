<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Portal Secretaria</title>
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
        <!--tabla ingreso validacion secretaria -->
        <link rel="stylesheet" type="text/css" href="../css/estilos.css">
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <!-- descargadoo ya ! error <script type="text/javascript" src="js/jquery.min.js"></script>-->
        <script type="text/javascript" src="../js/manipulacion.js"></script>
        <script type="text/javascript" src="../js/efec.js" ></script>
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
                    var diasSemana = new Array("Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado");
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
                        
                        <!--ingrese datos tabla-->  
                        <p>Registro de Convalidacion del Alumno</p>
<center>
    
    <form action="" method="post" name="formulario" id="formulario">
        <p>
            <strong> Universidad</strong>
            <input class="text-box" name="universidad" type="text" id="unversidad" size="20" maxlength="50" />
        <strong> Facultad</strong>
            <input class="text-box" name="facultad" type="text" id="facultad" size="20" maxlength="50" />
            <strong> Escuela  Profesional</strong>
        <input class="text-box" name="escuela" type="text" id="escuela" size="20" maxlength="50" />

        <p><strong >Codigo </strong>
        <input class="text-box" name="Codigo" type="text" id="codigo" size="20" maxlength="50" />
    <strong>Plan</strong>
        <input class="text-box" name="plan" type="text" id="plan" size="5" maxlength="50" />
    <strong>Plan Nuevo</strong>
        <input class="text-box" name="plannuevo" type="text" id="plannuevo" size="5" maxlength="50" />
    </p>
  <p><strong>Nombres:</strong>
    <input  class="text-box" name="descripcion" id="nombre" size="20" maxlength="50">
    <strong>Apellidos:</strong>
    <input  class="text-box" name="apellidos" id="apellidos" size="30" maxlength="50"/>
  </p>
</form><br/>
    <!--INGRESO DE TRABLA JQUERY -->
    <!--<a href="#" onClick="return false" onmouseOver="alert('Ingrese cursos del alumno ')">
    <img src="../img/interrogacion.png" width="45" height="45">-->
    <table border='1'>
    <div id="divContenedor" >
		
        <div id="divContenedorTabla" >
            <table align="center" width="800" class="table-responsive">
                            <caption>Plan academico </caption>
				<thead>
					<tr>
				<th>Ciclo</th><th>Nombre Curso</th><th>CR</th><th>HT</th><th>TH</th><th>HNP</th><th>Nota</th><th width="40">&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<tr>
                                            <td><input type="text"  size="3"class="clsAnchoTotal form-control "></td>
						<td><input type="text" size="20" class="clsAnchoTotal form-control"></td>
						<td><input type="text" size="3"class="clsAnchoTotal form-control"></td>
                                                <td><input type="text" size="3"class="clsAnchoTotal form-control"></td>
                                                <td><input type="text"size="3" class="clsAnchoTotal form-control"></td>
						<td><input type="text" size="3"class="clsAnchoTotal form-control"></td>
                                                <td><input type="text" size="3"class="clsAnchoTotal form-control"></td>
						<td align="right"><input type="button" value="-" class="clsEliminarFila btn btn-danger"></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4" align="right" >
							<input type="button" value="Agregar una fila" class="clsAgregarFila btn btn-default" >
							<!--<input type="button" value="Clonar la tabla" class="clsClonarTabla">
							<input type="button" value="Eliminar la tabla" class="clsEliminarTabla">-->
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>

    </table>
                    
    <p>
    <center>
    <div>
        <input type="button" class="btn btn-success"name="ingresar" id="enviar" value="ingresar" />
      <input type="button" class="btn btn-danger"name="cancelar" id="cancelar" value="Cancelar" />
    
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


    </body>
</html>
