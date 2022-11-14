package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.xml.datatype.DatatypeConfigurationException;
import java.io.IOException;

import publicadores.*;

@WebServlet(name = "RegistroClase", value = "/RegistroClase")
public class RegistroClase extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreClase = request.getParameter("nombreClase");

        try {
            DtClase dtClase = PublicadorClase.buscarClase(nombreClase);
            DtUsuario usuario = (DtUsuario) request.getSession().getAttribute("usuario");

            PublicadorRegistro.registrarSocioClase(dtClase, (DtSocio) usuario);
        } catch (RegistroExistenteException_Exception e) {
            throw new RuntimeException(e);
        }
    }
}
