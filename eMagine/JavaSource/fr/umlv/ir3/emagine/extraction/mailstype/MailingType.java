package fr.umlv.ir3.emagine.extraction.mailstype;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.BaseEntity;

@Entity(access = AccessType.FIELD)
public class MailingType extends BaseEntity {

		/**
	 * 
	 */
	private static final long serialVersionUID = 5127008085508457457L;
	
	private String Title;
	private String Comment;
	private ArrayList<String> attachments;
	private String mailObject;
	private String mailCore;
	
}
