/**
 *
 */
package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.apprentice.ApprenticeManager;
import fr.umlv.ir3.emagine.apprentice.ApprenticeModifyForm;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class AbsenceDeleteAction extends BaseAction {

	/**
	 * The user wants to delete all several absences.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */
	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		ApprenticeManager apprenticeManager = ManagerManager.getInstance().getApprenticeManager();
		AbsenceManager absenceManager = ManagerManager.getInstance().getAbsenceManager();
		
		// Delete the absences
		DAOManager.beginTransaction();
		String [] ids = request.getParameterValues("currentSelectedIds");

		
		if(ids != null && ids.length > 0) {
			List <Absence> absencesToRemove = new LinkedList <Absence> ();
			Apprentice apprentice = apprenticeManager.retrieve(
					Long.parseLong(
							((ApprenticeModifyForm)request.getSession().getAttribute("apprenticeModifyForm")).getIdApprenticeToModify()));
			
			for (String id : ids) {
				try {
					absencesToRemove.add(absenceManager.retrieve(Long.parseLong(id)));
				} catch (EMagineException exception) {
					exception.printStackTrace();
					addEMagineExceptionError(errors, exception);
				}
			}
			
			if(!absencesToRemove.isEmpty()) {
				apprentice.getAbsences().removeAll(absencesToRemove);
				apprenticeManager.update(apprentice);
			}
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
