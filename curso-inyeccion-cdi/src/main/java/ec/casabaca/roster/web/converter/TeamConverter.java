package ec.casabaca.roster.web.converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ec.casabaca.roster.dao.TeamDAO;
import ec.casabaca.roster.model.Team;

@FacesConverter ("ec.casabaca.TeamConverter")
public class TeamConverter implements Converter {

	@EJB
	private TeamDAO teamDAO;
	
	public Object getAsObject(FacesContext context, UIComponent component, String id) {
		return teamDAO.find(Long.valueOf(id));
	}

	public String getAsString(FacesContext context, UIComponent component, Object teamObject) {
		Team team = (Team) teamObject;
		return String.valueOf(team.getId());
	}

}
