<%-- 
    Document   : Principal
    Created on : 23/10/2021, 12:43:06 a.m.
    Author     : DIDIER
--%>
<%
    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("ususession") == null) {
        response.sendRedirect("index.jsp");
    } else {
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <div class="container-fluid">
                <!--<a class="navbar-brand" href="#">Navbar</a>-->
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none " class="btn btn-outline-light" href="Controlador?menu=Principal&accion=Listar">Home</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none " class="btn btn-outline-light" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Producto</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none " class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none " class="btn btn-outline-light" href="Controlador?menu=Cliente&accion=Listar" target="myFrame">Clientes</a>
                        </li>
                        <!--GLITCH-->
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none " class="btn btn-outline-light" href="Controlador?menu=NuevaVenta&accion=default" target="myFrame">Nueva Venta</a>
                        </li>
                    </ul>
                    <!--77-->
                    <div class="dropdown">
                        <a href="#" style="margin-right: 40px; border: none;" class="btn btn-outline-light dropdown-toggle" data-toggle="dropdown">
                            ${usuario.getNom()}
                        </a>
                        <div class="dropdown-menu text-center">
                            <a>
                                <img src="img/user.jpg" alt="60" width="60"/>
                            </a>
                            <br>
                            <a>${usuario.getNom()}</a>
<!--                            <br>
                            <a>${telefono.getTel()}</a>-->
                            <div class="dropdown-divider"></div>
                            <a href="Validar?accion=salir">Salir</a>
                        
                    </div>
                </div>
            </div>
        </nav>
        <div class="m-4" style="height: 530px">
            <iframe name="myFrame" style="height: 100%; width: 100%; border: none"></iframe>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
    </body>
</html>
<% }%>