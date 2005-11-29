package fr.umlv.ir3.emagine.firm;

import fr.umlv.ir3.emagine.modification.ModificationManager;
import fr.umlv.ir3.emagine.util.DAOManager;

public class JobManager extends ModificationManager<Job, JobDAO> {

	@Override
	protected JobDAO getDAO() {
		return DAOManager.getInstance().getJobDAO();
	}
}