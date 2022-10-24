
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
@WebService(name = "ControladorPublishClase", targetNamespace = "http://Publicadores/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ControladorPublishClase {


    /**
     * 
     * @return
     *     returns publicadores.DtClaseArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/ControladorPublishClase/getClasesRankingRequest", output = "http://Publicadores/ControladorPublishClase/getClasesRankingResponse")
    public DtClaseArray getClasesRanking();

    /**
     * 
     * @param arg0
     * @throws ClaseExistenteException_Exception
     */
    @WebMethod
    @Action(input = "http://Publicadores/ControladorPublishClase/agregarClaseRequest", output = "http://Publicadores/ControladorPublishClase/agregarClaseResponse", fault = {
        @FaultAction(className = ClaseExistenteException_Exception.class, value = "http://Publicadores/ControladorPublishClase/agregarClase/Fault/ClaseExistenteException")
    })
    public void agregarClase(
        @WebParam(name = "arg0", partName = "arg0")
        DtClase arg0)
        throws ClaseExistenteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns publicadores.DtClase
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/ControladorPublishClase/buscarClaseRequest", output = "http://Publicadores/ControladorPublishClase/buscarClaseResponse")
    public DtClase buscarClase(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

}