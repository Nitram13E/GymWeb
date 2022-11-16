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
import java.nio.charset.StandardCharsets;
import java.util.Base64;

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
            byte[] foto = IOUtils.toByteArray(request.getPart("fotoPerfil").getInputStream());
            if(foto.length != 0) usuario.setFoto(foto);

            usuario.setNombre(request.getParameter("nameUser"));
            usuario.setApellido(request.getParameter("lastnameUser"));
            usuario.setFechaNac(DatatypeFactory.newInstance().newXMLGregorianCalendar(request.getParameter("birthUser")));

            PublicadorUsuario.modificarUsuario(usuario, request.getParameter("birthUser"));
            request.getSession().setAttribute("usuario", usuario);

            String urlFoto = "data:image/png;base64," + new String(Base64.getEncoder().encode(usuario.getFoto()), StandardCharsets.UTF_8);
            request.getSession().setAttribute("urlFoto", urlFoto);
        }
        catch (DatatypeConfigurationException | UsuarioNoExisteException_Exception | ParseException_Exception e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("index.jsp");
    }
}
