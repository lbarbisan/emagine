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
	
}
