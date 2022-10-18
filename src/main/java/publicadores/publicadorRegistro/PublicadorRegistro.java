package publicadores.publicadorRegistro;

import publicadores.datatypes.DtClase;
import publicadores.datatypes.RegistroArray;

public class PublicadorRegistro {
    public static RegistroArray getRegistrosClase(DtClase clase) {
        publicadores.publicadorRegistro.ControladorPublishRegistro service = new ControladorPublishRegistroService().getControladorPublishRegistroPort();
        //invoke business method
        return service.getRegistrosClase(clase);
    }
}
