package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import publicadores.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ConsultaActividadDeportiva", value = "/ConsultaActividadDeportiva")
public class ConsultaActividadDeportiva extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DtProfesor dtProfesor = (DtProfesor) request.getSession().getAttribute("usuario");
        String actividadDeportiva = request.getParameter("actividadDeportiva");

        if(dtProfesor == null) response.sendRedirect("index.jsp");

        List<DtActividadDeportiva> actividades = PublicadorInstitucionDeportiva.getActividadesDeInstitucion(dtProfesor.getInstitucion()).getItem();

        if(!actividades.isEmpty())
        {
            if(actividadDeportiva == null)
            {
                request.setAttribute("actividadDeportiva", actividades.get(0));
            }
            else
            {
                DtActividadDeportiva dtActividadDeportiva = PublicadorActividadDeportiva.buscarActividadDeportiva(actividadDeportiva);

                request.setAttribute("actividadDeportiva", dtActividadDeportiva);
            }

            //Traer clases de la Actividad Deportiva seleccionada
            List<DtClase> clasesActividad = PublicadorActividadDeportiva.getClases((DtActividadDeportiva) request.getAttribute("actividadDeportiva")).getItem();

            request.setAttribute("clasesActividad", clasesActividad);
        }

        request.setAttribute("actividadesDeportivas",actividades);

        request.getRequestDispatcher("actividades_deportivas.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Buscar actividades deportivas
        String query = request.getParameter("queryActividad");
        DtProfesor dtProfesor = (DtProfesor) request.getSession().getAttribute("usuario");
        if(query == null || query == "") response.sendRedirect("ConsultaActividadDeportiva");
        if(dtProfesor == null) response.sendRedirect("ConsultaActividadDeportiva");

        if(query != "" && query != null)
        {
            List<DtActividadDeportiva> actividades = PublicadorInstitucionDeportiva.getActividadesDeInstitucion(dtProfesor.getInstitucion()).getItem();
            List<DtActividadDeportiva> actividadesBusqueda = new ArrayList<>();

            for(DtActividadDeportiva actividad: actividades)
            {
                if(actividad.getNombre().toLowerCase().contains(query.toLowerCase()))
                {
                    actividadesBusqueda.add(actividad);
                }
            }

            request.setAttribute("actividadesDeportivas",actividadesBusqueda);
            request.getRequestDispatcher("actividades_deportivas.jsp").forward(request, response);
        }

    }
}
