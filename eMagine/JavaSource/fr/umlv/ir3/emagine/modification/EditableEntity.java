package fr.umlv.ir3.emagine.modification;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import fr.umlv.ir3.emagine.util.base.BaseEntity;

/**
 * 
 * @author  Administrateur
 */
@Entity(access = AccessType.FIELD)
public abstract class EditableEntity extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 15466724567987L;
	
    @OneToMany(cascade=CascadeType.ALL,
    			mappedBy = "editableEntity")
	private List<Modification> modifications = new ArrayList<Modification>();

    /**
     * This constructor is necessary for Hibernate, it's used for lazy load
     */
	protected EditableEntity() {super();}

	/**
	 * @return the list of modifications for this class
	 */
	public List<Modification> getModifications() {
		return modifications;
	}	
	/**
	 * @return the current modification, or null if no modification exist
	 */
	public Modification getCurrentModification() {
		if(modifications.size()==0) {
			return null;
		}
		else {
			return modifications.get(modifications.size()-1);
		}
	}
}