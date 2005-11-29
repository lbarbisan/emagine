package fr.umlv.ir3.emagine.event;

import java.util.Date;
import fr.umlv.ir3.emagine.util.search.SearchParam;

public interface EventSearchParam extends SearchParam {
	public Date getDateMin();
	public Date getDateMax();
	public EventTypeEnum getType();
}
