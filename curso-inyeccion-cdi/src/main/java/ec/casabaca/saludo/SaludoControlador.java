package ec.casabaca.saludo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class SaludoControlador {
	
	private String mensajeSaludo;
	private String mensajeSaludoFormal;
	private String nombre;
	
	@Inject @Informal
	Saludo saludo;
//	@Inject
//	Saludo saludoFormal;
	
	public void procesarSaludo () {
		mensajeSaludo = this.saludo.saludar(nombre);
//		mensajeSaludoFormal = this.saludoFormal.saludar(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMensajeSaludo() {
		return mensajeSaludo;
	}

	public String getMensajeSaludoFormal() {
		return mensajeSaludoFormal;
	}

	
}
