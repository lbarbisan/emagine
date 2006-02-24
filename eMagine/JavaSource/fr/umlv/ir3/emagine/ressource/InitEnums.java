package fr.umlv.ir3.emagine.ressource;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DefaultAddressEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.GroupEnum;
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
import fr.umlv.ir3.emagine.apprentice.candidate.YearObtentionEnum;
import fr.umlv.ir3.emagine.event.EventTypeEnum;
import fr.umlv.ir3.emagine.firm.actor.FunctionEnum;
import fr.umlv.ir3.emagine.modification.EditableStateEnum;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.EmagineEnum;
import fr.umlv.ir3.emagine.util.EmagineEnumDAO;

public class InitEnums {

	static final void createEnums(int start, int length)
			throws EMagineException {
		initializeEnum(CourseOptionEnum.class);
		initializeEnum(EventTypeEnum.class);
		initializeEnum(GroupEnum.class);
	}

	static final void createDefaultAddressEnum(int start, int length)
			throws EMagineException {
		EmagineEnumDAO emagineEnumDAO = DAOManager.getInstance()
				.getEmagineEnumDAO();
		DefaultAddressEnum enums = new DefaultAddressEnum("Personnelle");
		emagineEnumDAO.create(enums);
		enums = new DefaultAddressEnum("Professionnelle");
		emagineEnumDAO.create(enums);
		enums = new DefaultAddressEnum("Académique");
		emagineEnumDAO.create(enums);
	}

	static final void createFunctionEnum(int start, int length)
			throws EMagineException {
		EmagineEnumDAO emagineEnumDAO = DAOManager.getInstance()
				.getEmagineEnumDAO();
		FunctionEnum enums = new FunctionEnum("DRH");
		emagineEnumDAO.create(enums);
		enums = new FunctionEnum("PDG");
		emagineEnumDAO.create(enums);
		enums = new FunctionEnum("Chef de projet");
		emagineEnumDAO.create(enums);
		enums = new FunctionEnum("Développeur");
		emagineEnumDAO.create(enums);
		enums = new FunctionEnum("Comptable");
		emagineEnumDAO.create(enums);
	}

	static final void createJustificationEnum(int start, int length)
			throws EMagineException {
		EmagineEnumDAO emagineEnumDAO = DAOManager.getInstance()
				.getEmagineEnumDAO();

		//Maladie	
		JustificationEnum enums = new JustificationEnum("M");
		emagineEnumDAO.create(enums);
		//RDV entreprise
		enums = new JustificationEnum("E");
		emagineEnumDAO.create(enums);
		//Justifiée			
		enums = new JustificationEnum("J");
		emagineEnumDAO.create(enums);
		//Accident
		enums = new JustificationEnum("A");
		emagineEnumDAO.create(enums);
		//Non justifiée
		enums = new JustificationEnum("NJ");
		emagineEnumDAO.create(enums);
	}

	static final void createDepartmentEnum(int start, int length)
			throws EMagineException {
		EmagineEnumDAO emagineEnumDAO = DAOManager.getInstance()
				.getEmagineEnumDAO();
		for (int index = start; index < length; index++) {
			DepartmentEnum enums = new DepartmentEnum("Department " + index);
			emagineEnumDAO.create(enums);
		}
	}

	static final void createCountryEnum(int start, int length)
			throws EMagineException {
		EmagineEnumDAO emagineEnumDAO = DAOManager.getInstance()
				.getEmagineEnumDAO();
		for (int index = start; index < length; index++) {
			CountryEnum countryEnum = new CountryEnum("Country " + index);
			emagineEnumDAO.create(countryEnum);
		}
	}

	static final void createProfessionEnum(int start, int length)
			throws EMagineException {
		EmagineEnumDAO emagineEnumDAO = DAOManager.getInstance()
				.getEmagineEnumDAO();
		ProfessionEnum enums = new ProfessionEnum("Cadre");
		emagineEnumDAO.create(enums);
		enums = new ProfessionEnum("Enseignant");
		emagineEnumDAO.create(enums);
		enums = new ProfessionEnum("Technicien");
		emagineEnumDAO.create(enums);
		enums = new ProfessionEnum("Secrétaire");
		emagineEnumDAO.create(enums);
		enums = new ProfessionEnum("Artisan");
		emagineEnumDAO.create(enums);
	}

	static final void createLanguageEnum(int start, int length)
			throws EMagineException {
		EmagineEnumDAO emagineEnumDAO = DAOManager.getInstance()
				.getEmagineEnumDAO();
		LanguageEnum enums = new LanguageEnum("Anglais");
		emagineEnumDAO.create(enums);
		enums = new LanguageEnum("Allemand");
		emagineEnumDAO.create(enums);
		enums = new LanguageEnum("Espagnol");
		emagineEnumDAO.create(enums);
		enums = new LanguageEnum("Italien");
		emagineEnumDAO.create(enums);
	}

	static final void createLevelEntryEnum(int start, int length)
			throws EMagineException {
		EmagineEnumDAO emagineEnumDAO = DAOManager.getInstance()
				.getEmagineEnumDAO();
		LevelEntryEnum enums = new LevelEntryEnum("Bac");
		emagineEnumDAO.create(enums);
		enums = new LevelEntryEnum("+1");
		emagineEnumDAO.create(enums);
		enums = new LevelEntryEnum("+2");
		emagineEnumDAO.create(enums);
		enums = new LevelEntryEnum("+3");
		emagineEnumDAO.create(enums);
		enums = new LevelEntryEnum("+4");
		emagineEnumDAO.create(enums);
		enums = new LevelEntryEnum("+5");
		emagineEnumDAO.create(enums);
	}

	static final void createNationalityEnum(int start, int length)
			throws EMagineException {
		EmagineEnumDAO emagineEnumDAO = DAOManager.getInstance()
				.getEmagineEnumDAO();
		for (int index = start; index < length; index++) {
			NationalityEnum enums = new NationalityEnum("Nationality " + index);
			emagineEnumDAO.create(enums);
		}
	}

	static final void createSexEnum(int start, int length)
			throws EMagineException {
		EmagineEnumDAO emagineEnumDAO = DAOManager.getInstance()
				.getEmagineEnumDAO();
		SexEnum enums = new SexEnum("Homme");
		emagineEnumDAO.create(enums);
		enums = new SexEnum("Femme");
		emagineEnumDAO.create(enums);
	}

	static final void createYearEnum(int start, int length)
			throws EMagineException {
		EmagineEnumDAO emagineEnumDAO = DAOManager.getInstance()
				.getEmagineEnumDAO();
		YearEnum enums = new YearEnum("1");
		emagineEnumDAO.create(enums);
		enums = new YearEnum("2");
		emagineEnumDAO.create(enums);
		enums = new YearEnum("3");
		emagineEnumDAO.create(enums);
		enums = new YearEnum("4");
		emagineEnumDAO.create(enums);
		enums = new YearEnum("5");
		emagineEnumDAO.create(enums);
		enums =  new YearEnum("Diplomé");
		emagineEnumDAO.create(enums);
	}

	static final void initializeEnum(Class enumClass) throws EMagineException {
		EmagineEnumDAO emagineEnumDAO = DAOManager.getInstance()
				.getEmagineEnumDAO();

		List<Field> fields = new ArrayList<Field>();

		for (Field field : enumClass.getFields()) {
			int modifiers = field.getModifiers();
			if (Modifier.isFinal(modifiers) && Modifier.isPublic(modifiers)
					&& Modifier.isStatic(modifiers)) {
				fields.add(field);
				try {
					String value = (String) field.get(null);
					Object[] objects = new Object[1];
					objects[0] = value;
					for (Constructor constructor : enumClass.getConstructors()) {
						if (constructor.getParameterTypes().length == 1) {
							emagineEnumDAO.create((EmagineEnum) constructor
									.newInstance(objects));
						}
					}
				} catch (SecurityException e) {
					// TODO SecurityException.e Not Implemented
					e.printStackTrace();
				} catch (EMagineException e) {
					// TODO EMagineException.e Not Implemented
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO InstantiationException.e Not Implemented
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO InvocationTargetException.e Not Implemented
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO IllegalArgumentException.e Not Implemented
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO IllegalAccessException.e Not Implemented
					e.printStackTrace();
				}
			}

		}
	}

	static final void createEditableStateEnum(int start, int length)
			throws EMagineException {
		EmagineEnumDAO emagineEnumDAO = DAOManager.getInstance()
				.getEmagineEnumDAO();
		for (int index = start; index < length; index++) {
			EditableStateEnum enums = new EditableStateEnum("Etat " + index);
			emagineEnumDAO.create(enums);
		}
	}

	static final void createYearObtentionEnum(int start, int length)
			throws EMagineException {
		EmagineEnumDAO emagineEnumDAO = DAOManager.getInstance()
				.getEmagineEnumDAO();
		YearObtentionEnum enums = null;
		for (int index = start; index < length; index++) {
			enums = new YearObtentionEnum("" + (2000 + index));
			emagineEnumDAO.create(enums);
		}
	}

	static final void createContactEnum(int start, int length)
			throws EMagineException {
		EmagineEnumDAO emagineEnumDAO = DAOManager.getInstance()
				.getEmagineEnumDAO();
		ContactEnum enums = new ContactEnum("JPO");
		emagineEnumDAO.create(enums);
		enums = new ContactEnum("Internet");
		emagineEnumDAO.create(enums);
		enums = new ContactEnum("Amis");
		emagineEnumDAO.create(enums);
		enums = new ContactEnum("Autres");
		emagineEnumDAO.create(enums);
	}

	static final void createDiplomaEnum(int start, int length)
			throws EMagineException {
		EmagineEnumDAO emagineEnumDAO = DAOManager.getInstance()
				.getEmagineEnumDAO();
		DiplomaEnum enums = new DiplomaEnum("Baccalauréat");
		emagineEnumDAO.create(enums);
		enums = new DiplomaEnum("Licence");
		emagineEnumDAO.create(enums);
		enums = new DiplomaEnum("Master");
		emagineEnumDAO.create(enums);
		enums = new DiplomaEnum("Doctorat");
		emagineEnumDAO.create(enums);
		enums = new DiplomaEnum("DUT");
		emagineEnumDAO.create(enums);
		enums = new DiplomaEnum("BTS");
		emagineEnumDAO.create(enums);
		enums = new DiplomaEnum("Licence Pro");
		emagineEnumDAO.create(enums);
	}

	static final void createSectionEnum(int start, int length)
			throws EMagineException {
		EmagineEnumDAO emagineEnumDAO = DAOManager.getInstance()
				.getEmagineEnumDAO();
		SectionEnum enums = new SectionEnum("Informatique");
		emagineEnumDAO.create(enums);
		enums = new SectionEnum("GEII");
		emagineEnumDAO.create(enums);
		enums = new SectionEnum("MIAS");
		emagineEnumDAO.create(enums);
	}

	static final EmagineEnum getEmagineEnum(String name,
			Class<? extends EmagineEnum> clazz) throws EMagineException {
		EmagineEnumDAO emagineEnumDAO = DAOManager.getInstance()
				.getEmagineEnumDAO();

		return emagineEnumDAO.find(name, clazz);
	}
}
