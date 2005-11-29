package fr.umlv.ir3.emagine.firm;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseEditableManager;

public class JobManager extends BaseEditableManager<Job, JobDAO> {

	@Override
	protected JobDAO getDAO() {
		return DAOManager.getInstance().getJobDAO();
	}

	@Override
	public Job retrieve(long id) throws EMagineException {
		return getDAO().retrieve(Job.class, id);
	}
}