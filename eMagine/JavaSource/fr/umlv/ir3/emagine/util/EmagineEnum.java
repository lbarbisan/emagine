/**
 *  
 */
package fr.umlv.ir3.emagine.util;

import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.base.BaseEntity;

/**
 * @author lbarbisan
 *
 */
@Entity(access = AccessType.FIELD)
public class EmagineEnum extends BaseEntity{

	private static final long serialVersionUID = 41873052571735056L;
	 
	@Column(unique = true, nullable = false)
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
	public boolean equals(Object obj) {
		if(obj.getClass()==this.getClass())
		{
			return ((EmagineEnum)obj).getName().equals(this.getName());
		}
		return false;
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.name;
	}
}
