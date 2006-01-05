package fr.umlv.ir3.emagine.user;

import java.util.ArrayList;
import java.util.Collection;

import fr.umlv.ir3.emagine.user.profile.Profile;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseDAOTest;
import fr.umlv.ir3.emagine.util.search.SearchParams;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class UserDAOTest extends BaseDAOTest<User> {
	
	UserDAO dao;

	public UserDAOTest(String arg0) {
		super(arg0);
	}
	
	protected void setUp() throws Exception {
		dao = new UserDAO();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		dao = null;
		super.tearDown();
	}
	
	@Override
	protected BaseDAO<User> getDAO() {
		return dao;
	}

	@Override
	protected User createEntity() {
		User user = new User();
		user.setLogin("login");
		user.setPassword("password");
		user.setEmail("Email. &é~#'{([-|`_ç^à@)]=+}^¨$£¤%ù*µ?,;.:!§<>");
		user.setFirstName("FirstName. &é~#'{([-|`_ç^à@)]=+}^¨$£¤%ù*µ?,;.:!§<>");
		user.setLastName("LastName. &é~#'{([-|`_ç^à@)]=+}^¨$£¤%ù*µ?,;.:!§<>");
		user.setProfile(new Profile());
		return user;
	}

	@Override
	protected Collection<User> createEntityCollection() {
		ArrayList<User> list = new ArrayList<User>();
		User user1 = new User();
		User user2 = new User();
		
		user1.setLogin("user1");
		user1.setPassword("password1");
		user1.setEmail("Email1");
		user1.setFirstName("FirstName1");
		user1.setLastName("LastName1");
		user1.setProfile(new Profile());
		
		user2.setLogin("user2");
		user2.setPassword("password2");
		user2.setEmail("Email2");
		user2.setFirstName("FirstName2");
		user2.setLastName("LastName2");
		user2.setProfile(new Profile());
		
		list.add(user1);
		list.add(user2);
		return list;
	}

	@Override
	protected void updateEntity(User entity) {
		entity.setLogin("NewUser");
		entity.setPassword("NewPassword");
		entity.setEmail("NewEmail");
		entity.setFirstName("NewFirstName");
		entity.setLastName("NewLastName");
	}

	@Override
	protected SearchParams createSearchParams() {
		SearchParamsImpl searchParams = new SearchParamsImpl();
		searchParams.setField("login" , "user1");
		return searchParams;
	}

	@Override
	protected void compareEntity(User entity1, User entity2) {
		
		assertTrue(conditionCheck(entity1.getEmail(), entity2.getEmail()));
		assertTrue(conditionCheck(entity1.getFirstName(), entity2.getFirstName()));
		assertTrue(conditionCheck(entity1.getLastName(), entity2.getLastName()));
		assertTrue(conditionCheck(entity1.getLogin(), entity2.getLogin()));
		assertTrue(conditionCheck(entity1.getModifications(), entity2.getModifications()));
		assertTrue(conditionCheck(entity1.getModificationsInWait(), entity2.getModificationsInWait()));
		assertTrue(conditionCheck(entity1.getPassword(), entity2.getPassword()));
		assertTrue(conditionCheck(entity1.getProfile(), entity2.getProfile()));
	} 

	/**
	 * Renvoi True si la condition est vérifier False Sinon
	 * @param <ConditionnalEntityType>
	 * @param Obj1 Première Object à Tester
	 * @param Obj2 Deuxième Object à Tester
	 * @return True si la condition est vérifier False Sinon
	 */
	private<ConditionnalEntityType> boolean conditionCheck(ConditionnalEntityType Obj1, ConditionnalEntityType Obj2)
	{
			return (!(Obj1!=null ^ Obj2!=null)) &&
					((Obj1==null && Obj2==null) || 
					Obj1.equals(Obj2));
	}
	
}
