package fr.umlv.ir3.emagine.firm;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.firm.actor.FirmActor;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.EventableManager;

public class FirmManager extends EventableManager<Firm, FirmDAO> {

	/**
	 * Lists the firms which want one or more Apprentice of the given courseOption. The list is ordered and tries to put the most asking firms on top.
	 * @param rapprochementSearchParam
	 * @return
	 * @throws EMagineException 
	 */
	public List<Firm> find(RapprochementSearchParams rapprochementSearchParams) throws EMagineException {
		return super.find(rapprochementSearchParams);
	}

	@Override
	public void update(Firm firm) throws EMagineException {
		// Creates an event and associates it to this
		Event event = new Event();
		// TODO FirmManager.update Initialiser le event
		addEvent(firm, event);
		
		super.update(firm);
		// FIXME : manque les transactions
		// TODO fr.umlv.ir3.emagine.firm.FirmManager.update(firm)
		throw new EMagineException("exception.unimplementedMethod",
				"fr.umlv.ir3.emagine.firm.FirmManager.update(firm)");
	}
	
	/**
	 * Adds the given job to the given firm
	 * @param firm
	 * @param job
	 * @throws EMagineException
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
	 * Removes the given job from the given firm
	 * @param firm
	 * @param job
	 * @throws EMagineException
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
	 * Removes the given jobs from the given firm
	 * @param firm
	 * @param jobs
	 * @throws EMagineException
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
	 * Adds the given actor to the firm
	 * @param firm
	 * @param actor
	 * @throws EMagineException
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
	 * Removes the given actor from the given firm
	 * @param firm
	 * @param actor
	 * @throws EMagineException
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
	 * Removes the given actors from the given firm
	 * @param firm
	 * @param actors
	 * @throws EMagineException
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