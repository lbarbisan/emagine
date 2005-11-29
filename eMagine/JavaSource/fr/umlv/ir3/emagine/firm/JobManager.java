package fr.umlv.ir3.emagine.firm;

import fr.umlv.ir3.emagine.modification.ModificationManager;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public class JobManager extends ModificationManager<Job, JobDAO> {

	@Override
	protected JobDAO getDAO() {
		return DAOManager.getInstance().getJobDAO();
	}

	@Override
	public Job retrieve(long id) throws EMagineException {
		return getDAO().retrieve(Job.class, id);
	}
}