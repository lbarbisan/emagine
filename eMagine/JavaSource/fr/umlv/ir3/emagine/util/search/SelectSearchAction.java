package fr.umlv.ir3.emagine.util.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.ir3.emagine.util.base.BaseEntity;




public abstract class SelectSearchAction extends SearchAction {
	@SuppressWarnings("unchecked")
	@Override
	public ActionForward moveTo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		SelectSearchForm<BaseEntity> selectSearchForm = (SelectSearchForm<BaseEntity>)form;
		updateSelectedSearchIds(selectSearchForm.getPageResults(), selectSearchForm.getCurrentSelectedIds(), selectSearchForm.getSelectedIds());
		return super.moveTo(mapping, form, request, response);
	}
	
	private void updateSelectedSearchIds(List<BaseEntity> pageResults, String currentSelectedIds[], Set<String> selectedIds) {
		// Get the selected ids for the current page 
		Set<String> currentIdsSet = new HashSet<String>(Arrays.asList(currentSelectedIds));
		// For each baseEntity in the search results for the current page
		for (BaseEntity baseEntity : pageResults) {
			String stringId = baseEntity.getId().toString();
			// Test if the id of the search result has been selected that time
			if (currentIdsSet.contains(stringId)) {
				// Add the id in the list of all the selected ids
				selectedIds.add(stringId);
			} else {
				// Remove the id from the list of all the selected ids
				selectedIds.remove(stringId);
			}
		}
	}
}
