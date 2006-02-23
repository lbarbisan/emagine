package fr.umlv.ir3.emagine.extraction.mailings;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.extraction.ExtractionType;
import fr.umlv.ir3.emagine.extraction.PropertiesExtractAction;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.base.BaseManager;
import fr.umlv.ir3.emagine.util.base.Identifiable;

public class MailAction<I extends Identifiable, E extends BaseEntity, D extends BaseDAO<E>, M extends BaseManager<E, D>> extends PropertiesExtractAction {

	/**
	 * Displays the mailingType form
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();

		MailForm showForm = (MailForm)form;

		try {
			// Retreive the list of all the mailing types
			showForm.setMailingTypes(ManagerManager.getInstance().getMailingTypeManager().findAll());
			
			// Set the selected mailing type to null, to know if the jsp can display it or not (here, to force the user to select a mailing type)
			showForm.setMailingType(null);
			
		} catch (EMagineException e) {
			// save the error
			addEMagineExceptionError(errors, e);
		}

		return viewFormIfNoErrors(mapping, request, errors);
	}
	
	public ActionForward mailResults(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();

		MailForm showForm = (MailForm)form;
		// Sets fixed values for the config : xls and all columns
		showForm.setExtractionType(ExtractionType.XLS);
		showForm.setSelectedEntityProperties(showForm.getEntityProperties().toArray(new String[0]));
		
		try {
			// Retrieve the MailType to display the file attached to the mailing type
			showForm.setMailingType(ManagerManager.getInstance().getMailingTypeManager().retrieve(Long.parseLong(showForm.getMailingTypeId())));
		} catch (EMagineException e) {
			// save the error
			addEMagineExceptionError(errors, e);
		}
		
		return successIfNoErrors(mapping, request, errors);
	}
}
