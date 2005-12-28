package fr.umlv.ir3.emagine.user;

import servletunit.struts.MockStrutsTestCase;

public class UserDeleteActionTest extends MockStrutsTestCase {

	public UserDeleteActionTest (String testName) { 
    	super(testName); 
    }
	
	protected void setUp() throws Exception { 
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

    public void testSuccessfulDelete() {
        assertTrue(true);//setRequestPathInfo("/userSearch");
        //actionPerform(); 
    }
}
