package fr.umlv.ir3.emagine.apprentice.candidate;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.apprentice.ApprenticeDAO;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.EventableManagerImpl;

public class CandidateManagerImpl extends EventableManagerImpl<Candidate, CandidateDAO> implements CandidateManager {
	
	/**
	 * @see fr.umlv.ir3.emagine.apprentice.candidate.CandidateManager#delete(java.util.Collection)
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
	 * @see fr.umlv.ir3.emagine.apprentice.candidate.CandidateManager#integrate(java.util.Collection)
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
	 * @see fr.umlv.ir3.emagine.apprentice.candidate.CandidateManager#find(fr.umlv.ir3.emagine.apprentice.candidate.CandidateSearchParams)
	 */
	public List<Candidate> find(CandidateSearchParams candidateSearchParams) throws EMagineException {
		return super.find(candidateSearchParams);
	}
	
	public @Override CandidateDAO getDAO() {
		return DAOManager.getInstance().getCandidateDAO();
	}
}
