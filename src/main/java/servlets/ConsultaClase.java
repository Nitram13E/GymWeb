package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ConsultaClase", value = "/ConsultaClase")
public class ConsultaClase extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreClase = request.getParameter("nombreClase");
        DtClase dtClase = buscarClase(nombreClase);

        List<Registro> registros = icRegistro.obtenerRegistrosClase(nombreClase);



        request.setAttribute("nombreClase", nombreClase);
        request.setAttribute("clase", dtClase);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/clases.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
