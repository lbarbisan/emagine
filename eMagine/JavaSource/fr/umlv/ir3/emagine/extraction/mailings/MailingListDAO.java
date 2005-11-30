package fr.umlv.ir3.emagine.extraction.mailings;

import java.util.List;

import org.hibernate.Session;

import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class MailingListDAO extends BaseDAO<MailingList> {

	public List<MailingList> findAll() {
		Session session = HibernateUtils.getSession();
		return session.createQuery("From MailingList").list();
	}

}
