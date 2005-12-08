package fr.umlv.ir3.emagine.user.profile;

import java.util.Collection;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;

public class RightManager extends BaseManagerImpl<Right, RightDAO> {

	public Collection<Right> findAll() throws EMagineException {
		return getDAO().findAll();	// TODO : getRights javadoc (notamment pour les exceptions)
	}

	public RightDAO getDAO() {
		return DAOManager.getInstance().getRightDAO();
	}
	
	@Override
	public Right retrieve(long id) throws EMagineException {
		return getDAO().retrieve(Right.class, id);
	}

}
