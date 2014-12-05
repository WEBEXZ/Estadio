<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
    
        <h1>MÓDULO DE SEGURIDAD</h1>
    <center>
        <form>
                CLAVE:
                <input type="text" name="sclave" size="15" id="sclave">
        </form>
        
        <div id="encontrar"><h1 id="encontrado"></h1></div>
        
        <%
        Class.forName("com.mysql.jdbc.Driver");
        String base_datos = "feliciano";
        String usuario = "feliciano";
        String contrasena = "alebrijes";
        String url = "jdbc:mysql://localhost:3307/feliciano?autoReconnect=true"+base_datos; 
        Connection  conexion = DriverManager.getConnection(url,usuario,contrasena);
        Statement Estamento = conexion.createStatement();
        ResultSet rs = Estamento.executeQuery("select * from seguridad");
        out.println("<table border=2>");
        out.println("<tr><th>CLAVE</th><th>ZONA</th><th>AREA</th><th>VERSUS</th><th>TIPO</th><th>FECHA_COMPRA</th><th>CANTIDAD_BOLETOS</th><th>TOTAL</th></tr>");
        while (rs.next()) 
        {
            out.println("<tr>");
            out.println("<td>");    
            out.println(rs.getString("CLAVE"));
            out.println("</td><td>");
            out.println(rs.getString("ZONA"));
            out.println("</td><td>");
            out.println(rs.getString("AREA"));
            out.println("</td><td>");
            out.println(rs.getString("VERSUS"));
            out.println("</td><td>");
            out.println(rs.getString("TIPO"));
            out.println("</td><td>");
            out.println(rs.getString("FECHA_COMPRA"));
            out.println("</td><td>");
            out.println(rs.getString("CANTIDAD_BOLETOS"));
            out.println("</td><td>");
            out.println(rs.getString("TOTAL"));
            out.println("</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        rs.close();
        Estamento.close();
        conexion.close();
        %>
    </center>
    </body>
</html>
