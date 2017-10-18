package ec.casabaca.roster.service.mdb;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.TextMessage;

@RequestScoped
public class PlayerJMSProducer {
	@Resource(lookup = "java:/ConnectionFactory")
	private static ConnectionFactory connectionFactory;
	@Resource(lookup = "queue/myQueue")
	private static Queue queue;
	
	public void enviarMensaje (String texto) {
		try (JMSContext context = connectionFactory.createContext();) {
			TextMessage textMessage = context.createTextMessage(texto);
			context.createProducer().send(queue, textMessage);
		}
	}

}
