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
    <link rel="stylesheet" href="styles/dashboard.css">

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
        <div class="container-actividades"> <!--CONTAINER ACTIVIDADES-->
            <c:if test="${sessionScope.esProfesor == true}">
                <div id="carousel-Actividades" class="carousel slide" data-bs-ride="false">
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carousel-Actividades" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carousel-Actividades" data-bs-slide-to="1" aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carousel-Actividades" data-bs-slide-to="2" aria-label="Slide 3"></button>
                    </div>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/Slides/img%20(15).webp" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>First slide label</h5>
                                <p>Some representative placeholder content for the first slide.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/Slides/img%20(22).webp" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Second slide label</h5>
                                <p>Some representative placeholder content for the second slide.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/Slides/img%20(23).webp" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Third slide label</h5>
                                <p>Some representative placeholder content for the third slide.</p>
                            </div>
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carousel-Actividades" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carousel-Actividades" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </c:if>
        </div>
        <div class="container-clases"> <!--CONTAINER CLASES-->
            <div id="carouselClases" class="carousel slide" data-bs-ride="false">
                <div class="carousel-indicators">
                    <%List<DtClase> clasesSocio = (List<DtClase>) request.getAttribute("clasesSocio");%>
                    <c:forEach var = "i" begin="0" end="${clasesSocio.size() - 1}">
                        <button type="button" data-bs-target="#carouselClases" data-bs-slide-to="${i}" aria-label="Slide ${i+1}" <c:if test="${i == 0}">class="active"</c:if>></button>
                    </c:forEach>
                </div>
                <div class="carousel-inner">
                    <c:forEach items = "${clasesSocio}" var = "clase">
                        <a href="ConsultaClase?nombreClase=${clase.getNombre()}">
                            <div class="carousel-item active">
                                <img src="https://mdbcdn.b-cdn.net/img/Photos/Slides/img%20(15).webp" class="d-block w-100" alt="...">
                                <div class="carousel-caption d-none d-md-block">
                                    <h5>${clase.getNombre()}</h5>
                                    <p>${clase.getUrl()}</p>
                                </div>
                            </div>
                        </a>
                    </c:forEach>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselClases" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselClases" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
    </main>
    <footer>
    </footer>
</div>
</body>
<script src="app.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</html>
