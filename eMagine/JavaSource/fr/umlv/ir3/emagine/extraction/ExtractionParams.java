package fr.umlv.ir3.emagine.extraction;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.util.IsASearchParam;
import fr.umlv.ir3.emagine.util.search.SearchParams;

public interface ExtractionParams extends SearchParams {
	@IsASearchParam("user.id")
	public User getUser();
	@IsASearchParam("view")
	public ViewEnum getView();
}