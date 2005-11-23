/**
 *  
 */
package fr.umlv.ir3.emagine.extraction.mailings;

import java.util.List;

import fr.umlv.ir3.emagine.util.BaseEntity;
import fr.umlv.ir3.emagine.util.Person;

/**
 * @author Laurent
 *
 */
public class MailingList<ObjectType extends Person> extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7296169511769454784L;
	
	private String Title;
	private String Comment;
	private List<ObjectType> persons;

}
