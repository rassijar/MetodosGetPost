<%-- 
    Document   : UsuarioVTA
    Created on : 19/08/2021, 09:19:17 AM
    Author     : Morenofamily
--%>

<%@page import="modelo.dto.UsuarioDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Usuario</title>            
    </head>
    <body>
        <h1>Lista de usuarios: </h1>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Correo</th>
                    <th>Clave</th> 
                    <th>Rol</th>
                </tr>
            </thead>
            <tbody>
                <% Object lista= request.getAttribute("lista");
                   List<Object> listObj=(List) lista;
      
                   for(Object i: listObj){
                       UsuarioDTO usu= (UsuarioDTO)i;
                   
                %>
                <tr>
                    <td><%=usu.getId() %></td>
                    <td><%=usu.getNombre()%></td>
                    <td><%=usu.getCorreo()%></td>
                    <td><%=usu.getClave()%></td>
                    <td><%=usu.getRol()%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
