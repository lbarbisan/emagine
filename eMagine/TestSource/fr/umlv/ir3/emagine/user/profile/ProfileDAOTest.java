package fr.umlv.ir3.emagine.user.profile;

import java.util.ArrayList;
import java.util.Collection;

import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseDAOTest;
import fr.umlv.ir3.emagine.util.search.SearchParams;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class ProfileDAOTest extends BaseDAOTest<Profile> {
	
	ProfileDAO dao;

	public ProfileDAOTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
		dao = new ProfileDAO();
	}

	protected void tearDown() throws Exception {
		dao = null;
		super.tearDown();
	}

	@Override
	protected BaseDAO<Profile> getDAO() {
		return dao;
	}

	//@Override
	protected Profile createEntity() {
		Profile profile = new Profile();
		profile.setDescription("description  &�~#'{([-|`_�^�@)]=+}^�$��%�*�?,;.:!�<>");
		profile.setName("profile");
		// FIXME setUsers ??
		return profile;
	}

	//@Override
	protected Collection<Profile> createEntityCollection() {
		ArrayList<Profile> list = new ArrayList<Profile>();
		
		Profile profile1 = new Profile();
		profile1.setDescription("description1  &�~#'{([-|`_�^�@)]=+}^�$��%�*�?,;.:!�<>");
		profile1.setName("profile1");
		
		Profile profile2 = new Profile();
		profile2.setDescription("description2  &�~#'{([-|`_�^�@)]=+}^�$��%�*�?,;.:!�<>");
		profile2.setName("profile2");
		
		Profile profile3 = new Profile();
		profile3.setDescription("description3  &�~#'{([-|`_�^�@)]=+}^�$��%�*�?,;.:!�<>");
		profile3.setName("profile3");
		
		list.add(profile1);
		list.add(profile2);
		list.add(profile3);
		
		return list;
	}

	@Override
	protected void updateEntity(Profile entity) {
		entity.setDescription("new description");
		entity.setName("new name");
//		 FIXME setUsers ??
	}

	@Override
	protected SearchParams createSearchParams() {
		SearchParamsImpl searchParams = new SearchParamsImpl();
		searchParams.setField("profile" , "profile");
		return searchParams;
	}

	@Override
	protected void compareEntity(Profile entity1, Profile entity2) {
		assertTrue(conditionCheck(entity1.getDescription(), entity2.getDescription()));
		assertTrue(conditionCheck(entity1.getId(), entity2.getId()));
		assertTrue(conditionCheck(entity1.getName(), entity2.getName()));
		// FIXME getRights mais o� est le set?
		assertTrue(conditionCheck(entity1.getRights(), entity2.getRights()));
		assertTrue(conditionCheck(entity1.getUsers(), entity2.getUsers()));
	}

	//@Override
	protected Collection<Profile> createForFindEntityCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Profile createEntity(int index) {
		// TODO enclosing_package.ProfileDAOTest.createEntity(enclosing_method_arguments)
		//throw new EMagineException("exception.unimplementedMethod", "enclosing_package.ProfileDAOTest.createEntity(enclosing_method_arguments)");
		return null;
	}

	@Override
	protected Profile createEntityForSearchParams(SearchParams params, int index) {
		// TODO enclosing_package.ProfileDAOTest.createEntityForSearchParams(enclosing_method_arguments)
		//throw new EMagineException("exception.unimplementedMethod", "enclosing_package.ProfileDAOTest.createEntityForSearchParams(enclosing_method_arguments)");
		return null;
	}
}
