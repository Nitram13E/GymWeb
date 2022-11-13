<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ActividadesDeportivas</title>
        <link rel="stylesheet" href="styles/actividadesdeportivas.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@200;300;700&family=Quicksand:wght@300;500;700&display=swap" rel="stylesheet">
        </head>
    <body>
    <jsp:include page="navbar.jsp" />
    <div class="container-info-actividad">
        <div class="container-titulo">
            <h1>Actividades Deportivas</h1>
        </div>
        <main>
            <form action="ConsultaActividadDeportiva" method="get">
                <div class="form-floating">
                    <input type="text" class="form-control" id="text-nombre">
                    <label for="text-nombre">Buscar</label>
                </div>
                <div class="container-lista-actividades">
                    <ul class="list-group">
                        <jsp:useBean id="actividadesDeportivas" scope="request" type="java.util.List"/>
                        <c:forEach items = "${actividadesDeportivas}" var = "actividad">
                            <li class="list-group-item">${actividad.getNombre()}>
                                <a onclick=""></a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </form>
                <div class="data">
                    <div class="subtitulo">
                        <h2>Información</h2>
                    </div>
                    <div class="flex">
                        <div class="above-input-positioning">
                            <label for="nombre_actividad">Nombre</label>
                            <input type="text" id="nombre_actividad" disabled>

                            <label for="costo_actividad">Costo</label>
                            <input type="number" id="costo_actividad" disabled>
                        </div>
                        <div class="above-input-positioning">
                            <label for="duracion_actividad">Duracion</label>
                            <input type="time" id="duracion_actividad" disabled>

                            <label for="fecha_actividad">Fecha</label>
                            <input type="date" id="fecha_actividad" disabled>
                        </div>
                        <div class="above-input-positioning">
                            <label for="descripcion_actividad">Descripcion</label>
                            <textarea id="descripcion_actividad" disabled></textarea>
                        </div>
                    </div>
                    <div class="carousel-clases row">
                    </div>
                </div>
        </main>
    </div>
    <script src="app.js"></script>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
