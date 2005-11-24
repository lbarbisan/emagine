package fr.umlv.ir3.emagine.statistic;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.BaseEntity;

@Entity(access = AccessType.FIELD)
public class Statistic extends BaseEntity{
	
	//FIXME : Hibernate - Trouver une meilleur solution pour la gestion des statistiques
	private String name;
	private String query;
	

}
