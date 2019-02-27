<%-- 
    Document   : index
    Created on : 21-feb-2019, 12:14:19
    Author     : Geraldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="partials/resource.jsp" />
        <link rel="stylesheet" href="style/loginstyle.css"/>
        <title>Login</title>
    </head>
    <body>
        <div class="login-form">
            <form>
                <h2 class="text-center">Iniciar sesión</h2>       
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Nombre de usuario" required="required">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Contraseña" required="required">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Iniciar sesión</button>
                </div>
                        
            </form>
        </div>
    </body>
</html>
