/**
 *  
 */
package fr.umlv.ir3.emagine.extraction.massmailing;

import java.util.List;

import fr.umlv.ir3.emagine.util.BaseEntity;

/**
 * @author Laurent
 *
 */
public class MassMailing extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4215239764444751264L;
	private String Title;
	private String Comment;
	private List<String> attachments;
	private String modelPath;

}
