package fr.umlv.ir3.emagine.extraction.mailings;

import java.util.Collection;

import fr.umlv.ir3.emagine.modification.EditableManagerImpl;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.MailManager;
import fr.umlv.ir3.emagine.util.person.Person;

public class MailingListManager extends EditableManagerImpl<MailingList, MailingListDAO> {

	@Override
	protected MailingListDAO getDAO() {
		return DAOManager.getInstance().getMailingListDAO();
	}

	//CRUD
	//Use case « Créer une mailing-list »
	//Use case « Modifier une mailing-list »
	//Use case « Supprimer des mailing-list »
	//Use case « Visualiser une mailing-list »	
	
	//TODO : Use case « Ajouter un membre à une mailing-list »
	public <PersonType extends Person> void addPerson(MailingList<PersonType> mailingList, PersonType person)
	{
		MailingListDAO mailingListDAO = getDAO();
		DAOManager.beginTransaction();
		try {
			mailingList.getPersons().add(person);
			mailingListDAO.update(mailingList);
			DAOManager.commitTransaction();
		} catch (EMagineException e) {
			DAOManager.rollBackTransaction();
		}
	}
	
	//TODO : Use case « Ajouter des membres à une mailing-list »
	public <PersonType extends Person> void addPersons(MailingList<PersonType> mailingList, Collection<PersonType> persons)
	{
		MailingListDAO mailingListDAO = getDAO();
		DAOManager.beginTransaction();
		try {
			mailingList.getPersons().addAll(persons);
			mailingListDAO.update(mailingList);
			DAOManager.commitTransaction();
		} catch (EMagineException e) {
			DAOManager.rollBackTransaction();
		}
	}
	
	//TODO : Use case « Supprimer un membre à une mailing-list »
	public <PersonType extends Person> void removePerson(MailingList<PersonType> mailingList, PersonType person)
	{
		MailingListDAO mailingListDAO = getDAO();
		DAOManager.beginTransaction();
		try {
			mailingList.getPersons().remove(person);
			mailingListDAO.update(mailingList);
			DAOManager.commitTransaction();
		} catch (EMagineException e) {
			DAOManager.rollBackTransaction();
		}
	}
	
//	TODO : Use case « Supprimer un membre à une mailing-list »
	public <PersonType extends Person> void removePersons(MailingList<PersonType> mailingList, Collection<PersonType> persons)
	{
		MailingListDAO mailingListDAO = getDAO();
		DAOManager.beginTransaction();
		try {
			mailingList.getPersons().removeAll(persons);
			mailingListDAO.update(mailingList);
			DAOManager.commitTransaction();
		} catch (EMagineException e) {
			DAOManager.rollBackTransaction();
		}
	}

	//TODO : Use case « Générer mailing »
	public void generateMailing(MailingList<? extends Person> mailingList, String object, String body, Collection<Attachment> attachments)
	{
		String to = "";
		for(Person user : mailingList.getPersons() )
		{
			to = user.getEmail() + ";";
		}
		try {
			MailManager.sendMail(to, object, body, attachments);
		} catch (EMagineException e) {
			// TODO EMagineException.e Not Implemented
			e.printStackTrace();
		}
	}
}
