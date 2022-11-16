<%@ page import="publicadores.DtClase" %>
<%@ page import="java.util.List" %>
<%@ page import="publicadores.DtActividadDeportiva" %>
<%@ page import="publicadores.PublicadorActividadDeportiva" %><%--
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
    <title>Ranking</title>
    <link rel="stylesheet" href="styles/nav.css">
    <link rel="stylesheet" href="styles/ranking.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@200;300;700&family=Quicksand:wght@300;500;700&display=swap" rel="stylesheet">
    <!--agrego estilo splide (paso II)-->
    <link rel="stylesheet" href="JS/splide-4.1.3/dist/css/splide.min.css">
</head>
<body>
<!--agrego splide (paso I)-->

<div class="container">
    <jsp:include page="navbar.jsp" />
    <!--Carruseles-->
    <main class="main-container">
        <div class="container-actividades"> <!--CONTAINER ACTIVIDADES-->
            <div class="label">
                <h1>Ranking Actividades</h1>
            </div>
            <section id="splide_actividades" class="splide splide_actividades" aria-label="Splide Actividades">
                <div class="splide__track">
                    <ul class="splide__list">
                        <c:forEach var="i" begin="0" end="${rankingActividades.size()-1}">
                            <li class="splide__slide">
                                <img src="assets/yoga.jpg" class="img-fluid"  alt="imagenGenerica">
                                <h5>${i+1}. ${rankingActividades[i].getNombre()}</h5>
                                <p>${rankingActividades[i].getDescripcion()}</p>
                                <p>$UYU ${rankingActividades[i].getCosto()}</p>

                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </section>
        </div>
        <div class="container-clases"> <!--CONTAINER CLASES-->
            <div class="label">
                <h1>Ranking Clases</h1>
            </div>
            <section id="splide_clases" class="splide splide_clases" aria-label="Splide Clases">
                <div class="splide__track">
                    <ul class="splide__list">
                        <c:forEach var = "i" begin="0" end="${rankingClases.size()-1}">
                        <li class="splide__slide">
                            <img src="assets/pilates.jpg" class="img-fluid" alt="">
                            <p>${i+1}. ${rankingClases[i].getNombre()}</p>
                            <p>${rankingClases[i].getUrl()}</p>
                            <p>${rankingClases[i].getFecha()}</p>
                        </li>
                        </c:forEach>
                    </ul>
                </div>
            </section>
        </div>
    </main>
    <jsp:include page="footer.jsp"/>
</div>
<script src="JS/app.js"></script>
<script src="JS/splide-4.1.3/dist/js/splide.min.js"></script>
<script>
    /*if(document.getElementById('splide_actividades'));*/

    const splideActividades = new Splide( '#splide_actividades', {
        drag   : 'free',
        focus  : 'center',
        snap: true,
        perPage: 3,
        autoScroll: {
            speed: 1,
        },
    } );
    splideActividades.mount();

    const splideClases = new Splide( '#splide_clases', {
        drag   : 'free',
        focus  : 'center',
        snap: true,
        perPage: 3,
        autoScroll: {
            speed: 1,
        },
    } );
    splideClases.mount();

</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>