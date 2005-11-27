package fr.umlv.ir3.emagine.util.base;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.modification.Modification;

public class BaseModifyForm extends ActionForm {

	private static final long serialVersionUID = 4056396430505536168L;
	
	private BaseEntity entity = new BaseEntity();
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// TODO UserModifyForm.validate()
		return super.validate(mapping, request);
	}
	
	public BaseEntity getEntity() {
		
		return entity;
	}
	
	public List<Event> getEvents()
	{
		return entity.getEvents();	
	}
	
	public Long getId()
	{
		return entity.getId();	
	}
	
	public List<Modification> getModifications()
	{
		return entity.getModifications();	
	}
	
	public Long getVersion()
	{
		return entity.getVersion();	
	}
	
	
}
