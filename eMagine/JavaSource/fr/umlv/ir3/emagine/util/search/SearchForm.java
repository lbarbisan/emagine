package fr.umlv.ir3.emagine.util.search;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import fr.umlv.ir3.emagine.extraction.Extractable;

public abstract class SearchForm<BaseType> extends ActionForm implements SearchParams {

	/** Number of page : Pagination **/
	protected int nbResultsByPage;

	/** Page Courante **/
	protected int indexPage;

	/** List of Results **/
	protected List<BaseType> results;
	
	/** List of Fields to use **/
	protected Collection<String> fields;

	
	/**
	 * Reset all informations of this form
	 */
	public void reset() {
		results = null;
	}
	
	public int getNbResultsByPage() {
		return nbResultsByPage;
	}
	
	public void setNbResultsByPage(int nbResultsByPage) {
		this.nbResultsByPage = nbResultsByPage;
	}
	
	public List<BaseType> getResults() {
		return results;
	}

	public List<BaseType> getPageResults() {
		int indexBegin = (indexPage - 1) * nbResultsByPage;
		return results.subList(indexBegin, indexBegin + nbResultsByPage);
	}

	public void setResults(List<BaseType> results) {
		this.results = results;
	}

	public int getIndexPage() {
		return indexPage;
	}

	/**
	 * Set the current page index
	 * @param indexPage from 1 to infinite
	 */
	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}
	
	/**
	 * @see fr.umlv.ir3.emagine.util.search.SearchParams#getField(java.lang.String)
	 */
	public String getField(String field) {
		// TODO SelectSearchForm.getField()
		return null;
	}

	public Collection<String> getFields() {
		if (fields == null) {
			fields = new LinkedList<String>();
			for (Field field : getClass().getDeclaredFields()) {
				// TODO: getFields en fonction des annotations
				if (/*field.getName().startsWith("get") && *//*field.isAnnotationPresent(IsASearchParam.class)*/false) {
					//String methodName = method.getName();
					//String fieldName = methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
					fields.add(field.getName());
				}
			}
		}
		return fields;
	}

	public String getPropertyNameForColumn(String column) {
		// TODO SearchForm.getPropertyNameForColumn()
		return "TODO SearchForm.getPropertyNameForColumn()";
	}
	
	public abstract Extractable getExtractable();
}
