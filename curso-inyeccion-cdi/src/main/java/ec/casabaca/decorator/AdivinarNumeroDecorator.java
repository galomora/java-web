package ec.casabaca.decorator;

import java.io.Serializable;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import ec.casabaca.adivinar.numero.AdivinarNumero;

@Decorator
public class AdivinarNumeroDecorator implements AdivinarNumero, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
    @Delegate
    @Any
    AdivinarNumero adivinarNumeroOriginal;

	public void verificar() throws InterruptedException {
		System.out.println("Implementacion adicional en decorador");
		adivinarNumeroOriginal.verificar();
	}

}
