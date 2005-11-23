package fr.umlv.ir3.emagine.extraction.mailstype;

import java.util.List;

import fr.umlv.ir3.emagine.util.BaseEntity;

public class MailingType extends BaseEntity {

		/**
	 * 
	 */
	private static final long serialVersionUID = 5127008085508457457L;
	
	private String Title;
	private String Comment;
	private List<String> attachments;
	private String mailObject;
	private String mailCore;
	
}
