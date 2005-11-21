package fr.umlv.ir3.emagine.util.core;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

public abstract class SelectSearchForm<BaseType> extends SearchForm<BaseType> {

	protected Set<String> idSelected;

	protected String box[];

	protected String checkbox[];

	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO SelectSearchForm.reset()
	}


	public Set<String> getIdSelected() {
		return idSelected;
	}

	public void setIdSelected(Set<String> idSelected) {
		this.idSelected = idSelected;
	}

	public String[] getBox() {
		return box;
	}

	public void setBox(String[] box) {
		this.box = box;
	}

	public String[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}
}
