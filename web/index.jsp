<!DOCTYPE HTML>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title></title>
        <link rel="stylesheet" href="css/bootstrap.css" />
        <link rel="stylesheet" href="css/sing.css" />
        <script type="text/javascript" src="js/dataTables/jquery.js"></script>
        <script type="text/javascript" src="js/inicio.js"></script>
        
    </head>
    <body>
        <div class="container">
            <div class="marco">
                <form class="form-signin" role="form" >
                    <h2 class="form-signin-heading text-center"><img src="img/logoing.png" class="img2 img-circle " alt="" /></h2>
                    <input type="text" class="form-control" placeholder="Correo Electronico" required autofocus id="usu">
                    <input type="password" class="form-control" placeholder="Clave" required  id="cla">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" value="remember-me"> Recordar
                        </label>
                    </div>
                    <div class="btn btn-lg btn-primary btn-block"   onclick="validar();" id="resultados">Iniciar</div>
                   
                </form>
            </div>

        </div> <!-- /container -->

    </body>
</html>