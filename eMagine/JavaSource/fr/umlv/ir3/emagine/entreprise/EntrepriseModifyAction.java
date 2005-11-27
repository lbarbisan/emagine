/**
 *
 */
package fr.umlv.ir3.emagine.entreprise;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.EntityManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class EntrepriseModifyAction extends BaseAction {

	public ActionForward createEntreprise(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionMessages errors = new ActionMessages();
		
		// Retrieve the Entreprise's properties values
		EntrepriseModifyForm entrepriseModifyForm = (EntrepriseModifyForm) form;
		Entreprise entreprise = entrepriseModifyForm.getEntity();	// The password have been checked in the form .validate(...) method

		try {
			EntityManager.getInstance().getEntrepriseManager().createEntreprise(entreprise);
		} catch (EMagineException exception) {
			// save the error
			addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}

	public ActionForward updateEntreprise(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		ActionMessages errors = new ActionMessages();

		// Retrieve the Entreprise's properties values
		EntrepriseModifyForm entrepriseModifyForm = (EntrepriseModifyForm) form;
		Entreprise entreprise = entrepriseModifyForm.getEntity();	// The password check have been done in the form .validate(...) method

		// Update the Entreprise
		try {
			EntityManager.getInstance().getEntrepriseManager().updateEntreprise(entreprise);
		} catch (EMagineException exception) {
			// save the error
			addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}

}
