<%-- 
    Document   : solicitudes
    Created on : 25-feb-2019, 10:58:15
    Author     : Geraldo
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../../partials/resource.jsp" />
        <title>BookTwoLife</title>
    </head>
    <body>
        <jsp:include page="partials/navbar.jsp" />
        <%List<String> solicitudelist = (List) session.getAttribute("solicitudelist");
            int i = 1;
        %>
        <div class="container">

            <table class="table">
                <thead>
                    <tr>
                        <th>Número</th>
                        <th>Cantidad de libros</th>
                        <th>Anunciante</th>
                        <th>Precio total</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (String elem : solicitudelist) {


                    %>
                    <tr>
                        <td><%=i%></td>
                        <td>23</td>
                        <td>Fernando</td>
                        <td>25€</td>
                        <td><%=elem%></td>
                    </tr>
                    <%i++;
                    }%>
                </tbody>
            </table>

        </div>
    </body>
</html>
