package ec.casabaca.saludo;

import javax.enterprise.inject.Model;

@Informal
@Model
public class SaludoInformal extends Saludo {

	@Override
	public String saludar(String nombre) {
		return "Hola " + nombre + "!";
	}
	
}
