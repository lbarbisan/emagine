package fr.umlv.ir3.emagine.user.profile;

import fr.umlv.ir3.emagine.security.MustHaveRights;
import fr.umlv.ir3.emagine.util.base.BaseManager;

@MustHaveRights("right")
public interface RightManager extends BaseManager<Right, RightDAO> {

}