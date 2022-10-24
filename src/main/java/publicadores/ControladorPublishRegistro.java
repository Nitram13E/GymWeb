
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
@WebService(name = "ControladorPublishRegistro", targetNamespace = "http://Publicadores/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ControladorPublishRegistro {


    /**
     * 
     * @return
     *     returns publicadores.RegistroArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/ControladorPublishRegistro/obtenerRegistrosRequest", output = "http://Publicadores/ControladorPublishRegistro/obtenerRegistrosResponse")
    public RegistroArray obtenerRegistros();

    /**
     * 
     * @param arg0
     * @return
     *     returns publicadores.RegistroArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/ControladorPublishRegistro/obtenerRegistrosSocioRequest", output = "http://Publicadores/ControladorPublishRegistro/obtenerRegistrosSocioResponse")
    public RegistroArray obtenerRegistrosSocio(
        @WebParam(name = "arg0", partName = "arg0")
        DtSocio arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @throws RegistroExistenteException_Exception
     */
    @WebMethod
    @Action(input = "http://Publicadores/ControladorPublishRegistro/registrarSocioClaseRequest", output = "http://Publicadores/ControladorPublishRegistro/registrarSocioClaseResponse", fault = {
        @FaultAction(className = RegistroExistenteException_Exception.class, value = "http://Publicadores/ControladorPublishRegistro/registrarSocioClase/Fault/RegistroExistenteException")
    })
    public void registrarSocioClase(
        @WebParam(name = "arg0", partName = "arg0")
        DtClase arg0,
        @WebParam(name = "arg1", partName = "arg1")
        DtSocio arg1)
        throws RegistroExistenteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns publicadores.RegistroArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/ControladorPublishRegistro/getRegistrosClaseRequest", output = "http://Publicadores/ControladorPublishRegistro/getRegistrosClaseResponse")
    public RegistroArray getRegistrosClase(
        @WebParam(name = "arg0", partName = "arg0")
        DtClase arg0);

}
