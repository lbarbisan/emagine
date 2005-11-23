/**
 *  
 */
package fr.umlv.ir3.emagine.student.candidate.examcenter;

import java.util.List;

import fr.umlv.ir3.emagine.student.candidate.room.Room;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.BaseEntity;

/**
 * @author Laurent
 *
 */
public class FormationCenter extends BaseEntity {
	
	private String name;
	private Address address;
	private String phone;
	private List<Room> rooms;

}
