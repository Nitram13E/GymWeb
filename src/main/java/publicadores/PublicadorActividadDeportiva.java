package publicadores;

import java.util.List;

public class PublicadorActividadDeportiva {
    public static DtActividadDeportivaArray getActividadesDeportivas() {
        publicadores.ControladorPublishActividadDeportiva service = new ControladorPublishActividadDeportivaService().getControladorPublishActividadDeportivaPort();

        return service.getActividadesDeportivas();
    }

    public static DtClaseArray getClases(DtActividadDeportiva dtActividadDeportiva) {
        publicadores.ControladorPublishActividadDeportiva service = new ControladorPublishActividadDeportivaService().getControladorPublishActividadDeportivaPort();

        return service.getClases(dtActividadDeportiva);
    }

    public DtActividadDeportivaArray getActividadesDeportivasProfesor(DtProfesor dtProfesor) throws UsuarioNoExisteException_Exception {
        publicadores.ControladorPublishActividadDeportiva service = new ControladorPublishActividadDeportivaService().getControladorPublishActividadDeportivaPort();

        return service.getActividadesDeportivasProfesor(dtProfesor);
    }
}