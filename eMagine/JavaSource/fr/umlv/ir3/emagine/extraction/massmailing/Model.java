package fr.umlv.ir3.emagine.extraction.massmailing;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.BaseEntity;

@Entity(access = AccessType.FIELD)
public class Model extends BaseEntity {
	private String name;
	private String path;
}
