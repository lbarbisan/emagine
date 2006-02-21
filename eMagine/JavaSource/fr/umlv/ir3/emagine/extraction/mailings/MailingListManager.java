package fr.umlv.ir3.emagine.extraction.mailings;

import java.util.Collection;

import fr.umlv.ir3.emagine.modification.EditableManager;
import fr.umlv.ir3.emagine.security.MustHaveRights;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.person.Person;

@MustHaveRights("mailingList")
public interface MailingListManager extends EditableManager<MailingList, MailingListDAO> {

	//TODO : Use case ��Ajouter un membre � une mailing-list��
	@MustHaveRights("mailingList.update")
	public abstract void addPerson(
			MailingList mailingList, Person person);

	//TODO : Use case ��Ajouter des membres � une mailing-list��
	@MustHaveRights("mailingList.update")
	public abstract void addPersons(
			MailingList mailingList, Collection<Person> persons);

	//TODO : Use case ��Supprimer un membre � une mailing-list��
	@MustHaveRights("mailingList.update")
	public abstract void removePerson(
			MailingList mailingList, Person person);

	//	TODO : Use case ��Supprimer un membre � une mailing-list��
	@MustHaveRights("mailingList.update")
	public abstract void removePersons(
			MailingList mailingList, Collection<Person> persons);

	//TODO : Use case ��G�n�rer mailing��
	public abstract void generateMailing(
			MailingList mailingList, String object,String body) throws EMagineException;

}