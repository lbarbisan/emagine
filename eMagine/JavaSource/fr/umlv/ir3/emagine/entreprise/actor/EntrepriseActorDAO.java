package fr.umlv.ir3.emagine.entreprise.actor;

import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class EntrepriseActorDAO extends BaseDAO<EntrepriseActor> {
	@Override
	public EntrepriseActor retrieve(long id) {
	  	return (EntrepriseActor) HibernateUtils.getSession().load(EntrepriseActor.class, id);
	}
}