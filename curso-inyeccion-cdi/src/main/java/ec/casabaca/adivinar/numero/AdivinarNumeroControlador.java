package ec.casabaca.adivinar.numero;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Instance;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ec.casabaca.interceptor.LoggingInterceptorBinding;

@Named
@SessionScoped
public class AdivinarNumeroControlador implements Serializable, AdivinarNumero {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject @MaxNumber Integer numeroMaximo;
	
	@Inject @RandomNumber Instance<Integer> randomNumber;
	
	private Integer numeroUsuario;
	private Integer numeroAleatorio;
	private Integer intentosRestantes;
	
	private int maximoActual;
	private int minimoActual;
	
	@PostConstruct 
	public void inicializarControlador () {
		numeroUsuario = 0;
		numeroAleatorio = randomNumber.get();
		minimoActual = 0;
		maximoActual = numeroMaximo;
		intentosRestantes = 10;
	}
	
	public void validateNumberRange(FacesContext context, 
			UIComponent toValidate, 
			Object value) {
		int input = (Integer) value;

		if (input < minimoActual || input > maximoActual) {
			((UIInput) toValidate).setValid(false);
			FacesMessage message = new FacesMessage("Numero ingresado no es valido");
			context.addMessage(toValidate.getClientId(context), message);
		}

	}
	
	@LoggingInterceptorBinding
	public void verificar() throws InterruptedException {
		System.out.println("verificando");
        if (numeroUsuario > numeroAleatorio) {
        	maximoActual = numeroUsuario - 1;
        } else if (numeroUsuario < numeroAleatorio) {
        	minimoActual = numeroUsuario + 1;
        }
        if (numeroUsuario == numeroAleatorio) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage("Numero encontrado!"));
        }
        intentosRestantes--;
    }

	public Integer getNumeroUsuario() {
		return numeroUsuario;
	}

	public void setNumeroUsuario(Integer numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}

	public Integer getNumeroAleatorio() {
		return numeroAleatorio;
	}

	public void setNumeroAleatorio(Integer numeroAleatorio) {
		this.numeroAleatorio = numeroAleatorio;
	}

	public Integer getIntentosRestantes() {
		return intentosRestantes;
	}

	public void setIntentosRestantes(Integer intentosRestantes) {
		this.intentosRestantes = intentosRestantes;
	}

	public int getMaximoActual() {
		return maximoActual;
	}

	public void setMaximoActual(int maximoActual) {
		this.maximoActual = maximoActual;
	}

	public int getMinimoActual() {
		return minimoActual;
	}

	public void setMinimoActual(int minimoActual) {
		this.minimoActual = minimoActual;
	}
	
	
}
