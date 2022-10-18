package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import publicadores.datatypes.DtClase;
import publicadores.publicadorClase.PublicadorClase;
import publicadores.publicadorRegistro.PublicadorRegistro;
import publicadores.datatypes.RegistroArray;

import java.io.IOException;

@WebServlet(name = "ConsultaClase", value = "/ConsultaClase")
public class ConsultaClase extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreClase = request.getParameter("nombreClase");

        DtClase dtClase = PublicadorClase.buscarClase(nombreClase);

        RegistroArray registros = PublicadorRegistro.getRegistrosClase(dtClase);

        request.setAttribute("nombreClase", nombreClase);
        request.setAttribute("clase", dtClase);

        request.setAttribute("registros", registros);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/clases.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
