package fr.umlv.ir3.emagine.extraction.mailstype;

import fr.umlv.ir3.emagine.extraction.ExtractionParam;
import fr.umlv.ir3.emagine.util.Extractable;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseEditableManagerImpl;

public class MailingTypeManager extends BaseEditableManagerImpl<MailingType, MailingTypeDAO> {

	@Override
	protected MailingTypeDAO getDAO() {
		ManagerManager instance = ManagerManager.getInstance();
		instance.getMailingTypeManager();
		return null;
	}

	@Override
	public Extractable extract(ExtractionParam extractionParam) {
		// TODO MailingTypeManager.extract()
		return null;
	}
}
