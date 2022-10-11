package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConsultaClase", value = "/ConsultaClase")
public class ConsultaClase extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter salida = response.getWriter();

        salida.println(request.getContextPath());

        request.setAttribute("prueba", 123);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter salida = response.getWriter();

        salida.println(request.getContextPath());
    }
}
