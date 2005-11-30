/**
 *  
 */
package fr.umlv.ir3.emagine.extraction.massmailing;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import fr.umlv.ir3.emagine.extraction.mailings.Attachment;
import fr.umlv.ir3.emagine.util.base.EditableEntity;

/**
 * @author Laurent
 *
 */
@Entity(access = AccessType.FIELD)
public class MassMailing extends EditableEntity {

	private static final long serialVersionUID = -4215239764444751264L;
	@OneToMany
	private List<Attachment> attachments;
	private String Title;
	private String Comment;
	private Model modelPath;
	
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
	public Model getModelPath() {
		return modelPath;
	}
	public void setModelPath(Model modelPath) {
		this.modelPath = modelPath;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}

}
