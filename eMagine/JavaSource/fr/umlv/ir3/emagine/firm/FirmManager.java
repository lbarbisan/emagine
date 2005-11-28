package fr.umlv.ir3.emagine.firm;

import java.util.List;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.EditableManager;

public class FirmManager extends EditableManager<Firm, FirmDAO> {

	public List<Firm> getFirms(FirmSearchParam entrepriseSearchParam) throws EMagineException {
		return getDAO().getFirms(entrepriseSearchParam);
	}
	
	@Override
	protected FirmDAO getDAO() {
		return DAOManager.getInstance().getFirmDAO();
	}
}