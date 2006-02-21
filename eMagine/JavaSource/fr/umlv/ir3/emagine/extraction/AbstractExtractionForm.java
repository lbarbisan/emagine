package fr.umlv.ir3.emagine.extraction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import fr.umlv.ir3.emagine.util.base.Identifiable;
import fr.umlv.ir3.emagine.util.search.SearchForm;

public abstract class AbstractExtractionForm<I extends Identifiable> extends ActionForm implements ExtractionForm<I> {

	private static final long serialVersionUID = -3336470878301794439L;

	/**
	 * Used to know if the configuration must be saved
	 */
	protected boolean saveConfig;

	/**
	 * Type of extraction (XLS / CSV)
	 */
	protected ExtractionType extractionType;

	/**
	 * All the selected entity properties for the extraction entity
	 */
	protected String[] selectedEntityProperties;
	
	/**
	 * All the entityProperties of the form
	 *//*
	private Collection<String> entityProperties;*/

	/**
	 * The current selected ids of the form
	 */
	private String[] currentSelectedIds;

	/**
	 * @return Returns the extractionType.
	 */
	public ExtractionType getExtractionType() {
		return extractionType;
	}

	/**
	 * @param extractionType The extractionType to set.
	 */
	public void setExtractionType(ExtractionType extractionType) {
		this.extractionType = extractionType;
	}
	
	
	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionShowForm#setExtractionType(java.lang.String)
	 */
	public void setExtractionTypeName(String extractionTypeName) {
		this.extractionType = ExtractionType.valueOf(extractionTypeName);
	}
	
	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionShowForm#getExtractionTypeName()
	 */
	public String getExtractionTypeName() {
		return extractionType != null ? extractionType.toString() : null;
	}


	/**
	 * @return Returns the saveConfig.
	 */
	public boolean isSaveConfig() {
		return saveConfig;
	}

	/**
	 * @param saveConfig The saveConfig to set.
	 */
	public void setSaveConfig(boolean saveConfig) {
		this.saveConfig = saveConfig;
	}

	
	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionShowForm#getEntityProperties()
	 *//*
	public Collection<String> getEntityProperties() {
		if (entityProperties != null) {
			return entityProperties;
		}
		entityProperties = new ArrayList<String>();
		for (Method m : this.getClass().getDeclaredMethods()) {
			if (m.getAnnotation(NotAField.class) == null) {
				// This method can be a field, if it begins with "get" or "is"
				int prefixLength = -1;
				if (m.getName().startsWith("get")) {
					prefixLength = 3;
				} else if (m.getName().startsWith("is")) {
					prefixLength = 2;
				}
				if (prefixLength > 0) {
					// This method represents a field. It must be added in the list
					String fieldName = m.getName().substring(prefixLength, prefixLength + 1).toLowerCase() + m.getName().substring(prefixLength + 1);
					if (BaseEntity.class.isAssignableFrom(m.getReturnType())) {
						// This method returns a baseEntity : we will add all the entityProperties of the sub-entity
						// TODO to be continued...
					}
					entityProperties.add(fieldName);
				}
			}
		}
		// TODO AbstractExtractionForm.getEntityProperties()
		return null;
	}*/

	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionShowForm#getSelectedEntityProperties()
	 */
	public String[] getSelectedEntityProperties() {
		return selectedEntityProperties;
	}

	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionShowForm#setSelectedEntityProperties(java.lang.String[])
	 */
	public void setSelectedEntityProperties(String... selectedEntityProperties) {
		this.selectedEntityProperties = selectedEntityProperties;
	}

	/**
	 * @return Returns the currentSelectedIds.
	 */
	public String[] getCurrentSelectedIds() {
		return currentSelectedIds;
	}

	/**
	 * @param currentSelectedIds The currentSelectedIds to set.
	 */
	public void setCurrentSelectedIds(String[] currentSelectedIds) {
		this.currentSelectedIds = currentSelectedIds;
	}

	/**
	 * By default, the object containing the list the user wants to extract is a SearchForm object. The default action is to extract the list from that object.
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionForm#getExtractionList(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("unchecked")
	public List<I> getExtractionList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		SearchForm<I> searchForm = (SearchForm<I>)request.getSession().getAttribute(getExtractionObjectName());
		ArrayList<I> extractionList = new ArrayList<I>();
		for (final I identifiable : searchForm.getResults()) {
			for (final String id : currentSelectedIds) {
				if (id.equals(identifiable.getId().toString())) {
					extractionList.add(identifiable);
				}
			}
		}
		return extractionList;
	}
}
