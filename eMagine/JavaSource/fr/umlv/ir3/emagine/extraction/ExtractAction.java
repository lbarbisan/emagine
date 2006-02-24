package fr.umlv.ir3.emagine.extraction;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.base.BaseManager;
import fr.umlv.ir3.emagine.util.base.Identifiable;

public abstract class ExtractAction<I extends Identifiable, E extends BaseEntity, D extends BaseDAO<E>, M extends BaseManager<E, D>> extends BaseAction {
	/**
	 * Displays the config screen for the first time
	 */
	public ActionForward showConfig(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();

		ExtractionShowForm showForm = (ExtractionShowForm)form;
		
		try {
			// Retrieve the last user preferences for the given extraction entity, using the manager
			ExtractionManager manager = ManagerManager.getInstance().getExtractionManager();
			ExtractionConfig savedConfig = manager.retrieveCurrentUserConfig(showForm);
			
			// Sets the old values of the config
			showForm.setExtractionType(savedConfig.getExtractionType());
			showForm.setSelectedEntityProperties(savedConfig.getSelectedEntityProperties());
		} catch (EMagineException e) {
			// save the error
			addEMagineExceptionError(errors, e);
		}
		
		return successIfNoErrors(mapping, request, errors);
	}
	
	public ActionForward extract(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();

		ExtractionForm<I> extractionForm = (ExtractionForm<I>)form;
		
		try {
			// Save the preferences if the user wants to
			if (extractionForm.isSaveConfig()) {
				ManagerManager.getInstance().getExtractionManager().saveConfig((ExtractionConfig)extractionForm);	//TODO: au lieu de passer un extractionForm, passer un extractionConfig plutôt...
			}
			
			// Retrieve from the session, the collection the user wants to extract
			List<I> extractionList = extractionForm.getExtractionList(mapping, form, request, response);
			
			// Create the extractable to pass to the manager for extraction
			Extractable extractable = new ObjectListExtractable<I>(extractionList, Arrays.asList(extractionForm.getSelectedEntityProperties()));
			
			// Set the response headers
			final ExtractionType extractionType = extractionForm.getExtractionType();
			if (extractionType == null) {
				throw new EMagineException("exception.extraction.noExtractionType");
			}
			response.setContentType(extractionType.mimeType());
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Content-Disposition", "attachment; filename=\""+extractionForm.getExtractionEntityName()+"."+extractionType.fileExtension()+"\"");

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
	
	public abstract M getManager(ExtractionConfig config) throws EMagineException;
}
