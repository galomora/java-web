package ec.casabaca.roster.web.soap.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.4.redhat-1
 * 2016-07-21T18:29:37.082-05:00
 * Generated source version: 3.1.4.redhat-1
 * 
 */
@WebService(targetNamespace = "http://soap.web.roster.casabaca.ec/", name = "playerWebService")
@XmlSeeAlso({ObjectFactory.class})
public interface PlayerWebService {

    @WebMethod
    @RequestWrapper(localName = "findPlayer", targetNamespace = "http://soap.web.roster.casabaca.ec/", className = "ec.casabaca.roster.web.soap.client.FindPlayer")
    @ResponseWrapper(localName = "findPlayerResponse", targetNamespace = "http://soap.web.roster.casabaca.ec/", className = "ec.casabaca.roster.web.soap.client.FindPlayerResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ec.casabaca.roster.web.soap.client.Player findPlayer(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );
}
