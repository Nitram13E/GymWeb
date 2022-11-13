<%@ page import="publicadores.DtClase" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: PAP2022
  Date: 11/6/2022
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="styles/dashboard.scss">
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
    <aside>
        <div class="info-usuario">
            <img src="${sessionScope.urlFoto}" alt="avatar" class="avatar">
            <h1 class="nickname">${infoUsuario.getNickname()}</h1>
            <c:if test="${sessionScope.esProfesor == true}">
                <h4 class="tipo-usuario">Profesor</h4>
                <p class="descripcion">${infoUsuario.getDescripcion()}<p>
            </c:if>
            <c:if test="${sessionScope.esProfesor == false}">
                <h4 class="tipo-usuario">Socio</h4>
            </c:if>

            <div class="data-usuario">
                <div class="container-nombre">
                    <h5 class="nombre"><strong>Nombre</strong></h5>
                    <p class="nombre">${infoUsuario.getNombre()}</p>
                </div>
                <div class="container-apellido">
                    <h5 class="apellido"><strong>Apellido</strong></h5>
                    <p class="apellido">${infoUsuario.getApellido()}</p>
                </div>
            </div>
            <h5 class="email"><strong>Email</strong></h5>
            <dib class="email-usuario">
                <p class="email">${infoUsuario.getMail()}</p>
            </dib>
        </div>
    </aside>
    <main class="main-container">
        <c:if test="${sessionScope.esProfesor == true && ((actividadesProfesor != null) && (!actividadesProfesor.isEmpty()))}">
            <div class="container-actividades"> <!--CONTAINER ACTIVIDADES-->
                <h1 class="title_primary_carousel">Actividades Deportivas</h1>
                <section id="carousel-Actividades" class="splide" aria-label="Splide Basic HTML Example">
                    <div class="splide__track">
                        <ul class="splide__list">
                            <c:forEach begin="0" end="${actividadesProfesor.size() - 1}" var="i">
                                <div class="splide__slide">
                                    <img class="img_slider" src="assets/gym1.jpg" alt="Imagen Gym">
                                    <h2 class="title_slider">${actividadesProfesor[i].getNombre()}</h2>
                                    <p class="description_slider">${actividadesProfesor[i].getDescripcion()}</p>
                                    <a href="ConsultaActividadDeportiva?actividadDeportiva=${actividadesProfesor[i].getNombre()}"><button class="view-content-slider-btn" type="button">Ver info</button></a>
                                    <a href="ConsultaUsuario?actividadDeportiva=${actividadesProfesor[i].getNombre()}"><button class="view-content-slider-btn" type="button">Ver clase</button></a>
                                </div>
                            </c:forEach>
                        </ul>
                    </div>
                </section>
            </div>
        </c:if>

        <c:if test="${clasesActividad != null || clasesSocio != null}">
            <div class="container-clases"> <!--CONTAINER CLASES-->
                <h1 class="title_primary_carousel">Clases</h1>
                <section id="carousel-Clases" class="splide" aria-label="Splide Basic HTML Example">
                    <div class="splide__track">
                        <ul class="splide__list">
                            <!--Clases socio-->
                            <c:if test="${clasesSocio != null}">
                                <c:forEach begin="0" end="${clasesSocio.size() - 1}" var="i">
                                    <div class="splide__slide">
                                        <img class="img_slider" src="assets/gym1.jpg" alt="Imagen Gym">
                                        <h2 class="title_slider">${clasesSocio[i].getNombre()}</h2>
                                        <p class="description_slider">${clasesSocio[i].getUrl()}</p>
                                        <a href="ConsultaClase?nombreClase=${clasesSocio[i].getNombre()}"><button class="view-content-slider-btn" type="button">Ver info</button></a>
                                    </div>
                                </c:forEach>
                            </c:if>

                            <!--Actividad profesor-->
                            <c:if test="${clasesActividad != null}">
                                <c:forEach begin="0" end="${clasesActividad.size() - 1}" var="i">
                                    <div class="splide__slide">
                                        <img class="img_slider" src="assets/gym1.jpg" alt="Imagen Gym">
                                        <h2 class="title_slider">${clasesActividad[i].getNombre()}</h2>
                                        <p class="description_slider">${clasesActividad[i].getUrl()}</p>
                                        <a href="ConsultaClase?nombreClase=${clasesActividad[i].getNombre()}"><button class="view-content-slider-btn" type="button">Ver info</button></a>
                                    </div>
                                </c:forEach>
                            </c:if>
                        </ul>
                    </div>
                </section>
            </div>
        </c:if>

        <c:if test="${clasesActividad == null && clasesSocio == null}">
            <h1 id="#empty-message-act-clase">No se encontraron Actividades o clases asociadas!</h1>
        </c:if>
    </main>
</div>
<%--Splide library--%>
<script src="JS/splide-4.1.3/dist/js/splide.min.js"></script>

<script>

    if(document.getElementById("carousel-Actividades"))
    {
        const splideAct = new Splide( '#carousel-Actividades', {
            type   : 'loop',
            drag   : 'free',
            focus  : 'center',
            snap: true,
            perPage: 3,
            autoScroll: {
                speed: 1,
            },
        } );

        if(splideAct) splideAct.mount();
    }

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

<script src="JS/app.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>
