/**
 *
 */
package fr.umlv.ir3.emagine.apprentice.candidate.room;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class RoomModifyAction extends BaseAction {

	/**
	 * The administrator wants to show the details of room.
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
		ManagerManager managerManager = ManagerManager.getInstance();
		RoomModifyForm roomModifyForm = (RoomModifyForm) form;
		try {
			// Retrieve the room we want to see (if he exists) 
			String idRoom = request.getParameter("id");			
			if(idRoom != null && !"".equals(idRoom)) {
				Room room = managerManager.getRoomManager().retrieve(Long.parseLong(idRoom));
				roomModifyForm.setIdRoomToModify(idRoom);
				roomModifyForm.setName(room.getName());
				roomModifyForm.setNbDispo(room.getNumberOfFreeSits().toString());
				roomModifyForm.setCapacity(room.getCapacity().toString());
			}
			
		} catch (EMagineException exception) {
			exception.printStackTrace();
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
		
	}

	/**
	 * The administrator wants to modify the informations of room.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */	
	public ActionForward modify(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ActionMessages errors = new ActionMessages();
		ManagerManager managerManager = ManagerManager.getInstance();
		RoomManager roomManager = managerManager.getRoomManager();
		RoomModifyForm roomModifyForm = (RoomModifyForm) form;

		// Update the room
		try {
			Room room = roomManager.retrieve(Long.parseLong(roomModifyForm.getIdRoomToModify()));
			room.setName(roomModifyForm.getName());
			room.setCapacity(new Integer(roomModifyForm.getCapacity()));
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
