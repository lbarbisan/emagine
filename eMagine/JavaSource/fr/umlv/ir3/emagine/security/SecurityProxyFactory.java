package fr.umlv.ir3.emagine.security;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.base.BaseManager;

public class SecurityProxyFactory {
	/**
	 * Creates a SecurityProxy for the specified Manager
	 * @param <M> Manager type
	 * @param <D> DAO type
	 * @param <E> Entity type
	 * @param rightsInterface
	 * @return the SecurityProxy for the specified Manager
	 * @throws EMagineException if the security filter has not been initialized
	 */
	public static <M extends BaseManager<E, D>, D extends BaseDAO<E>, E extends BaseEntity> M createProxy(M rightsInterface) throws EMagineException {
		return new SecurityProxy<M, D, E>(rightsInterface).getProxy();
	}

}
