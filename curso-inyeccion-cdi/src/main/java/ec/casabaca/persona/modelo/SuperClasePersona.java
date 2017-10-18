package ec.casabaca.persona.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@MappedSuperclass
public class SuperClasePersona {
	@Column (name = "CEDULA", nullable = false)
	protected String cedula;
	@Column (name = "NOMBRE", nullable = false)
	protected String nombre;
	@Past
	@NotNull (message="Fecha de Nacimiento no puede ser null")
	@Column (name = "FECHA_NACIMIENTO", nullable = true)
	protected Date fechaNacimiento;
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
}
