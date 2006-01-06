package fr.umlv.ir3.emagine.apprentice.candidate.room;

import fr.umlv.ir3.emagine.security.MustHaveRights;
import fr.umlv.ir3.emagine.util.base.BaseManager;

@MustHaveRights("room")
public interface RoomManager extends BaseManager<Room, RoomDAO> {

}