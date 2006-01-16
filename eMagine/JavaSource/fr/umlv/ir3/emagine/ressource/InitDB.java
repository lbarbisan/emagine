package fr.umlv.ir3.emagine.ressource;

import java.io.FileNotFoundException;

import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.user.UserDAO;
import fr.umlv.ir3.emagine.user.profile.Profile;
import fr.umlv.ir3.emagine.user.profile.Right;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.EmagineEnum;
import fr.umlv.ir3.emagine.util.EmagineEnumDAO;

public class InitDB {

	/**
	 * @param args
	 * @throws EMagineException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, EMagineException {
		InitializeUser();
		InitializeDeparmentEnum();
		InitializeCountryEnum();
	}
	
	public static void InitializeUser()
	{
		
		UserDAO userDAO = DAOManager.getInstance().getUserDAO();
		DAOManager.beginTransaction();
		
		try {
		
		Profile profile = new Profile();
		profile.setDescription("Droit des utilisateurs");
		profile.setName("Administrateur");
		profile.addRights(new Right("user.create"));
		profile.addRights(new Right("user.update"));
		profile.addRights(new Right("user.delete"));
			
		User user = new User();
		user.setEmail("lbarbisan@gmail.com");
		user.setFirstName("Laurent");
		user.setLastName("Barbisan");
		user.setLogin("lbarbisan");
		user.setPassword("lbarbisan");	
		user.setProfile(profile);
		userDAO.create(user);

		user = new User();
		user.setEmail("netangel@gmail.com");
		user.setFirstName("Anthony");
		user.setLastName("Ogier");
		user.setLogin("aogier");
		user.setPassword("aogier");
		user.setProfile(profile);
		userDAO.create(user);
		
		user = new User();
		user.setEmail("jrenaudi@gmail.com");
		user.setFirstName("Jean-Baptiste");
		user.setLastName("Renaudi");
		user.setLogin("jrenaudi");
		user.setPassword("jrenaudi");
		user.setProfile(profile);
		userDAO.create(user);
		
		user = new User();
		user.setEmail("caroline.rondini@free.fr");
		user.setFirstName("Caroline");
		user.setLastName("Rondini");
		user.setLogin("crondini");
		user.setPassword("crondini");
		user.setProfile(profile);
		userDAO.create(user);
		
		user = new User();
		user.setEmail("mmancel@gmail.com");
		user.setFirstName("Mathieu");
		user.setLastName("Mancel");
		user.setLogin("mmancel");
		user.setPassword("mmancel");
		user.setProfile(profile);
		userDAO.create(user);
		
		} catch (EMagineException emagine) {
			// TODO EMagineException.e1 Not Implemented
			emagine.printStackTrace();
		}
		DAOManager.commitTransaction();

	}
	
	public static void InitializeDeparmentEnum()
	{
		EmagineEnumDAO emagineEnumDAO = DAOManager.getInstance().getEmagineEnumDAO();
		DAOManager.beginTransaction();
		
		try {				
			emagineEnumDAO.create(new DepartmentEnum("D1", "Ain"));
			emagineEnumDAO.create(new DepartmentEnum("D2", "Aisne"));
			emagineEnumDAO.create(new DepartmentEnum("D3", "Allier"));
			emagineEnumDAO.create(new DepartmentEnum("D4", "Alpes-de-Haute-Provence"));
			emagineEnumDAO.create(new DepartmentEnum("D5", "Hautes-Alpes"));
			emagineEnumDAO.create(new DepartmentEnum("D6", "Alpes-Maritimes"));
			emagineEnumDAO.create(new DepartmentEnum("D7", "Ardèche"));
			emagineEnumDAO.create(new DepartmentEnum("D8", "Ardennes"));
			emagineEnumDAO.create(new DepartmentEnum("D9", "Ariège"));
			emagineEnumDAO.create(new DepartmentEnum("D10", "Aube"));
			emagineEnumDAO.create(new DepartmentEnum("D11", "Aude"));
			emagineEnumDAO.create(new DepartmentEnum("D12", "Aveyron"));
			emagineEnumDAO.create(new DepartmentEnum("D13", "Bouches-du-Rhône"));
			emagineEnumDAO.create(new DepartmentEnum("D14", "Calvados"));
			emagineEnumDAO.create(new DepartmentEnum("D15", "Cantal"));
			emagineEnumDAO.create(new DepartmentEnum("D16", "Charente"));
			emagineEnumDAO.create(new DepartmentEnum("D17", "Charente-Maritime"));
			emagineEnumDAO.create(new DepartmentEnum("D18", "Cher"));
			emagineEnumDAO.create(new DepartmentEnum("D19", "Corrèze"));
			emagineEnumDAO.create(new DepartmentEnum("D2A", "Corse-du-Sud"));
			emagineEnumDAO.create(new DepartmentEnum("D2B", "Haute-Corse"));
			emagineEnumDAO.create(new DepartmentEnum("D21", "Côte-d'Or"));
			emagineEnumDAO.create(new DepartmentEnum("D22", "Côtes-d'Armor"));
			emagineEnumDAO.create(new DepartmentEnum("D23", "Creuse"));
			emagineEnumDAO.create(new DepartmentEnum("D24", "Dordogne"));
			emagineEnumDAO.create(new DepartmentEnum("D25", "Doubs"));
			emagineEnumDAO.create(new DepartmentEnum("D26", "Drôme"));
			emagineEnumDAO.create(new DepartmentEnum("D27", "Eure"));
			emagineEnumDAO.create(new DepartmentEnum("D28", "Eure-et-Loir"));
			emagineEnumDAO.create(new DepartmentEnum("D29", "Finistère"));
			emagineEnumDAO.create(new DepartmentEnum("D30", "Gard"));
			emagineEnumDAO.create(new DepartmentEnum("D31", "Haute-Garonne"));
			emagineEnumDAO.create(new DepartmentEnum("D32", "Gers"));
			emagineEnumDAO.create(new DepartmentEnum("D33", "Gironde"));
			emagineEnumDAO.create(new DepartmentEnum("D34", "Hérault"));
			emagineEnumDAO.create(new DepartmentEnum("D35", "Ille-et-Vilaine"));
			emagineEnumDAO.create(new DepartmentEnum("D36", "Indre"));
			emagineEnumDAO.create(new DepartmentEnum("D37", "Indre-et-Loire"));
			emagineEnumDAO.create(new DepartmentEnum("D38", "Isère"));
			emagineEnumDAO.create(new DepartmentEnum("D39", "Jura"));
			emagineEnumDAO.create(new DepartmentEnum("D40", "Landes"));
			emagineEnumDAO.create(new DepartmentEnum("D41", "Loir-et-Cher"));
			emagineEnumDAO.create(new DepartmentEnum("D42", "Loire"));
			emagineEnumDAO.create(new DepartmentEnum("D43", "Haute-Loire"));
			emagineEnumDAO.create(new DepartmentEnum("D44", "Loire-Atlantique"));
			emagineEnumDAO.create(new DepartmentEnum("D45", "Loiret"));
			emagineEnumDAO.create(new DepartmentEnum("D46", "Lot"));
			emagineEnumDAO.create(new DepartmentEnum("D47", "Lot-et-Garonne"));
			emagineEnumDAO.create(new DepartmentEnum("D48", "Lozère"));
			emagineEnumDAO.create(new DepartmentEnum("D49", "Maine-et-Loire"));
			emagineEnumDAO.create(new DepartmentEnum("D50", "Manche"));
			emagineEnumDAO.create(new DepartmentEnum("D51", "Marne"));
			emagineEnumDAO.create(new DepartmentEnum("D52", "Haute-Marne"));
			emagineEnumDAO.create(new DepartmentEnum("D53", "Mayenne"));
			emagineEnumDAO.create(new DepartmentEnum("D54", "Meurthe-et-Moselle"));
			emagineEnumDAO.create(new DepartmentEnum("D55", "Meuse"));
			emagineEnumDAO.create(new DepartmentEnum("D56", "Morbihan"));
			emagineEnumDAO.create(new DepartmentEnum("D57", "Moselle"));
			emagineEnumDAO.create(new DepartmentEnum("D58", "Nièvre"));
			emagineEnumDAO.create(new DepartmentEnum("D59", "Nord"));
			emagineEnumDAO.create(new DepartmentEnum("D60", "Oise"));
			emagineEnumDAO.create(new DepartmentEnum("D61", "Orne"));
			emagineEnumDAO.create(new DepartmentEnum("D62", "Pas-de-Calais"));
			emagineEnumDAO.create(new DepartmentEnum("D63", "Puy-de-Dôme"));
			emagineEnumDAO.create(new DepartmentEnum("D64", "Pyrénées-Atlantiques"));
			emagineEnumDAO.create(new DepartmentEnum("D65", "Hautes-Pyrénées"));
			emagineEnumDAO.create(new DepartmentEnum("D66", "Pyrénées-Orientales"));
			emagineEnumDAO.create(new DepartmentEnum("D67", "Bas-Rhin"));
			emagineEnumDAO.create(new DepartmentEnum("D68", "Haut-Rhin"));
			emagineEnumDAO.create(new DepartmentEnum("D69", "Rhône"));
			emagineEnumDAO.create(new DepartmentEnum("D70", "Haute-Saône"));
			emagineEnumDAO.create(new DepartmentEnum("D71", "Saône-et-Loire"));
			emagineEnumDAO.create(new DepartmentEnum("D72", "Sarthe"));
			emagineEnumDAO.create(new DepartmentEnum("D73", "Savoie"));
			emagineEnumDAO.create(new DepartmentEnum("D74", "Haute-Savoie"));
			emagineEnumDAO.create(new DepartmentEnum("D75", "Paris"));
			emagineEnumDAO.create(new DepartmentEnum("D76", "Seine-Maritime"));
			emagineEnumDAO.create(new DepartmentEnum("D77", "Seine-et-Marne"));
			emagineEnumDAO.create(new DepartmentEnum("D78", "Yvelines"));
			emagineEnumDAO.create(new DepartmentEnum("D79", "Deux-Sèvres"));
			emagineEnumDAO.create(new DepartmentEnum("D80", "Somme"));
			emagineEnumDAO.create(new DepartmentEnum("D81", "Tarn"));
			emagineEnumDAO.create(new DepartmentEnum("D82", "Tarn-et-Garonne"));
			emagineEnumDAO.create(new DepartmentEnum("D83", "Var"));
			emagineEnumDAO.create(new DepartmentEnum("D84", "Vaucluse"));
			emagineEnumDAO.create(new DepartmentEnum("D85", "Vendée"));
			emagineEnumDAO.create(new DepartmentEnum("D86", "Vienne"));
			emagineEnumDAO.create(new DepartmentEnum("D87", "Haute-Vienne"));
			emagineEnumDAO.create(new DepartmentEnum("D88", "Vosges"));
			emagineEnumDAO.create(new DepartmentEnum("D89", "Yonne"));
			emagineEnumDAO.create(new DepartmentEnum("D90", "Territoire de Belfort"));
			emagineEnumDAO.create(new DepartmentEnum("D91", "Essonne"));
			emagineEnumDAO.create(new DepartmentEnum("D92", "Hauts-de-Seine"));
			emagineEnumDAO.create(new DepartmentEnum("D93", "Seine-Saint-Denis"));
			emagineEnumDAO.create(new DepartmentEnum("D94", "Val-de-Marne"));
			emagineEnumDAO.create(new DepartmentEnum("D95", "Val-d'Oise"));
			emagineEnumDAO.create(new DepartmentEnum("D971", "Guadeloupe"));
			emagineEnumDAO.create(new DepartmentEnum("D972", "Martinique"));
			emagineEnumDAO.create(new DepartmentEnum("D973", "Guyane"));
			emagineEnumDAO.create(new DepartmentEnum("D974", "Réunion"));
			emagineEnumDAO.create(new DepartmentEnum("D975", "Saint-Pierre-et-Miquelon"));
			emagineEnumDAO.create(new DepartmentEnum("D984", "Terres australes et antarctiques française"));
			emagineEnumDAO.create(new DepartmentEnum("D985", "Mayotte"));
			emagineEnumDAO.create(new DepartmentEnum("D986", "Wallis-et-Futuna"));
			emagineEnumDAO.create(new DepartmentEnum("D987", "Polynésie française"));
			emagineEnumDAO.create(new DepartmentEnum("D988", "Nouvelle-Calédonie"));
		} catch (EMagineException emagine) {
			// TODO EMagineException.e1 Not Implemented
			emagine.printStackTrace();
		}
		DAOManager.commitTransaction();
	}

	public static void InitializeCountryEnum()
	{
		EmagineEnumDAO emagineEnumDAO = DAOManager.getInstance().getEmagineEnumDAO();
		DAOManager.beginTransaction();
		
		try {				
			emagineEnumDAO.create(new CountryEnum("Afghanistan", "Afghanistan"));
			emagineEnumDAO.create(new CountryEnum("Albania", "Albania"));
			emagineEnumDAO.create(new CountryEnum("Algeria", "Algeria"));
			emagineEnumDAO.create(new CountryEnum("American Samoa", "American Samoa"));
			emagineEnumDAO.create(new CountryEnum("Andorra", "Andorra"));
			emagineEnumDAO.create(new CountryEnum("Angola", "Angola"));
			emagineEnumDAO.create(new CountryEnum("Anguilla", "Anguilla"));
			emagineEnumDAO.create(new CountryEnum("Antarctica", "Antarctica"));
			emagineEnumDAO.create(new CountryEnum("Antigua", "Antigua"));
			emagineEnumDAO.create(new CountryEnum("Argentina", "Argentina"));
			emagineEnumDAO.create(new CountryEnum("Armenia", "Armenia"));
			emagineEnumDAO.create(new CountryEnum("Aruba", "Aruba"));
			emagineEnumDAO.create(new CountryEnum("Australia", "Australia"));
			emagineEnumDAO.create(new CountryEnum("Austria", "Austria"));
			emagineEnumDAO.create(new CountryEnum("Azerbaijan", "Azerbaijan"));
			emagineEnumDAO.create(new CountryEnum("Bahamas", "Bahamas"));
			emagineEnumDAO.create(new CountryEnum("Bahrain", "Bahrain"));
			emagineEnumDAO.create(new CountryEnum("Bangladesh", "Bangladesh"));
			emagineEnumDAO.create(new CountryEnum("Barbados", "Barbados"));
			emagineEnumDAO.create(new CountryEnum("Belarus", "Belarus"));
			emagineEnumDAO.create(new CountryEnum("Belgium", "Belgium"));
			emagineEnumDAO.create(new CountryEnum("Belize", "Belize"));
			emagineEnumDAO.create(new CountryEnum("Benin", "Benin"));
			emagineEnumDAO.create(new CountryEnum("Bermuda", "Bermuda"));
			emagineEnumDAO.create(new CountryEnum("Bhutan", "Bhutan"));
			emagineEnumDAO.create(new CountryEnum("Bolivia", "Bolivia"));
			emagineEnumDAO.create(new CountryEnum("Bosnia and Herzegovina", "Bosnia and Herzegovina"));
			emagineEnumDAO.create(new CountryEnum("Botswana", "Botswana"));
			emagineEnumDAO.create(new CountryEnum("Brazil", "Brazil"));
			emagineEnumDAO.create(new CountryEnum("British Virgin Islands", "British Virgin Islands"));
			emagineEnumDAO.create(new CountryEnum("Brunei", "Brunei"));
			emagineEnumDAO.create(new CountryEnum("Bulgaria", "Bulgaria"));
			emagineEnumDAO.create(new CountryEnum("Burkina Faso", "Burkina Faso"));
			emagineEnumDAO.create(new CountryEnum("Burma", "Burma"));
			emagineEnumDAO.create(new CountryEnum("Burundi", "Burundi"));
			emagineEnumDAO.create(new CountryEnum("Cambodia", "Cambodia"));
			emagineEnumDAO.create(new CountryEnum("Cameroon", "Cameroon"));
			emagineEnumDAO.create(new CountryEnum("Canada", "Canada"));
			emagineEnumDAO.create(new CountryEnum("Cape Verde", "Cape Verde"));
			emagineEnumDAO.create(new CountryEnum("Central African Republic", "Central African Republic"));
			emagineEnumDAO.create(new CountryEnum("Chad", "Chad"));
			emagineEnumDAO.create(new CountryEnum("Chile", "Chile"));
			emagineEnumDAO.create(new CountryEnum("China", "China"));
			emagineEnumDAO.create(new CountryEnum("Colombia", "Colombia"));
			emagineEnumDAO.create(new CountryEnum("Comoros", "Comoros"));
			emagineEnumDAO.create(new CountryEnum("Congo", "Congo"));
			emagineEnumDAO.create(new CountryEnum("Cook Islands", "Cook Islands"));
			emagineEnumDAO.create(new CountryEnum("Costa Rica", "Costa Rica"));
			emagineEnumDAO.create(new CountryEnum("Cote d'Ivoire", "Cote d'Ivoire"));
			emagineEnumDAO.create(new CountryEnum("Croatia", "Croatia"));
			emagineEnumDAO.create(new CountryEnum("Cuba", "Cuba"));
			emagineEnumDAO.create(new CountryEnum("Cyprus", "Cyprus"));
			emagineEnumDAO.create(new CountryEnum("Czech Republic", "Czech Republic"));
			emagineEnumDAO.create(new CountryEnum("Denmark", "Denmark"));
			emagineEnumDAO.create(new CountryEnum("Djibouti", "Djibouti"));
			emagineEnumDAO.create(new CountryEnum("Dominica", "Dominica"));
			emagineEnumDAO.create(new CountryEnum("Dominican Republic", "Dominican Republic"));
			emagineEnumDAO.create(new CountryEnum("Ecuador", "Ecuador"));
			emagineEnumDAO.create(new CountryEnum("Egypt", "Egypt"));
			emagineEnumDAO.create(new CountryEnum("El Salvador", "El Salvador"));
			emagineEnumDAO.create(new CountryEnum("Equatorial Guinea", "Equatorial Guinea"));
			emagineEnumDAO.create(new CountryEnum("Eritrea", "Eritrea"));
			emagineEnumDAO.create(new CountryEnum("Estonia", "Estonia"));
			emagineEnumDAO.create(new CountryEnum("Ethiopia", "Ethiopia"));
			emagineEnumDAO.create(new CountryEnum("Falkland Islands", "Falkland Islands"));
			emagineEnumDAO.create(new CountryEnum("Fiji", "Fiji"));
			emagineEnumDAO.create(new CountryEnum("Finland", "Finland"));
			emagineEnumDAO.create(new CountryEnum("France", "France"));
			emagineEnumDAO.create(new CountryEnum("French Guiana", "French Guiana"));
			emagineEnumDAO.create(new CountryEnum("French Polynesia", "French Polynesia"));
			emagineEnumDAO.create(new CountryEnum("Gabon", "Gabon"));
			emagineEnumDAO.create(new CountryEnum("The Gambia", "The Gambia"));
			emagineEnumDAO.create(new CountryEnum("Gaza Strip and West Bank", "Gaza Strip and West Bank"));
			emagineEnumDAO.create(new CountryEnum("Georgia", "Georgia"));
			emagineEnumDAO.create(new CountryEnum("Germany", "Germany"));
			emagineEnumDAO.create(new CountryEnum("Ghana", "Ghana"));
			emagineEnumDAO.create(new CountryEnum("Gibraltar", "Gibraltar"));
			emagineEnumDAO.create(new CountryEnum("Greece", "Greece"));
			emagineEnumDAO.create(new CountryEnum("Greenland", "Greenland"));
			emagineEnumDAO.create(new CountryEnum("Grenada", "Grenada"));
			emagineEnumDAO.create(new CountryEnum("Guadeloupe", "Guadeloupe"));
			emagineEnumDAO.create(new CountryEnum("Guam", "Guam"));
			emagineEnumDAO.create(new CountryEnum("Guatemala", "Guatemala"));
			emagineEnumDAO.create(new CountryEnum("Guinea", "Guinea"));
			emagineEnumDAO.create(new CountryEnum("Guinea-Bissau", "Guinea-Bissau"));
			emagineEnumDAO.create(new CountryEnum("Guyana", "Guyana"));
			emagineEnumDAO.create(new CountryEnum("Haiti", "Haiti"));
			emagineEnumDAO.create(new CountryEnum("The Holy See", "The Holy See"));
			emagineEnumDAO.create(new CountryEnum("Honduras", "Honduras"));
			emagineEnumDAO.create(new CountryEnum("Hong Kong", "Hong Kong"));
			emagineEnumDAO.create(new CountryEnum("Hungary", "Hungary"));
			emagineEnumDAO.create(new CountryEnum("Iceland", "Iceland"));
			emagineEnumDAO.create(new CountryEnum("India", "India"));
			emagineEnumDAO.create(new CountryEnum("Indonesia", "Indonesia"));
			emagineEnumDAO.create(new CountryEnum("Iran", "Iran"));
			emagineEnumDAO.create(new CountryEnum("Iraq", "Iraq"));
			emagineEnumDAO.create(new CountryEnum("Ireland", "Ireland"));
			emagineEnumDAO.create(new CountryEnum("Israel", "Israel"));
			emagineEnumDAO.create(new CountryEnum("Italy", "Italy"));
			emagineEnumDAO.create(new CountryEnum("Jamaica", "Jamaica"));
			emagineEnumDAO.create(new CountryEnum("Japan", "Japan"));
			emagineEnumDAO.create(new CountryEnum("Jordan", "Jordan"));
			emagineEnumDAO.create(new CountryEnum("Kazakhstan", "Kazakhstan"));
			emagineEnumDAO.create(new CountryEnum("Kenya", "Kenya"));
			emagineEnumDAO.create(new CountryEnum("Kiribati", "Kiribati"));
			emagineEnumDAO.create(new CountryEnum("Kuwait", "Kuwait"));
			emagineEnumDAO.create(new CountryEnum("Kyrgyzstan", "Kyrgyzstan"));
			emagineEnumDAO.create(new CountryEnum("Laos", "Laos"));
			emagineEnumDAO.create(new CountryEnum("Latvia", "Latvia"));
			emagineEnumDAO.create(new CountryEnum("Lebanon", "Lebanon"));
			emagineEnumDAO.create(new CountryEnum("Lesotho", "Lesotho"));
			emagineEnumDAO.create(new CountryEnum("Liberia", "Liberia"));
			emagineEnumDAO.create(new CountryEnum("Libya", "Libya"));
			emagineEnumDAO.create(new CountryEnum("Liechtenstein", "Liechtenstein"));
			emagineEnumDAO.create(new CountryEnum("Lithuania", "Lithuania"));
			emagineEnumDAO.create(new CountryEnum("Luxembourg", "Luxembourg"));
			emagineEnumDAO.create(new CountryEnum("Macau", "Macau"));
			emagineEnumDAO.create(new CountryEnum("Macedonia", "Macedonia"));
			emagineEnumDAO.create(new CountryEnum("Madagascar", "Madagascar"));
			emagineEnumDAO.create(new CountryEnum("Malawi", "Malawi"));
			emagineEnumDAO.create(new CountryEnum("Malaysia", "Malaysia"));
			emagineEnumDAO.create(new CountryEnum("Maldives", "Maldives"));
			emagineEnumDAO.create(new CountryEnum("Mali", "Mali"));
			emagineEnumDAO.create(new CountryEnum("Malta", "Malta"));
			emagineEnumDAO.create(new CountryEnum("Marshall Islands", "Marshall Islands"));
			emagineEnumDAO.create(new CountryEnum("Martinique", "Martinique"));
			emagineEnumDAO.create(new CountryEnum("Mauritania", "Mauritania"));
			emagineEnumDAO.create(new CountryEnum("Mauritius", "Mauritius"));
			emagineEnumDAO.create(new CountryEnum("Mayotte", "Mayotte"));
			emagineEnumDAO.create(new CountryEnum("Mexico", "Mexico"));
			emagineEnumDAO.create(new CountryEnum("Federated States of Micronesia", "Federated States of Micronesia"));
			emagineEnumDAO.create(new CountryEnum("Moldova", "Moldova"));
			emagineEnumDAO.create(new CountryEnum("Monaco", "Monaco"));
			emagineEnumDAO.create(new CountryEnum("Mongolia", "Mongolia"));
			emagineEnumDAO.create(new CountryEnum("Montserrat", "Montserrat"));
			emagineEnumDAO.create(new CountryEnum("Morocco", "Morocco"));
			emagineEnumDAO.create(new CountryEnum("Mozambique", "Mozambique"));
			emagineEnumDAO.create(new CountryEnum("Namibia", "Namibia"));
			emagineEnumDAO.create(new CountryEnum("Nauru", "Nauru"));
			emagineEnumDAO.create(new CountryEnum("Nepal", "Nepal"));
			emagineEnumDAO.create(new CountryEnum("Netherlands", "Netherlands"));
			emagineEnumDAO.create(new CountryEnum("Netherlands Antilles", "Netherlands Antilles"));
			emagineEnumDAO.create(new CountryEnum("New Caledonia", "New Caledonia"));
			emagineEnumDAO.create(new CountryEnum("New Zealand", "New Zealand"));
			emagineEnumDAO.create(new CountryEnum("Nicaragua", "Nicaragua"));
			emagineEnumDAO.create(new CountryEnum("Niger", "Niger"));
			emagineEnumDAO.create(new CountryEnum("Nigeria", "Nigeria"));
			emagineEnumDAO.create(new CountryEnum("North Korea", "North Korea"));
			emagineEnumDAO.create(new CountryEnum("Northern Mariana Islands", "Northern Mariana Islands"));
			emagineEnumDAO.create(new CountryEnum("Norway", "Norway"));
			emagineEnumDAO.create(new CountryEnum("Oman", "Oman"));
			emagineEnumDAO.create(new CountryEnum("Pakistan", "Pakistan"));
			emagineEnumDAO.create(new CountryEnum("Palau", "Palau"));
			emagineEnumDAO.create(new CountryEnum("Panama", "Panama"));
			emagineEnumDAO.create(new CountryEnum("Papua New Guinea", "Papua New Guinea"));
			emagineEnumDAO.create(new CountryEnum("Paraguay", "Paraguay"));
			emagineEnumDAO.create(new CountryEnum("Peru", "Peru"));
			emagineEnumDAO.create(new CountryEnum("Philippines", "Philippines"));
			emagineEnumDAO.create(new CountryEnum("Pitcairn Islands", "Pitcairn Islands"));
			emagineEnumDAO.create(new CountryEnum("Poland", "Poland"));
			emagineEnumDAO.create(new CountryEnum("Portugal", "Portugal"));
			emagineEnumDAO.create(new CountryEnum("Puerto Rico", "Puerto Rico"));
			emagineEnumDAO.create(new CountryEnum("Qatar", "Qatar"));
			emagineEnumDAO.create(new CountryEnum("Reunion", "Reunion"));
			emagineEnumDAO.create(new CountryEnum("Romania", "Romania"));
			emagineEnumDAO.create(new CountryEnum("Russia", "Russia"));
			emagineEnumDAO.create(new CountryEnum("Rwanda", "Rwanda"));
			emagineEnumDAO.create(new CountryEnum("Saint Kitts and Nevis", "Saint Kitts and Nevis"));
			emagineEnumDAO.create(new CountryEnum("Saint Lucia", "Saint Lucia"));
			emagineEnumDAO.create(new CountryEnum("Saint Pierre and Miquelon", "Saint Pierre and Miquelon"));
			emagineEnumDAO.create(new CountryEnum("Saint Vincent and the Grenadines", "Saint Vincent and the Grenadines"));
			emagineEnumDAO.create(new CountryEnum("Samoa", "Samoa"));
			emagineEnumDAO.create(new CountryEnum("San Marino", "San Marino"));
			emagineEnumDAO.create(new CountryEnum("Sao Tome and Principe", "Sao Tome and Principe"));
			emagineEnumDAO.create(new CountryEnum("Saudi Arabia", "Saudi Arabia"));
			emagineEnumDAO.create(new CountryEnum("Senegal", "Senegal"));
			emagineEnumDAO.create(new CountryEnum("Serbia and Montenegro", "Serbia and Montenegro"));
			emagineEnumDAO.create(new CountryEnum("Seychelles", "Seychelles"));
			emagineEnumDAO.create(new CountryEnum("Sierra Leone", "Sierra Leone"));
			emagineEnumDAO.create(new CountryEnum("Singapore", "Singapore"));
			emagineEnumDAO.create(new CountryEnum("Slovakia", "Slovakia"));
			emagineEnumDAO.create(new CountryEnum("Slovenia", "Slovenia"));
			emagineEnumDAO.create(new CountryEnum("Solomon Islands", "Solomon Islands"));
			emagineEnumDAO.create(new CountryEnum("Somalia", "Somalia"));
			emagineEnumDAO.create(new CountryEnum("South Africa", "South Africa"));
			emagineEnumDAO.create(new CountryEnum("South Korea", "South Korea"));
			emagineEnumDAO.create(new CountryEnum("Spain", "Spain"));
			emagineEnumDAO.create(new CountryEnum("Sri Lanka", "Sri Lanka"));
			emagineEnumDAO.create(new CountryEnum("Sudan", "Sudan"));
			emagineEnumDAO.create(new CountryEnum("Suriname", "Suriname"));
			emagineEnumDAO.create(new CountryEnum("Swaziland", "Swaziland"));
			emagineEnumDAO.create(new CountryEnum("Sweden", "Sweden"));
			emagineEnumDAO.create(new CountryEnum("Switzerland", "Switzerland"));
			emagineEnumDAO.create(new CountryEnum("Syria", "Syria"));
			emagineEnumDAO.create(new CountryEnum("Taiwan", "Taiwan"));
			emagineEnumDAO.create(new CountryEnum("Tajikistan", "Tajikistan"));
			emagineEnumDAO.create(new CountryEnum("Tanzania", "Tanzania"));
			emagineEnumDAO.create(new CountryEnum("Thailand", "Thailand"));
			emagineEnumDAO.create(new CountryEnum("Togo", "Togo"));
			emagineEnumDAO.create(new CountryEnum("Tonga", "Tonga"));
			emagineEnumDAO.create(new CountryEnum("Trinidad and Tobago", "Trinidad and Tobago"));
			emagineEnumDAO.create(new CountryEnum("Tunisia", "Tunisia"));
			emagineEnumDAO.create(new CountryEnum("Turkey", "Turkey"));
			emagineEnumDAO.create(new CountryEnum("Turkmenistan", "Turkmenistan"));
			emagineEnumDAO.create(new CountryEnum("Turks and Caicos Islands", "Turks and Caicos Islands"));
			emagineEnumDAO.create(new CountryEnum("Tuvalu", "Tuvalu"));
			emagineEnumDAO.create(new CountryEnum("Uganda", "Uganda"));
			emagineEnumDAO.create(new CountryEnum("Ukraine", "Ukraine"));
			emagineEnumDAO.create(new CountryEnum("United Arab Emirates", "United Arab Emirates"));
			emagineEnumDAO.create(new CountryEnum("United Kingdom", "United Kingdom"));
			emagineEnumDAO.create(new CountryEnum("United States", "United States"));
			emagineEnumDAO.create(new CountryEnum("United States Virgin Islands", "United States Virgin Islands"));
			emagineEnumDAO.create(new CountryEnum("Uruguay", "Uruguay"));
			emagineEnumDAO.create(new CountryEnum("Uzbekistan", "Uzbekistan"));
			emagineEnumDAO.create(new CountryEnum("Vanuatu", "Vanuatu"));
			emagineEnumDAO.create(new CountryEnum("Venezuela", "Venezuela"));
			emagineEnumDAO.create(new CountryEnum("Vietnam", "Vietnam"));
			emagineEnumDAO.create(new CountryEnum("West Bank and Gaza Strip", "West Bank and Gaza Strip"));
			emagineEnumDAO.create(new CountryEnum("Western Sahara", "Western Sahara"));
			emagineEnumDAO.create(new CountryEnum("Yemen", "Yemen"));
			emagineEnumDAO.create(new CountryEnum("Yugoslavia", "Yugoslavia"));
			emagineEnumDAO.create(new CountryEnum("Zaire", "Zaire"));
			emagineEnumDAO.create(new CountryEnum("Zambia", "Zambia"));
			emagineEnumDAO.create(new CountryEnum("Zimbabwe", "Zimbabwe"));

		} catch (EMagineException emagine) {
			// TODO EMagineException.e1 Not Implemented
			emagine.printStackTrace();
		}
		DAOManager.commitTransaction();
	}
}