package fr.umlv.ir3.emagine.apprentice.candidate;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.security.MustHaveRights;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.EventableManager;

@MustHaveRights("candidate")
public interface CandidateManager extends EventableManager<Candidate, CandidateDAO> {
	/**
	 * Delete a list of candidates.
	 * @param candidates The list of candidates to be deleted
	 * @throws EMagineException if one of those candidates doesn't exist in the database, or if one of them is connected and the force switch is false
	 */
	public abstract void delete(Collection<Candidate> candidates)
			throws EMagineException;

	/**
	 * Integrates the given candidates : apprentices are created, based on the given candidates.
	 * @param candidates
	 * @return the collection of created apprentices
	 * @throws EMagineException if an SQLException errors
	 */
	public abstract Collection<Apprentice> integrate(
			Collection<Candidate> candidates) throws EMagineException;

	/**
	 * Searches for the given candidateSearchParams
	 * @param candidateSearchParams
	 * @return
	 * @throws EMagineException
	 */
	public abstract List<Candidate> find(
			CandidateSearchParams candidateSearchParams)
			throws EMagineException;

}