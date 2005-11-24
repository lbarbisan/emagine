package fr.umlv.ir3.emagine.extraction.mailstype;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import fr.umlv.ir3.emagine.extraction.mailings.Attachment;
import fr.umlv.ir3.emagine.util.BaseEntity;

@Entity(access = AccessType.FIELD)
public class MailingType extends BaseEntity {

	private static final long serialVersionUID = 5127008085508457457L;
	@OneToMany
	private List<Attachment> attachments;
	private String Title;
	private String Comment;
	private String mailObject;
	private String mailCore;
	
}
