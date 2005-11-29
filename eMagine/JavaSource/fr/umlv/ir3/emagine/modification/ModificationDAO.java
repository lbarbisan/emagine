/**
 *  
 */
package fr.umlv.ir3.emagine.modification;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

/**
 * @author Laurent
 *
 */
public class ModificationDAO extends BaseDAO<Modification> {

	@Override
	public Modification retrieve(long id) throws EMagineException {
		return (Modification) HibernateUtils.getSession().load(Modification.class, id);
	}

}
