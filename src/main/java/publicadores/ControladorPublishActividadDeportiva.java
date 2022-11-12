
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
@WebService(name = "ControladorPublishActividadDeportiva", targetNamespace = "http://Publicadores/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ControladorPublishActividadDeportiva {


    /**
     * 
     * @param arg0
     * @return
     *     returns publicadores.DtClaseArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/ControladorPublishActividadDeportiva/getClasesRequest", output = "http://Publicadores/ControladorPublishActividadDeportiva/getClasesResponse")
    public DtClaseArray getClases(
        @WebParam(name = "arg0", partName = "arg0")
        DtActividadDeportiva arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns publicadores.DtActividadDeportivaArray
     * @throws UsuarioNoExisteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/ControladorPublishActividadDeportiva/getActividadesDeportivasProfesorRequest", output = "http://Publicadores/ControladorPublishActividadDeportiva/getActividadesDeportivasProfesorResponse", fault = {
        @FaultAction(className = UsuarioNoExisteException_Exception.class, value = "http://Publicadores/ControladorPublishActividadDeportiva/getActividadesDeportivasProfesor/Fault/UsuarioNoExisteException")
    })
    public DtActividadDeportivaArray getActividadesDeportivasProfesor(
        @WebParam(name = "arg0", partName = "arg0")
        DtProfesor arg0)
        throws UsuarioNoExisteException_Exception
    ;

    /**
     * 
     * @return
     *     returns publicadores.DtActividadDeportivaArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/ControladorPublishActividadDeportiva/getActividadesDeportivasRequest", output = "http://Publicadores/ControladorPublishActividadDeportiva/getActividadesDeportivasResponse")
    public DtActividadDeportivaArray getActividadesDeportivas();

}
