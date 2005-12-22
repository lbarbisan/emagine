package fr.umlv.ir3.emagine.firm;

import fr.umlv.ir3.emagine.modification.EditableManagerImpl;
import fr.umlv.ir3.emagine.util.DAOManager;

public class JobManager extends EditableManagerImpl<Job, JobDAO> {
	
	@Override
	protected JobDAO getDAO() {
		DAOManager instance = DAOManager.getInstance();
		return instance.getJobDAO();
	}
}