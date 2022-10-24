package publicadores;

public class PublicadorRegistro {
    public static void main(String[] argv) {
        publicadores.ControladorPublishRegistro service = new ControladorPublishRegistroService().getControladorPublishRegistroPort();
        //invoke business method
        service.obtenerRegistros();
    }
}
