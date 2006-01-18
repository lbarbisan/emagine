package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.Calendar;
import java.util.GregorianCalendar;

import fr.umlv.ir3.emagine.util.base.BaseDAOTest;
import fr.umlv.ir3.emagine.util.search.SearchParams;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class AbsenceDAOTest extends BaseDAOTest<Absence> {

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
	protected AbsenceDAO getDAO() {
		return dao;
	}
	@Override
	protected Absence createEntity(int index) {
		//FIXME : lbarbisan - Créer un candidat, sinon le test échoue, le candidat ne doit pas pouvoir être null
		return new Absence(true,index + " Test de justification. &é~#'{([-|`_ç^à@)]=+}^¨$£¤%ù*µ?,;.:!§<>",GregorianCalendar.getInstance().getTime(),GregorianCalendar.getInstance().getTime());
	}

	@Override
	protected void updateEntity(Absence abs) {
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
		searchParams.setField("JustificationComment" , "test de dat%");
		return searchParams;
	}

	@Override
	protected void compareEntity(Absence abs1, Absence abs2) {

		assertTrue(conditionCheck(abs1.getCurrentModification(), abs2.getCurrentModification()));
		assertTrue(conditionCheck(abs1.getEndDate(),abs2.getEndDate()));
		assertTrue(conditionCheck(abs1.getId(), abs2.getId()));
		assertTrue(conditionCheck(abs1.getJustificationComment(),abs2.getJustificationComment()));
		assertTrue(conditionCheck(abs1.getJustificationComment(),abs2.getJustificationComment()));
		assertTrue(conditionCheck(abs1.getModifications(),abs2.getModifications()));
		assertTrue(conditionCheck(abs1.getModifications(),abs2.getModifications()));
		assertTrue(conditionCheck(abs1.getNumberOfWorkedDays(),abs2.getNumberOfWorkedDays()));
		assertTrue(conditionCheck(abs1.getStartDate(),abs2.getStartDate()));
		assertTrue(conditionCheck(abs1.getApprentice(),abs2.getApprentice()));
	}
	
	@Override
	protected Absence createEntityForSearchParams(SearchParams params, int index) {
		GregorianCalendar startDate = new GregorianCalendar(2005,Calendar.DECEMBER,12);
		GregorianCalendar endDate = new GregorianCalendar(2006,Calendar.JANUARY,1);
		return new Absence(false,"test de date",startDate.getTime(),endDate.getTime());
	}
	
}
