package publicadores.publicadorClase;

import publicadores.datatypes.DtClase;

public class PublicadorClase {
    public static DtClase buscarClase(String nombre) {
        ControladorPublishClase service = new ControladorPublishClaseService().getControladorPublishClasePort();
        //invoke business method
        return service.buscarClase(nombre);
    }
}
