package fr.umlv.ir3.emagine.firm;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.firm.actor.FirmActor;
import fr.umlv.ir3.emagine.security.MustHaveRights;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.EventableManager;

@MustHaveRights("firm")
public interface FirmManager extends EventableManager<Firm, FirmDAO> {

	/**
	 * Lists the firms which want one or more Apprentice of the given courseOption. The list is ordered and tries to put the most asking firms on top.
	 * @param rapprochementSearchParam
	 * @return
	 * @throws EMagineException 
	 */
	public abstract List<Firm> find(
			RapprochementSearchParams rapprochementSearchParams)
			throws EMagineException;

	public abstract void update(Firm firm) throws EMagineException;

	/**
	 * Adds the given job to the given firm
	 * @param firm
	 * @param job
	 * @throws EMagineException
	 */
	@MustHaveRights("firm.update")
	public abstract void addJob(Firm firm, Job job) throws EMagineException;

	/**
	 * Removes the given job from the given firm
	 * @param firm
	 * @param job
	 * @throws EMagineException
	 */
	@MustHaveRights("firm.update")
	public abstract void removeJob(Firm firm, Job job) throws EMagineException;

	/**
	 * Removes the given jobs from the given firm
	 * @param firm
	 * @param jobs
	 * @throws EMagineException
	 */
	@MustHaveRights("firm.update")
	public abstract void removeJobs(Firm firm, Collection<Job> jobs)
			throws EMagineException;

	/**
	 * Adds the given actor to the firm
	 * @param firm
	 * @param actor
	 * @throws EMagineException
	 */
	@MustHaveRights("firm.update")
	public abstract void addFirmActor(Firm firm, FirmActor actor)
			throws EMagineException;

	/**
	 * Removes the given actor from the given firm
	 * @param firm
	 * @param actor
	 * @throws EMagineException
	 */
	@MustHaveRights("firm.update")
	public abstract void removeFirmActor(Firm firm, FirmActor actor)
			throws EMagineException;

	/**
	 * Removes the given actors from the given firm
	 * @param firm
	 * @param actors
	 * @throws EMagineException
	 */
	@MustHaveRights("firm.update")
	public abstract void removeFirmActors(Firm firm,
			Collection<FirmActor> actors) throws EMagineException;
	
	public List <Firm> getFirmsLessParentFirms(Firm firm) throws EMagineException;
}