package ec.casabaca.persona.modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue (value = "EMPLEADO")
@Table (name = "EMPLEADO", schema = "cursojee" )
public class Empleado extends SuperClasePersona {
	
	@Id
	@Column (name = "ID")
	@GeneratedValue (generator="EMPLEADO_ID_GEN", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator (schema="cursojee", name="EMPLEADO_ID_GEN", sequenceName="EMPLEADO_ID_SEQ", initialValue = 1, allocationSize = 1)
	protected Long id;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "DEPARTAMENTO_ID", referencedColumnName = "ID", foreignKey = @ForeignKey (name = "DEPARTAMENTO_EMPLEADO_FK"))
	private Departamento departamento;

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
}
