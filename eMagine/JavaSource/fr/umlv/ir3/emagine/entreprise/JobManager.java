package fr.umlv.ir3.emagine.entreprise;

import java.util.List;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManager;

public class JobManager extends BaseManager<Job, JobDAO> {

	public List<Job> getJobs() throws EMagineException {
		return getDAO().getJobs();
	}
	
	@Override
	protected JobDAO getDAO() {
		return DAOManager.getInstance().getJobDAO();
	}
}