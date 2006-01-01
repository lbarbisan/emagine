package fr.umlv.ir3.emagine.firm;

import fr.umlv.ir3.emagine.modification.EditableManagerImpl;
import fr.umlv.ir3.emagine.util.DAOManager;

public class JobManagerImpl extends EditableManagerImpl<Job, JobDAO> implements JobManager {
	
	@Override
	protected JobDAO getDAO() {
		DAOManager instance = DAOManager.getInstance();
		return instance.getJobDAO();
	}
}