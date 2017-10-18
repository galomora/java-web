package ec.casabaca.adivinar.numero;

import java.util.Random;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class Productor {
	private Integer numeroMaximo = 100;
	private Random random;
	
	public Productor() {
		random = new Random(100);
	}
	public @Produces @MaxNumber Integer getMaxNumber () {
		return numeroMaximo;
	}
	public @Produces @RandomNumber Integer getRandomNumber () {
		return random.nextInt(numeroMaximo);
	}
}
