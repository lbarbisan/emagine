package fr.umlv.ir3.emagine.util;

import java.util.Collection;

public interface Scrollable<ObjectType> extends Collection<ObjectType> {
	public int getIndex();
	public void setIndex(int index);
	public int getTotalPages();
	public Collection<ObjectType> getCurrentCollection();
	public int getNbResultsByPage();
	public void setNbResultsByPage();
}
