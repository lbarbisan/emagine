package fr.umlv.ir3.emagine.user;

public class Profile {
	private long id;
	
	@Override
	public boolean equals(Object obj) {
		return id == ((Profile)obj).getId();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
