package fr.umlv.ir3.emagine.extraction.mailstype;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseEditableManager;

public class MailingTypeManager extends BaseEditableManager<MailingType, MailingTypeDAO> {

	@Override
	public MailingType retrieve(long id) throws EMagineException {
		return getDAO().retrieve(MailingType.class, id);
	}

	@Override
	protected BaseDAO<MailingType> getDAO() {
		ManagerManager.getInstance().getMailingTypeManager();
		return null;
	}

	//TODO : Use case « Créer une mailing-list »
	//TODO : Use case « Modifier une mailing-list »
	//TODO : Use case « Ajouter un membre à une mailing-list »
	//TODO : Use case « Supprimer des mailing-list »
	//TODO : Use case « Visualiser une mailing-list »
	//TODO : Use case « Visualiser la liste des mailing-list »
	//TODO : Use case « Générer mailing »


}
