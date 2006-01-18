package fr.umlv.ir3.emagine.util.search;

import java.util.Arrays;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import fr.umlv.ir3.emagine.extraction.Extractable;
import fr.umlv.ir3.emagine.extraction.ObjectListExtractable;
import fr.umlv.ir3.emagine.util.base.BaseEntity;

public abstract class SelectSearchForm<EntityType extends BaseEntity> extends SearchForm<EntityType> {

	
	
	protected Set<String> selectedIds;

	protected String currentSelectedIds[];
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		currentSelectedIds = new String[0];
	}

	public String[] getCurrentSelectedIds() {
		return currentSelectedIds;
	}

	public void setCurrentSelectedIds(String[] currentSelectedIds) {
		this.currentSelectedIds = currentSelectedIds;
	}

	public Set<String> getSelectedIds() {
		return selectedIds;
	}

	public void setSelectedIds(Set<String> selectedId) {
		this.selectedIds = selectedId;
	}
	
	@Override
	public Extractable getExtractable() {
		return new ObjectListExtractable<EntityType>(results, Arrays.asList(currentSelectedIds));
	}
}
