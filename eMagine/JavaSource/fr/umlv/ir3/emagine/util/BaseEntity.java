package fr.umlv.ir3.emagine.util;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratorType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Version;

import fr.umlv.ir3.emagine.user.profile.Profile;

/**
 * @author  Administrateur
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "tbl_baseentity")
public class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 15466724567987L;
	
	private Long id;
    private Long version;
	
	protected BaseEntity()
	{}

	/**
	 * @return  Returns the id.
	 * @uml.property  name="id"
	 */
	
	@Id(generate = GeneratorType.AUTO )
	public Long getId() {
		return id;
	}

	/**
	 * @param id  The id to set.
	 * @uml.property  name="id"
	 */
	public void setId(Long id) {
		this.id = id;
	}
    
    @Version
    /**
     * @param version The version to set.
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * @return Returns the version.
     */
    public Long getVersion() {
        return this.version;
    }
    
    @Override
	public boolean equals(Object obj) {
		return id == ((Profile)obj).getId();
	}
	
	
}
