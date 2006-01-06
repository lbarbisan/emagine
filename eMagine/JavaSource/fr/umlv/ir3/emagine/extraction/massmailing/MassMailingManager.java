package fr.umlv.ir3.emagine.extraction.massmailing;

import fr.umlv.ir3.emagine.modification.EditableManager;
import fr.umlv.ir3.emagine.security.MustHaveRights;

@MustHaveRights("massMailing")
public interface MassMailingManager extends EditableManager<MassMailing, MassMailingDAO> {

}