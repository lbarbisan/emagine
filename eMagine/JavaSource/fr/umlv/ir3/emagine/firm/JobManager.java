package fr.umlv.ir3.emagine.firm;

import fr.umlv.ir3.emagine.modification.EditableManager;
import fr.umlv.ir3.emagine.security.MustHaveRights;

@MustHaveRights("job")
public interface JobManager extends EditableManager<Job, JobDAO> {

}