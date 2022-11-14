<%--
  Created by IntelliJ IDEA.
  User: PAP2022
  Date: 11/13/2022
  Time: 6:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/registro_clase.scss">
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
        <h1>Registro Clase</h1>
    </div>
    <section>
        <div class="container-info-clase">

            <div class="container-registrar-clase">
                <div class="above-input-positioning">
                    <label for="select-institucion">Institucion</label>
                    <select name="" id="select-institucion">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                    </select>
                </div>

                <div class="above-input-positioning">
                    <label for="select-actividadDeportiva">Actividad</label>
                    <select name="" id="select-actividadDeportiva">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                    </select>
                </div>

                <div class="above-input-positioning">
                    <label for="select-clase-act">Clase</label>
                    <select name="" id="select-clase-act">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                    </select>
                </div>

                <div class="container-btns-profile">
                    <form action="ConsultaRegistro" method="post">
                        <button type="submit">Registrar</button>
                    </form>
                    <button><a href="index.jsp">Cancelar</a></button>
                </div>
            </div>

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
        </div>
    </section>

</div>
<%--    <jsp:include page="footer.jsp"/>--%>
<script src="JS/app.js"></script>
</body>
</html>
