package fr.umlv.ir3.emagine.extraction.massmailing;

import fr.umlv.ir3.emagine.extraction.ExtractionParam;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.Extractable;
import fr.umlv.ir3.emagine.util.base.BaseEditableManagerImpl;

public class MassMailingManager extends BaseEditableManagerImpl<MassMailing, MassMailingDAO> {

	@Override
	protected MassMailingDAO getDAO() {
		return DAOManager.getInstance().getMassMailingDAO();
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
