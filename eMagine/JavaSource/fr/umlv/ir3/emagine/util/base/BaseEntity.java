package fr.umlv.ir3.emagine.util.base;

import java.io.Serializable;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratorType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

/**
 * 
 * @author  Administrateur
 */
@Entity(access = AccessType.FIELD)
@Inheritance(strategy=InheritanceType.JOINED )
public class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 15466724567987L;
	
	@Id(generate = GeneratorType.AUTO )
	private Long id;
    @Version
    private Long version;
    private String humanName;

	/**
     * This constructor is necessary for Hibernate, it's used for lazy load
     */
	protected BaseEntity() {super();}

	/**
	 * This method compare id of each object, if id are equals it return true
	 * else it return false
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	//FIXME : Hibernate - method equals de base doit �tre chang�, deplus la method hashCode doit �tre surchar� 
    @Override
	public boolean equals(Object obj) {
		return id == ((BaseEntity)obj).getId();
	}
    
	/**
	 * @return Returns the id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return Returns the version.
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * @param version The version to set.
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * @return Returns the humanName.
	 */
	public String getHumanName() {
		return humanName;
	}

	/**
	 * @param humanName The humanName to set.
	 */
	public void setHumanName(String humanName) {
		this.humanName = humanName;
	}
}
