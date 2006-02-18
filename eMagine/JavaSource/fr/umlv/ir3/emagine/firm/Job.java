package fr.umlv.ir3.emagine.firm;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.apprentice.candidate.CourseOptionEnum;
import fr.umlv.ir3.emagine.modification.EditableEntity;

@Entity(access = AccessType.FIELD)
public class Job extends EditableEntity {

	private static final long serialVersionUID = 1711695127749986129L;

	@ManyToOne()
	@JoinColumn(name = "firm_id")
	private Firm firm;
	
	@ManyToOne()
    @JoinColumn(name="cursus_id")
    @Cascade(CascadeType.SAVE_UPDATE)
	private CourseOptionEnum cursus;
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
	public Integer getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(Integer nbPlace) {
		this.nbPlace = nbPlace;
	}
}
