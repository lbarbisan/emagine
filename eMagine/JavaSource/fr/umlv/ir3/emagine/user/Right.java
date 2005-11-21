package fr.umlv.ir3.emagine.user;

import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import fr.umlv.ir3.emagine.util.core.BaseEntity;

/**
 * This class represent a right in the application, it's associated to a Profile
 * @author eMagine
 *
 */
@Entity(access = AccessType.FIELD)
@Table(name="tbl_right")
public class Right extends BaseEntity {
	String description;
	
	@Column(unique = true)
	String name;
	
	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return Returns the name.
	 */
	
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
