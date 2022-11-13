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
                        <a class="nav-link active text-white text-decoration-none" aria-current="true" href="ConsultaActividadDeportiva">Actividades Deportivas</a>
                    </li>
                </c:if>
                <li class="nav-item dropdown">
                    <a id="profile-user-icon" class="nav-link dropdown-toggle text-white text-decoration-none" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        <c:choose>
                            <c:when test="${sessionScope.urlFoto != null}">
                                <img src="${sessionScope.urlFoto}" alt="img" width="30" height="30" class="rounded-circl">
                            </c:when>
                            <c:when test="${sessionScope.urlFoto == null}">
                                <img src="profile-icon.png" width="30" height="30" class="rounded-circl">
                            </c:when>
                        </c:choose>
                    </a>
                    <div id="dropdown-profile" class="dropdown-menu dropdown-menu-right">
                        <a class="dropdown-item" href="ConsultaUsuario">Dashboard</a>
                        <a class="dropdown-item" href="perfil_usuario.jsp">Editar Perfil</a>
                        <div class="dropdown-divider"></div>
                        <form action="CerrarSesion" method="post">
                            <button class="dropdown-item" type="submit">Salir</button>
                        </form>
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