<%-- 
    Document   : solicitudes
    Created on : 25-feb-2019, 10:58:15
    Author     : Geraldo
--%>

<%@page import="model.Solicitude"%>
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
        <%List<Solicitude> solicitudelist = (List) session.getAttribute("solicitudeslist"); %>

        <%if (solicitudelist == null) {%>
        <h1>No hay</h1>
        <%   } else {
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
                    <%for (Solicitude elem : solicitudelist) {%>
                    <tr>
                        <td><%=elem.getIndex()%></td>
                        <td><%=elem.getBooks().size()%></td>
                        <td><%=elem.getSeller()%></td>
                        <td>25€</td>

                        <td><%=elem.getStatus()%>
                            <%if (elem.getStatus().equals("Compra aprobada")) {%>
                            <form action="/BookTwoLife/FrontController">
                                <input type="hidden" name="command" value="PayCommand">
                                <button type="submit" 
                                        class="btn btn-warning">Pagar Compra</button>
                            </form>
                            <%}%>
                        <td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
            <%}%>
        </div>
    </body>
</html>
