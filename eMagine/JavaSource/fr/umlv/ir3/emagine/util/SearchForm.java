package fr.umlv.ir3.emagine.util;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.struts.action.ActionForm;

public abstract class SearchForm<BaseType> extends ActionForm implements SearchParam {
	protected int nbResultsByPage;
	protected int indexPage;
	protected List<BaseType> results;
	
	protected Collection<String> fields;

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
	
	public Object getField(String field) {
		// TODO SelectSearchForm.getField()
		return null;
	}

	public Collection<String> getFields() {
		if (fields == null) {
			fields = new LinkedList<String>();
			for (Field field : getClass().getDeclaredFields()) {
				// TODO: getFields en fonction des annotations
				//System.out.println(field);
				//System.out.println(field.getDeclaredAnnotations().length);
				if (/*field.getName().startsWith("get") && */field.getAnnotation(IsAField.class) != null) {
					//String methodName = method.getName();
					//String fieldName = methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
					fields.add(field.getName());/*
					System.out.println("=== "+fieldName+" ===");
					for (Annotation annotation : method.getAnnotations()) {
						System.out.println(annotation.toString());
					}*/
				}
			}
		}
		return fields;
	}
	
}
