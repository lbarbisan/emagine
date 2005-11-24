package fr.umlv.ir3.emagine.entreprise;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.umlv.ir3.emagine.util.BaseEntity;

@Entity(access = AccessType.FIELD)
public class Job extends BaseEntity {
	private String name;
	
	//FIXME : filière... ?
	//private DieEnum cursus;
	private String title;
	private Integer nbPlace;
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "jobs_fk")
	private Entreprise entreprise;
	
}
