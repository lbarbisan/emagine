package fr.umlv.ir3.emagine.firm;

import java.util.List;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseEditableManager;

public class FirmManager extends BaseEditableManager<Firm, FirmDAO> {

	public List<Firm> getFirms(FirmSearchParam entrepriseSearchParam) throws EMagineException {
		return getDAO().getFirms(entrepriseSearchParam);
	}
	
	@Override
	protected FirmDAO getDAO() {
		return DAOManager.getInstance().getFirmDAO();
	}

	@Override
	public Firm retrieve(long id) throws EMagineException {
		return getDAO().retrieve(Firm.class, id);
	}
}