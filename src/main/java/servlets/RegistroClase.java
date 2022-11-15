package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.xml.datatype.DatatypeConfigurationException;
import java.io.IOException;
import java.util.List;

import publicadores.*;

@WebServlet(name = "RegistroClase", value = "/RegistroClase")
public class RegistroClase extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String institucion = request.getParameter("institucion");
        String actividad = request.getParameter("actividad");
        String clase = request.getParameter("clase");
        String claseExistente = request.getParameter("claseExistente");

        //Se ejecuta por primera vez, entonces se carga la lista de instituciones
        if(institucion == null && actividad == null && clase == null)
        {
            //Cargar las instituciones del sistema
            List<DtInstitucionDeportiva> instituciones = PublicadorInstitucionDeportiva.getInstitucionesDeportivas().getItem();

            request.setAttribute("instituciones", instituciones);
        }
        //Se carga la lista de actividades dependiendo de la institucion que se le ingrese como parametro
        else if(actividad == null && clase == null)
        {
            //Cargar las instituciones del sistema
            List<DtInstitucionDeportiva> instituciones = PublicadorInstitucionDeportiva.getInstitucionesDeportivas().getItem();

            DtInstitucionDeportiva dtInstitucion = instituciones.stream().filter(x -> x.getNombre().equals(institucion)).findFirst().get();

            List<DtActividadDeportiva> actividadesInst = PublicadorInstitucionDeportiva.getActividadesDeInstitucion(dtInstitucion).getItem();

            request.setAttribute("actividades", actividadesInst);
            request.setAttribute("instituciones", instituciones);
            request.getSession().setAttribute("institucion", dtInstitucion);
        }
        //Se carga la lista de clases dependiendo de la actividad ingresada por parametro
        else if(clase == null)
        {
            //Cargar las instituciones del sistema
            List<DtInstitucionDeportiva> instituciones = PublicadorInstitucionDeportiva.getInstitucionesDeportivas().getItem();

            DtInstitucionDeportiva dtInstitucion = instituciones.stream().filter(x -> x.getNombre().equals(institucion)).findFirst().get();

            List<DtActividadDeportiva> actividadesInst = PublicadorInstitucionDeportiva.getActividadesDeInstitucion(dtInstitucion).getItem();

            DtActividadDeportiva dtActividad = PublicadorActividadDeportiva.buscarActividadDeportiva(actividad);

            List<DtClase> clasesActividad = PublicadorActividadDeportiva.getClases(dtActividad).getItem();

            request.setAttribute("actividades", actividadesInst);
            request.setAttribute("instituciones", instituciones);
            request.setAttribute("clases", clasesActividad);
            request.getSession().setAttribute("institucion", dtInstitucion);
            request.getSession().setAttribute("actividad", dtActividad);
        }
        else
        //Seteo la clase para su registro
        {
            //Cargar las instituciones del sistema
            List<DtInstitucionDeportiva> instituciones = PublicadorInstitucionDeportiva.getInstitucionesDeportivas().getItem();

            DtInstitucionDeportiva dtInstitucion = instituciones.stream().filter(x -> x.getNombre().equals(institucion)).findFirst().get();

            List<DtActividadDeportiva> actividadesInst = PublicadorInstitucionDeportiva.getActividadesDeInstitucion(dtInstitucion).getItem();

            DtActividadDeportiva dtActividad = PublicadorActividadDeportiva.buscarActividadDeportiva(actividad);

            List<DtClase> clasesActividad = PublicadorActividadDeportiva.getClases(dtActividad).getItem();

            DtClase dtClase = PublicadorClase.buscarClase(clase);

            request.setAttribute("actividades", actividadesInst);
            request.setAttribute("instituciones", instituciones);
            request.setAttribute("clases", clasesActividad);
            request.getSession().setAttribute("institucion", dtInstitucion);
            request.getSession().setAttribute("actividad", dtActividad);
            request.getSession().setAttribute("clase", dtClase);
        }

        if(claseExistente != null)
        {
            request.setAttribute("claseExistente", claseExistente);
        }

        request.getRequestDispatcher("registro_clase.jsp").forward(request, response);

    }//End

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreClase = request.getParameter("nombreClase");

        try {
            DtClase dtClase = PublicadorClase.buscarClase(nombreClase);
            DtUsuario usuario = (DtUsuario) request.getSession().getAttribute("usuario");

            DtSocio socio = new DtSocio();
            socio.setNickname(usuario.getNickname());
            socio.setNombre(usuario.getNombre());
            socio.setApellido(usuario.getApellido());
            socio.setFechaNac(usuario.getFechaNac());
            socio.setFoto(usuario.getFoto());
            socio.setMail(usuario.getMail());
            socio.setContrasenia(usuario.getContrasenia());

            PublicadorRegistro.registrarSocioClase(dtClase, socio);

            response.sendRedirect("RegistroClase");

        } catch (RegistroExistenteException_Exception e) {
            response.sendRedirect("RegistroClase?claseExistente=" + nombreClase);
        }
    }
}
