package fr.umlv.ir3.emagine.apprentice.candidate;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.modification.EditableManager;
import fr.umlv.ir3.emagine.security.MustHaveRights;
import fr.umlv.ir3.emagine.util.EMagineException;

@MustHaveRights("candidate")
public interface CandidateManager extends EditableManager<Candidate , CandidateDAO> 
{
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
			CandidateSearchParam candidateSearchParams)
			throws EMagineException;

}