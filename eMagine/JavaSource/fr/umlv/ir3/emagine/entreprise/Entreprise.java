package fr.umlv.ir3.emagine.entreprise;

import java.util.List;

import fr.umlv.ir3.emagine.student.Address;
import fr.umlv.ir3.emagine.util.BaseEntity;

public class Entreprise extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7717597898466060238L;

	//FIXME : l'entreprise peut elle recevoir un publi-postage
	private String name;
	private Entreprise motherEntreprise;
	private Address address;
	private String phone;
	private String Fax;
	private String email;
	private String webSite;
	private List<Job> jobs;
}
