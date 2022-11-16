package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import publicadores.DtActividadDeportiva;
import publicadores.DtClase;
import publicadores.PublicadorActividadDeportiva;
import publicadores.PublicadorClase;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Ranking", value = "/Ranking")
public class Ranking extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DtActividadDeportiva> rankingActividades = PublicadorActividadDeportiva.getActividadesRanking().getItem();
        request.setAttribute("rankingActividades", rankingActividades);

        List<DtClase>  rankingClases = PublicadorClase.getClasesRanking().getItem();
        request.setAttribute("rankingClases",rankingClases);


        //Envia los atributos y a la pagina directamente al jsp
        request.getRequestDispatcher("/ranking.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
