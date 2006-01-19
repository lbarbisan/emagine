/**
 *  
 */
package fr.umlv.ir3.emagine.apprentice;


import fr.umlv.ir3.emagine.util.EmagineEnum;

/**
 * @author Laurent
 *
 */
<<<<<<< .mine
public class NationalityEnum extends EmagineEnum{
	public NationalityEnum(String string) {
		super(string);
	}

	private static final long serialVersionUID = 729255237916282703L;
=======
public enum NationalityEnum {
	FRENCH("française"),
	ENGLISH("anglaise");
	
	private String name;
	private NationalityEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return this.toString();
	}
>>>>>>> .r503
}
