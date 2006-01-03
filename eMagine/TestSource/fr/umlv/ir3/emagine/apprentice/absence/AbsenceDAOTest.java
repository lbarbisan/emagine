package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseDAOTest;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.search.SearchParams;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class AbsenceDAOTest extends BaseDAOTest {

	AbsenceDAO dao;
	
	public AbsenceDAOTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		dao = new AbsenceDAO();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		dao = null;
		super.tearDown();
	}
	
	@Override
	protected BaseDAO getDAO() {
		return dao;
	}

	@Override
	protected BaseEntity createEntity() {
		return new Absence(true,"Test de justification. &щ~#'{([-|`_ч^р@)]=+}^и$гд%∙*╡?,;.:!з<>",GregorianCalendar.getInstance().getTime(),GregorianCalendar.getInstance().getTime());
	}

	@Override
	protected Collection createEntityCollection() {
		ArrayList<Absence> list = new ArrayList<Absence>();
		GregorianCalendar start = new GregorianCalendar(2005,Calendar.DECEMBER,12);
		GregorianCalendar end = new GregorianCalendar(2006,Calendar.JANUARY,1);
		list.add(new Absence(true,"Test de justification. &щ~#'{([-|`_ч^р@)]=+}^и$гд%∙*╡?,;.:!з<>",GregorianCalendar.getInstance().getTime(),GregorianCalendar.getInstance().getTime()));
		list.add(new Absence(false,"Test de justification. &щ~#'{([-|`_ч^р@)]=+}^и$гд%∙*╡?,;.:!з<>",GregorianCalendar.getInstance().getTime(),GregorianCalendar.getInstance().getTime()));
		list.add(new Absence(true,"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",GregorianCalendar.getInstance().getTime(),GregorianCalendar.getInstance().getTime()));
		list.add(new Absence(false,"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",GregorianCalendar.getInstance().getTime(),GregorianCalendar.getInstance().getTime()));
		list.add(new Absence(true,"test de date",start.getTime(),end.getTime()));
		list.add(new Absence(false,"test de date",start.getTime(),end.getTime()));
		return list;
	}

	@Override
	protected void updateEntity(BaseEntity entity) {
		Absence abs = (Absence) entity;
		GregorianCalendar start = new GregorianCalendar(2005,Calendar.JULY,14);
		GregorianCalendar end = new GregorianCalendar(2006,Calendar.NOVEMBER,11);
		abs.setStartDate(start.getTime());
		abs.setEndDate(end.getTime());
		abs.setJustification(!abs.isJustification());
		abs.setJustificationComment("NEW COMMENT");
	}

	@Override
	protected SearchParams createSearchParams() {
		SearchParamsImpl searchParams = new SearchParamsImpl();
		searchParams.setField("JustificationComment" , "test de date");
		return searchParams;
	}

	@Override
	protected void compareEntity(BaseEntity entity1, BaseEntity entity2) {
		Absence abs1 = (Absence) entity1;
		Absence abs2 = (Absence) entity2;

		assertTrue(abs1.getCurrentModification().equals(abs2.getCurrentModification()));
		assertTrue(abs1.getEndDate().equals(abs2.getEndDate()));
		assertTrue(abs1.getId()== abs2.getId());
		assertTrue(abs1.getJustificationComment().equals(abs2.getJustificationComment()));
		assertTrue(abs1.getJustificationComment().equals(abs2.getJustificationComment()));
		assertTrue(abs1.getModifications().equals(abs2.getModifications()));
		assertTrue(abs1.getModifications().equals(abs2.getModifications()));
		assertTrue(abs1.getNumberOfWorkedDays() == abs2.getNumberOfWorkedDays());
		assertTrue(abs1.getStartDate().equals(abs2.getStartDate()));
	}
}
