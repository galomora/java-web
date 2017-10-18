package ec.casabaca.timer.ejb;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Singleton
@LocalBean
public class TimerBean {
	@Resource
	TimerService timerService;
	
	private Date fechaEjecucionTimerProgramado;
	private Date fechaEjecucionTimerAuto;
	
	@Lock (LockType.WRITE)
	public void ejecutarTimeoutProgramado () {
//		30 segundos
		timerService.createSingleActionTimer(2000000, new TimerConfig());
		fechaEjecucionTimerProgramado = new Date();
	}
	
	@Timeout
	public void doTimeout (Timer timer) {
		System.out.println();
	}
	
	@Schedule (second="*/15", minute="50", hour="*", persistent = false)
	public void ejecutarTimerAutomatico() {
		if (fechaEjecucionTimerAuto == null) {
			fechaEjecucionTimerAuto = new Date();
		}
		System.out.println("ejecutando timer auto " + fechaEjecucionTimerAuto);
	}
	
	private Long calcularDiferencia (Date fechaInicio, Date fechaFin, TimeUnit timeUnit) {
		long diferenciaMilisegundos = fechaFin.getTime() - fechaInicio.getTime();
		return timeUnit.convert(diferenciaMilisegundos, TimeUnit.MILLISECONDS);
	}
	
	public String getEstadoTimerProgramado () {
		if (fechaEjecucionTimerProgramado == null) {
			return "Timer Programado no ejecutado";
		}
		return "Se ejecuta timeout programado, tiempo transcurrido en segundos: " + 
				calcularDiferencia (fechaEjecucionTimerProgramado, new Date (), TimeUnit.SECONDS);
	}
	
	public String getEstadoTimerAuto () {
		if (fechaEjecucionTimerAuto == null) {
			return "Timer Auto no ejecutado";
		}
		return "Se ejecuta timeout programado, tiempo transcurrido en minutos: " +
				calcularDiferencia (fechaEjecucionTimerAuto, new Date (), TimeUnit.MINUTES);
	}
	
}
