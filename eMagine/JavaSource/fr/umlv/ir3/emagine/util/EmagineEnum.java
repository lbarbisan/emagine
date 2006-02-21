/**
 *  
 */
package fr.umlv.ir3.emagine.util;

import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratorType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

import fr.umlv.ir3.emagine.util.base.BaseEntity;

/**
 * @author lbarbisan
 *
 */
@Entity(access = AccessType.FIELD)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class EmagineEnum {

	private static final long serialVersionUID = 41873052571735056L;

	@Id(generate = GeneratorType.AUTO)
	private Long id;
	@Version
	private Long version;
	
	@Column(nullable = false)
	private String name;
	
	public EmagineEnum(){super();}
	protected EmagineEnum(String name)
	{	
		this.name = name;		
	}	
	
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) return true;
		if (id == null) throw new IllegalStateException("id not set; use generation instead of creation to obtain an entity with a valid id");
		return id == ((BaseEntity) that).getId();
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.name;
	}
	/**
	 * @return Returns the id.
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id The id to set.
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return Returns the version.
	 */
	public long getVersion() {
		return version;
	}
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		if (id == null) throw new IllegalStateException("id not set; use generation instead of creation to obtain an entity with a valid id");
		return id.hashCode();
	}
}
