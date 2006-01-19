package fr.umlv.ir3.emagine.ressource;

import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DefaultAddressEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.LanguageEnum;
import fr.umlv.ir3.emagine.apprentice.LevelEntryEnum;
import fr.umlv.ir3.emagine.apprentice.NationalityEnum;
import fr.umlv.ir3.emagine.apprentice.SexEnum;
import fr.umlv.ir3.emagine.apprentice.YearEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.ContactEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.CourseOptionEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.DiplomaEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.ProfessionEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.SectionEnum;
import fr.umlv.ir3.emagine.event.EventTypeEnum;
import fr.umlv.ir3.emagine.extraction.ViewEnum;
import fr.umlv.ir3.emagine.modification.EditableStateEnum;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.EmagineEnum;
import fr.umlv.ir3.emagine.util.EmagineEnumDAO;

public class InitEnums {

	static final void createDefaultAddressEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		for(int index=start;index<length; index++)
		{
			DefaultAddressEnum defaultAddressEnum =  new DefaultAddressEnum("DefaultAddressEnum" + index);
			emagineEnumDAO.create(defaultAddressEnum);
		}
	}
	
	static final void createDepartmentEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		for(int index=start;index<length; index++)
		{
			DepartmentEnum enums =  new DepartmentEnum("DepartmentEnum" + index);
			emagineEnumDAO.create(enums);
		}
	}
	
	static final void createCountryEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		for(int index=start;index<length; index++)
		{
			CountryEnum countryEnum =  new CountryEnum("pays" + index);
			emagineEnumDAO.create(countryEnum);
		}
	}
	
	static final void createCourseOptionEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		for(int index=start;index<length; index++)
		{
			CourseOptionEnum courseOptionEnum =  new CourseOptionEnum("CourseOption" + index);
			emagineEnumDAO.create(courseOptionEnum);
		}
	}
	
	static final void createProfessionEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		for(int index=start;index<length; index++)
		{
			ProfessionEnum professionEnum =  new ProfessionEnum("Profession" + index);
			emagineEnumDAO.create(professionEnum);
		}
	}
	
	static final void createLanguageEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		for(int index=start;index<length; index++)
		{
			LanguageEnum languageEnum =  new LanguageEnum("LanguageEnum" + index);
			emagineEnumDAO.create(languageEnum);
		}
	}
	
	static final void createLevelEntryEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		for(int index=start;index<length; index++)
		{
			LevelEntryEnum enums =  new LevelEntryEnum("LevelEntryEnum" + index);
			emagineEnumDAO.create(enums);
		}
	}
	
	static final void createNationalityEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		for(int index=start;index<length; index++)
		{
			NationalityEnum enums =  new NationalityEnum("NationalityEnum" + index);
			emagineEnumDAO.create(enums);
		}
	}
	
	static final void createSexEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		for(int index=start;index<length; index++)
		{
			SexEnum enums =  new SexEnum("SexEnum" + index);
			emagineEnumDAO.create(enums);
		}
	}
	
	static final void createYearEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		for(int index=start;index<length; index++)
		{
			YearEnum enums =  new YearEnum("YearEnum" + index);
			emagineEnumDAO.create(enums);
		}
	}
	
	static final void createEventTypeEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		for(int index=start;index<length; index++)
		{
			EventTypeEnum enums =  new EventTypeEnum("EventTypeEnum" + index);
			emagineEnumDAO.create(enums);
		}
	}
	
	static final void createViewEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		for(int index=start;index<length; index++)
		{
			ViewEnum enums =  new ViewEnum("ViewEnum" + index);
			emagineEnumDAO.create(enums);
		}
	}
	
	static final void createEditableStateEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		for(int index=start;index<length; index++)
		{
			EditableStateEnum enums =  new EditableStateEnum("EditableStateEnum" + index);
			emagineEnumDAO.create(enums);
		}
	}
	
	
	static final void createDiplomaEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		for(int index=start;index<length; index++)
		{
			DiplomaEnum enums =  new DiplomaEnum("DiplomaEnum" + index);
			emagineEnumDAO.create(enums);
		}
	}
	
	static final void createContactEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		for(int index=start;index<length; index++)
		{
			ContactEnum enums =  new ContactEnum("ContactEnum" + index);
			emagineEnumDAO.create(enums);
		}
	}
	
	static final void createSectionEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		for(int index=start;index<length; index++)
		{
			SectionEnum enums =  new SectionEnum("SectionEnum" + index);
			emagineEnumDAO.create(enums);
		}
	}
	
	
	private final static EmagineEnum getEmagineEnum(Class clazz) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		
		return  emagineEnumDAO.findAll(clazz).get(0);
		
	}
}
