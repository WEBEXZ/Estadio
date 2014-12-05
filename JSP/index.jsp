<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ESTADIO TECNOLÓGICO DE OAXACA</title>
        <link rel="stylesheet" type="text/css" href="./Estilos/style.css">
    </head>
    <body>
        <h1><marquee>ESTADIO TECNOLÓGICO DE OAXACA</marquee></h1>
        
    <center>
        <div id="menu">
            <nav>
            <ul>
		<li class="active"><a href="index.jsp">HOME</a></li>
		<li><a href="login.jsp">LOGIN</a></li>
		<li><a href="ventas.jsp">COMPRAR</a></li>
            </ul>
            </nav>
        </div>
    </center>
        
    <center><img name="miImagen" id='imgMostrar' WIDTH=478 HEIGHT=350></center>
        <script>
            i = 0;
            direccion = new Array();
            direccion[0] = "./Imagenes/1.JPG"
            direccion[1] = "./Imagenes/2.jpg";
            direccion[2] = "./Imagenes/3.jpg";

            function cambiaIMG()
            {
                i = i+1;
                if(i == direccion.length)i = 0;
                document.images.miImagen.src = direccion[i];
                setTimeout('cambiaIMG()',2000)
            }; cambiaIMG()
        </script>
    </body>
</html>
