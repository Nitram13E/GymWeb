package servlets;

import Controlador.Interfaces.Fabrica;
import Controlador.Interfaces.ICInstDeportiva;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ConsultaActividadDeportiva", value = "/ConsultaActividadDeportiva")
public class ConsultaActividadDeportiva extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Fabrica fabrica =Fabrica.getInstancia();
        ICInstDeportiva icInstDeportiva = fabrica.getICInstDeportiva();

    }
}
