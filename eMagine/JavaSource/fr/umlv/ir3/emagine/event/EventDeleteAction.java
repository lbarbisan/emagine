/**
 *
 */
package fr.umlv.ir3.emagine.event;

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
import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.apprentice.candidate.CandidateManager;
import fr.umlv.ir3.emagine.apprentice.candidate.CandidateModifyForm;
import fr.umlv.ir3.emagine.firm.Firm;
import fr.umlv.ir3.emagine.firm.FirmManager;
import fr.umlv.ir3.emagine.firm.FirmModifyForm;
import fr.umlv.ir3.emagine.firm.actor.FirmActor;
import fr.umlv.ir3.emagine.firm.actor.FirmActorManager;
import fr.umlv.ir3.emagine.firm.actor.FirmActorModifyForm;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutor;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutorManager;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutorModifyForm;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;
import fr.umlv.ir3.emagine.util.base.EventableEntity;

public class EventDeleteAction extends BaseAction {

	/**
	 * The administrator wants to delete all several events.
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
		
		ManagerManager managerManager = ManagerManager.getInstance();
		String parameter = request.getParameter("from");
		String [] ids = request.getParameterValues("currentSelectedIds");

		if(ids != null && ids.length > 0) {
			if(parameter != null && !"".equals(parameter)) {
				List <EventableEntity> eventsToRemove = new LinkedList <EventableEntity> ();

				if("apprentice".equals(parameter)) {
					ApprenticeManager manager = managerManager.getApprenticeManager();
					Apprentice entity = manager.retrieve(
							Long.parseLong(((ApprenticeModifyForm)request.getSession().getAttribute("apprenticeModifyForm")).getIdApprenticeToModify()));
					for (String id : ids)
							eventsToRemove.add(manager.retrieve(Long.parseLong(id)));						
					entity.getEvents().removeAll(eventsToRemove);
					manager.update(entity);
				}
				else if("firm".equals(parameter)) {
					FirmManager manager = managerManager.getFirmManager();
					Firm entity = managerManager.getFirmManager().retrieve(
							Long.parseLong(((FirmModifyForm)request.getSession().getAttribute("companyModifyForm")).getIdFirmToModify()));
					for (String id : ids)
						eventsToRemove.add(manager.retrieve(Long.parseLong(id)));						
					entity.getEvents().removeAll(eventsToRemove);
					manager.update(entity);
				}
				else if("teatcher".equals(parameter)) {
					TeacherTutorManager manager = managerManager.getTeacherTutorManager();
					TeacherTutor entity = managerManager.getTeacherTutorManager().retrieve(
							Long.parseLong(((TeacherTutorModifyForm)request.getSession().getAttribute("teacherTutorModifyForm")).getIdTeacherTutorToModify()));
					for (String id : ids)
						eventsToRemove.add(manager.retrieve(Long.parseLong(id)));						
					entity.getEvents().removeAll(eventsToRemove);
					manager.update(entity);
				}
				else if("firmActor".equals(parameter)) {
					FirmActorManager manager = managerManager.getFirmActorManager();
					FirmActor entity = managerManager.getFirmActorManager().retrieve(
							Long.parseLong(((FirmActorModifyForm)request.getSession().getAttribute("firmActorModifyForm")).getIdFirmActorToModify()));
					for (String id : ids)
						eventsToRemove.add(manager.retrieve(Long.parseLong(id)));						
					entity.getEvents().removeAll(eventsToRemove);
					manager.update(entity);
				}
				else if("candidate".equals(parameter)) {
					CandidateManager manager = managerManager.getCandidateManager();
					Candidate entity = managerManager.getCandidateManager().retrieve(
							Long.parseLong(((CandidateModifyForm)request.getSession().getAttribute("candidateModifyForm")).getIdCandidateToModify()));
					for (String id : ids)
						eventsToRemove.add(manager.retrieve(Long.parseLong(id)));						
					entity.getEvents().removeAll(eventsToRemove);
					manager.update(entity);
				}
			}
		}
		
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}	
}
