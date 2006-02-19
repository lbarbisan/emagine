package fr.umlv.ir3.emagine.apprentice.candidate;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.base.BaseEntity;

@Entity(access = AccessType.FIELD)
public class Mark extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8045472804649001348L;
	
	private String value;
	private String courseName;
	
	/**
	 * @return Returns the courseName.
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName The courseName to set.
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * @return Returns the value.
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value The value to set.
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
