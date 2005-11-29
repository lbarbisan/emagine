package fr.umlv.ir3.emagine.firm;

import java.util.List;

import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseEventableManager;

public class FirmManager extends BaseEventableManager<Firm, FirmDAO> {

	public List<Firm> find(FirmSearchParam entrepriseSearchParam) throws EMagineException {
		return getDAO().find(entrepriseSearchParam);
	}

	@Override
	public void update(Firm firm) throws EMagineException {

		// Creates an event and associates it to this
		Event event = new Event();
		// TODO FirmManager.update Initialiser le event
		addEvent(firm, event);
		
		// TODO FirmManager.update()
		super.update(firm);
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