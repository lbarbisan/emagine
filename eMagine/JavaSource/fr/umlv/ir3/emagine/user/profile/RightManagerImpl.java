package fr.umlv.ir3.emagine.user.profile;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;

public class RightManagerImpl extends BaseManagerImpl<Right, RightDAO> implements RightManager {
	public RightDAO getDAO() {
		return DAOManager.getInstance().getRightDAO();
	}
}
