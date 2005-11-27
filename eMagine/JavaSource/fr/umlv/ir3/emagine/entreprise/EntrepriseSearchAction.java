package fr.umlv.ir3.emagine.entreprise;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.EntityManager;
import fr.umlv.ir3.emagine.util.search.SearchAction;

public class EntrepriseSearchAction extends SearchAction {

	/**
	 * The administrator wants to search all the entreprises matching his or her request.
	 * @param params the search parameters
	 * @param request the request
	 */
	public ActionForward searchEntreprises(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		EntrepriseSearchForm entrepriseSearchForm = (EntrepriseSearchForm)form;
		EntityManager manager = EntityManager.getInstance();

		// Retrieve the searched entreprises, and set them in the page 
		try {
			entrepriseSearchForm.setResults(manager.getEntrepriseManager().getEntreprises(entrepriseSearchForm));
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
