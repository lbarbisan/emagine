/**
 *  
 */
package fr.umlv.ir3.emagine.extraction.massmailing;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import fr.umlv.ir3.emagine.extraction.mailings.Attachment;
import fr.umlv.ir3.emagine.util.BaseEntity;

/**
 * @author Laurent
 *
 */
@Entity(access = AccessType.FIELD)
public class MassMailing extends BaseEntity {

	private static final long serialVersionUID = -4215239764444751264L;
	@OneToMany
	private List<Attachment> attachments;
	private String Title;
	private String Comment;
	private Model modelPath;

}
