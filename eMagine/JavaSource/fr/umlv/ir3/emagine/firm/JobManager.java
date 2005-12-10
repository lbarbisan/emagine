package fr.umlv.ir3.emagine.firm;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.base.BaseEditableManagerImpl;

public class JobManager extends BaseEditableManagerImpl<Job, JobDAO> {
	
	@Override
	protected JobDAO getDAO() {
		DAOManager instance = DAOManager.getInstance();
		return instance.getJobDAO();
	}
}