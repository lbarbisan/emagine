package fr.umlv.ir3.emagine.util;

import java.util.Collection;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import fr.umlv.ir3.emagine.extraction.mailings.Attachment;

public class MailManager {

	/**
	 * Sends an email using the SMTP protocol to the specified <code>to</code> email address, with the specified <code>subject</code>, and attaching all the specified <code>attachments</code>.
	 * The SMTP server must be specified in the  // FIXME : charger le smtp depuis un fichier de conf
	 * @param to destination email address
	 * @param subject subject of the email
	 * @param body
	 * @param attachments
	 * @throws EMagineException
	 */
	public static void  sendMail(String to, String subject, String body, Collection<Attachment> attachments) throws EMagineException
	{
		// Thanks to http://www.infini-fr.com/Sciences/Informatique/Langages/Imperatifs/Java/javamail.html
		try {
			// Target smtp server
			Properties props = System.getProperties();
			props.put("mail.smtp.host", "localhost");	// FIXME : charger le smtp depuis un fichier de conf
			Session session = Session.getDefaultInstance(props, null);
			
			// Creates a new mail
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("eMagineMailer@free.fr"));	// FIXME : charger le from depuis un fichier de conf
			InternetAddress[] address = {new InternetAddress(to)};
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			
			// Creates the body
			MimeMultipart mp = new MimeMultipart();
			MimeBodyPart mbp = new MimeBodyPart();
			mbp.setText(body);
			mp.addBodyPart(mbp);
			
			for (Attachment attachment : attachments) {
				// Adds an attachment
				MimeBodyPart mbpFile = new MimeBodyPart();
				mbpFile.setText("Attachement " + attachment.getName());
				FileDataSource fds = new FileDataSource(attachment.getPath());
				mbpFile.setDataHandler(new DataHandler(fds));
				mbpFile.setFileName(attachment.getName());
				mp.addBodyPart(mbpFile);
			}
			
			// Links the body with the mail
			msg.setContent(mp);
			
			// Sends the mail
			Transport.send(msg);
			
		} catch (AddressException e) {
			throw new EMagineException("exceptions.mailManager.sendMail.addressException", e);
		} catch (MessagingException e) {
			throw new EMagineException("exceptions.mailManager.sendMail.messagingException", e);
		}
	}
}
