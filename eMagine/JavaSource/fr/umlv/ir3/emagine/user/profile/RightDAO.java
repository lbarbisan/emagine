package fr.umlv.ir3.emagine.user.profile;

import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class RightDAO extends BaseDAO<Right> {
	
	public List<String> findCategories() {
		List<Object[]> list = HibernateUtils
				.getSession()
				.createQuery(
						"select distinct rights.category from Right rights")
				.list();
		if (list.size() <= 0) {
			return null;
		}
		
		List<String> listCategory = new ArrayList<String>();
		for(Object[] objects: list)
		{
			listCategory.add((String)objects[0]);
		}
		return listCategory;
	}
	
	public List<Right> findRightsFor(String category)
	{
		List<Right> list = HibernateUtils
		.getSession()
		.createQuery(
				"Right rights where rights.category like '" + category + "'")
		.list();
		if (list.size() <= 0) {
			return null;
		}
		return list;
	}
	
//	public Map<String, List<Right>> findRightsOrderByCategories()
//	{
//		List<Object[]> list = HibernateUtils
//		.getSession()
//		.createQuery(
//				"select right.category, right from Right right where right.category like '" + category + "'")
//		.list();
//		if (list.size() <= 0) {
//			return null;
//		}
//		return list;
//	}
}
