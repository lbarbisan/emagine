package fr.umlv.ir3.emagine;

import org.hibernate.Session;

import fr.umlv.ir3.emagine.util.HibernateUtils;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateUtils.getSession();
	}

}
