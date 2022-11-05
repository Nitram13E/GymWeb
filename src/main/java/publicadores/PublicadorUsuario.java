package publicadores;

public class PublicadorUsuario {

    public static DtUsuario loginUsuario(String email, String password) throws UsuarioNoExisteException_Exception {
        publicadores.ControladorPublishUsuario service = new ControladorPublishUsuarioService().getControladorPublishUsuarioPort();

        return service.loginUsuario(email, password);
    }

    public static void modificarUsuario(DtUsuario dtUsuario) throws UsuarioNoExisteException_Exception {
        publicadores.ControladorPublishUsuario service = new ControladorPublishUsuarioService().getControladorPublishUsuarioPort();

        service.modificarUsuario(dtUsuario);
    }

    public static DtUsuarioArray getUsuarios() {
        publicadores.ControladorPublishUsuario service = new ControladorPublishUsuarioService().getControladorPublishUsuarioPort();

        return service.getUsuarios();
    }

    public static DtClaseArray getClasesProfesor(DtClaseArray dtClasesArray, DtProfesor dtProfesor) {
        publicadores.ControladorPublishUsuario service = new ControladorPublishUsuarioService().getControladorPublishUsuarioPort();

        return service.getClasesProfesor(dtClasesArray, dtProfesor);
    }
}