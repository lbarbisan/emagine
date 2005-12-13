package fr.umlv.ir3.emagine.event;

import java.util.Date;

import fr.umlv.ir3.emagine.util.IsASearchParam;
import fr.umlv.ir3.emagine.util.search.SearchParams;

public interface EventSearchParams extends SearchParams {
	@IsASearchParam("dateMin")
	public Date getDateMin();
	@IsASearchParam("dateMax")
	public Date getDateMax();
	@IsASearchParam("type")
	public EventTypeEnum getType();
}
