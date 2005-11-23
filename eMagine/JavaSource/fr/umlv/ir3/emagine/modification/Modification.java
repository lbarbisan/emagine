package fr.umlv.ir3.emagine.modification;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.util.BaseEntity;

//FIXME: supprimer BASe ENtity, sinon on peut modifier une modification...
public class Modification<ObjectType extends BaseEntity> extends BaseEntity{
	
	private ModificationStateEnum modificationSate;
	
	private String comment;
	
	private User source;
	
	//FIXME : mapping entre les droits et les objets, 
	private User destination;
	
	
	private ObjectType oldValue;
	private ObjectType currentValue;
	private ObjectType newValue;
	
}
