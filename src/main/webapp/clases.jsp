<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="publicadores.Registro" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="clase" scope="request" type="publicadores.DtClase"/>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;300;400;500;700;800&display=swap" rel="stylesheet">
        <title>GymWeb - Clases</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp" />
        <div class="container-clases">
            <div class="container-title">
                <h1>Clase</h1>
            </div>
            <div class="container-info-clase">
                <form action="ConsultaClase" method="post">
                    <div class="container-informacion-registro-clase">
                        <h1>Informacion</h1>
                        <div class="flex">
                            <div class="above-input-positioning">
                                <label for="nombre-clase">Nombre</label>
                                <input id="nombre-clase" name="nombreClase" type="text" value="${clase.getNombre()}" disabled>

                                <label for="hora-clase">Hora</label>
                                <input id="hora-clase" name="horaClase" type="text" value=${clase.getHoraInicio().toString().substring(11,19)} disabled>
                            </div>

                            <div class="above-input-positioning">
                                <label for="fecha-registro-clase">Fecha de registro</label>
                                <input id="fecha-registro-clase" name="fechaRegistroClase" type="text" value=${clase.getFechaReg().toString().substring(0,10)} disabled>

                                <label for="fecha-inicio-clase">Fecha de clase</label>
                                <input id="fecha-inicio-clase" name="fechaInicioClase" type="text" value=${clase.getFecha().toString().substring(0,10)} disabled>
                            </div>
                        </div>

                        <div class="above-input-positioning">
                            <label for="url-registro-clase">Url</label>
                            <input id="url-registro-clase" name="urlRegistroClase" type="text" value=${clase.getUrl()} disabled>
                        </div>
                    </div>

                    <div>
                        <h1>Socios</h1>
                        <div class="container-lista-socios">
                            <ul class="list-group">
                                <jsp:useBean id="registros" scope="request" type="java.util.List"/>
                                <c:forEach items = "${registros}" var = "registro">
                                    <li class="list-group-item">${registro.getSocio()}</li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    <%--    <jsp:include page="footer.jsp"/>--%>
        <script src="app.js"></script>
    </body>
</html>
