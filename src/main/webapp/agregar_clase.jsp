<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 24/9/2022
  Time: 2:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;300;400;500;700;800&display=swap" rel="stylesheet">
        <title>GymWeb - Agregar Clase</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp" />
        <section class="containerProfile">
            <div class="container-profile-information">

                <h1 id="title_clase">Registrar Clase</h1>

                <form id="profile-form" action="">
                    <%--User information Data--%>
                    <div class="user-information-data">

                        <label class="btn btn-default btn-file" id="label-upload-img-clase">
                            Subir foto <input id="upload-img-clase" name="imgClaseUpload" type="file" style="display: none;" required accept="image/png, image/gif, image/jpeg">
                        </label>

                        <div class="above-input-positioning">
                            <label for="institucion-clase">Institucion</label>
                            <input class="widthAuto" type="text" name="institucionClase" id="institucion-clase">
                        </div>

                        <div class="flex">

                            <div class="above-input-positioning">
                                <label for="name-user">Nombre</label>
                                <input type="text" name="nameUser" id="name-user">
                            </div>

                            <div class="above-input-positioning">
                                <label for="hora-clase">Hora</label>
                                <input type="text" name="horaClase" id="hora-clase">
                            </div>
                        </div>

                        <div class="above-input-positioning">
                            <label for="date-class">Fecha clase</label>
                            <input type="date" name="dateClass" id="date-class">
                        </div>

                        <div class="above-input-positioning">
                            <label for="url-clase">Url</label>
                            <input class="widthAuto" type="text" name="urlClase" id="url-clase">
                        </div>

                        <div class="container-btns-profile">
                            <button type="submit">Registrar</button>
                            <button><a href="index.jsp">Cancelar</a></button>
                        </div>
                    </div>
                </form>

            </div>
        </section>
<%--        <jsp:include page="footer.jsp"/>--%>
        <script src="app.js"></script>
    </body>
</html>
