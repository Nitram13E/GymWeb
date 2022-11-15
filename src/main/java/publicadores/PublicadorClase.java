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

    public static void agregarClase(DtClase dtClase, DtProfesor dtProfesor, DtActividadDeportiva dtActividadDeportiva, String fechaHora) throws ClaseExistenteException_Exception, ParseException_Exception {
        publicadores.ControladorPublishClase service = new ControladorPublishClaseService().getControladorPublishClasePort();

        service.agregarClase(dtClase, dtProfesor, dtActividadDeportiva, fechaHora);
    }
}