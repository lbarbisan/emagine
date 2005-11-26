package fr.umlv.ir3.emagine.util;

import java.util.List;

import org.apache.struts.action.ActionForm;

public abstract class SearchForm<BaseType> extends ActionForm implements SearchParam {
	protected int nbResultsByPage;
	protected int indexPage;
	protected List<BaseType> results;

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
}
