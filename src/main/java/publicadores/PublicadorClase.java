package publicadores;

public class PublicadorClase {
    public static DtClaseArray getClasesRanking() {
        publicadores.ControladorPublishClase service = new ControladorPublishClaseService().getControladorPublishClasePort();

        return service.getClasesRanking();
    }

    public static DtClase buscarClase(String nombre) {
        publicadores.ControladorPublishClase service = new ControladorPublishClaseService().getControladorPublishClasePort();

        return service.buscarClase(nombre);
    }

    public static void agregarClase(DtClase dtClase, DtUsuario usuario, String actividadDeportiva) throws ClaseExistenteException_Exception {
        publicadores.ControladorPublishClase service = new ControladorPublishClaseService().getControladorPublishClasePort();

        service.agregarClase(dtClase, usuario, actividadDeportiva);
    }
}