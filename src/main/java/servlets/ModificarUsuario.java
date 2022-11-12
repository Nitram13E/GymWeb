package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.io.IOUtils;
import publicadores.DtUsuario;
import publicadores.PublicadorUsuario;
import publicadores.UsuarioNoExisteException_Exception;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Arrays;

@MultipartConfig
@WebServlet(name = "ModificarUsuario", value = "/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DtUsuario usuario = (DtUsuario) request.getSession().getAttribute("usuario");

        try {
            usuario.setFoto(IOUtils.toByteArray(request.getPart("fotoPerfil").getInputStream()));
            usuario.setApellido(request.getParameter("lastnameUser"));

            String[] date = request.getParameter("birthUser").split("-");
            usuario.setFechaNac(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]), -3));

            XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]), -3);

            PublicadorUsuario.modificarUsuario(usuario, request.getParameter("birthUser"));
        }
        catch (DatatypeConfigurationException | UsuarioNoExisteException_Exception e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("index.jsp");
    }
}
