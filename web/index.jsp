<!DOCTYPE HTML>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title></title>
        <link rel="stylesheet" href="css/bootstrap.css" />
        <link rel="stylesheet" href="css/sing.css" />
    </head>
    <body>
        <div class="container">
            <div class="marco">
                <form class="form-signin" role="form" action="ControlUsuarios">
                    <h2 class="form-signin-heading text-center"><img src="img/logoing.png" class="img2 img-circle " alt="" /></h2>
                    <input type="text" class="form-control" placeholder="Correo Electronico" required autofocus name="usuario">
                    <input type="password" class="form-control" placeholder="Clave" required name="clave">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" value="remember-me"> Recordar
                        </label>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" >Iniciar</button>
                </form>
            </div>

        </div> <!-- /container -->

    </body>
</html>