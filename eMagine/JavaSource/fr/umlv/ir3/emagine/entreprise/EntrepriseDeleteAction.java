package fr.umlv.ir3.emagine.entreprise;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.EntityManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class EntrepriseDeleteAction extends BaseAction {

	/**
	 * The administrator wants to delete all the selected entreprises
	 * @param form the ActionForm containing the request parameters
	 * @param request the request
	 */
	public ActionForward deleteEntreprises(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		
		// Retrieve the collection of entreprises to delete
		EntrepriseSearchForm entrepriseSearchForm = (EntrepriseSearchForm) form;
		List<Entreprise> entreprises = entrepriseSearchForm.getResults();
		boolean deletionForced = entrepriseSearchForm.isDeletionForced();

		// Delete the entreprises
		DAOManager.beginTransaction();
		try {
			EntityManager.getInstance().getEntrepriseManager().deleteEntreprises(entreprises, deletionForced);	// TODO : gérer le switch de forçage de suppression
		} catch (EMagineException exception) {
			// save the error
			addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
