package fr.umlv.ir3.emagine.extraction.mailings;

import java.util.Collection;

import fr.umlv.ir3.emagine.modification.EditableManager;
import fr.umlv.ir3.emagine.util.person.Person;

public interface MailingListManager extends EditableManager<MailingList, MailingListDAO> {

	//TODO : Use case « Ajouter un membre à une mailing-list »
	public abstract <PersonType extends Person> void addPerson(
			MailingList<PersonType> mailingList, PersonType person);

	//TODO : Use case « Ajouter des membres à une mailing-list »
	public abstract <PersonType extends Person> void addPersons(
			MailingList<PersonType> mailingList, Collection<PersonType> persons);

	//TODO : Use case « Supprimer un membre à une mailing-list »
	public abstract <PersonType extends Person> void removePerson(
			MailingList<PersonType> mailingList, PersonType person);

	//	TODO : Use case « Supprimer un membre à une mailing-list »
	public abstract <PersonType extends Person> void removePersons(
			MailingList<PersonType> mailingList, Collection<PersonType> persons);

	//TODO : Use case « Générer mailing »
	public abstract void generateMailing(
			MailingList<? extends Person> mailingList, String object,
			String body, Collection<Attachment> attachments);

}