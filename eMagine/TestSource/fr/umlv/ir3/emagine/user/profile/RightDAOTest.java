package fr.umlv.ir3.emagine.user.profile;

import java.util.ArrayList;
import java.util.Collection;

import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseDAOTest;
import fr.umlv.ir3.emagine.util.search.SearchParams;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class RightDAOTest extends BaseDAOTest<Right> {

	RightDAO dao;
	
	public RightDAOTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
		dao = new RightDAO();
	}

	protected void tearDown() throws Exception {
		dao = null;
		super.tearDown();
	}

	@Override
	protected BaseDAO<Right> getDAO() {
		return dao;
	}

	@Override
	protected Right createEntity() {
		Right right = new Right("right");
		right.setDescription("description  &щ~#'{([-|`_ч^р@)]=+}^и$гд%∙*╡?,;.:!з<>");
		return right;
	}

	@Override
	protected Collection<Right> createEntityCollection() {
		
		ArrayList<Right> list = new ArrayList<Right>();
		
		Right right1 = new Right("right1");
		right1.setDescription("description1  &щ~#'{([-|`_ч^р@)]=+}^и$гд%∙*╡?,;.:!з<>");
		Right right2 = new Right("right2");
		right2.setDescription("description2  &щ~#'{([-|`_ч^р@)]=+}^и$гд%∙*╡?,;.:!з<>");
		Right right3 = new Right("righ3");
		right3.setDescription("description3  &щ~#'{([-|`_ч^р@)]=+}^и$гд%∙*╡?,;.:!з<>");
		Right right4 = new Right("right4");
		right4.setDescription("description4  &щ~#'{([-|`_ч^р@)]=+}^и$гд%∙*╡?,;.:!з<>");
		
		list.add(right1);
		list.add(right2);
		list.add(right3);
		list.add(right4);
		return list;
		
	}

	@Override
	protected void updateEntity(Right entity) {
		entity.setDescription("new Description");
		entity.setName("new Name");
	}

	@Override
	protected SearchParams createSearchParams() {
		SearchParamsImpl searchParams = new SearchParamsImpl();
		searchParams.setField("right" , "right");
		return searchParams;
	}

	@Override
	protected void compareEntity(Right entity1, Right entity2) {
		assertTrue(conditionCheck(entity1.getDescription(), entity2.getDescription()));
		assertTrue(conditionCheck(entity1.getId(), entity2.getId()));
		assertTrue(conditionCheck(entity1.getName(), entity2.getName()));
	}
	
}
