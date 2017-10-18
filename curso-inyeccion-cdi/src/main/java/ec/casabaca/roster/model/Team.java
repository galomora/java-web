package ec.casabaca.roster.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (schema="cursojee", name="TEAM")
public class Team implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column (name = "ID")
	@GeneratedValue (generator="TEAM_ID_GEN", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator (schema="cursojee", name="TEAM_ID_GEN", sequenceName="TEAM_ID_SEQ", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@ManyToMany (fetch = FetchType.LAZY)
	@JoinTable (schema="cursojee", name="TEAM_PLAYER", 
	joinColumns={@JoinColumn (name= "TEAM_ID", referencedColumnName="ID")}, 
	foreignKey = @ForeignKey (name="TEAM_TEAM_PLAYER_FK"),
	inverseForeignKey = @ForeignKey (name="PLAYER_TEAM_PLAYER_FK"),
	inverseJoinColumns = {@JoinColumn (name="PLAYER_ID", referencedColumnName= "ID")})
	private List<Player> players;
	
	@Column (name = "CITY", nullable = false)
	private String city;
	
	@Column (name = "NAME", nullable = false)
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		Team other = (Team) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", players=" + players + ", city=" + city + ", name=" + name + "]";
	}
	
}
