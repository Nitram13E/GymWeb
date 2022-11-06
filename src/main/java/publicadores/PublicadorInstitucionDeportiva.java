package publicadores;

public class PublicadorInstitucionDeportiva {
    public static DtActividadDeportivaArray getActividadesDeInstitucion(DtInstitucionDeportiva dtInstitucionDeportiva) {
        publicadores.ControladorPublishInstitucionDeportiva service = new ControladorPublishInstitucionDeportivaService().getControladorPublishInstitucionDeportivaPort();

        return service.getActividadesDeInstitucion(dtInstitucionDeportiva);
    }

    public static DtInstitucionDeportivaArray getInstitucionesDeportivas(DtInstitucionDeportiva dtInstitucionDeportiva) {
        publicadores.ControladorPublishInstitucionDeportiva service = new ControladorPublishInstitucionDeportivaService().getControladorPublishInstitucionDeportivaPort();

        return service.getInstitucionesDeportivas();
    }
}