package fr.umlv.ir3.emagine.util;

import java.util.ArrayList;
import java.util.Collection;

import fr.umlv.ir3.emagine.extraction.mailings.Attachment;

import junit.framework.TestCase;

public class MailManagerTest extends TestCase {

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.MailManager.sendMail(String, String, String, Collection<Attachment>)'
	 */
	public final void testSendMail() throws EMagineException {
		Collection<Attachment> attachments = new ArrayList<Attachment>();
		Attachment attachment = new Attachment();
		attachment.setName(this.getClass().getSimpleName()+".java");
		attachment.setPath("TestSource/"+this.getClass().getPackage().getName().replaceAll("\\.", "/")+"/"+this.getClass().getSimpleName()+".java");
		attachments.add(attachment);
		MailManager.sendMail("root@localhost.localdomain", "MailManagerTest", "Just a funny test", attachments);
	}

}
