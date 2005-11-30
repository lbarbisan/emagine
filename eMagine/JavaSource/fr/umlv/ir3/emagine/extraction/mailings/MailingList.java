/**
 *  
 */
package fr.umlv.ir3.emagine.extraction.mailings;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import fr.umlv.ir3.emagine.util.base.EditableEntity;
import fr.umlv.ir3.emagine.util.person.Person;

/**
 * @author Laurent
 * @Persistance Terminé
 */
@Entity(access = AccessType.FIELD)
public class MailingList<ObjectType extends Person> extends EditableEntity{

	private static final long serialVersionUID = 7296169511769454784L;
	
	private String Title;
	private String comment;
	/* Ici il n'y a pas besoin d'une liaison bi-driectionnelle */
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},
			targetEntity = Person.class)
	private List<ObjectType> persons;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public List<ObjectType> getPersons() {
		return persons;
	}
	public void setPersons(List<ObjectType> persons) {
		this.persons = persons;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}

}
