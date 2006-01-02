package fr.umlv.ir3.emagine.firm;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.firm.actor.FirmActor;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.EventableManagerImpl;

public class FirmManagerImpl extends EventableManagerImpl<Firm, FirmDAO> implements FirmManager {

	/**
	 * @see fr.umlv.ir3.emagine.firm.FirmManager#find(fr.umlv.ir3.emagine.firm.RapprochementSearchParams)
	 */
	public List<Firm> find(RapprochementSearchParams rapprochementSearchParams) throws EMagineException {
		return super.find(rapprochementSearchParams);
	}

	/**
	 * @see fr.umlv.ir3.emagine.firm.FirmManager#update(fr.umlv.ir3.emagine.firm.Firm)
	 */
	@Override
	public void update(Firm firm) throws EMagineException {
		// Creates an event and associates it to this
		Event event = new Event();
		// TODO FirmManagerImpl.update Initialiser le event
		addEvent(firm, event);
		
		super.update(firm);
		// FIXME : manque les transactions
		// TODO fr.umlv.ir3.emagine.firm.FirmManagerImpl.update(firm)
		throw new EMagineException("exception.unimplementedMethod",
				"fr.umlv.ir3.emagine.firm.FirmManagerImpl.update(firm)");
	}
	
	/**
	 * @see fr.umlv.ir3.emagine.firm.FirmManager#addJob(fr.umlv.ir3.emagine.firm.Firm, fr.umlv.ir3.emagine.firm.Job)
	 */
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

	/**
	 * @see fr.umlv.ir3.emagine.firm.FirmManager#removeJob(fr.umlv.ir3.emagine.firm.Firm, fr.umlv.ir3.emagine.firm.Job)
	 */
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

	/**
	 * @see fr.umlv.ir3.emagine.firm.FirmManager#removeJobs(fr.umlv.ir3.emagine.firm.Firm, java.util.Collection)
	 */
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

	/**
	 * @see fr.umlv.ir3.emagine.firm.FirmManager#addFirmActor(fr.umlv.ir3.emagine.firm.Firm, fr.umlv.ir3.emagine.firm.actor.FirmActor)
	 */
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

	/**
	 * @see fr.umlv.ir3.emagine.firm.FirmManager#removeFirmActor(fr.umlv.ir3.emagine.firm.Firm, fr.umlv.ir3.emagine.firm.actor.FirmActor)
	 */
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

	/**
	 * @see fr.umlv.ir3.emagine.firm.FirmManager#removeFirmActors(fr.umlv.ir3.emagine.firm.Firm, java.util.Collection)
	 */
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
}