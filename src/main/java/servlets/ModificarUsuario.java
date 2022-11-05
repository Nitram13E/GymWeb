package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import publicadores.DtUsuario;
import publicadores.PublicadorUsuario;
import publicadores.UsuarioNoExisteException_Exception;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;

@WebServlet(name = "ModificarUsuario", value = "/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DtUsuario usuario = (DtUsuario) request.getSession().getAttribute("usuario");
        try {
            usuario.setNombre(request.getParameter("nameUser"));
            usuario.setApellido(request.getParameter("lastnameUser"));
            usuario.setFechaNac(DatatypeFactory.newInstance().newXMLGregorianCalendar(request.getParameter("birthUser")));

            XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(request.getParameter("birthUser"));

            PublicadorUsuario.modificarUsuario(usuario);
        }
        catch (DatatypeConfigurationException | UsuarioNoExisteException_Exception e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("index.jsp");
    }
}
