package fr.umlv.ir3.emagine.event;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.firm.actor.FirmActor;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseManager;
import fr.umlv.ir3.emagine.util.base.EventableEntity;
import fr.umlv.ir3.emagine.util.search.SearchAction;

public class EventSearchAction extends SearchAction {

	/**
	 * The administrator wants to show the search form.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		EventSearchForm eventSearchForm = (EventSearchForm)form;

		// Retrieve all profiles and set them in the form
		try {
			eventSearchForm.reset();
			eventSearchForm.setTypes((List<EventTypeEnum>)ManagerManager.getInstance().getEmagineEnumManager().findAll(EventTypeEnum.class));
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
	
	/**
	 * The administrator wants to search all the company matching his or her request.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */
	public ActionForward search(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		ManagerManager managerManager = ManagerManager.getInstance();

		EventSearchForm eventSearchForm = (EventSearchForm) form;
		String parameter = request.getParameter("from");

		// Retrieve the searched users, and set them in the page 
		try {
			if("apprentice".equals(parameter)) {
				eventSearchForm.setResults(searchEvents(managerManager.getApprenticeManager(), request, "apprenticeModifyForm", "idApprenticeToModify"));
			}
			else if("firm".equals(parameter)) {
				eventSearchForm.setResults(searchEvents(managerManager.getFirmManager(), request, "companyModifyForm", "idFirmToModify"));
			}
			else if("teacher".equals(parameter)) {
				eventSearchForm.setResults(searchEvents(managerManager.getTeacherTutorManager(), request, "teacherTutorModifyForm", "idTeacherTutorToModify"));
			}
			else if("firmActor".equals(parameter)) {
				eventSearchForm.setResults(searchEvents(managerManager.getFirmActorManager(), request, "firmActorModifyForm", "idFirmActorToModify"));
			}
			else if("candidate".equals(parameter)) {
				eventSearchForm.setResults(searchEvents(managerManager.getCandidateManager(), request, "candidateModifyForm", "idCandidateToModify"));
			}
			
			eventSearchForm.setTypes((List<EventTypeEnum>)ManagerManager.getInstance().getEmagineEnumManager().findAll(EventTypeEnum.class));
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
	
	
	private <E extends EventableEntity, D extends BaseDAO<E>, M extends BaseManager<E, D>> List<Event> searchEvents(M manager, HttpServletRequest request, String formName, String property) throws NumberFormatException, EMagineException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		System.err.println(Long.parseLong(BeanUtils.getNestedProperty(request.getSession().getAttribute(formName), property)));
		E entity = manager.retrieve(
				Long.parseLong(
						BeanUtils.getNestedProperty(
								request.getSession().getAttribute(formName), property)));
		return entity.getEvents();
	}
}