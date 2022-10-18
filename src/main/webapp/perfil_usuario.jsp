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
        <title>GymWeb - Perfil</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp" />
        <section class="containerProfile">
            <div class="container-profile-information">
                <%--Logo information--%>
                <div class="profile-logo-information">
                    <img src="https://i.pinimg.com/originals/e4/2a/57/e42a57ad5659ea5f5b977aa0a75871f3.jpg" alt="">
                    <div class="profile-data-user">
                        <h1>Shifter24</h1>
                        <p>felipeviera3224@gmail.com</p>
                        <p>Cambiar foto de perfil</p>
                    </div>
                </div>

                <form id="profile-form" action="">
                    <%--User information Data--%>
                    <div class="user-information-data">
                        <div class="flex">
                            <div class="above-input-positioning">
                                <label for="name-user">Nombre</label>
                                <input type="text" name="nameUser" id="name-user">
                            </div>

                            <div class="above-input-positioning">
                                <label for="lastname-user">Apellido</label>
                                <input type="text" name="lastnameUser" id="lastname-user">
                            </div>
                        </div>

                        <div class="above-input-positioning">
                            <label for="birth-user">Fecha de nacimiento</label>
                            <input type="date" name="birthUser" id="birth-user">
                        </div>

                        <div class="flex">
                            <div class="above-input-positioning">
                                <label for="desc-user">Descripcion</label>
                                <textarea name="descriptionUser" id="desc-user"></textarea>
                            </div>

                            <div class="above-input-positioning">
                                <label for="bio-user">Biografia</label>
                                <textarea name="bioUser" id="bio-user"></textarea>
                            </div>
                        </div>

                        <div class="above-input-positioning">
                            <label for="website-user">Sitio Web</label>
                            <input type="text" name="websiteUser" id="website-user">
                        </div>

                        <div class="container-btns-profile">
                            <button type="submit">Guardar</button>
                            <a href="index.jsp"><button>Cancelar</button></a>
                        </div>
                    </div>
                </form>

            </div>
        </section>
<%--        <jsp:include page="footer.jsp"/>--%>
        <script src="app.js"></script>
    </body>
</html>
