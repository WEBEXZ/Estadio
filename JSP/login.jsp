<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ESTADIO TECNOLÓGICO DE OAXACA</title>
        <link rel="stylesheet" type="text/css" href="./Estilos/style.css">
        <script src="./JavaScript/jquery-1.11.1.js" type="text/javascript"></script>
        <script type="text/javascript" src="./JavaScript/ajax.js"></script>
    </head>
    <body>
        <center>
            <h1>LOGIN DE USUARIOS</h1>
            <h2>ACCESO: <%=new Date()%></h2>
            <form id="form1" action="JqueryServlet" method="POST">
                <label for="user">USUARIO:</label>
                <input type="text" name="usuario" size="15" id="usuario"><br/>
                <label for="pass">CONTRASEÑA:</label>
                <input type="password" name="contrasena" size="15" id="contrasena"><br/>
                <input type="submit" value="ENVIAR" name="boton" />
                <br/><br/>
                
                <div id="mensaje"></div>
            </form>
        </center>
    </body>
</html>