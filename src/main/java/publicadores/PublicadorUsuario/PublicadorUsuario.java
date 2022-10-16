package publicadores.PublicadorUsuario;

public class PublicadorUsuario {
    public static void main(String[] argv) {
        ControladorPublishUsuario service = new ControladorPublishUsuarioService().getControladorPublishUsuarioPort();
        //invoke business method
        service.retornarUsuarios();
    }
}
