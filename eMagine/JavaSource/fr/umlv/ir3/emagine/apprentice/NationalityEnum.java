/**
 *  
 */
package fr.umlv.ir3.emagine.apprentice;


/**
 * @author Laurent
 *
 */
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
}
