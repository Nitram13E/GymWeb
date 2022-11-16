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
            <div>
                <c:if test="${claseExistente != null}">
                    <h2>Usted ya se encuentra registrado a la clase: <span style="color: darkred">${claseExistente}</span></h2>
                </c:if>
                <div class="container-registrar-clase">
                    <div>
                        <h1>Institucion</h1>
                        <div class="container-lista-socios">
                            <ul class="list-group">
                                <c:forEach items = "${instituciones}" var = "institucion">
                                    <a href="RegistroClase?institucion=${institucion.getNombre()}"><li class="list-group-item">${institucion.getNombre()}</li></a>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                    <div>
                        <h1>Actividad</h1>
                        <div class="container-lista-socios">
                            <ul class="list-group">
                                <c:forEach items = "${actividades}" var = "actividad">
                                    <a href="RegistroClase?institucion=${sessionScope.institucion.getNombre()}&actividad=${actividad.getNombre()}"><li class="list-group-item">${actividad.getNombre()}</li></a>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                    <div>
                        <h1>Clase</h1>
                        <div class="container-lista-socios">
                            <ul class="list-group">
                                <c:forEach items = "${clases}" var = "clase">
                                    <a href="RegistroClase?institucion=${sessionScope.institucion.getNombre()}&actividad=${actividad.getNombre()}&clase=${clase.getNombre()}"><li class="list-group-item">${clase.getNombre()}</li></a>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="container-btns-profile">
                    <form action="RegistroClase" method="post">
                        <input style="display: none" type="text" name="nombreClase" value="${sessionScope.clase.getNombre()}">
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
<script>
    function triggerRegistroClase(elemento)
    {
        window.location = elemento.value;
    }
</script>
</body>
</html>
