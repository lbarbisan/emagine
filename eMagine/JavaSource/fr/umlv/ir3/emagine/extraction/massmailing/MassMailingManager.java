package fr.umlv.ir3.emagine.extraction.massmailing;

import fr.umlv.ir3.emagine.extraction.ExtractionParam;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.Extractable;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseEditableManagerImpl;

public class MassMailingManager extends BaseEditableManagerImpl<MassMailing, MassMailingDAO> {

	@Override
	public MassMailing retrieve(long id) throws EMagineException {
		return getDAO().retrieve(MassMailing.class, id);
	}

	@Override
	protected MassMailingDAO getDAO() {
		ManagerManager instance = ManagerManager.getInstance();
		instance.getMailingTypeManager();
		return null;
	}

	@Override
	public Extractable extract(ExtractionParam extractionParam) {
		// TODO MassMailingManager.extract()
		return null;
	}
	
	//CRUD
	//Use case « créer un publipostage »
	//Use case « supprimer un publipostage »
	//Use case « mettre à jour un publipostage »
	//Use case « charger un publipostage »
	
}
