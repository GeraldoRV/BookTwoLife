<%-- 
    Document   : main
    Created on : 21-feb-2019, 12:42:55
    Author     : Geraldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../../partials/resource.jsp" />
        <link rel="stylesheet" href="/BookTwoLife/views/buyer/style/mainstyle.css"/>
        <title>BookTwoLife</title>
    </head>
    <body>
        <jsp:include page="partials/navbar.jsp" />
        <div class="container py-2">
            <ul class="list-group">
                <li class="list-group-item">
                    <h5>El Principito</h5> 
                    <p>El principito es un cuento poético que viene acompañado
                        de ilustraciones hechas con acuarelas por el mismo Saint-Exupéry. 
                        En él, un piloto se encuentra perdido...</p>
                    <small>3 €</small>
                    <div class="button">
                        <form action="/BookTwoLife/FrontController">                   
                            <input type="hidden" name="command" value="AddToCartCommand">
                            <input type="hidden" name="name" value="Principito">
                            <button type="submit" class="btn btn-warning">Añadir al carrito</button>
                        </form>
                        <form action="/BookTwoLife/FrontController">                   
                            <input type="hidden" name="command" value="TransformViewCommand">
                            <input type="hidden" name="name" value="Principito">
                            <button type="submit" class="btn btn-outline-warning">Ver detalles</button>
                        </form>
                        <form action="/BookTwoLife/FrontController">                   
                            <input type="hidden" name="command" value="TwoStepViewCommand">
                            <input type="hidden" name="name" value="Laura">
                            <button type="submit" class="btn btn-warning">Información del vendedor</button>
                        </form>
                    </div>
                </li>
                <li class="list-group-item">
                    <h5>Don Quijote</h5> 
                    <p>En un lugar de la mancha...</p>
                    <small>3 €</small>
                    <div class="button">
                        <form action="/BookTwoLife/FrontController">                   
                            <input type="hidden" name="command" value="AddToCartCommand">
                            <input type="hidden" name="name" value="Quijote">
                            <button type="submit" class="btn btn-warning">Añadir al carrito</button>
                        </form>
                        <form action="/BookTwoLife/FrontController">                   
                            <input type="hidden" name="command" value="TransformViewCommand">
                            <input type="hidden" name="name" value="Quijote">
                            <button type="submit" class="btn btn-outline-warning">Ver detalles</button>
                        </form>
                        <form action="/BookTwoLife/FrontController">                   
                            <input type="hidden" name="command" value="TwoStepViewCommand">
                            <input type="hidden" name="name" value="Marco">
                            <button type="submit" class="btn btn-warning">Información del vendedor</button>
                        </form>
                    </div>
                </li>
                <li class="list-group-item">
                    <h5>50 Sombras de Gray</h5> 
                    <p>+ 18</p>
                    <small>3 €</small>
                    <div class="button">
                        <form action="/BookTwoLife/FrontController">                   
                            <input type="hidden" name="command" value="AddToCartCommand">
                            <input type="hidden" name="name" value="Sombras">
                            <button type="submit" class="btn btn-warning">Añadir al carrito</button>
                        </form>
                        <form action="/BookTwoLife/FrontController">                   
                            <input type="hidden" name="command" value="TransformViewCommand">
                            <input type="hidden" name="name" value="Sombras">
                            <button type="submit" class="btn btn-outline-warning">Ver detalles</button>
                        </form>
                        <form action="/BookTwoLife/FrontController">                   
                            <input type="hidden" name="command" value="TwoStepViewCommand">
                            <input type="hidden" name="name" value="Juan">
                            <button type="submit" class="btn btn-warning">Información del vendedor</button>
                        </form>
                    </div>
                </li>
            </ul>
        </div>
    </body>
</html>
