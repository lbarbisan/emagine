/**
 *  
 */
package fr.umlv.ir3.emagine.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

/**
 * @author lbarbisan
 *
 */
@Entity(access = AccessType.FIELD)
public class EmagineEnum<EntityType extends EmagineEnum<EntityType>> extends BaseEntity implements Serializable{

	// S T A T I C
	@ManyToOne
	protected static Map<String ,EmagineEnum> list = new HashMap<String, EmagineEnum>();
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
	@Column(unique = true, nullable = false)
	private String name;
	
	protected EmagineEnum(String name)
	{
		SearchParamsImpl searchParamsImpl = new SearchParamsImpl();
		searchParamsImpl.setField("name", name);
		
		this.name = name;

//		DAOManager.beginTransaction();
//		
//		try {
//			List<EmagineEnum> DBlist =  DAOManager.getInstance().getEmagineEnumDAO().find(searchParamsImpl);
//			if(DBlist.isEmpty())
//			{
//				DAOManager.getInstance().getEmagineEnumDAO().create(this);
//				list.put(name, this);
//			}
//		} catch (EMagineException e) {
//			// TODO Emagine Enum a catch
//		}
//		
//		DAOManager.commitTransaction();
		
	}	
	protected EmagineEnum(){super();}
	
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
