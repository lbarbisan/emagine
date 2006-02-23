/**
 *
 */
package fr.umlv.ir3.emagine.apprentice.candidate;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class CandidateIntegrateAction extends BaseAction {

	/**
	 * The user wants to integrate candidates.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		CandidateManager candidateManager = ManagerManager.getInstance().getCandidateManager();
		
		// Integrate the candidates
		DAOManager.beginTransaction();
		String [] ids = request.getParameterValues("currentSelectedIds");

		if(ids != null && ids.length > 0) {
			List <Candidate> candidates = new LinkedList <Candidate> ();;

			for (String idCandidate : ids) {
				try {					
					candidates.add(candidateManager.retrieve(Long.parseLong(idCandidate)));
				} catch (EMagineException exception) {
					addEMagineExceptionError(errors, exception);
				}
			}			

			if(!candidates.isEmpty())
				candidateManager.integrate(candidates);
		}

		// Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}	
}
