<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="Acciones.Partidos"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    
        <h1>MÓDULO DE VENTAS</h1>
    <center>
        <h2>FECHA: <%=new Date()%></h2>
        <form id="form2" action="Enviar" method="POST">
        <table> 
            <tr> 
                <th><br/>TIPO DE VENTA:<br/><br/></th> 
                <th><br/><select name="stipo_venta" id="stipo_venta">
                            <option>NORMAL</option>
                            <option>PREVENTA</option>
                        </select><br/><br/></th> 
            </tr> 

            <tr>
                <th><br/>PARTIDO:<br/><br/></th>
                <th><br/><select name="partido" id="partido">
                            <option value="0" selected>---SELECCIONE PARTIDO---</option>
                            <%
                                Class.forName("com.mysql.jdbc.Driver");
                                String base_datos = "feliciano";
                                String usuario = "feliciano";
                                String contrasena = "alebrijes";
                                String url = "jdbc:mysql://localhost:3307/feliciano?autoReconnect=true"+base_datos; 
                                Connection  conexion = DriverManager.getConnection(url,usuario,contrasena);
                                Statement Estamento = conexion.createStatement();
                                ResultSet rs = Estamento.executeQuery("SELECT visitante FROM partidos;");
                                int a=0;
                                while (rs.next()) 
                                {
                                    a+= 1;
                                    String visitante = rs.getString("visitante");
                                    out.print("<option value="+'"'+a+'"'+">ALEBRIJES VS "+visitante+"</option>");
                                }
                                rs.close();
                                Estamento.close();
                                conexion.close();
                            %>
                        </select><br/><br/></th>
            </tr>
            
            <tr>
                <th><br/>FECHA:<br/><br/></th>
                <th><br/><input type="text" name="hora" value="NO HAY PARTIDO" id="hora" disabled="" /><br/><br/></th>
            </tr>

            <tr>
                <th><br/>AREA:<br/><br/></th>
                <th><br/><select name="area" id="area">
                            <option value="0" selected>---SELECCIONE AREA---</option>
                            <option value="1">ALTA</option>
                            <option value="2">BAJA</option>
                            <option value="3">CENTRAL</option>
                            <option value="4">VIP</option>
                            <option value="5">PALCOS</option>
                        </select><br/><br/></th>
            </tr>
            
            <tr>
                <th><br/>ZONA:<br/><br/></th>
                <th><br/><select name="zona" id="zona">
                            <option value="0" selected>---SELECCIONE ZONA---</option>
                            <option value="1">GOL NORTE</option>
                            <option value="2">GOL SUR</option>
                            <option value="3">GENERAL</option>
                            <option value="4">PREFERENTE</option>
                        </select><br/><br/></th>
            </tr>
            
            <tr>
                <th><br/>BOLETOS DISPONIBLES:<br/><br/></th>
                <th><br/><input type="text" name="result" value="NO EXISTE DICHA RELACIÓN" id="b_disponibles" disabled="" /><br/><br/></th>
                
            </tr>

            <tr>
                <th><br/>NOMBRE:<br/><br/></th>
                <th><br/><input type="text" name="nombre" value="" id="nombre" /><br/><br/></th>
            </tr>   

            <tr>
                <th><br/>CANTIDAD DE BOLETOS:<br/><br/></th>
                <th><br/><input type="text" name="cantidad" value="0" id="cantidad" /><br/><br/></th>
            </tr>

            <tr>
                <th><br/>DESCUENTO:<br/><br/></th>
                <th><br/><select name="descuento" id="descuento">
                            <option value="0" selected>---SELECCIONA DESCUENTO---
                            <option value="Ordinario">ORDINARIO</option>
                            <option value="Estudiante">ESTUDIANTE</option>
                            <option value="Nino">NIÑO</option>
                        </select><br/><br/></th>
            </tr>
        </table> 
        <br/><br/>
        <input type="submit" value="ENVIAR" name="boton" id="boton"/>
        <div id="respuestas"><h1 id="respuesta"></h1></div>
        </form>
    </center>
    </body>
</html>
