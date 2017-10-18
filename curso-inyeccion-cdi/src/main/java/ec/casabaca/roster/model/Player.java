package ec.casabaca.roster.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (schema="cursojee", name="PLAYER")
public class Player implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column (name = "ID")
	@GeneratedValue (generator="PLAYER_ID_GEN", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator (schema="cursojee", name="PLAYER_ID_GEN", sequenceName="PLAYER_ID_SEQ", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@ManyToMany (mappedBy = "players", fetch = FetchType.LAZY)
	private List<Team> teams;
	
	@Column (name = "NAME", nullable = false)
	private String name;
	
	@Column (name = "POSITION")
	@Enumerated (EnumType.STRING)
	private PlayerPosition position;
	
	@Column (name = "SALARY")
	private Double salary;
	
	@Transient 
	private String json;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerPosition getPosition() {
		return position;
	}

	public void setPosition(PlayerPosition position) {
		this.position = position;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
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
		Player other = (Player) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", teams=" + teams + ", name=" + name + ", position=" + position + ", salary="
				+ salary + "]";
	}

	

	
}
