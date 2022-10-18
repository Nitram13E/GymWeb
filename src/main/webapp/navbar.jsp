<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">GymWeb</a>
        <ul class="nav justify-content-end">
            <li class="nav-item">
                <a class="nav-link active text-white text-decoration-none" aria-current="true" href="actividades_deportivas.jsp">Actividades Deportivas</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white text-decoration-none" href="clases.jsp" >Clases</a>
            </li>
            <li class="nav-item dropdown">
                <a id="profile-user-icon" class="nav-link dropdown-toggle text-white text-decoration-none" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    <img src="profile-icon.png" width="30" height="30" class="rounded-circl">
                </a>
                <div id="dropdown-profile" class="dropdown-menu">
                    <a class="dropdown-item" href="#">Dashboard</a>
                    <a class="dropdown-item" href="perfil_usuario.jsp">Editar Perfil</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="index.jsp">Salir</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white text-decoration-none" href="login.jsp">Ingresar</a>
            </li>
        </ul>
    </div>
</nav>