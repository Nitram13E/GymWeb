package publicadores;

public class PublicadorActividadDeportiva {
    public static void main(String[] argv) {
        publicadores.ControladorPublishActividadDeportiva service = new ControladorPublishActividadDeportivaService().getControladorPublishActividadDeportivaPort();
        //invoke business method
        service.getActividadesDeportivas();
    }
}
