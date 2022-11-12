
package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ControladorPublishUsuario", targetNamespace = "http://Publicadores/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ControladorPublishUsuario {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns publicadores.DtClaseArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/ControladorPublishUsuario/getClasesProfesorRequest", output = "http://Publicadores/ControladorPublishUsuario/getClasesProfesorResponse")
    public DtClaseArray getClasesProfesor(
        @WebParam(name = "arg0", partName = "arg0")
        DtClaseArray arg0,
        @WebParam(name = "arg1", partName = "arg1")
        DtProfesor arg1);

    /**
     * 
     * @return
     *     returns publicadores.DtUsuarioArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/ControladorPublishUsuario/getUsuariosRequest", output = "http://Publicadores/ControladorPublishUsuario/getUsuariosResponse")
    public DtUsuarioArray getUsuarios();

    /**
     * 
     * @param arg1
     * @param arg0
     * @throws UsuarioNoExisteException_Exception
     */
    @WebMethod
    @Action(input = "http://Publicadores/ControladorPublishUsuario/modificarUsuarioRequest", output = "http://Publicadores/ControladorPublishUsuario/modificarUsuarioResponse", fault = {
        @FaultAction(className = UsuarioNoExisteException_Exception.class, value = "http://Publicadores/ControladorPublishUsuario/modificarUsuario/Fault/UsuarioNoExisteException")
    })
    public void modificarUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        DtUsuario arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws UsuarioNoExisteException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns publicadores.DtUsuario
     * @throws UsuarioNoExisteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/ControladorPublishUsuario/loginUsuarioRequest", output = "http://Publicadores/ControladorPublishUsuario/loginUsuarioResponse", fault = {
        @FaultAction(className = UsuarioNoExisteException_Exception.class, value = "http://Publicadores/ControladorPublishUsuario/loginUsuario/Fault/UsuarioNoExisteException")
    })
    public DtUsuario loginUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws UsuarioNoExisteException_Exception
    ;

}
