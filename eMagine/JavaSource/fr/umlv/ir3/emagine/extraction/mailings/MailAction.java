package fr.umlv.ir3.emagine.extraction.mailings;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.extraction.Extractable;
import fr.umlv.ir3.emagine.extraction.ExtractionConfig;
import fr.umlv.ir3.emagine.extraction.ExtractionForm;
import fr.umlv.ir3.emagine.extraction.ExtractionType;
import fr.umlv.ir3.emagine.extraction.ObjectListExtractable;
import fr.umlv.ir3.emagine.util.Bundles;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.base.BaseManager;
import fr.umlv.ir3.emagine.util.base.Identifiable;

public class MailAction<I extends Identifiable, E extends BaseEntity, D extends BaseDAO<E>, M extends BaseManager<E, D>> extends BaseAction {

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
		
		try {
			// Retrieve the MailType to display the file attached to the mailing type
			showForm.setMailingType(ManagerManager.getInstance().getMailingTypeManager().retrieve(Long.parseLong(showForm.getMailingTypeId())));
		} catch (EMagineException e) {
			// save the error
			addEMagineExceptionError(errors, e);
		}
		
		return successIfNoErrors(mapping, request, errors);
	}
	
	public ActionForward mail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();

		ExtractionForm<I> extractionForm = (ExtractionForm<I>)form;
		
		try {
			// Sets fixed values for the config : xls and all columns
			extractionForm.setExtractionType(ExtractionType.XLS);
			extractionForm.setSelectedEntityProperties(extractionForm.getEntityProperties().toArray(new String[0]));

			// Retrieve from the session, the collection the user wants to extract
			List<I> extractionList = extractionForm.getExtractionList(mapping, form, request, response);
			
			// Create the extractable to pass to the manager for extraction
			Extractable extractable = new ObjectListExtractable<I>(extractionList, Arrays.asList(extractionForm.getSelectedEntityProperties()));
			
			// Set the response headers
			response.setContentType(extractionForm.getExtractionType().mimeType());
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Content-Disposition", "attachment; filename=\""+extractionForm.getExtractionEntityName()+"."+extractionForm.getExtractionType().fileExtension()+"\"");

			// Extract
//			final PrintWriter writer = response.getWriter();
//			getManager(extractionForm).extract(extractable, extractionForm, new OutputStream() {
//				@Override
//				public void write(int b) throws IOException {
//					writer.write(b);
//				}
//			});
			//FIXME : Pour les extractions, il ne faut pas faire de méthode getOutputStream() car en cas d'erreur, une redirection vers la jsp d'erreur est faite, et le framework struts utilise response.getWriter qui est incompatible et qui renvoie une exception.
			getManager(extractionForm).extract(extractable, extractionForm, response.getOutputStream());

			return null;
		} catch (EMagineException e) {
			// save the error
			addEMagineExceptionError(errors, e);
		}
		
		return successIfNoErrors(mapping, request, errors);
	}



	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractAction#getManager(fr.umlv.ir3.emagine.extraction.ExtractionConfig)
	 * @throws EMagineException if the config manager 
	 */
	public BaseManager getManager(ExtractionConfig config)
			throws EMagineException {
		final String managerClass = Bundles.getExtractionBundle().getString("extraction."+config.getExtractionEntityName()+".manager");
		final BaseManager manager = ManagerManager.getInstance().getManager(managerClass);
		if (manager == null) {
			throw new EMagineException("exception.mail.unknownConfigManager", "extraction."+config.getExtractionEntityName()+".manager", managerClass);
		}
		return manager;
	}
}
