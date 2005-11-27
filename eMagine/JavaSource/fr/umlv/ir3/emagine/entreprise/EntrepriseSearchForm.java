package fr.umlv.ir3.emagine.entreprise;

import fr.umlv.ir3.emagine.util.IsAField;
import fr.umlv.ir3.emagine.util.search.SelectSearchForm;

public class EntrepriseSearchForm extends SelectSearchForm<Entreprise> implements EntrepriseSearchParam {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2405706291327109100L;

	@IsAField
	private String name;

	private boolean deletionForced;

	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public boolean isDeletionForced() {
		return deletionForced;
	}

	public void setDeletionForced(boolean forceDeletion) {
		this.deletionForced = forceDeletion;
	}
}
