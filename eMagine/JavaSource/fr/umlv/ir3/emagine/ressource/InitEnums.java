package fr.umlv.ir3.emagine.ressource;

import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DefaultAddressEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.JustificationEnum;
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
import fr.umlv.ir3.emagine.modification.EditableStateEnum;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.EmagineEnum;
import fr.umlv.ir3.emagine.util.EmagineEnumDAO;

public class InitEnums {

	static final void createDefaultAddressEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		DefaultAddressEnum enums =  new DefaultAddressEnum("Académique");
		emagineEnumDAO.create(enums);
		enums =  new DefaultAddressEnum("Professionnelle");
		emagineEnumDAO.create(enums);
		enums =  new DefaultAddressEnum("Personnelle");
		emagineEnumDAO.create(enums);
	}
	
	static final void createJustificationEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();

			//Maladie	
			JustificationEnum enums =  new JustificationEnum("M");
			emagineEnumDAO.create(enums);
			//RDV entreprise
			enums =  new JustificationEnum("E");
			emagineEnumDAO.create(enums);
			//Justifiée			
			enums =  new JustificationEnum("J");
			emagineEnumDAO.create(enums);
			//Accident
			enums =  new JustificationEnum("A");
			emagineEnumDAO.create(enums);
			//Non justifiée
			enums =  new JustificationEnum("NJ");
			emagineEnumDAO.create(enums);
	}
	
	static final void createDepartmentEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		for(int index=start;index<length; index++)
		{
			DepartmentEnum enums =  new DepartmentEnum("Department " + index);
			emagineEnumDAO.create(enums);
		}
	}
	
	static final void createCountryEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		for(int index=start;index<length; index++)
		{
			CountryEnum countryEnum =  new CountryEnum("Country " + index);
			emagineEnumDAO.create(countryEnum);
		}
	}
	
	static final void createCourseOptionEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
			
			CourseOptionEnum enums =  new CourseOptionEnum("GEII");	
			emagineEnumDAO.create(enums);
			enums =  new CourseOptionEnum("MFPI");
			emagineEnumDAO.create(enums);		
			enums =  new CourseOptionEnum("IR");
			emagineEnumDAO.create(enums);						
			enums =  new CourseOptionEnum("GM");
			emagineEnumDAO.create(enums);			
			enums =  new CourseOptionEnum("EI");
			emagineEnumDAO.create(enums);
			enums =  new CourseOptionEnum("GMU");
			emagineEnumDAO.create(enums);
	}
	
	static final void createProfessionEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		ProfessionEnum enums =  new ProfessionEnum("Cadre");	
		emagineEnumDAO.create(enums);
		enums =  new ProfessionEnum("Enseignant");
		emagineEnumDAO.create(enums);		
		enums =  new ProfessionEnum("Technicien");
		emagineEnumDAO.create(enums);						
		enums =  new ProfessionEnum("Secrétaire");
		emagineEnumDAO.create(enums);			
		enums =  new ProfessionEnum("Artisan");
		emagineEnumDAO.create(enums);
	}
	
	static final void createLanguageEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		LanguageEnum enums =  new LanguageEnum("Anglais");	
		emagineEnumDAO.create(enums);
		enums =  new LanguageEnum("Allemand");
		emagineEnumDAO.create(enums);		
		enums =  new LanguageEnum("Espagnol");
		emagineEnumDAO.create(enums);
	}
	
	static final void createLevelEntryEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		LevelEntryEnum enums =  new LevelEntryEnum("Bac");
		emagineEnumDAO.create(enums);
		enums =  new LevelEntryEnum("+1");
		emagineEnumDAO.create(enums);
		enums =  new LevelEntryEnum("+2");
		emagineEnumDAO.create(enums);
		enums =  new LevelEntryEnum("+3");
		emagineEnumDAO.create(enums);
		enums =  new LevelEntryEnum("+4");
		emagineEnumDAO.create(enums);
		enums =  new LevelEntryEnum("+5");
		emagineEnumDAO.create(enums);
	}
	
	static final void createNationalityEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		for(int index=start;index<length; index++)
		{
			NationalityEnum enums =  new NationalityEnum("Nationality " + index);
			emagineEnumDAO.create(enums);
		}
	}
	
	static final void createSexEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
			SexEnum enums =  new SexEnum("Homme");
			emagineEnumDAO.create(enums);
			enums =  new SexEnum("Femme");
			emagineEnumDAO.create(enums);
	}
	
	static final void createYearEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		for(int index=start;index<length; index++)
		{
			YearEnum enums =  new YearEnum(new Integer(2000 + index).toString());
			emagineEnumDAO.create(enums);
		}
	}
	
	static final void createEventTypeEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		EventTypeEnum enums =  new EventTypeEnum("Changement adresse");
		emagineEnumDAO.create(enums);
		enums =  new EventTypeEnum("Changement de Tuteur Enseignant");
		emagineEnumDAO.create(enums);
		enums =  new EventTypeEnum("Changement de Tuteur Ingénieur");
		emagineEnumDAO.create(enums);
		enums =  new EventTypeEnum("Envoi mail");
		emagineEnumDAO.create(enums);
		enums =  new EventTypeEnum("Envoi courrier");
		emagineEnumDAO.create(enums);
	}
	
	static final void createEditableStateEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		for(int index=start;index<length; index++)
		{
			EditableStateEnum enums =  new EditableStateEnum("Etat " + index);
			emagineEnumDAO.create(enums);
		}
	}
		
	static final void createContactEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		ContactEnum enums =  new ContactEnum("JPO");
		emagineEnumDAO.create(enums);
		enums =  new ContactEnum("Internet");
		emagineEnumDAO.create(enums);
		enums =  new ContactEnum("Amis");
		emagineEnumDAO.create(enums);
		enums =  new ContactEnum("Autres");
		emagineEnumDAO.create(enums);
	}
	
	static final void createDiplomaEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		DiplomaEnum enums =  new DiplomaEnum("Baccalauréat");
		emagineEnumDAO.create(enums);
		enums =  new DiplomaEnum("Licence");
		emagineEnumDAO.create(enums);
		enums =  new DiplomaEnum("Master");
		emagineEnumDAO.create(enums);
		enums =  new DiplomaEnum("Doctorat");
		emagineEnumDAO.create(enums);
		enums =  new DiplomaEnum("DUT");
		emagineEnumDAO.create(enums);
		enums =  new DiplomaEnum("BTS");
		emagineEnumDAO.create(enums);
		enums =  new DiplomaEnum("Licence Pro");
		emagineEnumDAO.create(enums);
	}
	
	static final void createSectionEnum(int start, int length) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		SectionEnum enums =  new SectionEnum("Informatique");
		emagineEnumDAO.create(enums);
		enums =  new SectionEnum("GEII");
		emagineEnumDAO.create(enums);
		enums =  new SectionEnum("MIAS");
		emagineEnumDAO.create(enums);
	}
	
	static final EmagineEnum getEmagineEnum(String name, Class<? extends EmagineEnum> clazz) throws EMagineException
	{
		EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
		
		return  emagineEnumDAO.find(name, clazz);		
	}
}
