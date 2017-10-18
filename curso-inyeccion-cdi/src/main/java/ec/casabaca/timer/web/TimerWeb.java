package ec.casabaca.timer.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ec.casabaca.timer.ejb.TimerBean;

@Named
@SessionScoped
public class TimerWeb implements Serializable {
	
	@EJB TimerBean timerBean;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	private String estadoTimerAuto;
//	private String estadoTimerProgramado;

	public void invocarTimerProgramado () {
		this.timerBean.ejecutarTimeoutProgramado();
	} 
	
	public void consultarTimerAuto () {
		this.timerBean.getEstadoTimerAuto();
	}

	public String getEstadoTimerAuto() {
		return this.timerBean.getEstadoTimerAuto();
	}

	public String getEstadoTimerProgramado() {
		return this.timerBean.getEstadoTimerProgramado();
	}
	
	
}
