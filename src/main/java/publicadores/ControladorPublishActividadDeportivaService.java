
package publicadores;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ControladorPublishActividadDeportivaService", targetNamespace = "http://Publicadores/", wsdlLocation = "http://127.0.0.1:1927/controladorActividadDeportiva?wsdl")
public class ControladorPublishActividadDeportivaService
    extends Service
{

    private final static URL CONTROLADORPUBLISHACTIVIDADDEPORTIVASERVICE_WSDL_LOCATION;
    private final static WebServiceException CONTROLADORPUBLISHACTIVIDADDEPORTIVASERVICE_EXCEPTION;
    private final static QName CONTROLADORPUBLISHACTIVIDADDEPORTIVASERVICE_QNAME = new QName("http://Publicadores/", "ControladorPublishActividadDeportivaService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://127.0.0.1:1927/controladorActividadDeportiva?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CONTROLADORPUBLISHACTIVIDADDEPORTIVASERVICE_WSDL_LOCATION = url;
        CONTROLADORPUBLISHACTIVIDADDEPORTIVASERVICE_EXCEPTION = e;
    }

    public ControladorPublishActividadDeportivaService() {
        super(__getWsdlLocation(), CONTROLADORPUBLISHACTIVIDADDEPORTIVASERVICE_QNAME);
    }

    public ControladorPublishActividadDeportivaService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CONTROLADORPUBLISHACTIVIDADDEPORTIVASERVICE_QNAME, features);
    }

    public ControladorPublishActividadDeportivaService(URL wsdlLocation) {
        super(wsdlLocation, CONTROLADORPUBLISHACTIVIDADDEPORTIVASERVICE_QNAME);
    }

    public ControladorPublishActividadDeportivaService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CONTROLADORPUBLISHACTIVIDADDEPORTIVASERVICE_QNAME, features);
    }

    public ControladorPublishActividadDeportivaService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ControladorPublishActividadDeportivaService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ControladorPublishActividadDeportiva
     */
    @WebEndpoint(name = "ControladorPublishActividadDeportivaPort")
    public ControladorPublishActividadDeportiva getControladorPublishActividadDeportivaPort() {
        return super.getPort(new QName("http://Publicadores/", "ControladorPublishActividadDeportivaPort"), ControladorPublishActividadDeportiva.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ControladorPublishActividadDeportiva
     */
    @WebEndpoint(name = "ControladorPublishActividadDeportivaPort")
    public ControladorPublishActividadDeportiva getControladorPublishActividadDeportivaPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://Publicadores/", "ControladorPublishActividadDeportivaPort"), ControladorPublishActividadDeportiva.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CONTROLADORPUBLISHACTIVIDADDEPORTIVASERVICE_EXCEPTION!= null) {
            throw CONTROLADORPUBLISHACTIVIDADDEPORTIVASERVICE_EXCEPTION;
        }
        return CONTROLADORPUBLISHACTIVIDADDEPORTIVASERVICE_WSDL_LOCATION;
    }

}