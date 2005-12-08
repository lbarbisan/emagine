package fr.umlv.ir3.emagine.extraction.mailstype;

import fr.umlv.ir3.emagine.extraction.ExtractionParam;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.Extractable;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseEditableManagerImpl;

public class MailingTypeManager extends BaseEditableManagerImpl<MailingType, MailingTypeDAO> {

	@Override
	public MailingType retrieve(long id) throws EMagineException {
		return getDAO().retrieve(MailingType.class, id);
	}

	@Override
	protected MailingTypeDAO getDAO() {
		ManagerManager instance = ManagerManager.getInstance();
		instance.getMailingTypeManager();
		return null;
	}
	//CRUD
	//TODO : Use case « Créer une mailingType »
	//TODO : Use case « Supprimer une mailingType »
	//TODO : Use case « Ajouter une mailingType »
	//TODO : Use case « Update une mailingType »

	@Override
	public Extractable extract(ExtractionParam extractionParam) {
		// TODO MailingTypeManager.extract()
		return null;
	}
}
