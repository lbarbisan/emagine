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
		
		super.update(firm);
	}
	
	public void addJob(Firm firm, Job job) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			firm.getJobs().add(job);
			getDAO().update(firm);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	public void removeJob(Firm firm, Job job) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			firm.getEvents().remove(job);
			getDAO().update(firm);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	public void removeJob(Firm firm, List<Job> jobs) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			firm.getEvents().removeAll(jobs);
			getDAO().update(firm);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
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