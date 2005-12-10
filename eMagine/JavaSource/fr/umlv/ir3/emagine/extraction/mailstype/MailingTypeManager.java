package fr.umlv.ir3.emagine.extraction.mailstype;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.base.BaseEditableManagerImpl;

public class MailingTypeManager extends BaseEditableManagerImpl<MailingType, MailingTypeDAO> {

	@Override
	protected MailingTypeDAO getDAO() {
		return DAOManager.getInstance().getMailingTypeDAO();
	}
}
