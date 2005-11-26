package fr.umlv.ir3.emagine.entreprise;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.umlv.ir3.emagine.student.candidate.DieEnum;
import fr.umlv.ir3.emagine.util.BaseEntity;

@Entity(access = AccessType.FIELD)
public class Job extends BaseEntity {

	private static final long serialVersionUID = 7997162235010277048L;

	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "entreprise_id")
	private Entreprise entreprise;
	
	private DieEnum cursus;
	private String name;
	private String title;
	private Integer nbPlace;
	
	public DieEnum getCursus() {
		return cursus;
	}
	public void setCursus(DieEnum cursus) {
		this.cursus = cursus;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(Integer nbPlace) {
		this.nbPlace = nbPlace;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
