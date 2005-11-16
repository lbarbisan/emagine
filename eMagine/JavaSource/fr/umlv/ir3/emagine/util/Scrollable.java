package fr.umlv.ir3.emagine.util;

import java.util.Collection;

public interface Scrollable extends Collection {
	public int getIndex();
	public void setIndex(int index);
	public int getTotalPages();
	public Collection getCurrentCollection();
	public int getNbResultsByPage();
	public void setNbResultsByPage();
}
