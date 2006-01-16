/**
 *  
 */
package fr.umlv.ir3.emagine.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import fr.umlv.ir3.emagine.util.base.BaseEntity;

/**
 * @author lbarbisan
 *
 */
@Entity(access = AccessType.FIELD)
public class EmagineEnum extends BaseEntity implements Serializable{

	// S T A T I C
	@ManyToOne
	private static Map<String ,EmagineEnum> list = new HashMap<String, EmagineEnum>();
	private static final long serialVersionUID = 3836342655386886511L;
	public static Map<String, EmagineEnum> getList()
	{
		return list;
	}
	public static EmagineEnum enumFor(String name)
	{
		return list.get(name);
	}
	
	// I N S T A N C E S
	private final String name;

	protected EmagineEnum(String name)
	{
		this.name = name;
		list.put(name, this);
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
