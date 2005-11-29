package fr.umlv.ir3.emagine.modification;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import fr.umlv.ir3.emagine.event.Event;

public abstract class ModificationForm<EntityType extends EditableEntity> extends ActionForm {

	private static final long serialVersionUID = 4056396430505536168L;
	
	protected EntityType entity;
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// TODO BaseModifyForm.validate()
		return super.validate(mapping, request);
	}
	
	public EntityType getEntity() {
		return entity;
	}

	public List<Event> getEvents() {
		//TODO: Mettre ça au propre
			return entity.getEvents();
			
	}

	public Long getId() {
		return entity.getId();	
	}
	
	public List<Modification> getModifications() {
		return entity.getModifications();	
	}
	
	public Long getVersion() {
		return entity.getVersion();	
	}
}
