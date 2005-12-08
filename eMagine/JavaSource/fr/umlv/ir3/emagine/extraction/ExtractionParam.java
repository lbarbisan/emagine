package fr.umlv.ir3.emagine.extraction;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.util.search.SearchParam;

public interface ExtractionParam extends SearchParam {
	public User getUser();
	public ViewEnum getView();
}