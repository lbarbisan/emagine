/**
 *  
 */
package fr.umlv.ir3.emagine.extraction.mailings;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import fr.umlv.ir3.emagine.util.BaseEntity;
import fr.umlv.ir3.emagine.util.Person;

/**
 * @author Laurent
 * @Persistance Terminé
 */
@Entity(access = AccessType.FIELD)
public class MailingList<ObjectType extends Person> extends BaseEntity{

	private static final long serialVersionUID = 7296169511769454784L;
	
	private String Title;
	private String Comment;
	/* Ici il n'y a pas besoin d'une liaison bi-driectionnelle */
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},
			targetEntity = Person.class)
	private List<ObjectType> persons;

}
