
package ec.casabaca.roster.web.soap.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para playerPosition.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="playerPosition"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CAPTAIN"/&gt;
 *     &lt;enumeration value="OFFENSIVE"/&gt;
 *     &lt;enumeration value="DEFENSIVE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "playerPosition")
@XmlEnum
public enum PlayerPosition {

    CAPTAIN,
    OFFENSIVE,
    DEFENSIVE;

    public String value() {
        return name();
    }

    public static PlayerPosition fromValue(String v) {
        return valueOf(v);
    }

}
