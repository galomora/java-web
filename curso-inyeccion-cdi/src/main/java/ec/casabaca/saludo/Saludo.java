package ec.casabaca.saludo;

import javax.enterprise.inject.Model;

@Model
public class Saludo {
	public String saludar (String nombre) {
		return "Buenos dias " + nombre + ".";
	}
}
