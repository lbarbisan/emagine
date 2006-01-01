package fr.umlv.ir3.emagine.extraction.mailstype;

import fr.umlv.ir3.emagine.modification.EditableManagerImpl;
import fr.umlv.ir3.emagine.util.DAOManager;


public class MailingTypeManagerImpl extends EditableManagerImpl<MailingType, MailingTypeDAO> implements MailingTypeManager {

	@Override
	protected MailingTypeDAO getDAO() {
		return DAOManager.getInstance().getMailingTypeDAO();
	}
}
