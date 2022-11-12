package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.io.IOUtils;
import publicadores.DtUsuario;
import publicadores.ParseException_Exception;
import publicadores.PublicadorUsuario;
import publicadores.UsuarioNoExisteException_Exception;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.io.IOException;

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
            usuario.setFechaNac(DatatypeFactory.newInstance().newXMLGregorianCalendar(request.getParameter("birthUser")));

            PublicadorUsuario.modificarUsuario(usuario, request.getParameter("birthUser"));
        }
        catch (DatatypeConfigurationException | UsuarioNoExisteException_Exception e) {
            throw new RuntimeException(e);
        } catch (ParseException_Exception e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("index.jsp");
    }
}
