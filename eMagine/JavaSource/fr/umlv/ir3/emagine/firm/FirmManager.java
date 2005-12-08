package fr.umlv.ir3.emagine.firm;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.extraction.ExtractionParam;
import fr.umlv.ir3.emagine.firm.actor.FirmActor;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.Extractable;
import fr.umlv.ir3.emagine.util.base.BaseEventableManager;

public class FirmManager extends BaseEventableManager<Firm, FirmDAO> {

	/**
	 * Lists the firms which want one or more Apprentice of the given courseOption. The list is ordered and tries to put the most asking firms on top.
	 * @param rapprochementSearchParam
	 * @return
	 */
	public List<Firm> find(RapprochementSearchParam rapprochementSearchParam) {
		FirmDAO dao = getDAO();
		return dao.find(rapprochementSearchParam);
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
			Collection<Job> jobs = firm.getJobs();
			jobs.add(job);
			FirmDAO dao = getDAO();
			dao.update(firm);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	public void removeJob(Firm firm, Job job) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			Collection<Job> jobs = firm.getJobs();
			jobs.remove(job);
			FirmDAO dao = getDAO();
			dao.update(firm);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	public void removeJobs(Firm firm, Collection<Job> jobs) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			Collection<Job> jobCollection = firm.getJobs();
			jobCollection.removeAll(jobs);
			FirmDAO dao = getDAO();
			dao.update(firm);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	public void addFirmActor(Firm firm, FirmActor actor) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			Collection<FirmActor> actors = firm.getFirmActors();
			actors.add(actor);
			FirmDAO dao = getDAO();
			dao.update(firm);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	public void removeFirmActor(Firm firm, FirmActor actor) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			Collection<FirmActor> actors = firm.getFirmActors();
			actors.remove(actor);
			FirmDAO dao = getDAO();
			dao.update(firm);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	public void removeFirmActors(Firm firm, Collection<FirmActor> actors) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			Collection<FirmActor> actorCollection = firm.getFirmActors();
			actorCollection.removeAll(actors);
			FirmDAO dao = getDAO();
			dao.update(firm);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}	
	
	@Override
	protected FirmDAO getDAO() {
		DAOManager instance = DAOManager.getInstance();
		return instance.getFirmDAO();
	}

	@Override
	public Firm retrieve(long id) throws EMagineException {
		FirmDAO dao = getDAO();
		return dao.retrieve(id);
	}

	@Override
	public Extractable extract(ExtractionParam extractionParam) {
		// TODO FirmManager.extract()
		return null;
	}
}