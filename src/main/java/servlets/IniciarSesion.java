package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import publicadores.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@WebServlet(name = "IniciarSesion", value = "/IniciarSesion")
public class IniciarSesion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            DtUsuario usuario = PublicadorUsuario.loginUsuario(email, password);
            request.getSession().setAttribute("usuario", usuario);

            String urlFoto = "data:image/png;base64," + new String(Base64.getEncoder().encode(usuario.getFoto()), StandardCharsets.UTF_8);
            request.getSession().setAttribute("urlFoto", urlFoto);

            if(usuario instanceof DtProfesor) {
                request.getSession().setAttribute("esProfesor", true);
            }
            else {
                request.getSession().setAttribute("esProfesor", false);
            }
        } catch (UsuarioNoExisteException_Exception e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("index.jsp");
    }
}
