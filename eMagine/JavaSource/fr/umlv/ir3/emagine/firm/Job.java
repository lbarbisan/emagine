package fr.umlv.ir3.emagine.firm;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.umlv.ir3.emagine.student.candidate.CourseOptionEnum;
import fr.umlv.ir3.emagine.util.base.BaseEntity;

@Entity(access = AccessType.FIELD)
public class Job extends BaseEntity {

	private static final long serialVersionUID = 7997162235010277048L;

	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "firm_id")
	private Firm firm;
	
	private CourseOptionEnum cursus;
	private String name;
	private String title;
	private Integer nbPlace;
	
	public CourseOptionEnum getCursus() {
		return cursus;
	}
	public void setCursus(CourseOptionEnum cursus) {
		this.cursus = cursus;
	}
	public Firm getFirm() {
		return firm;
	}
	public void setFirm(Firm firm) {
		this.firm = firm;
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
