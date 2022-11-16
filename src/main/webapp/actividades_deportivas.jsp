<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ActividadesDeportivas</title>
    <link rel="stylesheet" href="styles/actividadesdeportivas.css">
    <!-- Link to the file hosted on your server, -->
    <link rel="stylesheet" href="JS/splide-4.1.3/dist/css/splide.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@200;300;700&family=Quicksand:wght@300;500;700&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="navbar.jsp" />
<div class="container">
    <div class="container-titulo">
        <h1>Actividades Deportivas</h1>
    </div>
    <main>
        <div class="searchAndSelect">
            <form action="ConsultaActividadDeportiva" method="post">
                <div class="form-floating">
                    <input type="text" class="form-control" name="queryActividad" id="text-nombre" placeholder="Buscar">
                    <input type="submit" class="form-control" hidden>
                    <label for="text-nombre">Buscar</label>
                </div>
            </form>
            <ol class="listaActividades">
                <jsp:useBean id="actividadesDeportivas" scope="request" type="java.util.List"/>
                <c:forEach items = "${actividadesDeportivas}" var = "actividad">
                    <a href="ConsultaActividadDeportiva?actividadDeportiva=${actividad.getNombre()}"><li class="list-group-item">${actividad.getNombre()}</li></a>
                </c:forEach>
            </ol>
        </div>
        <div class="data">
            <div class="subtitulo">
                <h2>Información</h2>
            </div>
            <div class="informacion row">
                <div class="col">
                    <div class="above-input-positioning nombre">
                        <label for="text-nombre">Nombre</label>
                        <input disabled type="text" class="form-control" id="actividaddeportiva_nombre" placeholder="Nombre" value="${actividadDeportiva.getNombre()}">
                    </div>
                    <div class="above-input-positioning costo">
                        <label for="text-costo">Costo</label>
                        <input disabled type="text" class="form-control" id="actividaddeportiva_costo" placeholder="Costo" value="${actividadDeportiva.getCosto()}">
                    </div>
                </div>
                <div class="col">
                    <div class="above-input-positioning duracion">
                        <label for="text-duracion">Duracion</label>
                        <input disabled type="text" class="form-control" id="actividaddeportiva_duracion" placeholder="Duracion" value="${actividadDeportiva.getDuracion()}">
                    </div>
                    <div class="above-input-positioning costo">
                        <label for="text-nombre">Fecha</label>
                        <input disabled type="date" class="form-control" id="actividaddeportiva_fecha" placeholder="Fecha" value="${actividadDeportiva.getFechaReg().toString().substring(0,10)}">
                    </div>
                </div>
                <div class="col">
                    <div class="above-input-positioning descripcion">
                        <label for="text-descripcion">Descripcion</label>
                        <textarea disabled class="form-control" id="actividaddeportiva_descripcion" placeholder="Descripcion">${actividadDeportiva.getDescripcion()}</textarea>
                    </div>
                </div>
            </div>

            <div class="carousel-clases row">
                <c:if test="${clasesActividad != null}">
                    <div class="container-clase-add">
                        <h2>Clases</h2>
                        <a href="AgregarClase?actividadDeportiva=${actividadDeportiva.getNombre()}">Agregar</a>
                    </div>

                    <section id="carousel-Clases" class="splide" aria-label="Splide Basic HTML Example">
                        <div class="splide__track">
                            <ul class="splide__list">
                                <c:forEach begin="0" end="${clasesActividad.size() - 1}" var="i">
                                    <div class="splide__slide">
                                        <img class="img_slider" src="assets/gym1.jpg" alt="Imagen Gym">
                                        <h2 class="title_slider">${clasesActividad[i].getNombre()}</h2>
                                        <p class="description_slider">${clasesActividad[i].getUrl()}</p>
                                        <a href="ConsultaClase?nombreClase=${clasesActividad[i].getNombre()}"><button class="view-content-slider-btn" type="button">Ver info</button></a>
                                    </div>
                                </c:forEach>
                            </ul>
                        </div>
                    </section>
                </c:if>
            </div>
        </div>

    </main>
</div>
<script src="JS/app.js"></script>
<%--Splide library--%>
<script src="JS/splide-4.1.3/dist/js/splide.min.js"></script>
<script>

    if(document.getElementById("carousel-Clases"))
    {
        const splideClases = new Splide( '#carousel-Clases', {
            type   : 'loop',
            drag   : 'free',
            focus  : 'center',
            snap: true,
            perPage: 3,
            autoScroll: {
                speed: 1,
            },
        } );

        if(splideClases) splideClases.mount();
    }

</script>
</body>
</html>