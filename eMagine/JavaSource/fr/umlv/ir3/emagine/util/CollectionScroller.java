package fr.umlv.ir3.emagine.util;

import java.util.Collection;
import java.util.Iterator;

public class CollectionScroller<ObjectType> implements Scrollable<ObjectType> {

	int index;
	Collection<ObjectType> collection;
	
	public CollectionScroller(Collection<ObjectType> c) {
		this.collection = c;
		this.index = 0;
	}
	
	public boolean add(ObjectType o) {
		return collection.add(o);
	}

	public boolean addAll(Collection<? extends ObjectType> c) {
		return collection.addAll(c);
	}

	public void clear() {
		collection.clear();
	}

	public boolean contains(Object o) {
		return collection.contains(o);
	}

	public boolean containsAll(Collection<?> c) {
		return collection.containsAll(c);
	}

	public boolean isEmpty() {
		return collection.isEmpty();
	}

	public Iterator<ObjectType> iterator() {
		return collection.iterator();
	}

	public boolean remove(Object o) {
		return collection.remove(o);
	}

	public boolean removeAll(Collection<?> c) {
		return collection.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return collection.retainAll(c);
	}

	public int size() {
		return collection.size();
	}

	public Object[] toArray() {
		return collection.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return collection.toArray(a);
	}

	public Collection<ObjectType> getCurrentCollection() {
		return null;	// TODO implémenter cette fonction
	}

	public int getIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getNbResultsByPage() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getTotalPages() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setIndex(int index) {
		// TODO Auto-generated method stub
		
	}

	public void setNbResultsByPage() {
		// TODO Auto-generated method stub
		
	}
}
