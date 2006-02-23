package fr.umlv.ir3.emagine.util;

import java.io.File;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.Properties;
import java.util.ResourceBundle;

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

public class MailManager {

	/**
	 * Sends an email using the SMTP protocol to the specified <code>to</code> email address, with the specified <code>subject</code>, and attaching all the specified <code>attachments</code>.
	 * The SMTP server must be specified in the
	 * @param to destination email address
	 * @param subject subject of the email
	 * @param body
	 * @param attachments
	 * @throws EMagineException
	 */
	public static void  sendMail(String to, String subject, String body, Collection<String> attachments) throws EMagineException
	{
		// Thanks to http://www.infini-fr.com/Sciences/Informatique/Langages/Imperatifs/Java/javamail.html
		try {
			ResourceBundle config = Bundles.getConfigBundle();
		
			
			// Target smtp server
			Properties props = System.getProperties();
			props.put("mail.smtp.host", config.getString("mailManager.smtpServer"));
			Session session = Session.getDefaultInstance(props, null);
			
			// Creates a new mail
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(config.getString("mailManager.fromAdress")));
			InternetAddress[] address = {new InternetAddress(to)};
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			
			// Creates the body
			MimeMultipart mp = new MimeMultipart();
			MimeBodyPart mbp = new MimeBodyPart();
			mbp.setText(body);
			mp.addBodyPart(mbp);
			
			if (attachments != null) {
				for (String attachment : attachments) {
					// Adds an attachment
					File file =  new File(attachment);
					MimeBodyPart mbpFile = new MimeBodyPart();
					mbpFile.setText("Attachement " + file.getName());
					FileDataSource fds = new FileDataSource(file);
					mbpFile.setDataHandler(new DataHandler(fds));
					mbpFile.setFileName(file.getName());
					mp.addBodyPart(mbpFile);
				}
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
	
	/**
	 * Sends an email using the SMTP protocol to the specified <code>to</code> emails addresses (hidden mode), with the specified <code>subject</code>, and attaching all the specified <code>attachments</code>.
	 * The SMTP server must be specified in the
	 * @param to destination emails addresses
	 * @param subject subject of the email
	 * @param body
	 * @param attachments
	 * @throws EMagineException
	 */
	public static void sendMultiMailsBCC(Collection<String> to, String subject, String body, Collection<String> attachments) throws EMagineException
	{
		// Thanks to http://www.infini-fr.com/Sciences/Informatique/Langages/Imperatifs/Java/javamail.html
		try {
			ResourceBundle config = Bundles.getConfigBundle();
		
			
			// Target smtp server
			Properties props = System.getProperties();
			props.put("mail.smtp.host", config.getString("mailManager.smtpServer"));
			Session session = Session.getDefaultInstance(props, null);
			
			// Creates a new mail
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(config.getString("mailManager.fromAdress")));
			LinkedList<InternetAddress> addresses = new LinkedList<InternetAddress>();
			for (String address : to) {
				addresses.add(new InternetAddress(address));
			}
			msg.setRecipients(Message.RecipientType.BCC, addresses.toArray(new InternetAddress[addresses.size()]));
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			
			// Creates the body
			MimeMultipart mp = new MimeMultipart();
			MimeBodyPart mbp = new MimeBodyPart();
			mbp.setText(body);
			mp.addBodyPart(mbp);
			
			if (attachments != null) {
				for (String attachment : attachments) {
					// Adds an attachment
					File file =  new File(attachment);
					MimeBodyPart mbpFile = new MimeBodyPart();
					mbpFile.setText("Attachement " + file.getName());
					FileDataSource fds = new FileDataSource(file);
					mbpFile.setDataHandler(new DataHandler(fds));
					mbpFile.setFileName(file.getName());
					mp.addBodyPart(mbpFile);
				}
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
