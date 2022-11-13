package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import publicadores.DtActividadDeportiva;
import publicadores.DtProfesor;
import publicadores.PublicadorActividadDeportiva;
import publicadores.PublicadorInstitucionDeportiva;

import java.io.IOException;

@WebServlet(name = "ConsultaActividadDeportiva", value = "/ConsultaActividadDeportiva")
public class ConsultaActividadDeportiva extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DtProfesor dtProfesor = (DtProfesor) request.getSession().getAttribute("usuario");

        DtActividadDeportiva dtActividadDeportiva = PublicadorActividadDeportiva.buscarActividadDeportiva(request.getParameter("actividadDeportiva"));

        if(dtActividadDeportiva != null) {

        }

        request.setAttribute("actividadesDeportivas", PublicadorInstitucionDeportiva.getActividadesDeInstitucion(dtProfesor.getInstitucion()).getItem());

        request.getRequestDispatcher("/actividades_deportivas.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
