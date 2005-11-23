/**
 *  
 */
package fr.umlv.ir3.emagine.events;

import java.util.Date;
import java.util.List;

import fr.umlv.ir3.emagine.util.BaseEntity;

/**
 * @author Laurent
 *
 */
public class Event extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9082348519478717464L;
	/**
	 * 
	 */
	private Date startDate;
	private Date endDate;
	private String Title;
	private String Comment;
	private EventTypeEnum type;
	private List<BaseEntity> sources;
}
