<%-- 
    Document   : nuevo
    Created on : 26/04/2015, 05:20:39 AM
    Author     : Aula E3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo!</h1>
        <form action="nuevoInsert.do">
            <table>
                <tr>
                    <td>Destino:</td>
                    <td><input type="text" name="destino" /></td>
                </tr>
                <tr>
                    <td>Asunto:</td>
                    <td><input type="text" name="asunto" /></td>
                </tr>
                <tr>
                    <td>Mensaje</td>
                    <td><textarea name="contenido" cols="26" rows="8"></textarea><</td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit">Enviar</button></td>
                </tr>
            </table>                        
        </form>      
    </body>
</html>
