package ec.casabaca.roster.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

import ec.casabaca.roster.web.resftul.PlayerRestfulClient;
import ec.casabaca.roster.web.websocket.Notificador;

@Singleton
@LocalBean
public class NotificacionScheduler {
	
	@Inject
	Notificador notificador;
	@Inject
	PlayerRestfulClient client;
	
	@Schedule (second="*/30", minute="*", hour="3", persistent = false)
	public void enviarNotificacionAutomatica() throws IOException {
		System.out.println("Enviando notificacion automatica");
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		notificador.enviarMensajeTodos("Notificacion automatica " + format.format(new Date()));
	}
	
}
