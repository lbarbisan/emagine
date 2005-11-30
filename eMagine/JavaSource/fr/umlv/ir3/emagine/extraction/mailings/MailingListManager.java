package fr.umlv.ir3.emagine.extraction.mailings;

import java.util.List;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseEditableManager;
import fr.umlv.ir3.emagine.util.person.Person;

public class MailingListManager extends BaseEditableManager<MailingList, MailingListDAO> {

	@Override
	public MailingList retrieve(long id) throws EMagineException {
		// TODO MailingListManager.retrieve()
		return null;
	}

	@Override
	protected BaseDAO<MailingList> getDAO() {
		ManagerManager.getInstance().getMailingListManager();
		return null;
	}

	//CRUD
	//Use case « Créer une mailing-list »
	//Use case « Modifier une mailing-list »
	//Use case « Supprimer des mailing-list »
	//Use case « Visualiser une mailing-list »	
	
	//TODO : Use case « Ajouter un membre à une mailing-list »
	public List<MailingList> AddPerson(Person person)
	{
		return null;
	}

	//TODO : Use case « Visualiser la liste des mailing-list »
	public List<MailingList> findAll()
	{
		return null;
	}

	
	//TODO : Use case « Générer mailing »
	public List<MailingList> generateMailing(MailingList list)
	{
		return null;
	}



}
