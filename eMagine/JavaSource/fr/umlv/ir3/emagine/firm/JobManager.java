package fr.umlv.ir3.emagine.firm;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.base.EditableManager;

public class JobManager extends EditableManager<Job, JobDAO> {

	@Override
	protected JobDAO getDAO() {
		return DAOManager.getInstance().getJobDAO();
	}
}