/**
 *  
 */
package fr.umlv.ir3.emagine.extraction.mailings;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.modification.EditableEntity;
import fr.umlv.ir3.emagine.util.person.Person;

/**
 * @author Laurent
 * @Persistance Terminé
 */
@Entity(access = AccessType.FIELD)
public class MailingList extends EditableEntity {

	private static final long serialVersionUID = 7296169511769454784L;
	
	private String title;
	private String comment;
	/* Ici il n'y a pas besoin d'une liaison bi-driectionnelle */
	@OneToMany(targetEntity = Person.class)
	@Cascade(CascadeType.SAVE_UPDATE)
	
	private List<Person> persons;
	/**
	 * @return Returns the comment.
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment The comment to set.
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return Returns the persons.
	 */
	public List<Person> getPersons() {
		return persons;
	}
	/**
	 * @param persons The persons to set.
	 */
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	/**
	 * @return Returns the title.
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title The title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}
