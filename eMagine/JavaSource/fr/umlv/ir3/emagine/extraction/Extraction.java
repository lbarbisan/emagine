package fr.umlv.ir3.emagine.extraction;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.util.base.BaseEntity;

@Entity(access = AccessType.FIELD)
public class Extraction extends BaseEntity {

	@OneToOne
	private User user;

	private List<String> columns;

	private ViewEnum viewName;

	/**
	 * @return Returns the user.
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user The user to set.
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return Returns the viewName.
	 */
	public ViewEnum getViewName() {
		return viewName;
	}

	/**
	 * @param viewName The viewName to set.
	 */
	public void setViewName(ViewEnum viewName) {
		this.viewName = viewName;
	}

	/**
	 * @param columns The columns to set.
	 */
	public void setColumns(List<String> columns) {
		this.columns = columns;
	}

	public List<String> getColumns() {
		return columns;
	}
}
