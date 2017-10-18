package ec.casabaca.persona.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Usuario
 *
 */
@Entity
//@DiscriminatorValue (value = "CLIENTE")
@Table (name = "CLIENTE", schema = "cursojee" )
public class Cliente extends SuperClasePersona {
	@Id
	@Column (name = "ID")
	@GeneratedValue (generator="CLIENTE_ID_GEN", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator (schema="cursojee", name="CLIENTE_ID_GEN", sequenceName="CLIENTE_ID_SEQ", initialValue = 1, allocationSize = 1)
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
