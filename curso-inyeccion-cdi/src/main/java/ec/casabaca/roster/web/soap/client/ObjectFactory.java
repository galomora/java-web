
package ec.casabaca.roster.web.soap.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ec.casabaca.roster.web.soap.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindPlayer_QNAME = new QName("http://soap.web.roster.casabaca.ec/", "findPlayer");
    private final static QName _FindPlayerResponse_QNAME = new QName("http://soap.web.roster.casabaca.ec/", "findPlayerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ec.casabaca.roster.web.soap.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindPlayer }
     * 
     */
    public FindPlayer createFindPlayer() {
        return new FindPlayer();
    }

    /**
     * Create an instance of {@link FindPlayerResponse }
     * 
     */
    public FindPlayerResponse createFindPlayerResponse() {
        return new FindPlayerResponse();
    }

    /**
     * Create an instance of {@link Player }
     * 
     */
    public Player createPlayer() {
        return new Player();
    }

    /**
     * Create an instance of {@link Team }
     * 
     */
    public Team createTeam() {
        return new Team();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindPlayer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.roster.casabaca.ec/", name = "findPlayer")
    public JAXBElement<FindPlayer> createFindPlayer(FindPlayer value) {
        return new JAXBElement<FindPlayer>(_FindPlayer_QNAME, FindPlayer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindPlayerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.roster.casabaca.ec/", name = "findPlayerResponse")
    public JAXBElement<FindPlayerResponse> createFindPlayerResponse(FindPlayerResponse value) {
        return new JAXBElement<FindPlayerResponse>(_FindPlayerResponse_QNAME, FindPlayerResponse.class, null, value);
    }

}
