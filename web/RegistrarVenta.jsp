<%-- 
    Document   : RegistrarVenta
    Created on : 2/11/2021, 10:13:24 p.m.
    Author     : DIDIER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <title>JSP Page</title>
        <style>
            @media print{
                .parte01,.btn, .accion{
                    display: none;
                }
            }
        </style>
    </head>
    <body>

        <div class="d-flex">
            <div class="col-sm-5 parte01">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <div class="form_goup">
                                <label>Datos Del Cliente</label>
                            </div>
                            <div class="form_goup d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="CodigoCliente" value="${c.getDni()}" class="form-control" placeholder="Codigo" >
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">
                                </div>

                                <div class="col-sm-6">
                                    <input type="text" name="nombrescliente" value="${c.getNom()}" class="form-control"  placeholder="Datos Cliente" >
                                </div>
                            </div>
                            <div class="form_goup">
                                <label>Datos Producto</label>
                            </div>
                            <!--1-->
                            <div class="form_goup d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="CodigoProducto" value="${Producto.getId()}" class="form-control" placeholder="Codigo" >
                                    <input type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info"placeholder="Buscar">
                                    <!--<button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info"placeholder="Buscar"></button>-->
                                </div>

                                <div class="col-sm-6">
                                    <input type="text" name="nomproducto" value="${producto.getNom()}" class="form-control"  placeholder="Datos Producto" >
                                </div>
                            </div>
                            <!--2-->
                            <div class="form_goup d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="Precio" value="${producto.getPre()}" class="form-control" placeholder="$/.0.00" >
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" name="cant" placeholder="" value="1" class="form-control">
                                </div>

                                <div class="col-sm-3">
                                    <input type="text" name="stock" value="${producto.getStock()}" class="form-control"  placeholder="Stock">
                                </div>
                            </div>
                            <!--BOTON AGREGAR-->
                            <div class="form_goup">
                                <input type="submit" name="accion" value="Agregar" class="btn btn-outline-info">
                                <!--<button type="submit" name="accion" value="Agregar" class="btn btn-outline-info"></button>-->
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!----------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

            <div class="col-sm-8 d-flex">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-5 ml-auto">
                            <label>Numero.Serie: </label>
                            <input type="text" name=""NroSerie value="${nserie}" class="form-control">
                        </div>
                        <br>

                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>NRO</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>
                                    <th class="accion">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="List" items="${lista}">
                                    <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getIdproducto()}</td>
                                        <td>${list.getDescripcionP()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <td>${list.getCantidad()}</td>
                                        <td>${list.getSubtotal()}</td>
                                        <td class="d-flex">
                                            <a class="btn btn-warning">Editar</a>
                                            <a class="btn btn-danger" style="margin-left: 10px;">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">

                        <div class="col-sm-6">
                            <a href="Controlador?menu=NuevaVenta&acciom=GenerarVenta" onclick="print()" class="btn btn-success">Generar Venta</a>
                            <input type="submit" name="accion" value="Cancelar"class="btn btn-danger">
                        </div>
                        <div class="col-sm-4 nl-auto">
                            <input type="text" name="txtTotal" value="$/. ${totalPagar}" class="form-control">
                        </div>

                    </div>
                </div>

            </div>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
    </body>
</html>
