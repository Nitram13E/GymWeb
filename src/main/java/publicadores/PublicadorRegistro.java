package publicadores;

public class PublicadorRegistro {
    public static void registrarSocioClase(DtClase dtClase, DtSocio dtSocio) throws RegistroExistenteException_Exception {
        publicadores.ControladorPublishRegistro service = new ControladorPublishRegistroService().getControladorPublishRegistroPort();

        service.registrarSocioClase(dtClase, dtSocio);
    }

    public static RegistroArray getRegistros() {
        publicadores.ControladorPublishRegistro service = new ControladorPublishRegistroService().getControladorPublishRegistroPort();

        return service.obtenerRegistros();
    }

    public static RegistroArray getRegistrosClase(DtClase dtClase) {
        publicadores.ControladorPublishRegistro service = new ControladorPublishRegistroService().getControladorPublishRegistroPort();

        return service.getRegistrosClase(dtClase);
    }

    public static DtSocioArray obtenerSociosClase(DtClase dtClase) {
        publicadores.ControladorPublishRegistro service = new ControladorPublishRegistroService().getControladorPublishRegistroPort();

        return service.obtenerSociosClase(dtClase);
    }

    public static RegistroArray getRegistrosSocio(DtSocio dtSocio) {
        publicadores.ControladorPublishRegistro service = new ControladorPublishRegistroService().getControladorPublishRegistroPort();

        return service.obtenerRegistrosSocio(dtSocio);
    }

    public static DtClaseArray obtenerClasesSocio(DtSocio dtSocio) {
        publicadores.ControladorPublishRegistro service = new ControladorPublishRegistroService().getControladorPublishRegistroPort();

        return service.obtenerClasesSocio(dtSocio);
    }
}