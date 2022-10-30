package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import publicadores.ClaseExistenteException_Exception;
import publicadores.DtClase;
import publicadores.PublicadorActividadDeportiva;
import publicadores.PublicadorClase;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@WebServlet(name = "AgregarClase", value = "/AgregarClase")
public class AgregarClase extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombreClase");

        String horaClase =  request.getParameter("horaClase");
        GregorianCalendar hora = new GregorianCalendar(1, Calendar.JANUARY,1, Integer.parseInt(horaClase.split(":")[0]), Integer.parseInt(horaClase.split(":")[1]), 0);

        String fechaClase = request.getParameter("fechaClase");
        String urlClase = request.getParameter("urlClase");

        DtClase dtClase = new DtClase();
        try {
            dtClase.setNombre(nombre);
            dtClase.setHoraInicio(DatatypeFactory.newInstance().newXMLGregorianCalendar(hora));
            dtClase.setFecha(DatatypeFactory.newInstance().newXMLGregorianCalendar(fechaClase));
            dtClase.setFechaReg(DatatypeFactory.newInstance().newXMLGregorianCalendar(Date.from(Instant.now()).toString()));
            dtClase.setUrl(urlClase);

            PublicadorClase.agregarClase(dtClase);
        }
        catch (DatatypeConfigurationException | ClaseExistenteException_Exception e) {
            throw new RuntimeException(e);
        }
    }

}
