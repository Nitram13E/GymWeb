package publicadores;

public class PublicadorCLase {
    public static void main(String[] argv) {
        publicadores.ControladorPublishClase service = new ControladorPublishClaseService().getControladorPublishClasePort();
        //invoke business method
        service.getClasesRanking();
    }
}
