package fr.umlv.ir3.emagine.extraction.mailstype;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import fr.umlv.ir3.emagine.extraction.mailings.Attachment;
import fr.umlv.ir3.emagine.modification.EditableEntity;

@Entity(access = AccessType.FIELD)
public class MailingType extends EditableEntity {

	//TODO title et comment sont en majuscule
	private static final long serialVersionUID = 5127008085508457457L;
	@OneToMany
	private List<Attachment> attachments;
	private String title;
	private String comment;
	private String mailObject;
	private String mailCore;
	
	public List<Attachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getMailCore() {
		return mailCore;
	}
	public void setMailCore(String mailCore) {
		this.mailCore = mailCore;
	}
	public String getMailObject() {
		return mailObject;
	}
	public void setMailObject(String mailObject) {
		this.mailObject = mailObject;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
