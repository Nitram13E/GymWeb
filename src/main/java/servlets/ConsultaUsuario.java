package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import publicadores.DtProfesor;
import publicadores.DtSocio;
import publicadores.DtUsuario;
import publicadores.PublicadorUsuario;

import java.io.IOException;
import java.util.Comparator;

@WebServlet(name = "ConsultaUsuario", value = "/ConsultaUsuario")
public class ConsultaUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //TODO:Disminuir complejidad agregando un metodo en servidor
        DtUsuario usuario = PublicadorUsuario.getUsuarios().getItem().stream().filter(dtUsuario -> dtUsuario.getMail().equals(email) && dtUsuario.getContrasenia().equals(password)).findFirst().get();
        request.getSession().setAttribute("usuario", usuario);

        if(usuario instanceof DtProfesor) {
            request.getSession().setAttribute("esProfesor", true);
        }
        else if(usuario instanceof DtSocio){
            request.getSession().setAttribute("esProfesor", false);
        }

        response.sendRedirect("index.jsp");
    }
}
