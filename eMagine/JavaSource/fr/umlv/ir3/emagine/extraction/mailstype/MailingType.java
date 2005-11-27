package fr.umlv.ir3.emagine.extraction.mailstype;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import fr.umlv.ir3.emagine.extraction.mailings.Attachment;
import fr.umlv.ir3.emagine.util.base.BaseEntity;

@Entity(access = AccessType.FIELD)
public class MailingType extends BaseEntity {

	private static final long serialVersionUID = 5127008085508457457L;
	@OneToMany
	private List<Attachment> attachments;
	private String Title;
	private String Comment;
	private String mailObject;
	private String mailCore;
	
	public List<Attachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
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
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	
}
