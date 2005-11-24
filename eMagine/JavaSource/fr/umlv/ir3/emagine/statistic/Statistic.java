package fr.umlv.ir3.emagine.statistic;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.BaseEntity;

@Entity(access = AccessType.FIELD)
public class Statistic extends BaseEntity{
	
	//FIXME Trouver une meilleur solution
	private String name;
	private String query;
	

}
