package fr.umlv.ir3.emagine.extraction.mailstype;

import fr.umlv.ir3.emagine.modification.EditableManager;
import fr.umlv.ir3.emagine.security.MustHaveRights;

@MustHaveRights("mailingType")
public interface MailingTypeManager extends EditableManager<MailingType, MailingTypeDAO> {

}