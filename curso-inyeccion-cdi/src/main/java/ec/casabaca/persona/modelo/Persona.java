package ec.casabaca.persona.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
@Table (name = "PERSONA", schema = "cursojee" )
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "TIPO_PERSONA", discriminatorType = DiscriminatorType.STRING)
@NamedQuery (name="CONSULTAR_PERSONAS", query = "select o from Persona o")
public class Persona {
	@Id
	@Column (name = "ID")
	@GeneratedValue (generator="PERSONA_ID_GEN", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator (schema="cursojee", name="PERSONA_ID_GEN", sequenceName="PERSONA_ID_SEQ", initialValue = 1, allocationSize = 1)
	private Long id;
	@Version
	private Long version;
	@Column (name = "NOMBRE", nullable = false)
	@NotNull
	private String nombre;
	@Past
	@NotNull (message="Fecha de Nacimiento no puede ser null")
	@Column (name = "FECHA_NACIMIENTO", nullable = true)
	private Date fechaNacimiento;
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "DEPARTAMENTO_ID", referencedColumnName = "ID", foreignKey = @ForeignKey (name = "DEPARTAMENTO_PERSONA_FK"))
	private Departamento departamento;
	
	private InformacionUsuario informacionUsuario;
	
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
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public InformacionUsuario getInformacionUsuario() {
		return informacionUsuario;
	}
	public void setInformacionUsuario(InformacionUsuario informacionUsuario) {
		this.informacionUsuario = informacionUsuario;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
