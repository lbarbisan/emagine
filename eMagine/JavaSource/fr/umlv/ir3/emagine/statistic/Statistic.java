package fr.umlv.ir3.emagine.statistic;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.modification.EditableEntity;

@Entity(access = AccessType.FIELD)
public class Statistic extends EditableEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5977430314628500313L;
	
	//FIXME : Hibernate - Trouver une meilleur solution pour la gestion des statistiques
	private String name;
	private String query;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	

}
