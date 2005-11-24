/**
 *  
 */
package fr.umlv.ir3.emagine.extraction.massmailing;

import java.util.ArrayList;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.BaseEntity;

/**
 * @author Laurent
 *
 */
@Entity(access = AccessType.FIELD)
public class MassMailing extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4215239764444751264L;
	private String Title;
	private String Comment;
	private ArrayList<String> attachments;
	private String modelPath;

}
