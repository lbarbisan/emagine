package fr.umlv.ir3.emagine.student;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.BaseEntity;

@Entity(access = AccessType.FIELD)
public class Mark extends BaseEntity{
	private Integer value;
}
