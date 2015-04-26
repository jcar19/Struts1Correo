<%-- 
    Document   : listar
    Created on : 26/04/2015, 05:20:18 AM
    Author     : Aula E3
--%>
<%@page import="com.myapp.struts.dao.beans.Mail"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Mail> lista = (List<Mail>) request.getAttribute("lista");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Correos!</h1>
        <a href="nuevo.do">Nuevo</a>
        <% if (lista != null) { %>
        <table border="1">
            <tr>
                <th>Asunto</th>
                <th>Cuerpo</th>
                <th>Remitente</th>
            </tr>
            <% for (Mail mails : lista) {%>
            <tr>
                <td><%= mails.getAsunto()%></td>
                <td><%= mails.getContenido()%></td>
                <td><%= mails.getRemitente()%></td>
            </tr>
            <% }%>

        </table>
        <% }%>
    </body>
</html>
