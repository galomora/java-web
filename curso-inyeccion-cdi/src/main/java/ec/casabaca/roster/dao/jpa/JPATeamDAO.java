package ec.casabaca.roster.dao.jpa;

import javax.ejb.Local;
import javax.ejb.Stateless;

import ec.casabaca.dao.GenericDaoImpl;
import ec.casabaca.roster.dao.TeamDAO;
import ec.casabaca.roster.model.Team;
@Stateless
@Local (TeamDAO.class)
public class JPATeamDAO extends GenericDaoImpl<Team, Long> implements TeamDAO {

}
