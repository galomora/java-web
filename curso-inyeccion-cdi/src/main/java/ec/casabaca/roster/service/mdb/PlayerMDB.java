package ec.casabaca.roster.service.mdb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven (name="playerMDB", activationConfig =
{@ActivationConfigProperty (propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
	@ActivationConfigProperty (propertyName = "destination", propertyValue = "queue/myQueue")})
public class PlayerMDB implements MessageListener {

	@Resource
	private MessageDrivenContext MDBContext;
	
	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			try {
				System.out.println("Recibido el mensaje de MDB " + textMessage.getText());
			} catch (JMSException e) {
				MDBContext.setRollbackOnly();
			}
		}
		else {
			System.out.println("Mensaje no permitido");
			MDBContext.setRollbackOnly();
		}
		
	}
	
}
