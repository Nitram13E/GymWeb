
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
@WebServiceClient(name = "ControladorPublishUsuarioService", targetNamespace = "http://Publicadores/", wsdlLocation = "http://127.0.0.1:1927/controladorUsuario?wsdl")
public class ControladorPublishUsuarioService
    extends Service
{

    private final static URL CONTROLADORPUBLISHUSUARIOSERVICE_WSDL_LOCATION;
    private final static WebServiceException CONTROLADORPUBLISHUSUARIOSERVICE_EXCEPTION;
    private final static QName CONTROLADORPUBLISHUSUARIOSERVICE_QNAME = new QName("http://Publicadores/", "ControladorPublishUsuarioService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://127.0.0.1:1927/controladorUsuario?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CONTROLADORPUBLISHUSUARIOSERVICE_WSDL_LOCATION = url;
        CONTROLADORPUBLISHUSUARIOSERVICE_EXCEPTION = e;
    }

    public ControladorPublishUsuarioService() {
        super(__getWsdlLocation(), CONTROLADORPUBLISHUSUARIOSERVICE_QNAME);
    }

    public ControladorPublishUsuarioService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CONTROLADORPUBLISHUSUARIOSERVICE_QNAME, features);
    }

    public ControladorPublishUsuarioService(URL wsdlLocation) {
        super(wsdlLocation, CONTROLADORPUBLISHUSUARIOSERVICE_QNAME);
    }

    public ControladorPublishUsuarioService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CONTROLADORPUBLISHUSUARIOSERVICE_QNAME, features);
    }

    public ControladorPublishUsuarioService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ControladorPublishUsuarioService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ControladorPublishUsuario
     */
    @WebEndpoint(name = "ControladorPublishUsuarioPort")
    public ControladorPublishUsuario getControladorPublishUsuarioPort() {
        return super.getPort(new QName("http://Publicadores/", "ControladorPublishUsuarioPort"), ControladorPublishUsuario.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ControladorPublishUsuario
     */
    @WebEndpoint(name = "ControladorPublishUsuarioPort")
    public ControladorPublishUsuario getControladorPublishUsuarioPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://Publicadores/", "ControladorPublishUsuarioPort"), ControladorPublishUsuario.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CONTROLADORPUBLISHUSUARIOSERVICE_EXCEPTION!= null) {
            throw CONTROLADORPUBLISHUSUARIOSERVICE_EXCEPTION;
        }
        return CONTROLADORPUBLISHUSUARIOSERVICE_WSDL_LOCATION;
    }

}
