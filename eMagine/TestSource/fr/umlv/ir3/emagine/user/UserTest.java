package fr.umlv.ir3.emagine.user;

import junit.framework.TestCase;

public class UserTest extends TestCase {
	User user;
	
	public UserTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
		user = new User();
	}

	protected void tearDown() throws Exception {
		user = null;
		super.tearDown();
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.user.User.User()'
	 */
	public void testUser() {
		assertTrue(false);
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.user.User.getEmail()'
	 */
	public void testGetEmail() {
		assertTrue(true);
	}

}
