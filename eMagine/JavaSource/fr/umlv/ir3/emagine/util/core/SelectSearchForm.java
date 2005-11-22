package fr.umlv.ir3.emagine.util.core;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

public abstract class SelectSearchForm<BaseType> extends SearchForm<BaseType> {

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
}
