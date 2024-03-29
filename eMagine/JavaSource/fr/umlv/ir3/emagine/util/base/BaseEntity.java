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
public class BaseEntity implements Serializable, Identifiable {
	
	private static final long serialVersionUID = 15466724567987L;
	
	@Id(generate = GeneratorType.AUTO )
	private Long id;
    @Version
    private Long version;
    private String humanName;

	/**
     * This constructor is necessary for Hibernate, it's used for lazy load
     */
	protected BaseEntity() {
		super();
		humanName = this.getClass().getSimpleName();
	}

	/**
	 * This method compare id of each object, if id are equals it return true
	 * else it return false
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	//FIXME : Hibernate - method equals de base doit �tre chang�, deplus la method hashCode doit �tre surchar� 
    @Override
    public boolean equals(Object that) throws IllegalStateException {
       if (this == that) return true;
       if (id == null) throw new IllegalStateException("id not set; use generation instead of creation to obtain an entity with a valid id");
       return id == ((BaseEntity) that).getId();
    }

    @Override
    public int hashCode() throws IllegalStateException {
       if (id == null) throw new IllegalStateException("id not set; use generation instead of creation to obtain an entity with a valid id");
       return id.hashCode();
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
	 * @return Returns the humanName.
	 */
	public String getHumanName() {
		return humanName;
	}
}
