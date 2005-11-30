package fr.umlv.ir3.emagine.extraction.mailings;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.MailManager;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseEditableManager;
import fr.umlv.ir3.emagine.util.person.Person;

public class MailingListManager extends BaseEditableManager<MailingList, MailingListDAO> {

	@Override
	public MailingList retrieve(long id) throws EMagineException {
		// TODO MailingListManager.retrieve()
		return null;
	}

	@Override
	protected MailingListDAO getDAO() {
		ManagerManager instance = ManagerManager.getInstance();
		instance.getMailingListManager();
		return null;
	}

	//CRUD
	//Use case ��Cr�er une mailing-list��
	//Use case ��Modifier une mailing-list��
	//Use case ��Supprimer des mailing-list��
	//Use case ��Visualiser une mailing-list��	
	
	//TODO : Use case ��Ajouter un membre � une mailing-list��
	public void addPerson(MailingList mailingList, Person person)
	{
		MailingListDAO mailingListDAO = getDAO();
		DAOManager.beginTransaction();
		mailingList.getPersons().add(person);
		try {
			mailingListDAO.update(mailingList);
			DAOManager.commitTransaction();
		} catch (EMagineException e) {
			DAOManager.rollBackTransaction();
		}
	}
	
	//TODO : Use case ��Ajouter des membres � une mailing-list��
	public void addPersons(MailingList mailingList, Collection<Person> persons)
	{
		MailingListDAO mailingListDAO = getDAO();
		DAOManager.beginTransaction();
		mailingList.getPersons().add(persons);
		try {
			mailingListDAO.update(mailingList);
			DAOManager.commitTransaction();
		} catch (EMagineException e) {
			DAOManager.rollBackTransaction();
		}
	}
	
	//TODO : Use case ��Supprimer un membre � une mailing-list��
	public void removePerson(MailingList mailingList, Person person)
	{
		MailingListDAO mailingListDAO = getDAO();
		DAOManager.beginTransaction();
		mailingList.getPersons().remove(person);
		try {
			mailingListDAO.update(mailingList);
			DAOManager.commitTransaction();
		} catch (EMagineException e) {
			DAOManager.rollBackTransaction();
		}
	}
	
//	TODO : Use case ��Supprimer un membre � une mailing-list��
	public void removePersons(MailingList mailingList, Collection<Person> persons)
	{
		MailingListDAO mailingListDAO = getDAO();
		DAOManager.beginTransaction();
		mailingList.getPersons().remove(persons);
		try {
			mailingListDAO.update(mailingList);
			DAOManager.commitTransaction();
		} catch (EMagineException e) {
			DAOManager.rollBackTransaction();
		}
	}

	//TODO : Use case ��Visualiser la liste des mailing-list��
	public List<MailingList> findAll()
	{
		MailingListDAO mailingListDAO = getDAO();
		return mailingListDAO.findAll();
	}

	
	//TODO : Use case ��G�n�rer mailing��
	public void generateMailing(MailingList<? extends Person> mailingList, String object, Collection<Attachment> attachments)
	{
		String to = "";
		for(Person user : mailingList.getPersons() )
		{
			to = user.getEmail() + ";";
		}
		try {
			MailManager.sendMail(to, object, attachments);
		} catch (EMagineException e) {
			// TODO EMagineException.e Not Implemented
			e.printStackTrace();
		}
	}



}