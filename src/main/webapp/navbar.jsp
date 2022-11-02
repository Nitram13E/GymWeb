<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>
<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">GymWeb</a>
        <ul class="nav justify-content-end">
            <c:if test="${sessionScope.usuario != null}">
                <c:if test="${sessionScope.esProfesor == true}">
                    <li class="nav-item">
                        <a class="nav-link active text-white text-decoration-none" aria-current="true" href="actividades_deportivas.jsp">Actividades Deportivas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white text-decoration-none" href="clases.jsp" >Clases</a>
                    </li>
                </c:if>
                <li class="nav-item dropdown">
                    <a id="profile-user-icon" class="nav-link dropdown-toggle text-white text-decoration-none" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                        <img src="profile-icon.png" width="30" height="30" class="rounded-circl">
                    </a>
                    <div id="dropdown-profile" class="dropdown-menu">
                        <a class="dropdown-item" href="#">Dashboard</a>
                        <a class="dropdown-item" href="perfil_usuario.jsp">Editar Perfil</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="${sessionScope.usuario = null}">Salir</a> <!-- TODO: Mejorar -->
                    </div>
                </li>
            </c:if>
            <c:if test="${sessionScope.usuario == null}">
                <li class="nav-item">
                    <a class="nav-link text-white text-decoration-none" href="login.jsp">Ingresar</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>