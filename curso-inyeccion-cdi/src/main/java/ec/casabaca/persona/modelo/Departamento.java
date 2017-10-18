package ec.casabaca.persona.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "DEPARTAMENTO", schema = "cursojee" )
public class Departamento {
	@Id
	@Column (name = "ID")
	@GeneratedValue (generator="DEPARTAMENTO_ID_GEN", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator (schema="cursojee", name="DEPARTAMENTO_ID_GEN", sequenceName="DEPARTAMENTO_ID_SEQ", initialValue = 1, allocationSize = 1)
	private Long id;
	@Column (name = "NOMBRE", nullable = false)
	@NotNull
	private String nombre;
	@OneToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy="departamento", orphanRemoval = true)
	private List<Empleado> empleados;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	
}
