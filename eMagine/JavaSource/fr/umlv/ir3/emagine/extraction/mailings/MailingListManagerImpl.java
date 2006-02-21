package fr.umlv.ir3.emagine.extraction.mailings;

import java.util.Collection;

import fr.umlv.ir3.emagine.modification.EditableManagerImpl;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.MailManager;
import fr.umlv.ir3.emagine.util.person.Person;

public class MailingListManagerImpl extends EditableManagerImpl<MailingList, MailingListDAO> implements MailingListManager {

	//CRUD
	//Use case « Créer une mailing-list »
	//Use case « Modifier une mailing-list »
	//Use case « Supprimer des mailing-list »
	//Use case « Visualiser une mailing-list »	
	
	/**
	 * @see fr.umlv.ir3.emagine.modification.EditableManagerImpl#getDAO()
	 */
	@Override
	protected MailingListDAO getDAO() {
		return DAOManager.getInstance().getMailingListDAO();
	}

	//TODO : Use case « Ajouter un membre à une mailing-list »
	/**
	 * @see fr.umlv.ir3.emagine.extraction.mailings.MailingListManager#addPerson(fr.umlv.ir3.emagine.extraction.mailings.MailingList, PersonType)
	 */
	public void addPerson(MailingList mailingList, Person person)
	{
		try {
			DAOManager.beginTransaction();
			mailingList.getPersons().add(person);
			getDAO().update(mailingList);
			DAOManager.commitTransaction();
		} catch (EMagineException e) {
			DAOManager.rollBackTransaction();
		}
	}
	
	//TODO : Use case « Ajouter des membres à une mailing-list »
	/**
	 * @see fr.umlv.ir3.emagine.extraction.mailings.MailingListManager#addPersons(fr.umlv.ir3.emagine.extraction.mailings.MailingList, java.util.Collection)
	 */
	public void addPersons(MailingList mailingList, Collection<Person> persons)
	{
		DAOManager.beginTransaction();
		try {
			mailingList.getPersons().addAll(persons);
			getDAO().update(mailingList);
			DAOManager.commitTransaction();
		} catch (EMagineException e) {
			DAOManager.rollBackTransaction();
		}
	}
	
	//TODO : Use case « Supprimer un membre à une mailing-list »
	/**
	 * @see fr.umlv.ir3.emagine.extraction.mailings.MailingListManager#removePerson(fr.umlv.ir3.emagine.extraction.mailings.MailingList, PersonType)
	 */
	public void removePerson(MailingList mailingList, Person person)
	{
		DAOManager.beginTransaction();
		try {
			mailingList.getPersons().remove(person);
			getDAO().update(mailingList);
			DAOManager.commitTransaction();
		} catch (EMagineException e) {
			DAOManager.rollBackTransaction();
		}
	}
	
//	TODO : Use case « Supprimer un membre à une mailing-list »
	/**
	 * @see fr.umlv.ir3.emagine.extraction.mailings.MailingListManager#removePersons(fr.umlv.ir3.emagine.extraction.mailings.MailingList, java.util.Collection)
	 */
	public void removePersons(MailingList mailingList, Collection<Person> persons)
	{
		DAOManager.beginTransaction();
		try {
			mailingList.getPersons().removeAll(persons);
			getDAO().update(mailingList);
			DAOManager.commitTransaction();
		} catch (EMagineException e) {
			DAOManager.rollBackTransaction();
		}
	}

	//TODO : Use case « Générer mailing »
	/**
	 * @throws EMagineException 
	 * @see fr.umlv.ir3.emagine.extraction.mailings.MailingListManager#generateMailing(fr.umlv.ir3.emagine.extraction.mailings.MailingList, java.lang.String, java.lang.String, java.util.Collection)
	 */
	public void generateMailing(MailingList mailingList, String object, String body) throws EMagineException
	{
		// TODO : voir que faire en cas de l'envoie de la moitié des mails ...
		for(Person user : mailingList.getPersons() )
		{
			//FIXME : Pièce jointe
			MailManager.sendMail(user.getEmail(), object, body, null);
		}
	}
}
