package fr.umlv.ir3.emagine.firm.actor;

import java.util.List;

import junit.framework.TestCase;
import fr.umlv.ir3.emagine.ressource.DefaultLogin;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;

public class FirmActorManagerImplTest extends TestCase {

	/*
	 * Test method for 'fr.umlv.ir3.emagine.firm.actor.FirmActorManagerImpl.isEngineerTutor(FirmActor)'
	 */
	public void testIsEngineerTutor() throws EMagineException {
		DefaultLogin.login();
		List<EngineerTutor> lists = ManagerManager.getInstance().getEngineerTutorManager().findAll();
		if(lists.size()>0)
			{
				if(ManagerManager.getInstance().getFirmActorManager().isEngineerTutor(lists.get(0))!=true)
				{
					assertTrue(false);
				}
			}
		else
		{
			assertTrue(false);
		}
		
	}

}
