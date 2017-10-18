package ec.casabaca.roster.web.websocket;

import java.io.IOException;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint (value="/notificacion")
public class NotificacionWebsocket {
	
	private static final Logger logger = Logger.getLogger("NotificacionWebsocket");
	
	static Queue<Session> queue = new ConcurrentLinkedQueue<>();
	
	@OnOpen
    public void openConnection(Session session) {
        logger.log(Level.INFO, "Connection opened.");
        queue.add(session);
    }
	
	@OnMessage
	public void onMessage (final Session session, String msg) throws IOException {
		
		logger.log(Level.INFO, "se recibe mensaje." + msg);
		enviarMensajeTodos ("Mensaje recibido " + msg, session);
	}
	
	@OnClose
    public void closeConnection(Session session) {
		queue.remove(session);
        logger.log(Level.INFO, "Connection closed.");
    }
	
	@OnError
	public void error(Session session, Throwable error) {
		logger.log(Level.SEVERE, "Error en websocket." + error.getMessage(), error);
	}
	
	public void enviarMensajeTodos (String mensaje, Session session) throws IOException {
		for (Session openSession : session.getOpenSessions())
		if (openSession.isOpen()) {
			openSession.getBasicRemote().sendText(mensaje);
		}
	}
}
