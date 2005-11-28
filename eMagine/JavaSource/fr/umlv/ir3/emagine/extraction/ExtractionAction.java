package fr.umlv.ir3.emagine.extraction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.Extractable;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class ExtractionAction extends BaseAction {
	/**
	 * Displays the config screen for the first time
	 */
	public ActionForward showConfig(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ExtractionForm extractionForm = (ExtractionForm)form;
		
		// Retrieve the extractable from the session and set it in the form
		Extractable extractable = (Extractable)request.getSession().getAttribute(extractionForm.getExtractableName());
		extractionForm.setExtractable(extractable);
		
		return findSuccess(mapping);
	}
	
	/**
	 * Extracts the selected list, with selected columns (fields) into the selected file format
	 */
	public ActionForward extract(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		
		// Retrieve the extraction's properties values
		ExtractionForm extractionForm = (ExtractionForm)form;

		try {
			response.setContentType(extractionForm.getExtractionType().mimeType());
			ManagerManager.getInstance().getExtractionManager().extract(extractionForm, response.getOutputStream());
		} catch (EMagineException exception) {
			// save the error
			addEMagineExceptionError(errors, exception);
		}
		
        if (!errors.isEmpty()) {
            this.saveErrors(request, errors);
            return (mapping.getInputForward());
        }
        return null;
	}	
}
