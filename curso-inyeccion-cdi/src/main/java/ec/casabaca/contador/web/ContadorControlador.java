package ec.casabaca.contador.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ec.casabaca.contador.ejb.ContadorBean;
import ec.casabaca.controlador.ControladorBase;

@RequestScoped
@Named
public class ContadorControlador extends ControladorBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ContadorBean contador;
	private Integer cuenta;
	private String estado;
	
	@PostConstruct 
	public void inicializarContadorControlador () {
		incrementar ();
	}	
	private void incrementar () {
		contador.cambiarEstado();
		cuenta = contador.getHits();
		estado = contador.getEstado();
	}
	public Integer getCuenta() {
		return cuenta;
	}
	public String getEstado() {
		return estado;
	}
	
	
}
