package fr.umlv.ir3.emagine.user.profile;

import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import fr.umlv.ir3.emagine.util.base.BaseEntity;

/**
 * This class represent a right in the application, it's associated to a Profile
 * @author eMagine
 *
 */
@Entity(access = AccessType.FIELD)
@Table(name="rightapplication")
public class Right extends BaseEntity {

	private static final long serialVersionUID = -9217586569535677028L;
	
	private String description;
	
	@Column(unique = true)
	private String name;
	private String category;
	
	protected Right() {}
	
	public Right(String fullname) {
		this.setFullName(fullname);
	}
	
	
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
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public void setFullName(String fullName)
	{
		this.name = fullName;
		String[] string =  fullName.split("\\.");
		if(string.length==2)
		{
			this.category = string[0];
		}
		else
		{
			System.err.println(fullName);
		}
	}

	public String getCategory() {
		return category;
	}
}
