package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import publicadores.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@WebServlet(name = "AgregarClase", value = "/AgregarClase")
public class AgregarClase extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("errorAgregar") != null) request.setAttribute("errorAgregar", true);

        request.setAttribute("actividadDeportiva", request.getParameter("actividadDeportiva"));

        request.getRequestDispatcher("agregar_clase.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DtClase dtClase = new DtClase();
        String nombreClase = request.getParameter("nombreClase");
        try {
            XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(request.getParameter("fechaClase"));

            String[] hora =  request.getParameter("horaClase").split(":");
            fecha.setTime(Integer.parseInt(hora[0]), Integer.parseInt(hora[1]), 0);

            dtClase.setNombre(request.getParameter("nombreClase"));
            dtClase.setHoraInicio(fecha);
            dtClase.setFecha(fecha);
            dtClase.setFechaReg(DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.now(ZoneOffset.UTC).toString()));
            dtClase.setUrl(request.getParameter("urlClase"));

            DtProfesor dtProfesor = (DtProfesor) request.getSession().getAttribute("usuario");
            DtActividadDeportiva dtActividadDeportiva = PublicadorActividadDeportiva.buscarActividadDeportiva(request.getParameter("actividadDeportiva"));

            PublicadorClase.agregarClase(dtClase, dtProfesor, dtActividadDeportiva, fecha.toString());

            response.sendRedirect("ConsultaActividadDeportiva?actividadDeportiva=" + request.getParameter("actividadDeportiva"));
        }
        catch (DatatypeConfigurationException | ClaseExistenteException_Exception | ParseException_Exception e) {
            response.sendRedirect("AgregarClase?actividadDeportiva" + request.getParameter("actividadDeportiva") + "&errorAgregar=" + true);
        }
    }

}
