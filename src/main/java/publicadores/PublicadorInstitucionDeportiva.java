package publicadores;

import java.util.List;

public class PublicadorInstitucionDeportiva {
    public static DtActividadDeportivaArray getActividadesDeInstitucion(DtInstitucionDeportiva dtInstitucionDeportiva) {
        publicadores.ControladorPublishInstitucionDeportiva service = new ControladorPublishInstitucionDeportivaService().getControladorPublishInstitucionDeportivaPort();
        //invoke business method
        return service.getActividadesDeInstitucion(dtInstitucionDeportiva);
    }
}