package fr.umlv.ir3.emagine.student;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.BaseEntity;

@Entity(access = AccessType.FIELD)
public class Mark extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8045472804649001348L;
	
	private Integer value;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
