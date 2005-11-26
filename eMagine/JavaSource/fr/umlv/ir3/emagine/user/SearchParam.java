package fr.umlv.ir3.emagine.user;
public interface SearchParam {
		void setFilterbyField(String field, String value);
		void removeFilterbyField(String field);
		void clearFilterbyField();
}
