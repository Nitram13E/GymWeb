package publicadores;

public class PublicadorUsuario {
    public static void main(String[] argv) {
        publicadores.ControladorPublishUsuario service = new ControladorPublishUsuarioService().getControladorPublishUsuarioPort();
        //invoke business method
        service.modificarUsuario();
    }
}
