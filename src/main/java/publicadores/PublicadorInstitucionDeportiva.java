package publicadores;

public class PublicadorInstitucionDeportiva {
    public static void main(String[] argv) {
        publicadores.ControladorPublishInstitucionDeportiva service = new ControladorPublishInstitucionDeportivaService().getControladorPublishInstitucionDeportivaPort();
        //invoke business method
        service.getActividadesDeInstitucion();
    }
}
