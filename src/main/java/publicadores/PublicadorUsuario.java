package publicadores;

import java.util.List;

public class PublicadorUsuario {
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
