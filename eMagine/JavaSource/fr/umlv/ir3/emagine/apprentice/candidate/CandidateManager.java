package fr.umlv.ir3.emagine.apprentice.candidate;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.apprentice.ApprenticeDAO;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseEventableManager;

public class CandidateManager extends BaseEventableManager<Candidate, CandidateDAO> {
	
	/**
	 * Delete a list of candidates.
	 * @param candidates The list of candidates to be deleted
	 * @throws EMagineException if one of those candidates doesn't exist in the database, or if one of them is connected and the force switch is false
	 */
	public void delete(Collection<Candidate> candidates) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			CandidateDAO dao = getDAO();
			for (Candidate candidate : candidates) {
				dao.delete(candidate);
			}
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	/**
	 * Integrates the given candidates : apprentices are created, based on the given candidates.
	 * @param candidates
	 * @return the collection of created apprentices
	 * @throws EMagineException if an SQLException errors
	 */
	public Collection<Apprentice> integrate(Collection<Candidate> candidates) throws EMagineException {
		LinkedList<Apprentice> apprentices = new LinkedList<Apprentice>();
		DAOManager.beginTransaction();
		try {
			DAOManager daoManager = DAOManager.getInstance();
			ApprenticeDAO apprenticeDAO = daoManager.getApprenticeDAO();
			CandidateDAO dao = getDAO();
			for (Candidate candidate : candidates) {
				// Creates the new apprentice, based on the candidate
				Apprentice apprentice = new Apprentice(candidate);	// FIXME : vérifier que les listes sont recrées pour le nouveau apprentice
				apprenticeDAO.create(apprentice);
				// Deletes the old candidate
				dao.delete(candidate);

				apprentices.add(apprentice);
			}
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
		return apprentices;
	}
	
	/**
	 * Searches for the given candidateSearchParams
	 * @param candidateSearchParams
	 * @return
	 * @throws EMagineException
	 */
	public List<Candidate> find(CandidateSearchParams candidateSearchParams) throws EMagineException {
		return super.find(candidateSearchParams);
	}
	
	public @Override CandidateDAO getDAO() {
		return DAOManager.getInstance().getCandidateDAO();
	}
}
