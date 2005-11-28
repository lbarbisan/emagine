package fr.umlv.ir3.emagine.entreprise;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.base.BaseManager;

public class JobManager extends BaseManager<Job, JobDAO> {

	@Override
	protected JobDAO getDAO() {
		return DAOManager.getInstance().getJobDAO();
	}
}