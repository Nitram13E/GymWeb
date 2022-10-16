package publicadores.PublicadorClase;

public class PublicadorClase {
    public static void main(String[] argv) {
        ControladorPublishClase service = new ControladorPublishClaseService().getControladorPublishClasePort();
        //invoke business method
        service.();
    }
}
