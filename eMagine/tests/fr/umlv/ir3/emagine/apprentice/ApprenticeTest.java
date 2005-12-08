package fr.umlv.ir3.emagine.apprentice;

import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import fr.umlv.ir3.emagine.apprentice.absence.Absence;
import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.search.SearchParamImpl;

public class ApprenticeTest extends TestCase {

	private ApprenticeDAO apprenticeDao;
	private Candidate candidate = new Candidate();
	private Apprentice apprentice;
	
	public ApprenticeTest(String arg0) {
		super(arg0);
		apprenticeDao = ManagerManager.getInstance().getApprenticeManager().getDAO();
	}

	protected void setUp() throws Exception {
		super.setUp();
		try {
			SearchParamImpl searchParam = new SearchParamImpl();
			searchParam.setField("FirstName", "apprentice1");
			List<Apprentice> lists= apprenticeDao.find(searchParam);	
			apprentice = lists.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			apprentice = new Apprentice(candidate);
			apprentice.setFirstName("apprentice1");
			apprentice.setLastName("apprentice1");
		}		
		DAOManager.beginTransaction();
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		if(apprentice.getId()==null)
		{
			apprenticeDao.create(apprentice);
		}
		else
		{
			apprenticeDao.update(apprentice);	
		}
		DAOManager.commitTransaction();
	}


	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.setAbsences(List<Absence>)'
	 */
	public void testAddAbsence() {
		Absence absence = new Absence(false,
				"Feignassee !!!",
				new Date(),
				new Date());
		apprentice.addAbsence(absence);
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.getAddressAcademic()'
	 */
	public void testGetAddressAcademic() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.setAddressAcademic(Address)'
	 */
	public void testSetAddressAcademic() {
		Address address = new Address();
		address.setCity("City1");
		address.setCountry(CountryEnum.FR);
		address.setDepartment(DepartmentEnum.D01);
		address.setPostalCode("66666");
		address.setStreet("1 rue de paradie");
		apprentice.setAddressAcademic(address);

	}


	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.setAddressProfessional(Address)'
	 */
	public void testSetAddressProfessional() {
		Address address = new Address();
		address.setCity("City2");
		address.setCountry(CountryEnum.FR);
		address.setDepartment(DepartmentEnum.D01);
		address.setPostalCode("77777");
		address.setStreet("1 rue de paradie");
		apprentice.setAddressProfessional(address);
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.setDefaultAdress(DefaultAddressEnum)'
	 */
	public void testSetDefaultAdress() {
		Address address = new Address();
		address.setCity("City3");
		address.setCountry(CountryEnum.FR);
		address.setDepartment(DepartmentEnum.D01);
		address.setPostalCode("88888");
		address.setStreet("1 rue de paradie");
		apprentice.setAddressProfessional(address);
	}
}
