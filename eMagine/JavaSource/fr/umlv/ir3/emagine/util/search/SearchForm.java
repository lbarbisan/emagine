package fr.umlv.ir3.emagine.util.search;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;

import fr.umlv.ir3.emagine.extraction.Extractable;
import fr.umlv.ir3.emagine.util.IsASearchParam;

public abstract class SearchForm<BaseType> extends ActionForm implements SearchParams {

	private Log log = LogFactory.getLog(SearchForm.class);
	
	/** Number of page : Pagination **/
	protected int nbResultsByPage;

	/** Page Courante **/
	protected int indexPage;

	/** List of Results **/
	protected List<BaseType> results;
	
	/** List of Fields to use **/
	//protected Collection<String> fields;
	protected Map<String, String> methods;

	
	/**
	 * Reset all informations of this form
	 */
	public void reset() {
		results = null;
	}

	public int getNbResults() {
		if(results == null)
			return 0;
		return results.size();
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
		try {
			return this.getClass().getMethod(methods.get(field), null).invoke(this, null).toString();
		} catch (Exception exception) {
			log.error("can't retrieve value for field " + field, exception);
			return null;
		}
	}
	
	public Collection<String> getFields() {
		if (methods != null) {
			return methods.keySet();
		}
		methods = new HashMap<String,String>();
		//isBoolean = new ArrayList<Boolean>();
		for (Method m : this.getClass().getDeclaredMethods()) {
			if (m.getAnnotation(IsASearchParam.class) != null) {
				// This method can be a field, if it begins with "get" or "is"
				/*int prefixLength = -1;
				
				if (m.getName().startsWith("get")) {
					prefixLength = 3;
				} else if (m.getName().startsWith("is")) {
					prefixLength = 2;
				}
				if (prefixLength > 0) {
					// This method represents a field. It must be added in the list
					String fieldName = m.getName().substring(prefixLength, prefixLength + 1).toLowerCase() + m.getName().substring(prefixLength + 1);*/
					log.debug("Add field " + m.getAnnotation(IsASearchParam.class).value()[0]);
					methods.put(m.getAnnotation(IsASearchParam.class).value()[0], m.getName());
				//}
			//}
			}
		}
		return methods.keySet();
	}

	public String getPropertyNameForColumn(String column) {
		// TODO SearchForm.getPropertyNameForColumn()
		return "TODO SearchForm.getPropertyNameForColumn()";
	}
	
	public abstract Extractable getExtractable();
}
