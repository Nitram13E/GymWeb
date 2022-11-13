package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import publicadores.*;

import java.io.IOException;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ConsultaUsuario", value = "/ConsultaUsuario")
public class ConsultaUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DtUsuario usuario = (DtUsuario) request.getSession().getAttribute("usuario");
        Boolean esProfesor = (Boolean) request.getSession().getAttribute("esProfesor");
        if(usuario == null || esProfesor == null) response.sendRedirect("index.jsp");

        //Si es profesor traemos las actividades y las clases asociadas a esa actividad
        if(esProfesor)
        {
            try {
                DtProfesor profesor = (DtProfesor) usuario;

                //Traer actividades del profesor que esta logueado
                List<DtActividadDeportiva> actividadesProfesor = PublicadorActividadDeportiva.getActividadesDeportivasProfesor(profesor).getItem();

                //Traer las clases de cada actividad deportiva

                //Set info profesor to front end
                request.setAttribute("infoUsuario", profesor);
                //Set actividades to show in carousel
                request.setAttribute("actividadesProfesor", actividadesProfesor);

            } catch (UsuarioNoExisteException_Exception e) {

                throw new RuntimeException(e);
            }

        }
        //Si es socio entonces traemos las clases a las que se registro
        else
        {
            DtSocio socio = new DtSocio();
            socio.setNickname(usuario.getNickname());
            socio.setNombre(usuario.getNombre());
            socio.setApellido(usuario.getApellido());
            socio.setFechaNac(usuario.getFechaNac());
            socio.setFoto(usuario.getFoto());
            socio.setMail(usuario.getMail());
            socio.setContrasenia(usuario.getContrasenia());

            //Lista de clases de ese socio
            List<DtClase> clasesSocio = PublicadorRegistro.obtenerClasesSocio(socio).getItem();
            request.setAttribute("clasesSocio", clasesSocio);

            request.setAttribute("infoUsuario", socio);
        }

        //Envia los atributos y a la pagina directamente al jsp
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/dashboard.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
