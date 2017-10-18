package ec.casabaca.roster.web.websocket;

import java.io.IOException;
import java.util.Iterator;
import java.util.Queue;

import javax.faces.bean.ApplicationScoped;
import javax.websocket.Session;

@ApplicationScoped
public class Notificador {
	
	
	public void enviarMensaje (String mensaje, Session session) throws IOException {
		if (session.isOpen()) {
			session.getBasicRemote().sendText(mensaje);
		}
	}
	
	public void enviarMensajeTodos (String mensaje, Session session) throws IOException {
		for (Session openSession : session.getOpenSessions()) {
			if (openSession.isOpen()) {
				session.getBasicRemote().sendText(mensaje);
			}
		}
	}
	
	public void enviarMensajeTodos (String mensaje, Queue<Session> queue) throws IOException {
		Iterator<Session> iterator = queue.iterator();
		while (iterator.hasNext()) {
			Session session = iterator.next();
			if (session.isOpen()) {
				System.out.println("Se envia mensaje " + mensaje);
				session.getBasicRemote().sendText(mensaje);
			}
		}
	}
	
	public void enviarMensajeTodos (String mensaje) throws IOException {
		enviarMensajeTodos (mensaje, NotificacionWebsocket.queue);
	}
	
	
}
